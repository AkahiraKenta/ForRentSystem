package jp.co.forrentsystem.controller.backend;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.forrentsystem.form.backend.NewsForm;
import jp.co.forrentsystem.service.NewsService;

/**
 * ニュース登録完了コントローラ
 * @author k.akahira
 */
@Controller
public class RegistCompleteNewsController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistCompleteNewsController.class);

	@Autowired
	private NewsService newsService;

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registCompleteNews", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		logger.info("RegistCompleteNewsController-init");

		model = newsService.reloadModel(model, session);

		// ニュース登録画面へ
		ModelAndView mav = new ModelAndView();
		mav.addObject("newsId", model.get("newsId"));
		mav.setViewName("./back/registCompleteNews");
		return mav;
	}

	/**
	 * ニュース登録画面へ遷移
	 *
	 * @param newsId ニュースID
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/back/continueRegistNews", method = RequestMethod.GET)
	public String continueRegistNews(@Param(value="newsId") Integer newsId) {
		logger.info("RegistCompleteNewsController-continueRegistNews");

		NewsForm newsForm = newsService.getNewsByNewsId(newsId);

		return "redirect:/back/registNews";
	}

	@RequestMapping(value = "/back/back/backRegistCompleteNewsToManageTop", method = RequestMethod.GET)
	public String backRegistCompleteNewsToManageTop() {
		logger.info("RegistCompleteNewsController-backRegistCompleteNewsToManageTop");

		// 管理TOP画面へ
		return "redirect:/back/manageTop";
	}

	/**
	 * ニュース一覧画面へ遷移
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/back/backRegistCompleteNewsToListNews", method = RequestMethod.GET)
	public String backRegistCompleteRoomToListNews() {
		logger.info("RegistCompleteNewsController-backRegistCompleteRoomToListNews");

		// ニュース一覧画面へ
		return "redirect:/back/listNews";
	}
}
