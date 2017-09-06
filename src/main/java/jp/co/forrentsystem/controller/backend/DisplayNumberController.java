package jp.co.forrentsystem.controller.backend;

import java.util.List;

import jp.co.forrentsystem.constants.ArticleListDisplayNumber;
import jp.co.forrentsystem.constants.BannerDisplayNumber;
import jp.co.forrentsystem.constants.NewArticleDisplayNumber;
import jp.co.forrentsystem.constants.NewsDisplayNumber;
import jp.co.forrentsystem.constants.PopularityAreaDisplayNumber;
import jp.co.forrentsystem.constants.PopularityStationDisplayNumber;
import jp.co.forrentsystem.constants.RecommendedRoomDisplayNumber;
import jp.co.forrentsystem.dto.SystemSettingDto;
import jp.co.forrentsystem.form.backend.DisplayNumberForm;
import jp.co.forrentsystem.service.SystemSettingService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 表示件数一覧コントローラ
 * @author k.akahira
 */
@Controller
public class DisplayNumberController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(DisplayNumberController.class);

	@Autowired
	private SystemSettingService systemSettingService;

	/**
	 * 表示件数マスタ初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/displayNumber", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("DisplayNumberController-execute");

		// システム設定情報取得
		List<SystemSettingDto> systemSettingList = systemSettingService.getSystemSettingList();
		// 各表示設定値を取得
		DisplayNumberForm displayNumberForm = new DisplayNumberForm();
		displayNumberForm.setNewArticleDisplayNumberId(systemSettingList.get(0).getDisplayNumber());
		displayNumberForm.setPopularityStationDisplayNumberId(systemSettingList.get(1).getDisplayNumber());
		displayNumberForm.setPopularityAreaDisplayNumberId(systemSettingList.get(2).getDisplayNumber());
		displayNumberForm.setNewsDisplayNumberId(systemSettingList.get(3).getDisplayNumber());
		displayNumberForm.setBannerDisplayNumberId(systemSettingList.get(4).getDisplayNumber());
		displayNumberForm.setRecommendedRoomDisplayNumberId(systemSettingList.get(5).getDisplayNumber());
		displayNumberForm.setArticleListDisplayNumberId(systemSettingList.get(6).getDisplayNumber());


		ModelAndView mav = new ModelAndView();
		mav.addObject("displayNumberForm", displayNumberForm);
		mav.addObject("systemSettingList", systemSettingList);
		mav.addObject("newArticleDisplayNumberList", NewArticleDisplayNumber.getNewArticleDisplayNumberList());
		mav.addObject("popularityStationDisplayNumberList", PopularityStationDisplayNumber.getPopularityStationList());
		mav.addObject("popularityAreaDisplayNumberList", PopularityAreaDisplayNumber.getPopularityAreaList());
		mav.addObject("newsDisplayNumberList", NewsDisplayNumber.getNewsList());
		mav.addObject("bannerDisplayNumberList", BannerDisplayNumber.getBannerList());
		mav.addObject("recommendedRoomDisplayNumberList", RecommendedRoomDisplayNumber.getRecommendedRoomList());
		mav.addObject("articleListDisplayNumberList", ArticleListDisplayNumber.getArticleList());
		mav.setViewName("./back/displayNumber");
		return mav;
	}

	/**
	 * システム設定の表示件数を更新
	 *
	 * @param systemSettingId システム設定ID
	 * @param displayNumberId 表示件数ID
	 *
	 * @return システム設定ID
	 */
	@ResponseBody
	@RequestMapping(value = "/back/updateDisplayNumber", method = RequestMethod.GET)
	public Integer updateDisplayNumber(@Param(value="systemSettingId") Integer systemSettingId
			, @Param(value="displayNumberId") Integer displayNumberId) {
		logger.info("DisplayNumberController-updateDisplayNumber");
		// 構造マスタ更新
		systemSettingService.updateDisplayNumber(systemSettingId, displayNumberId);
		return systemSettingId;
	}
}
