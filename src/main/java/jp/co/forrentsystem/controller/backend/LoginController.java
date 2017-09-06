package jp.co.forrentsystem.controller.backend;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.co.forrentsystem.dto.SystemUserDto;
import jp.co.forrentsystem.form.backend.LoginForm;
import jp.co.forrentsystem.service.SystemUserService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * ログインコントローラ
 */
@Controller
public class LoginController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private SystemUserService loginService;

	/**
	 * 初期表示
	 *
	 * @param loginForm ログインForm
	 * @param result 画面エラー情報
	 *
	 * @return 画面表示情報
	 *
	 */
	@RequestMapping(value = "/back/login", method = RequestMethod.POST)
	public ModelAndView login(@Valid LoginForm loginForm, BindingResult result, HttpSession session) {
		logger.info("LoginController-login");
		ModelAndView mav = new ModelAndView();

		// エラーチェック
		if (result.hasErrors()) {
			// 再度ログイン画面へ
			mav.setViewName("./back/login");
			return mav;
		}

		// ユーザ認証処理
		String systemUserLoginId = loginForm.getSystemUserLoginId();
		String systemUserPassword = loginForm.getSystemUserPassword();
		SystemUserDto systemuserMstDto = loginService.login(systemUserLoginId, systemUserPassword);

		if (systemuserMstDto == null) {
			// 再度ログイン画面へ
			mav.addObject("loginForm", loginForm);
			mav.setViewName("./back/login");
			return mav;
		}

		// ログイン情報をSESSIONに格納
		session.setAttribute("systemUserClass", systemuserMstDto.getSystemUserClass());
		session.setAttribute("systemUserName", systemuserMstDto.getSystemUserName());
		session.setAttribute("systemUser", systemuserMstDto);
		mav.setViewName("redirect:/back/manageTop");

		return mav;
	}

	/**
	 * ログアウト後の初期表示
	 *
	 * @param loginForm ログインForm
	 * @param result 画面エラー情報
	 *
	 * @return 画面表示情報
	 *
	 */
	@RequestMapping(value = "/back/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		logger.info("LoginController-logout");

		// SESSION削除
		// 【使用箇所】メソッド名：callDetailRoomFromBuildingContact（物件お問合せ詳細から部屋詳細画面へ遷移）
		session.removeAttribute("buildingContactId");
		// 【使用箇所】メソッド名：callEditConfirmNews（ニュース編集確認画面へ遷移）
		// ※最終的になくなる可能性あり
		session.removeAttribute("newsForm");
		// 【使用箇所】メソッド名：callSearchBuildingContact（選択された処理ステータスを条件に物件問い合わせ情報を取得）
		// ※最終的になくなる可能性あり
		session.removeAttribute("searchProcessStatus");
		// 【使用箇所】メソッド名：login（初期表示）
		session.removeAttribute("systemUserClass");
		session.removeAttribute("systemUserName");
		session.removeAttribute("systemUser");
		// 【使用箇所】メソッド名：callListBuilding（建物一覧画面遷移）
		session.removeAttribute("searchBuildingForm");
		// 【使用箇所】メソッド名：init（おすすめ物件検索画面初期表示）
		// ※最終的になくなる可能性あり
		session.removeAttribute("searchRecommendedRoomForm");

		ModelAndView mav = new ModelAndView();
		mav.addObject("loginForm", new LoginForm());
		mav.setViewName("redirect:/");

		return mav;

	}
}
