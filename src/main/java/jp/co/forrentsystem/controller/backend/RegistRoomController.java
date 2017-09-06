package jp.co.forrentsystem.controller.backend;

import javax.validation.Valid;

import jp.co.forrentsystem.constants.ContractForm;
import jp.co.forrentsystem.constants.DeliveryMethod;
import jp.co.forrentsystem.constants.KeyMoneyClass;
import jp.co.forrentsystem.constants.PublicationFlag;
import jp.co.forrentsystem.constants.RecruitmentStatus;
import jp.co.forrentsystem.constants.RenewalFeeClass;
import jp.co.forrentsystem.constants.SecurityDepositClass;
import jp.co.forrentsystem.constants.SecurityMoneyClass;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.form.backend.RegistRoomsForm;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.EquipmentService;
import jp.co.forrentsystem.service.FloorPlanService;
import jp.co.forrentsystem.service.FloorService;
import jp.co.forrentsystem.service.GoodForConditionService;
import jp.co.forrentsystem.service.RoomsService;
import jp.co.forrentsystem.util.UtilService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 部屋情報登録コントローラ
 * @author k.akahira
 */
@Controller
public class RegistRoomController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistRoomController.class);

	@Autowired
	private RoomsService roomsService;
	@Autowired
	private FloorService floorService;
	@Autowired
	private FloorPlanService floorPlanService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private GoodForConditionService goodForConditionService;
	@Autowired
	private BuildingService buildingService;

	/**
	 * 初期表示
	 *
	 * @param model
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registRoom", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		logger.info("RegistRoomController-init");

		// 部屋登録FORMに建物情報を設定
		RegistRoomsForm registRoomsForm = roomsService.getBuildingInfoForRoom((DetailBuildingForm)model.get("detailBuildingForm"));

		ModelAndView mav = new ModelAndView();

		mav.addObject("registRoomsForm", registRoomsForm);
		// 階数マスタ取得
		mav.addObject("floorList", floorService.getFloorList());
		// 間取り
		mav.addObject("floorPlanList", floorPlanService.getFloorPlanList());
		// 敷金区分
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 礼金区分
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());
		// 保証金区分
		mav.addObject("securityMoneyClassList", SecurityMoneyClass.getSecurityMoneyClassList());
		// 更新料区分
		mav.addObject("renewalFeeClassList", RenewalFeeClass.getRenewalFeeClassList());
		// 公開フラグ
		mav.addObject("publicationFlag", PublicationFlag.getPublicationFlagList());
		mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
		mav.addObject("recruitmentStatusList", RecruitmentStatus.getRecruitmentStatusList());
		mav.addObject("contractFormList", ContractForm.getContractFormList());
		mav.addObject("delivaryMethodList", DeliveryMethod.getDeliveryMethodList());
		// 部屋設備取得
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件取得
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());

		mav.setViewName("./back/registRoom");

		return mav;
	}

	/**
	 * 部屋登録確認画面へ遷移
	 *
	 * @param registRoomForm 部屋登録情報FORM
	 * @param result 入力チェック
	 * @param attribute
	 * @param equipmentArray 部屋設備選択情報
	 * @param goodForConditionArray 部屋こだわり条件選択情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callRegistConfirmRoom", method = RequestMethod.POST)
	public ModelAndView callRegistConfirmRoom(@Valid RegistRoomsForm registRoomsForm, BindingResult result, RedirectAttributes attribute
			, @RequestParam(required = false) String[] equipmentArray, @RequestParam(required = false) String[] goodForConditionArray) {
		logger.info("RegistRoomController-callRegistConfirmRoom");

		registRoomsForm.setEquipmentArray(equipmentArray);
		registRoomsForm.setGoodForConditionArray(goodForConditionArray);

		// 部屋登録FORMをセッションに設定
		attribute.addFlashAttribute("registConfirmRoomForm", registRoomsForm);

		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.addObject("registRoomsForm", registRoomsForm);
			// 階数マスタ取得
			mav.addObject("floorList", floorService.getFloorList());
			// 間取り
			mav.addObject("floorPlanList", floorPlanService.getFloorPlanList());
			// 敷金区分
			mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
			// 礼金区分
			mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());
			// 保証金区分
			mav.addObject("securityMoneyClassList", SecurityMoneyClass.getSecurityMoneyClassList());
			// 更新料区分
			mav.addObject("renewalFeeClassList", RenewalFeeClass.getRenewalFeeClassList());
			// 公開フラグ
			mav.addObject("publicationFlag", PublicationFlag.getPublicationFlagList());
			mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
			mav.addObject("recruitmentStatusList", RecruitmentStatus.getRecruitmentStatusList());
			mav.addObject("contractFormList", ContractForm.getContractFormList());
			mav.addObject("delivaryMethodList", DeliveryMethod.getDeliveryMethodList());
			// 部屋設備取得
			mav.addObject("equipmentList", equipmentService.getEquipmentList());
			// こだわり条件取得
			mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
			mav.addObject("equipmentArray", equipmentArray);
			mav.addObject("goodForConditionArray", goodForConditionArray);
			mav.setViewName("./back/registRoom");

			return mav;
		}

		// リダイレクト（部屋登録確認画面）
		mav.setViewName("redirect:/back/registConfirmRoom");

		return mav;
	}

	/**
	 * 建物詳細画面へ遷移
	 *
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backRegistRoom", method = RequestMethod.GET)
	public String back(@Param(value="buildingId") Integer buildingId, RedirectAttributes attribute) {
		logger.info("RegistRoomController-back");

		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);

		// 建物情報を建物詳細Formに設定する
		DetailBuildingForm detailBuildingForm = buildingService.getBuildingDtoForDetailBuildingForm(buildingDto);

		//建物情報を建物詳細Formをattributeに保存
		attribute.addFlashAttribute("detailBuildingForm", detailBuildingForm);

		// リダイレクト（部屋詳細画面）
		return "redirect:/back/detailBuilding";
	}

	/**
	 * 部屋登録確認画面から遷移後の初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backRegistRoomFromConfirm", method = RequestMethod.GET)
	public ModelAndView backRegistRoomFromConfirm(ModelMap model) {
		logger.info("RegistRoomController-init");

		RegistRoomsForm registRoomsForm = (RegistRoomsForm)model.get("backRegistRoomForm");
		// 部屋登録FORMに建物情報を設定
		ModelAndView mav = new ModelAndView();

		mav.addObject("registRoomsForm", registRoomsForm);
		// 階数マスタ取得
		mav.addObject("floorList", floorService.getFloorList());
		// 間取り
		mav.addObject("floorPlanList", floorPlanService.getFloorPlanList());
		// 敷金区分
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 礼金区分
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());
		// 保証金区分
		mav.addObject("securityMoneyClassList", SecurityMoneyClass.getSecurityMoneyClassList());
		// 更新料区分
		mav.addObject("renewalFeeClassList", RenewalFeeClass.getRenewalFeeClassList());
		// 公開フラグ
		mav.addObject("publicationFlag", PublicationFlag.getPublicationFlagList());
		mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
		mav.addObject("recruitmentStatusList", RecruitmentStatus.getRecruitmentStatusList());
		mav.addObject("contractFormList", ContractForm.getContractFormList());
		mav.addObject("delivaryMethodList", DeliveryMethod.getDeliveryMethodList());
		// 部屋設備取得
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件取得
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		mav.addObject("equipmentArray", registRoomsForm.getEquipmentArray());
		mav.addObject("goodForConditionArray", registRoomsForm.getGoodForConditionArray());
		mav.setViewName("./back/registRoom");

		return mav;
	}
}
