package jp.co.forrentsystem.controller.backend;

import jp.co.forrentsystem.form.backend.LoginForm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 初回呼び出しコントローラ
 * @author k.akahira
 */
@Controller
public class IndexController {

	/**
	 * 初期画面表示処理
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView execute() {

		ModelAndView mav = new ModelAndView();
		mav.addObject("loginForm", new LoginForm());
		mav.setViewName("./back/login");

		return mav;
	}
}
