package jp.co.forrentsystem.controller.backend;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.co.forrentsystem.constants.BuildingType;
import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.dto.FloorDto;
import jp.co.forrentsystem.form.backend.SearchRecommendedRoomForm;
import jp.co.forrentsystem.service.FloorService;
import jp.co.forrentsystem.service.RecommendedRoomsService;
import jp.co.forrentsystem.util.PagerUtil;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * おすすめ物件情報検索コントローラ
 * @author k.akahira
 */
@Controller
public class SearchRecommendedRoomController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(SearchRecommendedRoomController.class);

	@Autowired
	private RecommendedRoomsService recommendedRoomsService;
	@Autowired
	private FloorService floorService;

	/**
	 * おすすめ物件検索画面初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/searchRecommendedRoom", method = RequestMethod.GET)
	public ModelAndView init(HttpSession session) {
		logger.info("SearchRecommendedRoomController-init");

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		// 初期表示のみ、ページング情報をFormに設定
		SearchRecommendedRoomForm searchRecommendedRoomForm = new SearchRecommendedRoomForm();
		// 現在ページを設定
		searchRecommendedRoomForm.setCurrentPage(currentPageDef);
		// ページング情報
		searchRecommendedRoomForm = recommendedRoomsService.getPagerForSearchRecommendedRoom(searchRecommendedRoomForm);
		int beginPage = PagerUtil.getBeginPage(searchRecommendedRoomForm.getCurrentPage(),searchRecommendedRoomForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,searchRecommendedRoomForm.getPageTotalNumber());

		// おすすめ物件Form情報をSESSIONに設定
		session.setAttribute("searchRecommendedRoomForm", searchRecommendedRoomForm);

		// おすすめ物件設定可能な物件リスト取得
		List<ArticleDto> articleList = recommendedRoomsService.getArticleForRecommendedRoom(searchRecommendedRoomForm);

		ModelAndView mav = new ModelAndView();
		mav.addObject("searchRecommendedRoomForm", searchRecommendedRoomForm);
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeAndBlankList());
		mav.addObject("floorList", addBlank(floorService.getFloorList()));
		mav.addObject("articleList", articleList);
		// 現在のページ番号
		mav.addObject("currentPageNumber", searchRecommendedRoomForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);
		mav.setViewName("./back/searchRecommendedRoom");

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
	@RequestMapping(value = "/back/pagerForRecommendedRoom", method = RequestMethod.GET)
    public ModelAndView pagerForRecommendedRoom(@Param(value="totalNumber") Integer totalNumber,
    					   @Param(value="viewNumber") Integer viewNumber,
    					   @Param(value="pageTotalNumber") Integer pageTotalNumber,
    					   @Param(value="pageNumber") Integer pageNumber,
    					   HttpSession session) {
		logger.info("SearchRecommendedRoomController-pagerForRecommendedRoom");

		SearchRecommendedRoomForm searchRecommendedRoomForm = (SearchRecommendedRoomForm)session.getAttribute("searchRecommendedRoomForm");
		searchRecommendedRoomForm.setTotalNumber(pageTotalNumber);
		// 今回選択されたページ数
		searchRecommendedRoomForm.setCurrentPage(pageNumber);
		searchRecommendedRoomForm.setViewNumber(viewNumber);
		searchRecommendedRoomForm.setPageTotalNumber(pageTotalNumber);
		int beginPage = PagerUtil.getBeginPage(pageNumber,pageTotalNumber);
		int endPage =  PagerUtil.getEndPage(beginPage,pageTotalNumber);

		// おすすめ物件設定可能な物件リスト取得
		List<ArticleDto> articleList = recommendedRoomsService.getArticleForRecommendedRoom(searchRecommendedRoomForm);

		ModelAndView mav = new ModelAndView();
		mav.addObject("searchRecommendedRoomForm", searchRecommendedRoomForm);
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeAndBlankList());
		mav.addObject("floorList", addBlank(floorService.getFloorList()));
		mav.addObject("articleList", articleList);
		// 現在のページ番号
		mav.addObject("currentPageNumber", pageNumber);
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);
		mav.setViewName("./back/searchRecommendedRoom");

		return mav;
	}


	/**
	 * 物件検索
	 *
	 * @param searchRecommendedRoomForm おすすめ物件Form
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callSearchRecommendedRoom", method = RequestMethod.POST)
    public ModelAndView searchRecommendedRoom(@Valid SearchRecommendedRoomForm searchRecommendedRoomForm,
    		HttpSession session) {
		logger.info("SearchRecommendedRoomController-searchRecommendedRoom");

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		searchRecommendedRoomForm.setCurrentPage(currentPageDef);
		// ページング情報
		searchRecommendedRoomForm = recommendedRoomsService.getPagerForSearchRecommendedRoom(searchRecommendedRoomForm);
		int beginPage = PagerUtil.getBeginPage(searchRecommendedRoomForm.getCurrentPage(),searchRecommendedRoomForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,searchRecommendedRoomForm.getPageTotalNumber());


		// 検索条件をSESSIONに設定
		session.setAttribute("searchRecommendedRoomForm", searchRecommendedRoomForm);
		// おすすめ物件設定可能な物件リスト取得
		List<ArticleDto> articleList = recommendedRoomsService.getArticleForRecommendedRoom(searchRecommendedRoomForm);

		ModelAndView mav = new ModelAndView();
		mav.addObject("searchRecommendedRoomForm", searchRecommendedRoomForm);
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeAndBlankList());
		mav.addObject("floorList", addBlank(floorService.getFloorList()));
		mav.addObject("articleList", articleList);
		// 現在のページ番号
		mav.addObject("currentPageNumber", searchRecommendedRoomForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);
		mav.setViewName("./back/searchRecommendedRoom");

		return mav;
	}

	/**
	 * おすすめ物件登録
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 * @param session セッション
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registRecommendedRoom", method = RequestMethod.GET)
    public ModelAndView registRecommendedRoom(@Param(value="buildingId") Integer buildingId,
    					   @Param(value="roomId") Integer roomId, HttpSession session) {
		logger.info("SearchRecommendedRoomController-registRecommendedRoom");

		// おすすめ物件登録
		recommendedRoomsService.registRecommendedRoom(buildingId, roomId);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/back/listRecommendedRoom");

		return mav;
	}

	/**
	 * 階層コードリストに空行を追加
	 *
	 * @param floorList 階層リスト
	 *
	 * @return 階層リスト
	 */
	private List<FloorDto> addBlank(List<FloorDto> floorList) {
		int floorClassId = 0;
		String floorName = "";

		FloorDto floorDto = new FloorDto();
		floorDto.setFloorClassId(floorClassId);
		floorDto.setFloorName(floorName);
		floorList.add(0, floorDto);
		return floorList;
	}
}
