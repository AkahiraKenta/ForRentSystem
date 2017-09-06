package jp.co.forrentsystem.controller.backend;

import java.util.List;

import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.service.RecommendedRoomsService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * おすすめ物件登録画面用コントローラー
 * @author d.kitajima
 *
 */
@Controller
public class ListRecommendedRoomController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(ListRecommendedRoomController.class);;

	@Autowired
	private RecommendedRoomsService recommendedRoomsService;

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/listRecommendedRoom", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("ListRecommendedRoomController-execute");

		// おすすめ物件リストを取得
		List<ArticleDto> articleList = recommendedRoomsService.getRecoomendedRoom();


		ModelAndView mav = new ModelAndView();

		mav.addObject("articleList", articleList);
		mav.setViewName("./back/listRecommendedRoom");

		return mav;
	}

	/**
	 * おすすめ物件削除処理
	 *
	 * @param id おすすめ物件ID
	 *
	 * @return 削除対象おすすめ物件ID
	 */
	@ResponseBody
	@RequestMapping(value = "/back/deleteRecommendRoom", method = RequestMethod.GET)
	public Integer deleteRecommendRoom(@Param(value="id") Integer id) {
		logger.info("ListRecommendedRoomController-deleteRecommendRoom");

		// おすすめ物件削除
		int deleteId= recommendedRoomsService.deleteRecommendRoom(id);

		return deleteId;
	}

	/**
	 * おすすめ物件の順位を更新
	 *
	 * @param id おすすめ物件ID配列
	 *
	 * @return おすすめ物件情報リスト
	 */
	@ResponseBody
	@RequestMapping(value = "/back/updateRecommendRoom", method = RequestMethod.POST)
	public List<ArticleDto> updateRecommendRoom(@Param(value="id") String[] id) {
		logger.info("ListRecommendedRoomController-updateRecommendRoom");

		// おすすめ物件更新
		List<ArticleDto> articleList = recommendedRoomsService.updateRecommendRoom(id);

		return articleList;
	}
}
