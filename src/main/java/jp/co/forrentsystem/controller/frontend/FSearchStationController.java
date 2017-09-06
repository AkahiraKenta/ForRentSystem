package jp.co.forrentsystem.controller.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.form.frontend.FSearchConditionForm;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.service.NearestStationService;
import jp.co.forrentsystem.service.RecommendedRoomsService;
import jp.co.forrentsystem.util.FileUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * フロント駅検索コントローラ
 */
@Controller
public class FSearchStationController {

	@Autowired
	private NearestStationService nearestStationService;
	@Autowired
	private RecommendedRoomsService recommendedRoomsService;
	@Autowired
	private BannerService bannerService;


	private Logger logger = org.slf4j.LoggerFactory.getLogger(FSearchStationController.class);

	/**
	 * フロント駅検索画面初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/searchStation", method = RequestMethod.GET)
	public ModelAndView init(HttpSession session) {
		logger.info("FSearchStation-init");
		// 検索条件削除（メニューを押下した場合の対処）
		session.removeAttribute("fSearchConditionForm");
		// 物件問い合わせ情報削除（メニューを押下した場合の対処）
		session.removeAttribute("fContactArticleForm");
		session.removeAttribute("fContactForm");

		// 建物情報と紐付く沿線駅情報を取得
		Map<Integer, List<NearestStationNameDto>> nearestStationListMap =
				nearestStationService.getNearestStationNameListMap();

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fSearchConditionForm", new FSearchConditionForm());
		mav.addObject("nearestStationListMap", nearestStationListMap);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.setViewName("/front/fSearchStation");

		return mav;
	}

	/**
	 * フロント駅検索画面へ戻る
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/callBackStationSearch", method = RequestMethod.GET)
	public ModelAndView callBackStationSearch(HttpSession session) {
		logger.info("FSearchStation-init");

		FSearchConditionForm fSearchConditionForm = new FSearchConditionForm();
		if (session.getAttribute("fSearchConditionForm") != null) {
			fSearchConditionForm = (FSearchConditionForm)session.getAttribute("fSearchConditionForm");
		}

		List<String> selecteStationList = new ArrayList<String>();
		if (fSearchConditionForm.getSelectedStationId() != null) {
			for(String stationId : fSearchConditionForm.getSelectedStationId()) {
				selecteStationList.add(stationId);
			}
		}

		// 建物情報と紐付く沿線駅情報を取得
		Map<Integer, List<NearestStationNameDto>> nearestStationListMap =
				nearestStationService.getNearestStationNameListMap();

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fSearchConditionForm", fSearchConditionForm);
		mav.addObject("nearestStationListMap", nearestStationListMap);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		// 駅検索チェックリスト
		mav.addObject("selecteStationList", selecteStationList);
		mav.setViewName("/front/fSearchStation");

		return mav;
	}
}
