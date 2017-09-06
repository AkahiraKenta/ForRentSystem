package jp.co.forrentsystem.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpSession;

import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.service.RecommendedRoomsService;
import jp.co.forrentsystem.util.FileUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * フロントプライバシーポリシーコントローラ
 */
@Controller
public class FPrivacyController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FPrivacyController.class);

	@Autowired
	private RecommendedRoomsService recommendedRoomsService;
	@Autowired
	private BannerService bannerService;

	/**
	 * フロントプライバシーポリシー初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/privacy", method = RequestMethod.GET)
	public ModelAndView init(HttpSession session) {
		logger.info("FPrivacyController-init");

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.setViewName("/front/fPrivacy");

		return mav;
	}
}
