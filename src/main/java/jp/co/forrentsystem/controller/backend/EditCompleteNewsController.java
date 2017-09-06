package jp.co.forrentsystem.controller.backend;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * ニュース編集完了コントローラ
 * @author k.akahira
 */
@Controller
public class EditCompleteNewsController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditCompleteNewsController.class);

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/editCompleteNews", method = RequestMethod.GET)
	public ModelAndView init() {
		logger.info("EditCompleteNewsController-init");

		// ニュース登録画面へ
		ModelAndView mav = new ModelAndView();
		mav.setViewName("./back/editCompleteNews");
		return mav;
	}

	/**
	 * 管理画面TOPへ戻る
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backEditCompleteNewsToManageTop", method = RequestMethod.GET)
	public ModelAndView backRegistCompleteNewsToManageTop(HttpSession session) {
		logger.info("EditCompleteNewsController-backEditCompleteNewsToManageTop");

		// ニュース情報のSESSION削除
		session.removeAttribute("newsForm");

		// 管理TOP画面へ
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/back/manageTop");

		return mav;
	}

	/**
	 * ニュース一覧画面へ戻る
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backEditCompleteNewsToListNews", method = RequestMethod.GET)
	public ModelAndView backEditCompleteNewsToListNews(HttpSession session) {
		logger.info("RegistCompleteRoomController-backEditCompleteNewsToListNews");

		// ニュース情報のSESSION削除
		session.removeAttribute("newsForm");

		// ニュース一覧画面へ
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/back/listNews");

		return mav;
	}
}
