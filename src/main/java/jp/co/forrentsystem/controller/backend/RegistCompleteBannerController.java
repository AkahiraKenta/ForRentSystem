package jp.co.forrentsystem.controller.backend;

import jp.co.forrentsystem.service.BannerService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * バナー設定登録完了画面用コントローラー
 * @author k.akahira
 *
 */
@Controller
public class RegistCompleteBannerController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistCompleteBannerController.class);

	@Autowired
	private BannerService bannerService;

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registCompleteBanner", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("RegistCompleteBannerController-execute");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("./back/registCompleteBanner");

		return mav;
	}
}
