package jp.co.forrentsystem.controller.backend;

import java.util.List;

import javax.validation.Valid;

import jp.co.forrentsystem.dto.AddressDto;
import jp.co.forrentsystem.dto.PopularityAreaDto;
import jp.co.forrentsystem.form.backend.PopularityAreaForm;
import jp.co.forrentsystem.service.PopularityAreaService;
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
 * 人気エリア設定画面用コントローラー
 * @author k.akahira
 *
 */
@Controller
public class PopularityAreaController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(PopularityAreaController.class);

	@Autowired
	private RouteService routeService;
	@Autowired
	private PopularityAreaService popularityAreaService;

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/settingPopularityArea", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("PopularityAreaController-execute");

		// 人気エリア設定されていない都道府県を取得
		List<AddressDto> addressDtoList = popularityAreaService.getProvinceListForPopularityArea();

		// 人気駅情報取得
		List<PopularityAreaDto> popularityAreaDtoList = popularityAreaService.getPopularityAreaList();

		ModelAndView mav = new ModelAndView();
		mav.addObject("popularityAreaForm", new PopularityAreaForm());
		mav.addObject("popularityAreaDtoList", popularityAreaDtoList);
		mav.addObject("addressDtoList", addressDtoList);
		mav.setViewName("./back/popularityArea");

		return mav;
	}

	/**
	 * 都道府県に紐付く住所情報を取得
	 *
	 * @param popularityAreaFrom 都道府県情報が格納された人気エリアForm
	 *
	 * @return 住所情報リスト
	 */
	@RequestMapping(value = "/back/searchPopularityArea", method = RequestMethod.POST)
	@ResponseBody
	public List<AddressDto> getAddressListForPopularityArea(@Valid PopularityAreaForm popularityAreaFrom) {
		logger.info("PopularityAreaController-getAddressListForPopularityArea");
		logger.info("popularityAreaFrom.getProvince():" + popularityAreaFrom.getProvince());

		// 郵便番号をキーに人気エリア設定されていない住所情報を取得
		List<AddressDto> addressDtoList = popularityAreaService.getAddressListForPopularityAreaByProvince(popularityAreaFrom.getSearchProvince());

		return addressDtoList;
	}

	/**
	 * 人気エリア登録処理
	 *
	 * @param province 都道府県
	 * @param city 市区町村
	 * @param townArea 町域
	 *
	 * @return 人気エリア情報
	 */
	@ResponseBody
	@RequestMapping(value = "/back/registPopularityArea", method = RequestMethod.POST)
//	public PopularityAreaDto registPopularityArea(@Param(value="province") String province,
//			@Param(value="city") String city, @Param(value="townArea") String townArea) {
	public PopularityAreaDto registPopularityArea(@Valid PopularityAreaForm popularityAreaFrom) {
		logger.info("PopularityAreaController-registPopularityArea");

		// 人気エリア登録
		PopularityAreaDto popularityAreaDto = popularityAreaService.registPopularityArea(
				popularityAreaFrom.getProvince(), popularityAreaFrom.getCity(), popularityAreaFrom.getTownArea());

		return popularityAreaDto == null ? new PopularityAreaDto() : popularityAreaDto;
	}

	/**
	 * 人気エリア削除処理
	 *
	 * @param popularityAreaId 人気エリアID
	 *
	 * @return 人気エリア情報
	 */
	@ResponseBody
	@RequestMapping(value = "/back/deletePopularityArea", method = RequestMethod.GET)
	public PopularityAreaDto deletePopularityArea(@Param(value="popularityAreaId") Integer popularityAreaId) {
		logger.info("PopularityAreaController-deletePopularityStation");

		// 人気駅削除
		PopularityAreaDto popularityAreaDto = popularityAreaService.deletePopularityArea(popularityAreaId);

		return popularityAreaDto;
	}

	/**
	 * 人気エリアの順位を更新
	 *
	 * @param popularityStationId 人気エリアID配列
	 *
	 * @return 人気エリア情報リスト
	 */
	@ResponseBody
	@RequestMapping(value = "/back/updatePopularityArea", method = RequestMethod.POST)
	public List<PopularityAreaDto> updatePopularityArea(@Param(value="popularityAreaId") String[] popularityAreaId) {
		logger.info("PopularityAreaController-updatePopularityArea");

		// 人気駅更新
		List<PopularityAreaDto> popularityAreaDtoList = popularityAreaService.updatePopularityArea(popularityAreaId);

		return popularityAreaDtoList;
	}
}
