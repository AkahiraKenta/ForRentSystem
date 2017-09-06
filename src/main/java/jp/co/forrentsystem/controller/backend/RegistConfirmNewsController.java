package jp.co.forrentsystem.controller.backend;

import javax.validation.Valid;

import jp.co.forrentsystem.form.backend.NewsForm;
import jp.co.forrentsystem.service.NewsService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * ニュース登録確認コントローラ
 * @author k.akahira
 */
@Controller
public class RegistConfirmNewsController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistConfirmNewsController.class);

	@Autowired
	private NewsService newsService;
	/**
	 * ニュース登録確認画面初期表示
	 *
	 * @param model
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registComfirmNews", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		logger.info("RegistConfirmNewsController-init");

		ModelAndView mav = new ModelAndView();
		mav.addObject("newsForm", model.get("newsForm"));
		mav.setViewName("./back/registConfirmNews");

		return mav;
	}

	/**
	 * ニュース完了画面へ遷移
	 *
	 * @param newsForm ニュースForm
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callRegistCompleteNews", method = RequestMethod.POST)
	public String callRegistCompleteNews(@Valid NewsForm newsForm, RedirectAttributes attribute) {
		logger.info("RegistConfirmNewsController-callRegistCompleteNews");

		// ニュース登録処理
		newsService.registNews(newsForm);

		int newsId = newsService.getMaxNewsId();
		attribute.addFlashAttribute("newsId", newsId);

		return "redirect:/back/registCompleteNews";
	}


	/**
	 * ニュース登録画面へ遷移
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callRegistCompleteNews", params="back", method = RequestMethod.POST)
	public String backRegistCompleteNews(@Valid NewsForm newsForm, RedirectAttributes attribute) {
		logger.info("RegistConfirmNewsController-backRegistConfirmNews");

		attribute.addFlashAttribute("newsForm", newsForm);

		// ニュース情報登録画面へ
		return "redirect:/back/registNews";
	}
}
