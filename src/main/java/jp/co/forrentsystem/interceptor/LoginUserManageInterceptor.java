package jp.co.forrentsystem.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * ログインユーザー情報の認証処理インターセプター
 * @author d.kitajima
 *
 */
public class LoginUserManageInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(LoginUserManageInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object controller) throws Exception {

		logger.info("SessionChecker-preHandle");

		HttpSession session = req.getSession();

		// ログインページ・ログイン・ログアウト以外で発動
		String uri = req.getRequestURI();

		// TODO:フロント画面のチェック省く方法は考慮が必要
		if (uri.endsWith("/") || uri.endsWith("/back/login") || uri.endsWith("/back/logout") || uri.endsWith(".css") || uri.endsWith(".js")) {
			return true;
		}

		// セッションチェック
		if (session.getAttribute("systemUser") == null) {
			logger.info("セッションタイムアウト！！！！");
			req.setAttribute("message", "セッションがタイムアウトしました。");
			throw new Exception();
		}
		return true;
	}



}
