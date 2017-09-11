package jp.co.forrentsystem.controller.backend;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.forrentsystem.form.backend.NewsForm;
import jp.co.forrentsystem.service.NewsService;

/**
 * ニュース編集確認コントローラ
 * @author k.akahira
 */
@Controller
public class EditConfirmNewsController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditConfirmNewsController.class);

	@Autowired
	private NewsService newsService;

	/**
	 * ニュース編集確認画面初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 *
	 */
	@RequestMapping(value = "/back/editConfirmNews", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		logger.info("EditConfirmNewsController-init");

		model = newsService.reloadModel(model, session);

		ModelAndView mav = new ModelAndView();
		mav.addObject("newsForm", model.get("newsForm"));
		mav.setViewName("./back/editConfirmNews");

		return mav;
	}

	/**
	 * ニュース編集完了画面遷移
	 *
	 * @param newsForm ニュースForm
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/calleditCompleteNews", method = RequestMethod.POST)
	public String callEditCompleteNews(@Valid NewsForm newsForm) {
		logger.info("EditConfirmNewsController-callEditCompleteNews");

		// ニュース編集処理
		newsService.updateNews(newsForm);

		return "redirect:/back/editCompleteNews";
	}


	/**
	 * 戻るボタン押下
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/calleditCompleteNews", params="back", method = RequestMethod.POST)
	public String backEditCompleteNews(@Valid NewsForm newsForm, RedirectAttributes attribute) {
		logger.info("EditConfirmNewsController-backEditConfirmNews");

		attribute.addFlashAttribute("newsForm", newsForm);

		// ニュース情報をSESSIONに設定
		return "redirect:/back/editNews";
	}
}
