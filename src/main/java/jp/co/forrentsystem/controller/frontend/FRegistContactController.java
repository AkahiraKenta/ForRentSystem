package jp.co.forrentsystem.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpSession;

import jp.co.forrentsystem.constants.ProcessClass;
import jp.co.forrentsystem.constants.ResidentsHopeTimeClass;
import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.form.frontend.FContactForm;
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
 * フロントお問合わせ登録コントローラ
 * @author k.akahira
 */
@Controller
public class FRegistContactController {

	@Autowired
	private RecommendedRoomsService recommendedRoomsService;
	@Autowired
	private BannerService bannerService;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FRegistContactController.class);

	/**
	 * フロント物件お問合わせ登録画面初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/registContact", method = RequestMethod.GET)
	public ModelAndView init(HttpSession session) {
		logger.info("FContactArticleController-init");

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fContactForm", new FContactForm());
		// お問合わせ種類
		mav.addObject("processList", ProcessClass.getProcessClassList());
		// 入居希望時期
		mav.addObject("residentsHopeTimeClassList", ResidentsHopeTimeClass.getResidentsHopeTimeClassList());
		// おすすめ物件画像リスト
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		// バナーリスト
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());

		mav.setViewName("/front/fRegistContact");

		return mav;
	}

	/**
	 * フロント物件お問合わせ登録確認画面からの戻り
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/backRegistContact", method = RequestMethod.GET)
	public ModelAndView backRegistContact(HttpSession session) {
		logger.info("FContactArticleController-init");

		FContactForm fContactForm = (FContactForm)session.getAttribute("fContactForm");

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fContactForm", fContactForm);
		// お問合わせ種類
		mav.addObject("processList", ProcessClass.getProcessClassList());
		// 入居希望時期
		mav.addObject("residentsHopeTimeClassList", ResidentsHopeTimeClass.getResidentsHopeTimeClassList());
		// おすすめ物件画像リスト
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		// バナーリスト
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());

		mav.setViewName("/front/fRegistContact");

		return mav;
	}
}
