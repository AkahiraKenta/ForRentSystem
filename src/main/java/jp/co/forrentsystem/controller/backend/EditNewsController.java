package jp.co.forrentsystem.controller.backend;

import javax.validation.Valid;

import jp.co.forrentsystem.constants.LinkClass;
import jp.co.forrentsystem.form.backend.NewsForm;
import jp.co.forrentsystem.service.NewsService;
import jp.co.forrentsystem.util.UtilService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * ニュース編集コントローラ
 * @author k.akahira
 */
@Controller
public class EditNewsController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditNewsController.class);

	@Autowired
	private NewsService newsService;

	/**
	 * ニュース編集画面初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/editNews", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		logger.info("EditNewsController-init");

		ModelAndView mav = new ModelAndView();
		mav.addObject("newsForm", (NewsForm)model.get("newsForm"));
		mav.addObject("linkClassList", LinkClass.getLinkClassList());
		mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
		mav.setViewName("./back/editNews");
		return mav;
	}

	/**
	 * ニュース一覧画面へ遷移
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backEditNews", method = RequestMethod.GET)
	public String backEditNews() {
		logger.info("EditNewsController-backEditNews");

		// リダイレクト（ニュース一覧画面）
		return "redirect:/back/listNews";
	}

	/**
	 * ニュース編集確認画面へ遷移
	 *
	 * @param newsForm ニュース編集情報Form
	 * @param result 画面エラー情報
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callEditConfirmNews", method = RequestMethod.POST)
	public ModelAndView callEditConfirmNews(@Valid NewsForm newsForm, BindingResult result, RedirectAttributes attribute) {
		logger.info("EditBuildingController-callEditConfirmBuilding");
		// ニュース編集情報をセッションに設定
		attribute.addFlashAttribute("newsForm", newsForm);

		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			// 建物種別リスト取得
			mav.addObject("newsForm", newsForm);
			mav.addObject("linkClassList", LinkClass.getLinkClassList());
			mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
			mav.setViewName("./back/editNews");
			return mav;
		}
		// リダイレクト（ニュース編集確認画面）
		mav.setViewName("redirect:/back/editConfirmNews");

		return mav;
	}
}
