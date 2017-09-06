package jp.co.forrentsystem.controller.backend;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import jp.co.forrentsystem.constants.BuildingType;
import jp.co.forrentsystem.dto.AddressDto;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.BuildingImageDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.dto.RouteDto;
import jp.co.forrentsystem.dto.StationDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.form.backend.EditBuildingForm;
import jp.co.forrentsystem.service.AddressService;
import jp.co.forrentsystem.service.BuildingImageService;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.NearestStationService;
import jp.co.forrentsystem.service.RouteService;
import jp.co.forrentsystem.service.StationService;
import jp.co.forrentsystem.service.StructureService;
import jp.co.forrentsystem.util.FileUtil;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 建物情報編集コントローラ
 * @author k.akahira
 */
@Controller
public class EditBuildingController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditBuildingController.class);

	@Autowired
	private AddressService addressService;
	@Autowired
	private StructureService structureService;
	@Autowired
	private RouteService routeService;
	@Autowired
	private StationService stationService;
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private BuildingImageService buildingImageService;
	@Autowired
	private NearestStationService nearestStationService;

	/**
	 * 建物編集画面初期表示
	 *
	 * @param model
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/editBuilding", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		logger.info("EditBuildingController-init");

		// 初期表示データ
		DetailBuildingForm detailBuildingForm = (DetailBuildingForm)model.get("detailBuildingForm");
		// 沿線リスト取得
		List<RouteDto> routeList = routeService.getAllRouteList();
		// 駅リスト取得(初期表示用）
		List<StationDto> stationList1 = new ArrayList<StationDto>();
		List<StationDto> stationList2 = new ArrayList<StationDto>();
		List<StationDto> stationList3 = new ArrayList<StationDto>();


		List<NearestStationNameDto> nearestStationList = nearestStationService.getNearestStationNameList(detailBuildingForm.getBuildingId());
		if (nearestStationList.size() > 0) {
			for (int i = 0; i < nearestStationList.size(); i++) {
				if (nearestStationList.get(i) != null) {
					if (i == 0) {
						stationList1 = stationService.getStationListByRouteId(nearestStationList.get(i).getRouteId());
					} else if (i == 1) {
						stationList2 = stationService.getStationListByRouteId(nearestStationList.get(i).getRouteId());
					} else {
						stationList3 = stationService.getStationListByRouteId(nearestStationList.get(i).getRouteId());
					}
				}
			}
		}

		// 建物画像
		BuildingImageDto buildingImage = buildingImageService.getBuildingImage(detailBuildingForm.getBuildingId());

		ModelAndView mav = new ModelAndView();
		// 建物種別リスト取得
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 構造リスト取得
		mav.addObject("structureList", structureService.getStructureList());
		mav.addObject("nearestRouteList1", routeList);
		mav.addObject("nearestStationList1", stationList1);
		mav.addObject("nearestRouteList2", routeList);
		mav.addObject("nearestStationList2", stationList2);
		mav.addObject("nearestRouteList3", routeList);
		mav.addObject("nearestStationList3", stationList3);
		mav.addObject("buildingImage", buildingImage);
		mav.addObject("editBuildingForm", detailBuildingForm);
		// 住所リスト取得
		mav.addObject("addressDtoList", addressService.getAddressListViewByZipCode(detailBuildingForm.getZipCode()));
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.setViewName("./back/editBuilding");

		return mav;
	}

	/**
	 * 建物編集確認画面へ遷移
	 *
	 * @param editBuildingForm 建物編集情報Form
	 * @param result 画面エラー情報
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/editConfirmBuilding", method = RequestMethod.POST)
	public ModelAndView callEditConfirmBuilding(@Valid EditBuildingForm editBuildingForm, BindingResult result, RedirectAttributes attribute) {
		logger.info("EditBuildingController-callEditConfirmBuilding");

		// 建物編集情報をattributeに設定
		attribute.addFlashAttribute("editConfirmBuildingForm", editBuildingForm);

		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			// 建物種別リスト取得
			mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
			// 構造リスト取得
			mav.addObject("structureList", structureService.getStructureList());
			// 沿線リスト取得
			List<RouteDto> routeList = routeService.getAllRouteList();
			// 駅リスト取得(初期表示用）
			List<StationDto> stationList = stationService.getStationListByRouteId(routeList.get(0).getRouteId());
			// 建物画像
			BuildingImageDto buildingImage = buildingImageService.getBuildingImage(editBuildingForm.getBuildingId());
			mav.addObject("nearestRouteList1", routeList);
			mav.addObject("nearestStationList1", stationList);
			mav.addObject("nearestRouteList2", routeList);
			mav.addObject("nearestStationList2", stationList);
			mav.addObject("nearestRouteList3", routeList);
			mav.addObject("nearestStationList3", stationList);
			mav.addObject("buildingImage", buildingImage);
			mav.addObject("editBuildingForm", editBuildingForm);
			// 建物画像ファイルパスを設定
			mav.addObject("filePath", FileUtil.getFileRelativePath());
			mav.setViewName("./back/editBuilding");
			return mav;
		}
		// リダイレクト（建物編集確認画面）
		mav.setViewName("redirect:/back/editConfirmBuilding");

		return mav;
	}

	/**
	 * 建物詳細画面へ遷移
	 *
	 * @param editBuildingForm 建物編集Form
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backEditBuilding", method = RequestMethod.GET, produces="text/plain;charset=utf-8")
	public String back(@Param(value="buildingId") Integer buildingId, RedirectAttributes attribute) {
		logger.info("EditBuildingController-back");

		// 先ほど登録した建物情報を取得
		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);

		// 建物情報を建物詳細Formに設定する
		DetailBuildingForm detailBuildingForm = buildingService.getBuildingDtoForDetailBuildingForm(buildingDto);

		//建物情報を建物詳細Formをattributeに保存
		attribute.addFlashAttribute("detailBuildingForm", detailBuildingForm);

		// リダイレクト（建物検索画面）
		return "redirect:/back/detailBuilding";
	}

	/**
	 * 「取込」押下時の住所取得処理
	 *
	 * @param zipCode 郵便番号
	 *
	 * @return 住所情報リスト
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getAddressListEditBuilding")
	public @ResponseBody List<AddressDto> getAddressListViewByZipCode(@Param(value="zipCode") String zipCode) {
		logger.info("EditBuildingController-getAddressListViewByZipCode");

		// 郵便番号をキーに対象住所を取得
		List<AddressDto> addressDtoList = addressService.getAddressListViewByZipCode(zipCode);

		return addressDtoList;
	}

	/**
	 * 沿線選択値変更時の駅情報取得処理
	 *
	 * @param routeId 沿線ID
	 *
	 * @return 駅情報リスト
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getStationListEditBuilding")
	public @ResponseBody List<StationDto> getStationListByRouteId(@Param(value="routeId") Integer routeId) {
		logger.info("RegistBuildingController-getStationListByRouteId");

		// 沿線IDをキーに対象駅を取得
		List<StationDto> stationDtoList = stationService.getStationListByRouteId(routeId);

		return stationDtoList;
	}

	/**
	 * 建物編集確認画面から戻った場合の建物編集画面初期表示
	 *
	 * @param model
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backFromEditConfirm", method = RequestMethod.GET)
	public ModelAndView backToEditConfirm(ModelMap model) {
		logger.info("EditBuildingController-backToEditConfirm");

		// 初期表示データ
		EditBuildingForm editConfirmBuildingForm = (EditBuildingForm)model.get("editConfirmBuildingForm");
		// 沿線リスト取得
		List<RouteDto> routeList = routeService.getAllRouteList();
		// 駅リスト取得(初期表示用）
		List<StationDto> stationList = stationService.getStationListByRouteId(routeList.get(0).getRouteId());
		// 建物画像
		BuildingImageDto buildingImage = buildingImageService.getBuildingImage(editConfirmBuildingForm.getBuildingId());

		ModelAndView mav = new ModelAndView();
		// 建物種別リスト取得
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 構造リスト取得
		mav.addObject("structureList", structureService.getStructureList());
		mav.addObject("nearestRouteList1", routeList);
		mav.addObject("nearestStationList1", stationList);
		mav.addObject("nearestRouteList2", routeList);
		mav.addObject("nearestStationList2", stationList);
		mav.addObject("nearestRouteList3", routeList);
		mav.addObject("nearestStationList3", stationList);
		mav.addObject("editBuildingForm", editConfirmBuildingForm);
		// 住所リスト取得
		mav.addObject("addressDtoList", addressService.getAddressListViewByZipCode(editConfirmBuildingForm.getZipCode()));
		mav.addObject("buildingImage", buildingImage);
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.setViewName("./back/editBuilding");

		return mav;
	}
}
