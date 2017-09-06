package jp.co.forrentsystem.controller.backend;

import java.util.List;

import javax.validation.Valid;

import jp.co.forrentsystem.constants.BuildingType;
import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dto.AddressDto;
import jp.co.forrentsystem.dto.RouteDto;
import jp.co.forrentsystem.dto.StationDto;
import jp.co.forrentsystem.dto.StructureDto;
import jp.co.forrentsystem.form.backend.RegistBuildingForm;
import jp.co.forrentsystem.service.AddressService;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.RouteService;
import jp.co.forrentsystem.service.StationService;
import jp.co.forrentsystem.service.StructureService;

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
 * 建物情報登録コントローラ
 * @author k.akahira
 */
@Controller
public class RegistBuildingController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistBuildingController.class);

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private StructureService structureService;
	@Autowired
	private RouteService routeService;
	@Autowired
	private StationService stationService;

	/**
	 * 建物情報登録画面初期表示処理
	 *
	 * @param model
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registBuilding", method = RequestMethod.GET,  produces="text/plain;charset=utf-8")
	public ModelAndView init(ModelMap model) {
		logger.info("RegistBuildingController-init");
		// 建物種別リスト取得
		List<MasterDto> buildingTypeList = BuildingType.getBuildingTypeList();
		// 構造リスト取得
		List<StructureDto> structureList = structureService.getStructureList();
		// 沿線リスト取得
		List<RouteDto> routeList = routeService.getAllRouteList();
		// 駅リスト取得(初期表示用）
		List<StationDto> stationList = stationService.getStationListByRouteId(routeList.get(0).getRouteId());

		ModelAndView mav = new ModelAndView();
		// 建物完了画面から遷移した場合、modelから取得する
		mav.addObject("registBuildingForm", (RegistBuildingForm)model.get("registBuildingForm") == null ?
				new RegistBuildingForm() : (RegistBuildingForm)model.get("registBuildingForm"));
		mav.addObject("buildingTypeList", buildingTypeList);
		mav.addObject("structureList", structureList);
		mav.addObject("nearestRouteList1", routeList);
		mav.addObject("nearestStationList1", stationList);
		mav.addObject("nearestRouteList2", routeList);
		mav.addObject("nearestStationList2", stationList);
		mav.addObject("nearestRouteList3", routeList);
		mav.addObject("nearestStationList3", stationList);
		mav.setViewName("./back/registBuilding");
		return mav;
	}

	/**
	 * 建物情報登録確認画面遷移
	 *
	 * @param registBuildingForm 建物登録情報FORM
	 * @param result 画面エラー情報
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callRegistConfirmBuilding", method = RequestMethod.POST,  produces="text/plain;charset=utf-8")
	public ModelAndView callRegistConfirmBuilding(@Valid RegistBuildingForm registBuildingForm, BindingResult result, RedirectAttributes attribute) {
		logger.info("RegistBuildingController-callRegistConfirmBuilding");

		ModelAndView mav = new ModelAndView();

		attribute.addFlashAttribute("registBuildingForm", registBuildingForm);
		if (result.hasErrors()) {
			// エラー発生の場合
			// 建物種別リスト取得
			List<MasterDto> buildingTypeList = BuildingType.getBuildingTypeList();
			// 構造リスト取得
			List<StructureDto> structureList = structureService.getStructureList();
			// 沿線リスト取得
			List<RouteDto> routeList = routeService.getAllRouteList();
			// 駅リスト取得(初期表示用）
			List<StationDto> stationList = stationService.getStationListByRouteId(routeList.get(0).getRouteId());

			mav.addObject("registBuildingForm",registBuildingForm);
			mav.addObject("buildingTypeList", buildingTypeList);
			mav.addObject("structureList", structureList);
			mav.addObject("nearestRouteList1", routeList);
			mav.addObject("nearestStationList1", stationList);
			mav.addObject("nearestRouteList2", routeList);
			mav.addObject("nearestStationList2", stationList);
			mav.addObject("nearestRouteList3", routeList);
			mav.addObject("nearestStationList3", stationList);
			mav.setViewName("./back/registBuilding");

			return mav;
		}

		// リダイレクト（建物登録確認画面）
		mav.setViewName("redirect:/back/registConfirmBuilding");

		return mav;
	}

	/**
	 * TOP画面遷移
	 *
	 * @return TOP画面遷移情報
	 */
	@RequestMapping(value = "/back/backRegistBuilding", method = RequestMethod.GET,  produces="text/plain;charset=utf-8")
	public String back() {
		logger.info("RegistBuildingController-back");

		// リダイレクト（管理TOP画面）
		return "redirect:/back/manageTop";
	}

	/**
	 * 「取込」押下時の住所取得処理
	 *
	 * @param zipCode 郵便番号
	 *
	 * @return 住所情報リスト
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getAddressList")
	public @ResponseBody List<AddressDto> getAddressListViewByZipCode(@Param(value="zipCode") String zipCode) {
		logger.info("RegistBuildingController-getAddressListViewByZipCode");

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
	@RequestMapping(method = RequestMethod.GET, value="/getStationList")
	public @ResponseBody List<StationDto> getStationListByRouteId(@Param(value="routeId") Integer routeId) {
		logger.info("RegistBuildingController-getStationListByRouteId");

		// 沿線IDをキーに対象駅を取得
		List<StationDto> stationDtoList = stationService.getStationListByRouteId(routeId);

		return stationDtoList;
	}
}
