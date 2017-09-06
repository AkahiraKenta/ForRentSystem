package jp.co.forrentsystem.controller.backend;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.co.forrentsystem.constants.ProcessStatus;
import jp.co.forrentsystem.dto.ContactDto;
import jp.co.forrentsystem.form.backend.ContactForm;
import jp.co.forrentsystem.service.ContactService;
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
 * お問合せ照会画面用コントローラー
 * @author k.akahira
 *
 */
@Controller
public class ListContactController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(ListContactController.class);

	@Autowired
	private ContactService contactService;

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/listContact", method = RequestMethod.GET)
	public ModelAndView init(HttpSession session) {
		logger.info("ListBuildingContactController-execute");

		// 前回の検索条件をSESSIONから削除
		session.removeAttribute("searchProcessStatus");
		// お問合せIDをSESSIONから削除
		session.removeAttribute("contactId");
		session.setAttribute("searchProcessStatus", 1);

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;

		ContactForm contactForm = new ContactForm();

		// 処理ステータス（初期値:1未処理)
		int processStatus = ProcessStatus.LEFT_UNATTENDED.getValue();

		// 現在ページを設定
		contactForm.setCurrentPage(currentPageDef);
		contactForm.setSearchProcessStatus(processStatus);
		contactForm.setProcessStatus(processStatus);

		// ページング情報をFormに設定
		contactForm = contactService.getPagerInfo(contactForm);
		int beginPage = PagerUtil.getBeginPage(contactForm.getCurrentPage(),contactForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,contactForm.getPageTotalNumber());

		// お問合わせ情報取得
		List<ContactDto> contactList = contactService.getContactList(contactForm);

		ModelAndView mav = new ModelAndView();
		mav.addObject("processStatusList", ProcessStatus.getProcessStatusList());
		mav.addObject("contactList", contactList);
		mav.addObject("contactForm", contactForm);
		// 現在のページ番号
		mav.addObject("currentPageNumber", contactForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);
		mav.setViewName("./back/listContact");

		return mav;
	}

	/**
	 * 選択された処理ステータスを条件に問い合わせ情報を取得
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callSearchContact", method = RequestMethod.POST)
	public ModelAndView callSearchContact(@Valid ContactForm contactForm, HttpSession session) {
		logger.info("ListBuildingContactController-callSearchContact");

		session.setAttribute("searchProcessStatus", contactForm.getSearchProcessStatus());

		// 現在のページのデフォルト値
		Integer currentPageDef = 1;
		// 現在ページを設定
		contactForm.setCurrentPage(currentPageDef);

		contactForm.setProcessStatus(contactForm.getSearchProcessStatus());

		// ページング情報をFormに設定
		contactForm = contactService.getPagerInfo(contactForm);
		int beginPage = PagerUtil.getBeginPage(contactForm.getCurrentPage(),contactForm.getPageTotalNumber());
		int endPage =  PagerUtil.getEndPage(beginPage,contactForm.getPageTotalNumber());

		// 物件お問合わせ情報取得
		List<ContactDto> contactList = contactService.getContactList(contactForm);

		ModelAndView mav = new ModelAndView();
		mav.addObject("processStatusList", ProcessStatus.getProcessStatusList());
		mav.addObject("contactList", contactList);
		mav.addObject("contactForm", contactForm);
		// 現在のページ番号
		mav.addObject("currentPageNumber", contactForm.getCurrentPage());
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);
		mav.setViewName("./back/listContact");

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
	@RequestMapping(value = "/back/pagerForContact", method = RequestMethod.GET)
    public ModelAndView pagerForContact(@Param(value="totalNumber") Integer totalNumber,
    					   @Param(value="viewNumber") Integer viewNumber,
    					   @Param(value="pageTotalNumber") Integer pageTotalNumber,
    					   @Param(value="pageNumber") Integer pageNumber,
    					   HttpSession session) {
		logger.info("SearchRecommendedRoomController-pagerForContact");

		ContactForm contactForm = new ContactForm();
		contactForm.setSearchProcessStatus((int)session.getAttribute("searchProcessStatus"));
		contactForm.setTotalNumber(pageTotalNumber);
		// 今回選択されたページ数
		contactForm.setCurrentPage(pageNumber);
		contactForm.setViewNumber(viewNumber);
		contactForm.setPageTotalNumber(pageTotalNumber);
		int beginPage = PagerUtil.getBeginPage(pageNumber,pageTotalNumber);
		int endPage =  PagerUtil.getEndPage(beginPage, pageTotalNumber);

		// お問合わせ情報取得
		List<ContactDto> contactList = contactService.getContactList(contactForm);

		ModelAndView mav = new ModelAndView();
		mav.addObject("processStatusList", ProcessStatus.getProcessStatusList());
		mav.addObject("contactList", contactList);
		mav.addObject("contactForm", contactForm);
		// 現在のページ番号
		mav.addObject("currentPageNumber", pageNumber);
		// 表示上最初のページ数
		mav.addObject("beginPage", beginPage);
		// 表示上最後のページ数
		mav.addObject("endPage", endPage);
		mav.setViewName("./back/listContact");

		return mav;
	}

	/**
	 * 詳細ボタン押下時、お問合せ詳細画面遷移
	 *
	 * @param contactId お問合せID
	 *
	 * @return 画面遷移
	 */
	@RequestMapping(value = "/back/detailContact", method = RequestMethod.GET)
	public String detailBuildingContact(RedirectAttributes attributes, @Param(value="contactId") Integer contactId) {
		logger.info("ListSystemUserController-detailBuildingContact");

		attributes.addFlashAttribute("contactId", contactId);

		return "redirect:/back/initDetailContact";
	}
}
