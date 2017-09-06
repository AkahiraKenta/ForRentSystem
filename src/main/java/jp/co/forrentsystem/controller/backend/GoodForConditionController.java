package jp.co.forrentsystem.controller.backend;

import java.util.List;

import jp.co.forrentsystem.dto.GoodForConditionDto;
import jp.co.forrentsystem.service.GoodForConditionService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * こだわり条件管理画面用コントローラー
 * @author k.akahira
 *
 */
@Controller
public class GoodForConditionController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(GoodForConditionController.class);

	@Autowired
	private GoodForConditionService goodForConditionService;


	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/listGoodForCondition", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("GoodForConditionController-execute");

		// こだわり条件を取得
		List<GoodForConditionDto> goodForConditionList = goodForConditionService.getGoodForConditionListOrderByDisplayNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("goodForConditionList", goodForConditionList);
		mav.setViewName("./back/goodForCondition");

		return mav;
	}

	/**
	 * こだわり条件登録処理
	 *
	 * @return 登録したこだわり条件情報
	 */
	@ResponseBody
	@RequestMapping(value = "/back/registGoodForCondition", method = RequestMethod.POST)
	public GoodForConditionDto registGoodForCondition() {
		logger.info("GoodForConditionController-registGoodForCondition");

		// こだわり条件登録
		GoodForConditionDto goodForConditionDto = goodForConditionService.registGoodForCondition();

		return goodForConditionDto;
	}

	/**
	 * こだわり条件削除処理
	 *
	 * @param conditionId こだわり条件ID
	 *
	 * @return こだわり条件ID
	 */
	@ResponseBody
	@RequestMapping(value = "/back/deleteGoodForCondition", method = RequestMethod.GET)
	public Integer deleteGoodForCondition(@Param(value="conditionId") Integer conditionId) {
		logger.info("GoodForConditionController-deleteGoodForCondition");

		// こだわり条件削除
		goodForConditionService.deleteGoodForCondition(conditionId);

		return conditionId;
	}

	/**
	 * こだわり条件を更新
	 *
	 * @param popularityStationId 駅ID配列
	 *
	 * @return こだわり条件ID
	 */
	@ResponseBody
	@RequestMapping(value = "/back/updateGoodForCondition", method = RequestMethod.GET)
	public Integer updateGoodForCondition(@Param(value="conditionId") Integer conditionId,
										@Param(value="conditionName") String conditionName) {
		logger.info("GoodForConditionController-updatePopularityArea");

		// こだわり条件更新処理
		goodForConditionService.updateGoodForCondition(conditionId, conditionName);

		return conditionId;
	}

	/**
	 * こだわり条件の表示順を更新
	 *
	 * @param conditionId こだわり条件ID配列
	 *
	 * @return こだわり条件ID
	 */
	@ResponseBody
	@RequestMapping(value = "/back/updateGoodForConditionDisplayNumber", method = RequestMethod.POST)
	public String[] updateGoodForConditionDisplayNumber(@Param(value="conditionId") String[] conditionId) {
		logger.info("GoodForConditionController-updateGoodForConditionDisplayNumber");

		// こだわり条件の表示順を更新
		goodForConditionService.updateGoodForConditionDisplayNumber(conditionId);

		return conditionId;
	}
}
