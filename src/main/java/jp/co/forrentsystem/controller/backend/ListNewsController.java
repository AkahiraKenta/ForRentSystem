package jp.co.forrentsystem.controller.backend;

import java.util.List;

import jp.co.forrentsystem.constants.LinkClass;
import jp.co.forrentsystem.dto.NewsDto;
import jp.co.forrentsystem.form.backend.NewsForm;
import jp.co.forrentsystem.service.NewsService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * ニュース一覧コントローラ
 * @author k.akahira
 */
@Controller
public class ListNewsController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(ListNewsController.class);

	@Autowired
	private NewsService newsService;

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/listNews", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("ListNewsController-execute");

		// ニュース情報取得
		List<NewsDto> newsList = newsService.getListNews();

		ModelAndView mav = new ModelAndView();
		mav.addObject("newsForm", new NewsForm());
		mav.addObject("newsList", newsList);
		mav.addObject("linkClassList", LinkClass.getLinkClassList());
		mav.setViewName("./back/listNews");
		return mav;
	}

	/**
	 * ニュース情報を削除
	 *
	 * @param newsId ニュースID
	 *
	 * @return ニュースID
	 */
	@ResponseBody
	@RequestMapping(value = "/back/deleteNews", method = RequestMethod.GET)
	public Integer deleteNews(@Param(value="newsId") Integer newsId) {
		logger.info("ListNewsController-deleteNews");

		// ニュース情報を削除
		newsService.deleteNews(newsId);

		return newsId;
	}

	/**
	 * ニュース編集画面へ遷移
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callEditNews", method = RequestMethod.GET)
	public String callEditNews(@Param (value="newsId") Integer newsId, RedirectAttributes attribute) {
		logger.info("ListNewsController-callEditNews");

		// ニュース情報を取得
		NewsForm newsForm = newsService.getNewsByNewsId(newsId);
		attribute.addFlashAttribute("newsForm", newsForm);

		return "redirect:/back/editNews";
	}
}
