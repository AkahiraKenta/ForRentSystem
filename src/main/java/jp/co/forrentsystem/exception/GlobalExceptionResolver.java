package jp.co.forrentsystem.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 共通例外クラス
 * @author k.akahira
 *
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(GlobalExceptionResolver.class);


	public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object object, Exception exception) {

		logger.error("例外をキャッチしました。", exception);

		ModelAndView mav = new ModelAndView();

		if (request.getAttribute("message") == null) {
			// JSPに表示する固定メッセージをセットします。
			mav.addObject("message", "予期せぬエラーが発生しました.");
		} else {
			// JSPに表示する渡されたメッセージをセットします。
			mav.addObject("message", request.getAttribute("message"));
		}
		mav.addObject("exception", exception);

		// 遷移先のJSPを指定します。(error.jspに遷移します。)
		mav.setViewName("error");
		return mav;

	}
}
