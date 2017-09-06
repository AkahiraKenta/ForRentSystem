package jp.co.forrentsystem.controller.backend;

import java.util.List;

import jp.co.forrentsystem.constants.LinkClass;
import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.util.UtilService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * バナー設定画面用コントローラー
 * @author k.akahira
 *
 */
@Controller
public class ListBannerController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(ListBannerController.class);

	@Autowired
	private BannerService bannerService;

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/listBanner", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("ListBannerController-execute");

		// バナー設定情報を取得
		List<BannerDto> bannerList = bannerService.getBannerList();

		ModelAndView mav = new ModelAndView();
		mav.addObject("bannerList", bannerList);
		mav.addObject("publicationFlagList", UtilService.getMasterDtoListForPublicationFlag());
		mav.addObject("linkClassList", LinkClass.getLinkClassList());
		mav.setViewName("./back/listBanner");

		return mav;
	}

	/**
	 * バナー設定新規登録
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callRegistBanner", method = RequestMethod.GET)
	public String registBanner() {
		logger.info("ListBannerController-registBanner");

		return "redirect:/back/registBanner";
	}


	/**
	 * バナー設定表示順更新
	 *
	 * @return 処理結果
	 */
	@ResponseBody
	@RequestMapping(value = "/back/callBannerDisplayNumber", method = RequestMethod.GET)
	public Integer callBannerDisplayNumber(@Param(value="bannerId") String[] bannerId) {
		logger.info("ListBannerController-callBannerDisplayNumber");

		// バナーの表示順を更新
		bannerService.updateBannerDisplayNumber(bannerId);

		return 0;
	}

	/**
	 * バナー設定詳細へ画面遷移
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callDetailBannerByBannerId", method = RequestMethod.GET)
	public String callDetailBannerByBannerId(@Param(value="bannerId") Integer bannerId, RedirectAttributes attributes) {
		logger.info("ListBannerController-registBanner");

		attributes.addFlashAttribute("bannerId", bannerId);
		return "redirect:/back/detailBanner";
	}


}
