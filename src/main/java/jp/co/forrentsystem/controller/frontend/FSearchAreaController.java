package jp.co.forrentsystem.controller.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.form.frontend.FSearchConditionForm;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.RecommendedRoomsService;
import jp.co.forrentsystem.util.FileUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * フロントエリア検索コントローラ
 * @author k.akahira
 */
@Controller
public class FSearchAreaController {

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private RecommendedRoomsService recommendedRoomsService;
	@Autowired
	private BannerService bannerService;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FSearchAreaController.class);

	/**
	 * フロントエリア検索画面初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/searchArea", method = RequestMethod.GET)
	public ModelAndView init(HttpSession session) {
		logger.info("FSearchStation-init");
		// 検索条件削除（メニューを押下した場合の対処）
		session.removeAttribute("fSearchConditionForm");
		// 物件問い合わせ情報削除（メニューを押下した場合の対処）
		session.removeAttribute("fContactArticleForm");
		session.removeAttribute("fContactForm");

		// 建物情報の住所を取得(都道府県単位）
		Map<String, Map<String, List<BuildingDto>>> buildingAddressListMap =
				buildingService.getBuildingAddressListMap();

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("buildingAddressListMap", buildingAddressListMap);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.setViewName("/front/fSearchArea");

		return mav;
	}

	/**
	 * フロントエリア検索画面へ戻る
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/callBackAreaSearch", method = RequestMethod.GET)
	public ModelAndView callBackAreaSearch(HttpSession session) {
		logger.info("FSearchStation-init");

		FSearchConditionForm fSearchConditionForm = (FSearchConditionForm)session.getAttribute("fSearchConditionForm");
		List<String> selectedTownAreaList = new ArrayList<String>();
		if (fSearchConditionForm.getSelectedTownArea() != null) {
			for(String areaId : fSearchConditionForm.getSelectedTownArea()) {
				selectedTownAreaList.add(areaId);
			}
		}

		// 建物情報の住所を取得(都道府県単位）
		Map<String, Map<String, List<BuildingDto>>> buildingAddressListMap =
				buildingService.getBuildingAddressListMap();

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("buildingAddressListMap", buildingAddressListMap);
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());

		// エリア検索チェックリスト
		mav.addObject("selectedTownAreaList", selectedTownAreaList);
		mav.setViewName("/front/fSearchArea");

		return mav;
	}
}
