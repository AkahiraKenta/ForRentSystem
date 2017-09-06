package jp.co.forrentsystem.controller.backend;

import java.util.List;

import javax.servlet.http.HttpSession;

import jp.co.forrentsystem.constants.BuildingType;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.dto.StructureDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.form.backend.ListBuildingForm;
import jp.co.forrentsystem.form.backend.SearchBuildingForm;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.NearestStationService;
import jp.co.forrentsystem.service.StructureService;
import jp.co.forrentsystem.util.PagerUtil;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 建物情報一覧コントローラ
 * @author k.akahira
 */
@Controller
public class ListBuildingController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(ListBuildingController.class);

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private NearestStationService nearestStationService;
	@Autowired
	private StructureService structureService;

	/**
	 * 建物一覧初期表示(メニューから遷移)
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/listBuilding", method = RequestMethod.GET)
	public ModelAndView init(HttpSession session, ModelMap model) {
		logger.info("ListBuildingController-init");

		// 建物検索条件を削除
		session.removeAttribute("searchBuildingForm");

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		// 初期表示のみ、ページング情報をFormに設定
		ListBuildingForm listBuildingForm = new ListBuildingForm();
		// 検索条件
		SearchBuildingForm searchBuildingForm = new SearchBuildingForm();
		// 現在ページを設定
		listBuildingForm.setCurrentPage(currentPageDef);
		// TODO:一旦、おすすめ物件画面の物件検索表示件数と同じ設定値を使用しています。
		// ページング情報
		listBuildingForm = buildingService.getPagerForSearchBuilding(listBuildingForm, searchBuildingForm);
		int beginPage = PagerUtil.getBeginPage(listBuildingForm.getCurrentPage(),listBuildingForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,listBuildingForm.getPageTotalNumber());

		// 建物検索
		List<BuildingDto> buildingDtoList = buildingService.searchBuildingList(listBuildingForm, searchBuildingForm);

		// 建物一覧Formに画面遷移元区別のための目印値を格納
		listBuildingForm.setBuildingListFlag(0);

		ModelAndView mav = new ModelAndView();
		mav.addObject("listBuildingForm", listBuildingForm);
		mav.addObject("buildingDtoList", buildingDtoList);
		// 現在のページ番号
		mav.addObject("currentPageNumber", listBuildingForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);
		// メッセージ
		mav.addObject("message", model.get("message"));
		mav.setViewName("./back/listBuilding");

		return mav;
	}

	/**
	 * 建物一覧初期表示(建物検索画面から遷移）
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callListBuilding", method = RequestMethod.GET)
	public ModelAndView callListBuilding(HttpSession session) {
		logger.info("ListBuildingController-callListBuilding");

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		// 初期表示のみ、ページング情報をFormに設定
		ListBuildingForm listBuildingForm = new ListBuildingForm();
		// 検索条件
		SearchBuildingForm searchBuildingForm = new SearchBuildingForm();
		if(session.getAttribute("searchBuildingForm") != null) {
			searchBuildingForm = (SearchBuildingForm)session.getAttribute("searchBuildingForm");
		}
		// 現在ページを設定
		listBuildingForm.setCurrentPage(currentPageDef);
		// TODO:一旦、おすすめ物件画面の物件検索表示件数と同じ設定値を使用しています。
		// ページング情報
		listBuildingForm = buildingService.getPagerForSearchBuilding(listBuildingForm, searchBuildingForm);
		int beginPage = PagerUtil.getBeginPage(listBuildingForm.getCurrentPage(),listBuildingForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,listBuildingForm.getPageTotalNumber());

		// 建物検索
		List<BuildingDto> buildingDtoList = buildingService.searchBuildingList(listBuildingForm, searchBuildingForm);

		// 建物一覧Formに画面遷移元区別のための目印値を格納
		listBuildingForm.setBuildingListFlag(1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("listBuildingForm", listBuildingForm);
		mav.addObject("buildingDtoList", buildingDtoList);
		// 現在のページ番号
		mav.addObject("currentPageNumber", listBuildingForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);
		mav.setViewName("./back/listBuilding");

		return mav;
	}

	/**
	 * 建物詳細画面へ遷移
	 *
	 * @param buildingId 建物ID
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callDetailBuildingByBuildingId", method = RequestMethod.GET)
	public ModelAndView detailBuilding(@Param(value="buildingId") Integer buildingId, RedirectAttributes attribute) {
		logger.info("ListBuildingController-callDetailBuilding");

		// 建物IDをキーに建物情報取得
		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);
		// 最寄駅名称取得
		List<NearestStationNameDto> nearestStationNameDtoList = nearestStationService.getNearestStationNameList(buildingId);
		// 建物種別名称取得
		String buildingTypeName = BuildingType.getTargetName(buildingDto.getBuildingType());
		// 建物構造名称取得
		StructureDto structureDto = structureService.getStructureName(buildingDto.getStructureId());

		DetailBuildingForm detailBuildingForm = buildingService.getDetailBuildingForm(buildingDto, nearestStationNameDtoList
				,buildingTypeName, structureDto);

		// 建物詳細FormをSESSIONに設定
		attribute.addFlashAttribute("detailBuildingForm", detailBuildingForm);

		ModelAndView mav = new ModelAndView();
		// リダイレクト（建物詳細画面）
		mav.setViewName("redirect:/back/detailBuilding");

		return mav;
	}

	/**
	 * 建物検索画面へ遷移
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backListBuilding", method = RequestMethod.GET)
	public ModelAndView back(HttpSession session) {
		logger.info("ListBuildingController-back");

		// 建物一覧情報FORMをセッションに設定
		session.removeAttribute("listBuildingForm");

		ModelAndView mav = new ModelAndView();
		mav.addObject("listBuildingForm", new ListBuildingForm());
		// リダイレクト（建物検索画面）
		mav.setViewName("redirect:/back/backSearchBuildingForListBuilding");

		return mav;
	}

	/**
	 * ページングによる建物一覧再検索
	 *
	 * @param totalNumber 全件数
	 * @param viewNumber 表示件数
	 * @param pageTotalNumber 全ページ数
	 * @param pageNumber 現在のページ番号
	 * @param buildingListFlag 建物一覧への遷移元判別フラグ
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/pagerForListBuilding", method = RequestMethod.GET)
    public ModelAndView pagerForListBuilding(@Param(value="totalNumber") Integer totalNumber,
    					   @Param(value="viewNumber") Integer viewNumber,
    					   @Param(value="pageTotalNumber") Integer pageTotalNumber,
    					   @Param(value="pageNumber") Integer pageNumber,
    					   @Param(value="buildingListFlag") Integer buildingListFlag,
    					   HttpSession session) {
		logger.info("ListBuildingController-pagerForListBuilding");

		// 初期表示のみ、ページング情報をFormに設定
		ListBuildingForm listBuildingForm = new ListBuildingForm();
		listBuildingForm.setBuildingListFlag(buildingListFlag);
		// 検索条件
		SearchBuildingForm searchBuildingForm = new SearchBuildingForm();
		if(session.getAttribute("searchBuildingForm") != null && buildingListFlag == 1) {
			searchBuildingForm = (SearchBuildingForm)session.getAttribute("searchBuildingForm");
		}

		listBuildingForm.setTotalNumber(pageTotalNumber);
		listBuildingForm.setCurrentPage(pageNumber);
		listBuildingForm.setViewNumber(viewNumber);
		listBuildingForm.setPageTotalNumber(pageTotalNumber);
		int beginPage = PagerUtil.getBeginPage(listBuildingForm.getCurrentPage(),listBuildingForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,listBuildingForm.getPageTotalNumber());

		// 建物検索
		List<BuildingDto> buildingDtoList = buildingService.searchBuildingList(listBuildingForm, searchBuildingForm);

		ModelAndView mav = new ModelAndView();
		mav.addObject("listBuildingForm", listBuildingForm);
		mav.addObject("buildingDtoList", buildingDtoList);
		// 現在のページ番号
		mav.addObject("currentPageNumber", listBuildingForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage",endPage);
		mav.setViewName("./back/listBuilding");

		return mav;
	}
}
