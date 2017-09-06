package jp.co.forrentsystem.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.co.forrentsystem.constants.BuildingType;
import jp.co.forrentsystem.constants.FBuiltClass;
import jp.co.forrentsystem.constants.FMinutesWalkClass;
import jp.co.forrentsystem.constants.FRentFromClass;
import jp.co.forrentsystem.constants.FRentToClass;
import jp.co.forrentsystem.constants.KeyMoneyClass;
import jp.co.forrentsystem.constants.SecurityDepositClass;
import jp.co.forrentsystem.constants.SortArticle;
import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.form.frontend.FSearchConditionForm;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.EquipmentService;
import jp.co.forrentsystem.service.FloorPlanService;
import jp.co.forrentsystem.service.GoodForConditionService;
import jp.co.forrentsystem.service.NearestStationService;
import jp.co.forrentsystem.service.RecommendedRoomsService;
import jp.co.forrentsystem.service.RoomsService;
import jp.co.forrentsystem.service.SystemSettingService;
import jp.co.forrentsystem.util.FileUtil;
import jp.co.forrentsystem.util.PagerUtil;
import jp.co.forrentsystem.util.UtilService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * フロント検索結果コントローラ
 */
@Controller
public class FSearchResultController {

	@Autowired
	private RoomsService roomsService;
	@Autowired
	private NearestStationService nearestStationService;
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private RecommendedRoomsService recommendedRoomsService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private GoodForConditionService goodForConditionService;
	@Autowired
	private FloorPlanService floorPlanService;
	@Autowired
	private SystemSettingService systemSettingService;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FSearchResultController.class);

	/**
	 * フロント検索結果画面初期表示(最寄駅から遷移）
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/callSearchRouteAndStation", method = RequestMethod.POST)
	public ModelAndView initNearestStation(@Valid FSearchConditionForm fSearchConditionForm, HttpSession session) {
		logger.info("FSearchResultController-initNearestStation");

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;

		// 現在ページを設定
		fSearchConditionForm.setCurrentPage(currentPageDef);
		// 表示件数取得
		int viewNumber = systemSettingService.getSystemSettingForArticleList();
		fSearchConditionForm.setViewNumber(viewNumber);
		// 物件件数を取得
		int viewCount = roomsService.countArticleList(fSearchConditionForm);
		// 全ページ数を設定
		fSearchConditionForm.setPageTotalNumber(PagerUtil.getPageTotalNumber(viewCount, viewNumber));

		int beginPage = PagerUtil.getBeginPage(fSearchConditionForm.getCurrentPage(),fSearchConditionForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,fSearchConditionForm.getPageTotalNumber());

		// 物件情報を取得する
		List<ArticleDto> articleList = roomsService.getArticleList(fSearchConditionForm);

		// 検索条件（最寄駅名称）取得
		List<NearestStationNameDto> searchConditionNearestStationList = nearestStationService.getRouteAndStationNameList(fSearchConditionForm);

		// 駅選択がなかった場合、selectedStationId=999を代入する。
		if (fSearchConditionForm.getSelectedStationId() == null) {
			String[] allStation = new String[1];
			allStation[0] = "999";
			fSearchConditionForm.setSelectedStationId(allStation);
		}

		// 最寄駅検索条件をSESSIONに格納
		session.setAttribute("fSearchConditionForm", fSearchConditionForm);

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fSearchConditionForm", fSearchConditionForm);
		mav.addObject("articleList", articleList);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		// 物件件数
		mav.addObject("viewCount", viewCount);
		// 最寄駅条件
		mav.addObject("searchConditionNearestStationList", searchConditionNearestStationList);
		// 住所条件
		mav.addObject("searchConditionAddressList", null);
		// 建物種別
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 部屋設備
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		// 賃料下限
		mav.addObject("rentFromClassList", FRentFromClass.getRentFromClassList());
		// 賃料上限
		mav.addObject("rentToClassList", FRentToClass.getRentToClassList());
		// 間取り
		mav.addObject("floorPlanList", floorPlanService.getFloorPlanList());
		// 駅徒歩
		mav.addObject("minutesWalkClassList", FMinutesWalkClass.getFMinutesWalkList());
		// 築年数
		mav.addObject("builtClassList", FBuiltClass.getBuiltList());
		// ソート
		mav.addObject("sortArticleList", SortArticle.getSortArticleList());
		// 敷金
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 礼金
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());

		// 現在のページ番号
		mav.addObject("currentPageNumber", fSearchConditionForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);

		mav.setViewName("/front/fSearchRefineResult");

		return mav;
	}

	/**
	 * フロント検索結果画面初期表示(エリアから遷移）
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/callSearchArea", method = RequestMethod.POST)
	public ModelAndView initArea(@Valid FSearchConditionForm fSearchConditionForm, HttpSession session) {
		logger.info("FSearchResultController-initArea");
		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		// 現在ページを設定
		fSearchConditionForm.setCurrentPage(currentPageDef);
		// 表示件数取得
		int viewNumber = systemSettingService.getSystemSettingForArticleList();
		fSearchConditionForm.setViewNumber(viewNumber);


		// 物件件数を取得
		int viewCount = roomsService.countArticleList(fSearchConditionForm);
		// 全ページ数を設定
		fSearchConditionForm.setPageTotalNumber(PagerUtil.getPageTotalNumber(viewCount, viewNumber));

		int beginPage = PagerUtil.getBeginPage(fSearchConditionForm.getCurrentPage(),fSearchConditionForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,fSearchConditionForm.getPageTotalNumber());

		// 物件情報を取得する
		List<ArticleDto> articleList = roomsService.getArticleList(fSearchConditionForm);

		// 検索条件として指定された住所を取得
		List<BuildingDto> searchConditionAddressList = buildingService.getAddressList(fSearchConditionForm);


		// エリア選択がなかった場合、selectedTownArea=999を代入する。
		if (fSearchConditionForm.getSelectedTownArea() == null) {
			String[] allArea = new String[1];
			allArea[0] = "999";
			fSearchConditionForm.setSelectedTownArea(allArea);
		}

		// エリア検索条件をSESSIONに格納
		session.setAttribute("fSearchConditionForm", fSearchConditionForm);

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fSearchConditionForm", fSearchConditionForm);
		mav.addObject("articleList", articleList);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		// 物件件数
		mav.addObject("viewCount", viewCount);
		// 最寄駅条件
		mav.addObject("searchConditionNearestStationList", null);
		// 住所条件
		mav.addObject("searchConditionAddressList", searchConditionAddressList);
		// 建物種別
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 部屋設備
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		// 賃料下限
		mav.addObject("rentFromClassList", FRentFromClass.getRentFromClassList());
		// 賃料上限
		mav.addObject("rentToClassList", FRentToClass.getRentToClassList());
		// 間取り
		mav.addObject("floorPlanList", floorPlanService.getFloorPlanList());
		// 駅徒歩
		mav.addObject("minutesWalkClassList", FMinutesWalkClass.getFMinutesWalkList());
		// 築年数
		mav.addObject("builtClassList", FBuiltClass.getBuiltList());
		// ソート
		mav.addObject("sortArticleList", SortArticle.getSortArticleList());
		// 敷金
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 礼金
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());

		// 現在のページ番号
		mav.addObject("currentPageNumber", fSearchConditionForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);

		mav.setViewName("/front/fSearchRefineResult");

		return mav;
	}

	/**
	 * フロント絞り込み検索結果
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/callSearchCondition", method = RequestMethod.POST)
	public ModelAndView searchCondition(@Valid FSearchConditionForm fSearchConditionForm, HttpSession session) {
		logger.info("FSearchResultController-searchCondition");

		FSearchConditionForm sessionForm = null;
		if (session.getAttribute("fSearchConditionForm") == null) {
			sessionForm = new FSearchConditionForm();
		} else {
			sessionForm = (FSearchConditionForm)session.getAttribute("fSearchConditionForm");
			// 駅検索条件とエリア検索条件をFORMに設定
			fSearchConditionForm.setSelectedStationId(sessionForm.getSelectedStationId());
			fSearchConditionForm.setSelectedTownArea(sessionForm.getSelectedTownArea());
		}

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		// 現在ページを設定
		fSearchConditionForm.setCurrentPage(currentPageDef);
		// 表示件数取得
		int viewNumber = systemSettingService.getSystemSettingForArticleList();
		fSearchConditionForm.setViewNumber(viewNumber);

		// 物件件数を取得
		int viewCount = roomsService.countArticleList(fSearchConditionForm);
		// 全ページ数を設定
		fSearchConditionForm.setPageTotalNumber(PagerUtil.getPageTotalNumber(viewCount, viewNumber));

		int beginPage = PagerUtil.getBeginPage(fSearchConditionForm.getCurrentPage(),fSearchConditionForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,fSearchConditionForm.getPageTotalNumber());


		// ソート順を格納
		fSearchConditionForm.setSortArticleId(fSearchConditionForm.getSortArticleId() == null ? SortArticle.RENT.getValue() : fSearchConditionForm.getSortArticleId());

		// 絞り込み条件をSESSIONに格納
		session.setAttribute("fSearchConditionForm", fSearchConditionForm);

		// 物件情報を取得する
		List<ArticleDto> articleList = roomsService.getArticleList(fSearchConditionForm);

		// 検索条件（最寄駅名称）取得
		List<NearestStationNameDto> searchConditionNearestStationList = sessionForm.getSelectedStationId() == null ?
				null : nearestStationService.getRouteAndStationNameList(sessionForm);

		// 検索条件として指定された住所を取得
		List<BuildingDto> searchConditionAddressList = sessionForm.getSelectedTownArea() == null ?
				null : buildingService.getAddressList(sessionForm);

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fSearchConditionForm", fSearchConditionForm);
		mav.addObject("articleList", articleList);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		// 物件件数
		mav.addObject("viewCount", viewCount);
		// 最寄駅条件
		mav.addObject("searchConditionNearestStationList", searchConditionNearestStationList);
		// 住所条件
		mav.addObject("searchConditionAddressList", searchConditionAddressList);
		// 建物種別
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 部屋設備
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		// 賃料下限
		mav.addObject("rentFromClassList", FRentFromClass.getRentFromClassList());
		// 賃料上限
		mav.addObject("rentToClassList", FRentToClass.getRentToClassList());
		// 間取り
		mav.addObject("floorPlanList", floorPlanService.getFloorPlanList());
		// 駅徒歩
		mav.addObject("minutesWalkClassList", FMinutesWalkClass.getFMinutesWalkList());
		// 築年数
		mav.addObject("builtClassList", FBuiltClass.getBuiltList());
		// ソート
		mav.addObject("sortArticleList", SortArticle.getSortArticleList());
		// 建物種別(選択済み）
		mav.addObject("selectedBuildingTypeHidden", UtilService.changeListString(fSearchConditionForm.getSelectedBuildingType()));
		// 設備(選択済み）
		mav.addObject("selectedEquipmentHidden", UtilService.changeListString(fSearchConditionForm.getSelectedEquipment()));
		// 間取り(選択済み）
		mav.addObject("selectedFloorPlanHidden", UtilService.changeListString(fSearchConditionForm.getSelectedFloorPlan()));
		// こだわり条件(選択済み）
		mav.addObject("selectedGoodForConditionHidden", UtilService.changeListString(fSearchConditionForm.getSelectedGoodForCondition()));
		// 敷金
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 礼金
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());

		// 現在のページ番号
		mav.addObject("currentPageNumber", fSearchConditionForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);

		mav.setViewName("/front/fSearchRefineResult");

		return mav;
	}

	/**
	 * フロント部屋詳細画面からの戻り
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/callBackSearchCondition", method = RequestMethod.POST)
	public ModelAndView callBackSearchResult(HttpSession session) {
		logger.info("FSearchResultController-callBackSearchResult");

		// 検索条件をSESSIONから取得
		FSearchConditionForm fSearchConditionForm = new FSearchConditionForm();
		if (session.getAttribute("fSearchConditionForm") != null) {
			fSearchConditionForm  = (FSearchConditionForm)session.getAttribute("fSearchConditionForm");
		}

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		// 現在ページを設定
		fSearchConditionForm.setCurrentPage(currentPageDef);
		// 表示件数取得
		int viewNumber = systemSettingService.getSystemSettingForArticleList();
		fSearchConditionForm.setViewNumber(viewNumber);


		// 物件件数を取得
		int viewCount = roomsService.countArticleList(fSearchConditionForm);
		// 全ページ数を設定
		fSearchConditionForm.setPageTotalNumber(PagerUtil.getPageTotalNumber(viewCount, viewNumber));

		int beginPage = PagerUtil.getBeginPage(fSearchConditionForm.getCurrentPage(),fSearchConditionForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,fSearchConditionForm.getPageTotalNumber());


		// 物件情報を取得する
		List<ArticleDto> articleList = roomsService.getArticleList(fSearchConditionForm);

		// 検索条件（最寄駅名称）取得
		List<NearestStationNameDto> searchConditionNearestStationList = fSearchConditionForm.getSelectedStationId() == null ?
				null : nearestStationService.getRouteAndStationNameList(fSearchConditionForm);

		// 検索条件として指定された住所を取得
		List<BuildingDto> searchConditionAddressList = fSearchConditionForm.getSelectedTownArea() == null ?
				null : buildingService.getAddressList(fSearchConditionForm);

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fSearchConditionForm", fSearchConditionForm);
		mav.addObject("articleList", articleList);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		// 物件件数
		mav.addObject("viewCount", viewCount);
		// 最寄駅条件
		mav.addObject("searchConditionNearestStationList", searchConditionNearestStationList);
		// 住所条件
		mav.addObject("searchConditionAddressList", searchConditionAddressList);
		// 建物種別
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 部屋設備
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		// 賃料下限
		mav.addObject("rentFromClassList", FRentFromClass.getRentFromClassList());
		// 賃料上限
		mav.addObject("rentToClassList", FRentToClass.getRentToClassList());
		// 間取り
		mav.addObject("floorPlanList", floorPlanService.getFloorPlanList());
		// 駅徒歩
		mav.addObject("minutesWalkClassList", FMinutesWalkClass.getFMinutesWalkList());
		// 築年数
		mav.addObject("builtClassList", FBuiltClass.getBuiltList());
		// ソート
		mav.addObject("sortArticleList", SortArticle.getSortArticleList());
		// 建物種別(選択済み）
		mav.addObject("selectedBuildingTypeHidden", UtilService.changeListString(fSearchConditionForm.getSelectedBuildingType()));
		// 設備(選択済み）
		mav.addObject("selectedEquipmentHidden", UtilService.changeListString(fSearchConditionForm.getSelectedEquipment()));
		// 間取り(選択済み）
		mav.addObject("selectedFloorPlanHidden", UtilService.changeListString(fSearchConditionForm.getSelectedFloorPlan()));
		// こだわり条件(選択済み）
		mav.addObject("selectedGoodForConditionHidden", UtilService.changeListString(fSearchConditionForm.getSelectedGoodForCondition()));
		// 敷金
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 礼金
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());

		// 現在のページ番号
		mav.addObject("currentPageNumber", fSearchConditionForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);

		mav.setViewName("/front/fSearchRefineResult");

		return mav;
	}

	/**
	 * 人気駅選択から遷移した場合の検索結果画面表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/searchResultByPopularityStation", method = RequestMethod.GET)
	public ModelAndView searchResultByPopularityStation(@Param(value="stationId") String stationId, HttpSession session) {
		logger.info("FSearchResultController-searchResultByPopularityStation");

		// 駅IDを配列に入れる
		String[] stationIdArray = new String[1];
		stationIdArray[0] = stationId;

		// 検索条件Formに駅IDを設定する
		FSearchConditionForm fSearchConditionForm = new FSearchConditionForm();
		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		// 現在ページを設定
		fSearchConditionForm.setCurrentPage(currentPageDef);
		// 表示件数取得
		int viewNumber = systemSettingService.getSystemSettingForArticleList();
		fSearchConditionForm.setViewNumber(viewNumber);

		fSearchConditionForm.setSelectedStationId(stationIdArray);

		// 物件件数を取得
		int viewCount = roomsService.countArticleList(fSearchConditionForm);
		// 全ページ数を設定
		fSearchConditionForm.setPageTotalNumber(PagerUtil.getPageTotalNumber(viewCount, viewNumber));

		int beginPage = PagerUtil.getBeginPage(fSearchConditionForm.getCurrentPage(),fSearchConditionForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,fSearchConditionForm.getPageTotalNumber());


		// 検索条件FormをSessionに格納する
		session.setAttribute("fSearchConditionForm", fSearchConditionForm);

		// 物件情報を取得する
		List<ArticleDto> articleList = roomsService.getArticleList(fSearchConditionForm);

		// 検索条件（最寄駅名称）取得
		List<NearestStationNameDto> searchConditionNearestStationList = nearestStationService.getRouteAndStationNameList(fSearchConditionForm);

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fSearchConditionForm", fSearchConditionForm);
		mav.addObject("articleList", articleList);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		// 物件件数
		mav.addObject("viewCount", viewCount);
		// 最寄駅条件
		mav.addObject("searchConditionNearestStationList", searchConditionNearestStationList);
		// 住所条件
		mav.addObject("searchConditionAddressList", null);
		// 建物種別
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 部屋設備
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		// 賃料下限
		mav.addObject("rentFromClassList", FRentFromClass.getRentFromClassList());
		// 賃料上限
		mav.addObject("rentToClassList", FRentToClass.getRentToClassList());
		// 間取り
		mav.addObject("floorPlanList", floorPlanService.getFloorPlanList());
		// 駅徒歩
		mav.addObject("minutesWalkClassList", FMinutesWalkClass.getFMinutesWalkList());
		// 築年数
		mav.addObject("builtClassList", FBuiltClass.getBuiltList());
		// ソート
		mav.addObject("sortArticleList", SortArticle.getSortArticleList());
		// 敷金
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 礼金
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());

		// 現在のページ番号
		mav.addObject("currentPageNumber", fSearchConditionForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);

		mav.setViewName("/front/fSearchRefineResult");

		return mav;
	}

	/**
	 * 人気エリア選択から遷移した場合の検索結果画面表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/searchResultByTownArea", method = RequestMethod.POST)
	public ModelAndView searchResultByTownArea(@Valid FSearchConditionForm fSearchConditionForm, HttpSession session) {
		logger.info("FSearchResultController-searchResultByTownArea");

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		// 現在ページを設定
		fSearchConditionForm.setCurrentPage(currentPageDef);
		// 表示件数取得
		Integer viewNumber = systemSettingService.getSystemSettingForArticleList();
		fSearchConditionForm.setViewNumber(viewNumber);

		// 物件件数を取得
		int viewCount = roomsService.countArticleList(fSearchConditionForm);
		// 全ページ数を設定
		fSearchConditionForm.setPageTotalNumber(PagerUtil.getPageTotalNumber(viewCount, viewNumber));

		int beginPage = PagerUtil.getBeginPage(fSearchConditionForm.getCurrentPage(),fSearchConditionForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,fSearchConditionForm.getPageTotalNumber());


		// 検索条件FormをSessionに格納する
		session.setAttribute("fSearchConditionForm", fSearchConditionForm);

		// 物件情報を取得する
		List<ArticleDto> articleList = roomsService.getArticleList(fSearchConditionForm);

		// 検索条件として指定された住所を取得
		List<BuildingDto> searchConditionAddressList = buildingService.getAddressList(fSearchConditionForm);

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fSearchConditionForm", fSearchConditionForm);
		mav.addObject("articleList", articleList);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		// 物件件数
		mav.addObject("viewCount", viewCount);
		// 最寄駅条件
		mav.addObject("searchConditionNearestStationList", null);
		// 住所条件
		mav.addObject("searchConditionAddressList", searchConditionAddressList);
		// 建物種別
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 部屋設備
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		// 賃料下限
		mav.addObject("rentFromClassList", FRentFromClass.getRentFromClassList());
		// 賃料上限
		mav.addObject("rentToClassList", FRentToClass.getRentToClassList());
		// 間取り
		mav.addObject("floorPlanList", floorPlanService.getFloorPlanList());
		// 駅徒歩
		mav.addObject("minutesWalkClassList", FMinutesWalkClass.getFMinutesWalkList());
		// 築年数
		mav.addObject("builtClassList", FBuiltClass.getBuiltList());
		// ソート
		mav.addObject("sortArticleList", SortArticle.getSortArticleList());
		// 敷金
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 礼金
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());

		// 現在のページ番号
		mav.addObject("currentPageNumber", fSearchConditionForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);

		mav.setViewName("/front/fSearchRefineResult");

		return mav;
	}

	/**
	 * ページングによる物件再検索
	 *
	 * @param totalNumber 全件数
	 * @param viewNumber 表示件数
	 * @param pageTotalNumber 全ページ数
	 * @param pageNumber 現在のページ番号
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/pagerForSearchResultArticle", method = RequestMethod.GET)
    public ModelAndView pagerForSearchResultArticle(@Param(value="totalNumber") Integer totalNumber,
    					   @Param(value="viewNumber") Integer viewNumber,
    					   @Param(value="pageTotalNumber") Integer pageTotalNumber,
    					   @Param(value="pageNumber") Integer pageNumber,
    					   HttpSession session) {
		logger.info("SearchRecommendedRoomController-pagerForRecommendedRoom");

		FSearchConditionForm fSearchConditionForm = new FSearchConditionForm();
		if (session.getAttribute("fSearchConditionForm") != null) {
			fSearchConditionForm = (FSearchConditionForm)session.getAttribute("fSearchConditionForm");
		}

		fSearchConditionForm.setTotalNumber(pageTotalNumber);
		// 今回選択されたページ数
		fSearchConditionForm.setCurrentPage(pageNumber);
		fSearchConditionForm.setViewNumber(viewNumber);
		fSearchConditionForm.setPageTotalNumber(pageTotalNumber);


		// 物件件数を取得
		int viewCount = roomsService.countArticleList(fSearchConditionForm);
		int beginPage = PagerUtil.getBeginPage(pageNumber, pageTotalNumber);
		int endPage =  PagerUtil.getEndPage(beginPage, pageTotalNumber);

		// 物件情報を取得する
		List<ArticleDto> articleList = roomsService.getArticleList(fSearchConditionForm);

		// 検索条件（最寄駅名称）取得
		List<NearestStationNameDto> searchConditionNearestStationList = fSearchConditionForm.getSelectedStationId() == null ?
				null : nearestStationService.getRouteAndStationNameList(fSearchConditionForm);

		// 検索条件として指定された住所を取得
		List<BuildingDto> searchConditionAddressList = fSearchConditionForm.getSelectedTownArea() == null ?
				null : buildingService.getAddressList(fSearchConditionForm);

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fSearchConditionForm", fSearchConditionForm);
		mav.addObject("articleList", articleList);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		// 物件件数
		mav.addObject("viewCount", viewCount);
		// 最寄駅条件
		mav.addObject("searchConditionNearestStationList", searchConditionNearestStationList);
		// 住所条件
		mav.addObject("searchConditionAddressList", searchConditionAddressList);
		// 建物種別
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 部屋設備
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		// 賃料下限
		mav.addObject("rentFromClassList", FRentFromClass.getRentFromClassList());
		// 賃料上限
		mav.addObject("rentToClassList", FRentToClass.getRentToClassList());
		// 間取り
		mav.addObject("floorPlanList", floorPlanService.getFloorPlanList());
		// 駅徒歩
		mav.addObject("minutesWalkClassList", FMinutesWalkClass.getFMinutesWalkList());
		// 築年数
		mav.addObject("builtClassList", FBuiltClass.getBuiltList());
		// ソート
		mav.addObject("sortArticleList", SortArticle.getSortArticleList());
		// 建物種別(選択済み）
		mav.addObject("selectedBuildingTypeHidden", UtilService.changeListString(fSearchConditionForm.getSelectedBuildingType()));
		// 設備(選択済み）
		mav.addObject("selectedEquipmentHidden", UtilService.changeListString(fSearchConditionForm.getSelectedEquipment()));
		// 間取り(選択済み）
		mav.addObject("selectedFloorPlanHidden", UtilService.changeListString(fSearchConditionForm.getSelectedFloorPlan()));
		// こだわり条件(選択済み）
		mav.addObject("selectedGoodForConditionHidden", UtilService.changeListString(fSearchConditionForm.getSelectedGoodForCondition()));
		// 敷金
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 礼金
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());

		// 現在のページ番号
		mav.addObject("currentPageNumber", pageNumber);
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);

		mav.setViewName("/front/fSearchRefineResult");

		return mav;
	}

	/**
	 * ソート順変更
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/callSearchResultArticleSort", method = RequestMethod.POST)
	public ModelAndView callSearchResultArticleSort(FSearchConditionForm paramForm, HttpSession session) {
		logger.info("FSearchResultController-callBackSearchResult");

		FSearchConditionForm fSearchConditionForm  = (FSearchConditionForm)session.getAttribute("fSearchConditionForm");
		fSearchConditionForm.setSortArticleId(paramForm.getSortArticleId());

		session.setAttribute("fSearchConditionForm", fSearchConditionForm);

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		// 現在ページを設定
		fSearchConditionForm.setCurrentPage(currentPageDef);
		// 表示件数取得
		int viewNumber = systemSettingService.getSystemSettingForArticleList();
		fSearchConditionForm.setViewNumber(viewNumber);

		// 物件件数を取得
		int viewCount = roomsService.countArticleList(fSearchConditionForm);
		// 全ページ数を設定
		fSearchConditionForm.setPageTotalNumber(PagerUtil.getPageTotalNumber(viewCount, viewNumber));

		int beginPage = PagerUtil.getBeginPage(fSearchConditionForm.getCurrentPage(),fSearchConditionForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,fSearchConditionForm.getPageTotalNumber());

		// 物件情報を取得する
		List<ArticleDto> articleList = roomsService.getArticleList(fSearchConditionForm);

		// 検索条件（最寄駅名称）取得
		List<NearestStationNameDto> searchConditionNearestStationList = fSearchConditionForm.getSelectedStationId() == null ?
				null : nearestStationService.getRouteAndStationNameList(fSearchConditionForm);

		// 検索条件として指定された住所を取得
		List<BuildingDto> searchConditionAddressList = fSearchConditionForm.getSelectedTownArea() == null ?
				null : buildingService.getAddressList(fSearchConditionForm);

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fSearchConditionForm", fSearchConditionForm);
		mav.addObject("articleList", articleList);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		// 物件件数
		mav.addObject("viewCount", viewCount);
		// 最寄駅条件
		mav.addObject("searchConditionNearestStationList", searchConditionNearestStationList);
		// 住所条件
		mav.addObject("searchConditionAddressList", searchConditionAddressList);
		// 建物種別
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 部屋設備
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		// 賃料下限
		mav.addObject("rentFromClassList", FRentFromClass.getRentFromClassList());
		// 賃料上限
		mav.addObject("rentToClassList", FRentToClass.getRentToClassList());
		// 間取り
		mav.addObject("floorPlanList", floorPlanService.getFloorPlanList());
		// 駅徒歩
		mav.addObject("minutesWalkClassList", FMinutesWalkClass.getFMinutesWalkList());
		// 築年数
		mav.addObject("builtClassList", FBuiltClass.getBuiltList());
		// ソート
		mav.addObject("sortArticleList", SortArticle.getSortArticleList());
		// 建物種別(選択済み）
		mav.addObject("selectedBuildingTypeHidden", UtilService.changeListString(fSearchConditionForm.getSelectedBuildingType()));
		// 設備(選択済み）
		mav.addObject("selectedEquipmentHidden", UtilService.changeListString(fSearchConditionForm.getSelectedEquipment()));
		// 間取り(選択済み）
		mav.addObject("selectedFloorPlanHidden", UtilService.changeListString(fSearchConditionForm.getSelectedFloorPlan()));
		// こだわり条件(選択済み）
		mav.addObject("selectedGoodForConditionHidden", UtilService.changeListString(fSearchConditionForm.getSelectedGoodForCondition()));
		// 敷金
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 礼金
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());

		// 現在のページ番号
		mav.addObject("currentPageNumber", fSearchConditionForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);

		mav.setViewName("/front/fSearchRefineResult");

		return mav;
	}
}
