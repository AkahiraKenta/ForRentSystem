package jp.co.forrentsystem.controller.backend;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.co.forrentsystem.constants.BuildingType;
import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dto.AddressDto;
import jp.co.forrentsystem.dto.RouteDto;
import jp.co.forrentsystem.dto.StationDto;
import jp.co.forrentsystem.form.backend.SearchBuildingForm;
import jp.co.forrentsystem.service.AddressService;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.RouteService;
import jp.co.forrentsystem.service.StationService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 建物情報検索コントローラ
 * @author k.akahira
 */
@Controller
public class SearchBuildingController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(SearchBuildingController.class);

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private RouteService routeService;
	@Autowired
	private StationService stationService;

	/**
	 * 建物検索画面初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/searchBuilding", method = RequestMethod.GET)
	public ModelAndView init(HttpSession session) {
		logger.info("SearchBuildingController-init");

		// 建物種別リスト取得
		List<MasterDto> buildingTypeList = BuildingType.getBuildingTypeAndBlankList();
		// 沿線リスト取得
		List<RouteDto> routeList = routeService.getAllExistRouteList();
		// 先頭に空行を追加
		routeList.add(0, new RouteDto());

		// SESSIONからFORMを取得
		SearchBuildingForm searchBuildingForm = new SearchBuildingForm();
		List<StationDto> stationList = new ArrayList<StationDto>();

		// メニューから遷移した場合のみ、検索条件をSESSIONから削除する
		session.removeAttribute("searchBuildingForm");

		ModelAndView mav = new ModelAndView();
		mav.addObject("searchBuildingForm", searchBuildingForm);
		mav.addObject("buildingTypeList", buildingTypeList);
		mav.addObject("routeList", routeList);
		mav.addObject("stationList", stationList);
		mav.setViewName("./back/searchBuilding");
		return mav;
	}

	/**
	 * 建物一覧画面遷移
	 *
	 * @param searchBuildingForm 建物検索情報FORM
	 * @param result 入力チェック
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callBildingList", method = RequestMethod.POST)
	public ModelAndView callListBuilding(@Valid SearchBuildingForm searchBuildingForm, BindingResult result, HttpSession session) {
		logger.info("SearchBuildingController-callListBuilding");

		// 建物検索情報FORMをセッションに設定
		session.setAttribute("searchBuildingForm", searchBuildingForm);

		ModelAndView mav = new ModelAndView();
		// リダイレクト（建物一覧画面）
		mav.setViewName("redirect:/back/callListBuilding");

		return mav;
	}

	/**
	 * TOP画面へ遷移
	 *
	 * @param sesson セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backSearchBuilding", method = RequestMethod.GET)
	public ModelAndView back(HttpSession session) {
		logger.info("SearchBuildingController-back");

		// 建物検索情報FORMをセッションに設定
		session.removeAttribute("searchBuildingForm");

		ModelAndView mav = new ModelAndView();
		// リダイレクト（管理TOP画面）
		mav.setViewName("redirect:/back/manageTop");

		return mav;
	}

	/**
	 * 「取込」押下時の住所取得処理
	 *
	 * @param zipCode 郵便番号
	 *
	 * @return 住所情報リスト
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getAddressListForSearchBuilding")
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
	@RequestMapping(method = RequestMethod.GET, value="/getStationListForSearchBuilding")
	public @ResponseBody List<StationDto> getStationListByRouteId(@Param(value="routeId") Integer routeId) {
		logger.info("RegistBuildingController-getStationListByRouteId");

		// 沿線IDをキーに対象駅を取得
		List<StationDto> stationDtoList = stationService.getStationListByRouteId(routeId);

		return stationDtoList;

	}

	/**
	 * 建物一覧画面から建物検索画面へ遷移
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backSearchBuildingForListBuilding", method = RequestMethod.GET)
	public ModelAndView backSearchBuildingForListBuilding(HttpSession session) {
		logger.info("SearchBuildingController-init");

		ModelAndView mav = new ModelAndView();

		if (session.getAttribute("searchBuildingForm") == null) {
			// SESSIONに建物検索Formが存在しない場合は、TOP画面へ遷移
			mav.setViewName("redirect:/back/manageTop");
		} else {
			// SESSIONに建物検索Formが存在する場合は、建物検索画面へ遷移
			// 建物種別リスト取得
			List<MasterDto> buildingTypeList = BuildingType.getBuildingTypeAndBlankList();
			// 沿線リスト取得
			List<RouteDto> routeList = routeService.getAllExistRouteList();
			// 先頭に空行を追加
			routeList.add(0, new RouteDto());

			// SESSIONからFORMを取得
			SearchBuildingForm searchBuildingForm = (SearchBuildingForm)session.getAttribute("searchBuildingForm");

			// 駅リスト取得(初期表示用）
			List<StationDto> stationList = stationService.getStationListByRouteId(searchBuildingForm.getRoute());
			stationList.add(0, new StationDto());

			mav.addObject("searchBuildingForm", searchBuildingForm);
			mav.addObject("buildingTypeList", buildingTypeList);
			mav.addObject("routeList", routeList);
			mav.addObject("stationList", stationList);
			mav.setViewName("./back/searchBuilding");
		}
		return mav;
	}
}
