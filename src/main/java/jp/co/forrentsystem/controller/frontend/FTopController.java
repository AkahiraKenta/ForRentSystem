package jp.co.forrentsystem.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpSession;

import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.dto.MainImageDto;
import jp.co.forrentsystem.dto.NewArticleDto;
import jp.co.forrentsystem.dto.NewsDto;
import jp.co.forrentsystem.dto.PopularityAreaDto;
import jp.co.forrentsystem.dto.PopularityStationDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.form.frontend.FSearchConditionForm;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.service.BuildingImageService;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.MainImageService;
import jp.co.forrentsystem.service.NewsService;
import jp.co.forrentsystem.service.PopularityAreaService;
import jp.co.forrentsystem.service.PopularityStationService;
import jp.co.forrentsystem.service.RecommendedRoomsService;
import jp.co.forrentsystem.service.SystemSettingService;
import jp.co.forrentsystem.util.FileUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * フロントTOPコントローラ
 */
@Controller
public class FTopController {

	@Autowired
	private MainImageService mainImageService;
	@Autowired
	private SystemSettingService systemSettingService;
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private BuildingImageService buildingImageService;
	@Autowired
	private PopularityStationService popularityStationService;
	@Autowired
	private PopularityAreaService popularityAreaService;
	@Autowired
	private NewsService newService;
	@Autowired
	private RecommendedRoomsService recommendedRoomsService;
	@Autowired
	private BannerService bannerService;


	private Logger logger = org.slf4j.LoggerFactory.getLogger(FTopController.class);

	/**
	 * フロントTOP画面初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/frontTop", method = RequestMethod.GET)
	public ModelAndView init(HttpSession session) {
		logger.info("FTop-init");

		// 検索条件削除（メニューを押下した場合の対処）
		session.removeAttribute("fSearchConditionForm");
		// 物件問い合わせ情報削除（メニューを押下した場合の対処）
		session.removeAttribute("fContactArticleForm");
		session.removeAttribute("fContactForm");

		// メイン画像取得
		List<MainImageDto> mainImageList = mainImageService.getMainImageViewList();

		// 新着物件画像情報(建物画像）
		List<NewArticleDto> newArticleList = buildingImageService.getBuildingImageByNewArticle();

		// 人気駅
		List<PopularityStationDto> popularityStationList = popularityStationService.getPopularityStationListByViewNumber();

		// 人気エリア
		List<PopularityAreaDto> popularityAreaList = popularityAreaService.getPopularityAreaListByViewNumber();

		// ニュース
		List<NewsDto> newsList = newService.getListNewsByViewNumber();

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("mainImageList", mainImageList);
		mav.addObject("newArticleList", newArticleList);
		mav.addObject("popularityStationList", popularityStationList);
		mav.addObject("popularityAreaList", popularityAreaList);
		mav.addObject("newsList", newsList);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		mav.addObject("fSearchConditionForm", new FSearchConditionForm());
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.setViewName("/front/fTop");

		return mav;
	}
}
