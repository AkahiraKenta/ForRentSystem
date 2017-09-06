package jp.co.forrentsystem.controller.backend;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.co.forrentsystem.constants.ProcessStatus;
import jp.co.forrentsystem.dto.BuildingContactDto;
import jp.co.forrentsystem.form.backend.BuildingContactForm;
import jp.co.forrentsystem.service.BuildingContactService;
import jp.co.forrentsystem.util.PagerUtil;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 物件お問合せ照会画面用コントローラー
 * @author k.akahira
 *
 */
@Controller
public class ListBuildingContactController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(ListBuildingContactController.class);

	@Autowired
	private BuildingContactService buildingContactService;

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/listBuildingContact", method = RequestMethod.GET)
	public ModelAndView init(HttpSession session) {
		logger.info("ListBuildingContactController-execute");

		// 前回の検索条件をSESSIONから削除
		session.removeAttribute("searchProcessStatus");
		// 物件お問合せIDをSESSIONから削除
		session.removeAttribute("buildingContactId");
		session.setAttribute("searchProcessStatus", 1);
		// 現在のページのデフォルト値
		Integer currentPageDef = 1;

		BuildingContactForm buildingContactForm = new BuildingContactForm();

		// 処理ステータス（初期値:1未処理)
		int processStatus = ProcessStatus.LEFT_UNATTENDED.getValue();

		// 現在ページを設定
		buildingContactForm.setCurrentPage(currentPageDef);
		buildingContactForm.setSearchProcessStatus(processStatus);
		buildingContactForm.setProcessStatus(processStatus);

		// ページング情報をFormに設定
		buildingContactForm = buildingContactService.getPagerInfo(buildingContactForm);
		int beginPage = PagerUtil.getBeginPage(buildingContactForm.getCurrentPage(),buildingContactForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,buildingContactForm.getPageTotalNumber());

		// 物件お問合わせ情報取得
		List<BuildingContactDto> buildingContactList = buildingContactService.getBuildingContactList(buildingContactForm);

		ModelAndView mav = new ModelAndView();
		mav.addObject("processStatusList", ProcessStatus.getProcessStatusList());
		mav.addObject("buildingContactList", buildingContactList);
		mav.addObject("buildingContactForm", buildingContactForm);
		// 現在のページ番号
		mav.addObject("currentPageNumber", buildingContactForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);
		mav.setViewName("./back/listBuildingContact");

		return mav;
	}

	/**
	 * 選択された処理ステータスを条件に物件問い合わせ情報を取得
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callSearchBuildingContact", method = RequestMethod.POST)
	public ModelAndView callSearchBuildingContact(@Valid BuildingContactForm buildingContactForm, HttpSession session) {
		logger.info("ListBuildingContactController-callSearchBuildingContact");

		session.setAttribute("searchProcessStatus", buildingContactForm.getSearchProcessStatus());

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		// 現在ページを設定
		buildingContactForm.setCurrentPage(currentPageDef);

		buildingContactForm.setProcessStatus(buildingContactForm.getSearchProcessStatus());

		// ページング情報をFormに設定
		buildingContactForm = buildingContactService.getPagerInfo(buildingContactForm);
		int beginPage = PagerUtil.getBeginPage(buildingContactForm.getCurrentPage(),buildingContactForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,buildingContactForm.getPageTotalNumber());

		// 物件お問合わせ情報取得
		List<BuildingContactDto> buildingContactList = buildingContactService.getBuildingContactList(buildingContactForm);

		ModelAndView mav = new ModelAndView();
		mav.addObject("processStatusList", ProcessStatus.getProcessStatusList());
		mav.addObject("buildingContactList", buildingContactList);
		mav.addObject("buildingContactForm", buildingContactForm);
		// 現在のページ番号
		mav.addObject("currentPageNumber", buildingContactForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);
		mav.setViewName("./back/listBuildingContact");

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
	@RequestMapping(value = "/back/pagerForBuildingContact", method = RequestMethod.GET)
    public ModelAndView pagerForBuildingContact(@Param(value="totalNumber") Integer totalNumber,
    					   @Param(value="viewNumber") Integer viewNumber,
    					   @Param(value="pageTotalNumber") Integer pageTotalNumber,
    					   @Param(value="pageNumber") Integer pageNumber,
    					   HttpSession session) {
		logger.info("SearchRecommendedRoomController-pagerForRecommendedRoom");

		BuildingContactForm buildingContactForm = new BuildingContactForm();
		buildingContactForm.setSearchProcessStatus((int)session.getAttribute("searchProcessStatus"));
		buildingContactForm.setTotalNumber(pageTotalNumber);
		// 今回選択されたページ数
		buildingContactForm.setCurrentPage(pageNumber);
		buildingContactForm.setViewNumber(viewNumber);
		buildingContactForm.setPageTotalNumber(pageTotalNumber);

		int beginPage = PagerUtil.getBeginPage(pageNumber, pageTotalNumber);
		int endPage =  PagerUtil.getEndPage(beginPage,pageTotalNumber);

		// 物件お問合わせ情報取得
		List<BuildingContactDto> buildingContactList = buildingContactService.getBuildingContactList(buildingContactForm);

		ModelAndView mav = new ModelAndView();
		mav.addObject("processStatusList", ProcessStatus.getProcessStatusList());
		mav.addObject("buildingContactList", buildingContactList);
		mav.addObject("buildingContactForm", buildingContactForm);
		// 現在のページ番号
		mav.addObject("currentPageNumber", pageNumber);
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);
		mav.setViewName("./back/listBuildingContact");

		return mav;
	}

	/**
	 * 詳細ボタン押下時、物件お問合せ詳細画面遷移
	 *
	 * @param buildingContactId 物件お問合せID
	 *
	 * @return 画面遷移
	 */
	@RequestMapping(value = "/back/detailBuildingContact", method = RequestMethod.GET)
	public String detailBuildingContact(RedirectAttributes attributes, @Param(value="buildingContactId") Integer buildingContactId) {
		logger.info("ListSystemUserController-detailBuildingContact");

		attributes.addFlashAttribute("buildingContactId", buildingContactId);

		return "redirect:/back/initDetailBuildingContact";
	}
}
