package jp.co.forrentsystem.controller.backend;

import javax.servlet.http.HttpSession;

import jp.co.forrentsystem.service.BannerService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * バナー設定編集完了画面用コントローラー
 * @author k.akahira
 *
 */
@Controller
public class EditCompleteBannerController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditCompleteBannerController.class);

	@Autowired
	private BannerService bannerService;

	/**
	 * 初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/editCompleteBanner", method = RequestMethod.GET)
	public ModelAndView execute(HttpSession session) {
		logger.info("RegistCompleteBannerController-execute");

		// バナーDTOを削除
		session.removeAttribute("bannerDto");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("./back/editCompleteBanner");

		return mav;
	}
}
