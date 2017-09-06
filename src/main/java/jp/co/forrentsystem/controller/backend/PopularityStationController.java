package jp.co.forrentsystem.controller.backend;

import java.util.List;

import jp.co.forrentsystem.dto.PopularityStationDto;
import jp.co.forrentsystem.dto.RouteDto;
import jp.co.forrentsystem.dto.StationDto;
import jp.co.forrentsystem.service.PopularityStationService;
import jp.co.forrentsystem.service.RouteService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 人気駅設定画面用コントローラー
 * @author k.akahira
 *
 */
@Controller
public class PopularityStationController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(PopularityStationController.class);

	@Autowired
	private PopularityStationService popularityStationService;
	@Autowired
	private RouteService routeService;

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/settingPopularityStation", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("PopularityStationController-execute");

		// 人気駅情報取得
		List<PopularityStationDto> populalityStationDtoList = popularityStationService.getPopularityStationList();
		// 沿線情報を取得
		List<RouteDto> routeDtoList = routeService.getPopularityRouteList();

		ModelAndView mav = new ModelAndView();
		mav.addObject("popularityStationList", populalityStationDtoList);
		mav.addObject("routeList", routeDtoList);
		mav.setViewName("./back/popularityStation");

		return mav;
	}

	/**
	 * 沿線IDに紐付く駅情報を取得
	 *
	 * @param routeId 沿線ID
	 *
	 * @return 駅情報リスト
	 */
	@ResponseBody
	@RequestMapping(value = "/back/getStationListForPopularityStation", method = RequestMethod.GET)
	public List<StationDto> getStationListForPopularityStation(@Param(value="routeId") Integer routeId) {
		logger.info("PopularityStationController-getStationListForPopularityStation");

		// 沿線IDをキーに駅情報を取得
		List<StationDto> stationDtoList = popularityStationService.getStationListForPopularityStationByRouteId(routeId);

		return stationDtoList;
	}

	/**
	 * 人気駅登録処理
	 *
	 * @param stationId 駅ID
	 *
	 * @return 人気駅情報
	 */
	@ResponseBody
	@RequestMapping(value = "/back/registPopularityStation", method = RequestMethod.POST)
	public PopularityStationDto registPopularityStation(@Param(value="stationId") Integer stationId) {
		logger.info("PopularityStationController-registPopularityStation");

		// 人気駅登録
		PopularityStationDto popularityStationDto = popularityStationService.registPopularityStation(stationId);

		return popularityStationDto;
	}

	/**
	 * 人気駅削除処理
	 *
	 * @param stationId 駅ID
	 *
	 * @return 人気駅情報
	 */
	@ResponseBody
	@RequestMapping(value = "/back/deletePopularityStation", method = RequestMethod.POST)
	public PopularityStationDto deletePopularityStation(@Param(value="stationId") Integer stationId) {
		logger.info("PopularityStationController-deletePopularityStation");

		// 人気駅削除
		PopularityStationDto popularityStationDto = popularityStationService.deletePopularityStation(stationId);

		return popularityStationDto;
	}

	/**
	 * 人気駅の順位を更新
	 *
	 * @param stationIdArray 駅ID配列
	 * @param rankArray 順位配列
	 *
	 * @return 人気駅情報リスト
	 */
	@ResponseBody
	@RequestMapping(value = "/back/updatePopularityStation", method = RequestMethod.POST)
	public List<PopularityStationDto> updatePopularityStation(@Param(value="popularityStationId") String[] popularityStationId) {
		logger.info("PopularityStationController-updatePopularityStation");

		// 人気駅更新
		List<PopularityStationDto> popularityStationDtoList = popularityStationService.updatePopularityStation(popularityStationId);

		return popularityStationDtoList;
	}
}
