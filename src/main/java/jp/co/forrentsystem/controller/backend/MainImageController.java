package jp.co.forrentsystem.controller.backend;

import jp.co.forrentsystem.constants.LinkClass;
import jp.co.forrentsystem.form.backend.MainImageForm;
import jp.co.forrentsystem.service.MainImageService;
import jp.co.forrentsystem.util.UtilService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// TODO:作成途中（一旦作業止めている状態）
/**
 * メイン画像コントローラ
 * @author k.akahira
 */
@Controller
public class MainImageController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(MainImageController.class);

	@Autowired
	private MainImageService mainImageService;

	/**
	 * メイン画像マスタ初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/listMainImage", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("MainImageController-execute");

		ModelAndView mav = new ModelAndView();
		mav.addObject("mainImageForm", new MainImageForm());
		mav.addObject("displayFlagList", UtilService.getMasterDtoListForViewFlag());
		mav.addObject("linkClassList", LinkClass.getLinkClassList());
		mav.setViewName("./back/mainImage");
		return mav;
	}
}
