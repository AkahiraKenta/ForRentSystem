package jp.co.forrentsystem.controller.backend;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.forrentsystem.constants.ProcessStatus;
import jp.co.forrentsystem.dto.ContactDto;
import jp.co.forrentsystem.form.backend.ContactForm;
import jp.co.forrentsystem.service.ContactService;

/**
 * お問合せ詳細情報コントローラ
 * @author k.akahira
 */
@Controller
public class DetailContactController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(DetailContactController.class);

	@Autowired
	private ContactService contactService;



	/**
	 * お問合せ画面初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/initDetailContact", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		logger.info("DetailContactController-init");

		int contactId = (int)contactService.reloadModel(model, session).get("contactId");

		// お問合せ情報取得
		List<ContactDto> contactList = contactService.getContactByContactId(contactId);

		ModelAndView mav = new ModelAndView();
		mav.addObject("contactForm", new ContactForm());
		mav.addObject("contactList", contactList);
		mav.addObject("processStatusList", ProcessStatus.getProcessStatusList());

		mav.setViewName("./back/detailContact");

		return mav;
	}

	/**
	 * 処理ステータス更新処理
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callUpdateContact", method = RequestMethod.GET)
	public String callUpdategContact(@Param(value="contactId") Integer contactId, @Param(value="processStatus") Integer processStatus, HttpSession session) {
		logger.info("DetailBuildingContactController-callUpdategContact");

		// 検索条件をSESSIONから削除
		session.removeAttribute("searchProcessStatus");

		// 処理ステータス更新
		contactService.updateContactForProcessStatus(contactId, processStatus);
		return "redirect:/back/listContact";
	}
}
