package jp.co.forrentsystem.controller.backend;

import java.util.List;

import jp.co.forrentsystem.dto.FloorPlanDto;
import jp.co.forrentsystem.service.FloorPlanService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 間取り一覧コントローラ
 * @author k.akhaira
 */
@Controller
public class ListFloorPlanController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(ListFloorPlanController.class);

	@Autowired
	private FloorPlanService floorPlanService;

	/**
	 * 間取りマスタ初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/listFloorPlan", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("ListFloorPlanController-execute");

		// 間取り情報取得
		List<FloorPlanDto> floorPlanList = floorPlanService.getFloorPlanList();

		ModelAndView mav = new ModelAndView();
		mav.addObject("floorPlanList", floorPlanList);
		mav.setViewName("./back/floorPlan");

		return mav;
	}

	/**
	 * 間取りマスタ登録処理
	 *
	 * @return 間取り情報
	 */
	@ResponseBody
	@RequestMapping(value = "/back/registFloorPlan", method = RequestMethod.POST)
	public FloorPlanDto registFloorPlan() {
		logger.info("ListFloorPlanController-registFloorPlan");

		// 間取りマスタ登録
		FloorPlanDto floorPlanDto = floorPlanService.registFloorPlan();

		return floorPlanDto;
	}

	/**
	 * 間取りマスタ削除処理
	 *
	 * @param popularityAreaId 人気エリアID
	 *
	 * @return 削除対象間取りID
	 */
	@ResponseBody
	@RequestMapping(value = "/back/deleteFloorPlan", method = RequestMethod.GET)
	public Integer deleteFloorPlan(@Param(value="floorPlanId") Integer floorPlanId) {
		logger.info("ListFloorPlanController-deleteFloorPlan");

		// 間取りマスタ削除
		int deleteFloorPlanId = floorPlanService.deleteFloorPlan(floorPlanId);

		return deleteFloorPlanId;
	}

	/**
	 * 間取りマスタの名称を更新
	 *
	 * @param popularityStationId 駅ID配列
	 *
	 * @return 間取り情報
	 */
	@ResponseBody
	@RequestMapping(value = "/back/updateFloorPlan", method = RequestMethod.GET)
	public FloorPlanDto updateFloorPlan(@Param(value="floorPlanId") Integer floorPlanId
			, @Param(value="floorPlanName") String floorPlanName) {
		logger.info("ListFloorPlanController-updateFloorPlan");

		// 間取りマスタ更新
		FloorPlanDto floorPlanDto = floorPlanService.updateFloorPlan(floorPlanId, floorPlanName);

		return floorPlanDto;
	}
}
