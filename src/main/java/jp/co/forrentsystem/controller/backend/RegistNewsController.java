package jp.co.forrentsystem.controller.backend;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.forrentsystem.constants.LinkClass;
import jp.co.forrentsystem.form.backend.NewsForm;
import jp.co.forrentsystem.service.NewsService;
import jp.co.forrentsystem.util.UtilService;

/**
 * ニュース登録コントローラ
 * @author k.akhaira
 */
@Controller
public class RegistNewsController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistNewsController.class);

	@Autowired
	private NewsService newsService;

	/**
	 * ニュース登録初期表示
	 *
	 * @param model
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registNews", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		logger.info("RegistNewsController-init");

		model = newsService.reloadModel(model, session);

		NewsForm newsForm = (NewsForm)model.get("newsForm");
		if (newsForm == null) {
			newsForm = new NewsForm();
			newsForm.setNewsId((Integer)model.get("newsId"));
		}


		ModelAndView mav = new ModelAndView();
		mav.addObject("newsForm", newsForm);
		mav.addObject("linkClassList", LinkClass.getLinkClassList());
		mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
		mav.setViewName("./back/registNews");

		return mav;
	}

	/**
	 * ニュース確認画面遷移
	 *
	 * @param newsForm ニュースForm
	 * @param result 画面エラー情報
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callRegistConfirmNews", method = RequestMethod.POST)
	public ModelAndView callRegistConfirmNews(@Valid NewsForm newsForm, BindingResult result, RedirectAttributes attribute) {
		logger.info("RegistNewsController-callRegistConfirmNews");

		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.addObject("newsForm", newsForm);
			mav.addObject("linkClassList", LinkClass.getLinkClassList());
			mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
			mav.setViewName("./back/registNews");
			return mav;
		}

		// ニュース情報をattributeに設定
		attribute.addFlashAttribute("newsForm", newsForm);

		mav.setViewName("redirect:/back/registComfirmNews");
		return mav;
	}

	/**
	 * ニュース登録画面へ遷移
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backRegistNews", method = RequestMethod.GET)
	public String backRegistNews() {
		logger.info("RegistNewsController-backRegistNews");

		return "redirect:/back/listNews";
	}
}
