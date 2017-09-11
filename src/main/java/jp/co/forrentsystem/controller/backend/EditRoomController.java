	package jp.co.forrentsystem.controller.backend;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import jp.co.forrentsystem.constants.ContractForm;
import jp.co.forrentsystem.constants.DeliveryMethod;
import jp.co.forrentsystem.constants.KeyMoneyClass;
import jp.co.forrentsystem.constants.PublicationFlag;
import jp.co.forrentsystem.constants.RecruitmentStatus;
import jp.co.forrentsystem.constants.RenewalFeeClass;
import jp.co.forrentsystem.constants.SecurityDepositClass;
import jp.co.forrentsystem.constants.SecurityMoneyClass;
import jp.co.forrentsystem.dto.RoomsImageDto;
import jp.co.forrentsystem.form.backend.DetailRoomForm;
import jp.co.forrentsystem.form.backend.EditRoomsForm;
import jp.co.forrentsystem.service.EquipmentService;
import jp.co.forrentsystem.service.FloorPlanService;
import jp.co.forrentsystem.service.FloorService;
import jp.co.forrentsystem.service.GoodForConditionService;
import jp.co.forrentsystem.service.RoomEquipmentService;
import jp.co.forrentsystem.service.RoomGoodForConditionService;
import jp.co.forrentsystem.service.RoomsService;
import jp.co.forrentsystem.util.FileUtil;
import jp.co.forrentsystem.util.UtilService;

/**
 * 部屋編集情報コントローラ
 * @author k.akahira
 */
@Controller
public class EditRoomController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditRoomController.class);

	@Autowired
	private FloorService floorService;
	@Autowired
	private FloorPlanService floorPlanService;
	@Autowired
	private RoomsService roomsService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private GoodForConditionService goodForConditionService;
	@Autowired
	private RoomEquipmentService roomEquipmentService;
	@Autowired
	private RoomGoodForConditionService roomGoodForConditionService;

	/**
	 * 初期表示
	 *
	 * @param session セッション情報
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/editRoom", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		logger.info("EditRoomController-init");

		DetailRoomForm detailRoomForm = (DetailRoomForm)roomsService.reloadModel(model, session).get("detailRoomForm");

		// 部屋画像リスト
		List<RoomsImageDto> roomImageDtoList = roomsService.getRoomImageList(detailRoomForm.getBuildingId(), detailRoomForm.getRoomId());
		// 部屋設備取得
		List<Integer> roomEquilpmentIdList = roomEquipmentService.getRoomEquipmentIdList(detailRoomForm.getBuildingId(), detailRoomForm.getRoomId());
		// 部屋こだわり条件取得
		List<Integer> roomGoodForConditionIdList = roomGoodForConditionService.getRoomGoodForConditionIdList(detailRoomForm.getBuildingId(), detailRoomForm.getRoomId());

		ModelAndView mav = new ModelAndView();
		mav.addObject("editRoomsForm", detailRoomForm);
		// 階数
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
		// 有効無効
		mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
		// 募集ステータス
		mav.addObject("recruitmentStatusList", RecruitmentStatus.getRecruitmentStatusList());
		// 契約形態
		mav.addObject("contractFormList", ContractForm.getContractFormList());
		// 引き渡し方法
		mav.addObject("delivaryMethodList", DeliveryMethod.getDeliveryMethodList());
		// 部屋設備取得
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件取得
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		mav.addObject("roomEquilpmentIdList", roomEquilpmentIdList);
		mav.addObject("roomGoodForConditionIdList", roomGoodForConditionIdList);
		mav.addObject("roomImageList", roomImageDtoList);
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.setViewName("./back/editRoom");

		return mav;
	}

	/**
	 * 部屋編集確認画面へ遷移
	 *
	 * @param editRoomsForm 部屋編集Form
	 * @param result 画面エラー情報
	 * @param attribute
	 * @param equipmentArray 部屋設備情報
	 * @param goodForConditionArray こだわり条件情報
	 * @return
	 */
	@RequestMapping(value = "/back/callEditConfirmRoom", method = RequestMethod.POST)
	public ModelAndView callEditConfirmRoom(@Valid EditRoomsForm editRoomsForm, BindingResult result, RedirectAttributes attribute
			, @RequestParam(required = false) String[] equipmentArray, @RequestParam(required = false) String[] goodForConditionArray) {
		logger.info("EditRoomController-callEditConfirmRoom");

		editRoomsForm.setEquipmentArray(equipmentArray);
		editRoomsForm.setGoodForConditionArray(goodForConditionArray);

		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			// 部屋画像リスト
			List<RoomsImageDto> roomImageDtoList = roomsService.getRoomImageList(editRoomsForm.getBuildingId(), editRoomsForm.getRoomId());

			mav.addObject("editRoomsForm", editRoomsForm);
			// 階数
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
			// 有効無効
			mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
			// 募集ステータス
			mav.addObject("recruitmentStatusList", RecruitmentStatus.getRecruitmentStatusList());
			// 契約形態
			mav.addObject("contractFormList", ContractForm.getContractFormList());
			// 引き渡し方法
			mav.addObject("delivaryMethodList", DeliveryMethod.getDeliveryMethodList());
			// 部屋設備取得
			mav.addObject("equipmentList", equipmentService.getEquipmentList());
			// こだわり条件取得
			mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
			mav.addObject("roomEquilpmentIdList", editRoomsForm.getEquipmentArray());
			mav.addObject("roomGoodForConditionIdList", editRoomsForm.getGoodForConditionArray());
			mav.addObject("roomImageList", roomImageDtoList);
			mav.addObject("filePath", FileUtil.getFileRelativePath());
			mav.setViewName("./back/editRoom");
			return mav;
		}

		attribute.addFlashAttribute("editRoomsForm", editRoomsForm);

		// リダイレクト（部屋編集確認画面）
		mav.setViewName("redirect:/back/editConfirmRoom");

		return mav;
	}

	/**
	 * 部屋詳細画面へ戻る
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backEditRoom", method = RequestMethod.GET)
	public String back(@Param(value="buildingId") Integer buildingId, @Param(value="roomId") Integer roomId,
			RedirectAttributes attribute) {
		logger.info("EditRoomController-back");

		attribute.addFlashAttribute("buildingId", buildingId);
		attribute.addFlashAttribute("roomId", roomId);
		attribute.addFlashAttribute("transactionFlag", 1);

		return "redirect:/back/detailRoom";
	}

	/**
	 * 部屋編集確認画面から部屋編集画面へ戻る
	 *
	 * @param model
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backForEditRoomConfirm", method = RequestMethod.GET)
	public ModelAndView backForEditRoomConfirm(ModelMap model, HttpSession session) {
		logger.info("EditRoomController-backForEditRoomConfirm");

		EditRoomsForm editRoomsForm =  (EditRoomsForm)roomsService.reloadModel(model, session).get("editRoomsForm");


		List<Integer> roomEquilpmentIdList = UtilService.changeListInteger(editRoomsForm.getEquipmentArray());
		List<Integer> roomGoodForConditionIdList = UtilService.changeListInteger(editRoomsForm.getGoodForConditionArray());

		// 部屋画像リスト
		List<RoomsImageDto> roomImageDtoList = roomsService.getRoomImageList(editRoomsForm.getBuildingId(), editRoomsForm.getRoomId());

		ModelAndView mav = new ModelAndView();
		mav.addObject("editRoomsForm", editRoomsForm);
		// 階数
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
		// 有効無効
		mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
		// 募集ステータス
		mav.addObject("recruitmentStatusList", RecruitmentStatus.getRecruitmentStatusList());
		// 契約形態
		mav.addObject("contractFormList", ContractForm.getContractFormList());
		// 引き渡し方法
		mav.addObject("delivaryMethodList", DeliveryMethod.getDeliveryMethodList());
		// 部屋設備取得
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件取得
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		mav.addObject("roomEquilpmentIdList", roomEquilpmentIdList);
		mav.addObject("roomGoodForConditionIdList", roomGoodForConditionIdList);
		mav.addObject("roomImageList", roomImageDtoList);
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.setViewName("./back/editRoom");

		return mav;
	}
}
