package jp.co.forrentsystem.controller.backend;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.co.forrentsystem.constants.LinkClass;
import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.form.backend.BannerForm;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.util.UtilService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * バナー設定登録画面用コントローラー
 * @author k.akahira
 *
 */
@Controller
public class DetailBannerController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(DetailBannerController.class);

	@Autowired
	private BannerService bannerService;

	/**
	 * 初期表示
	 *
	 * @param session セッション情報
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/detailBanner", method = RequestMethod.GET)
	public ModelAndView execute(ModelMap model) {
		logger.info("DetailBannerController-execute");
		// バナーFormにバナーIDを設定
		BannerForm bannerForm = new BannerForm();
		bannerForm.setBannerId((int)model.get("bannerId"));

		BannerDto bannerDto = bannerService.getBannerByBannerId((int)model.get("bannerId"));

		ModelAndView mav = new ModelAndView();
		mav.addObject("bannerForm", bannerForm);
		mav.addObject("banner", bannerDto);
		mav.addObject("publicationFlagList", UtilService.getMasterDtoListForPublicationFlag());
		mav.addObject("linkClassList", LinkClass.getLinkClassList());
		mav.setViewName("./back/detailBanner");

		return mav;
	}

	/**
	 * バナー編集画面へ遷移
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 * @throws IOException
	 */
	@RequestMapping(value = "/back/callEditBanner", method = RequestMethod.POST)
	public String callEditBanner(@Valid BannerForm bannerForm, RedirectAttributes attribute) throws IOException {
		logger.info("RegistBannerController-callRegistConfirmBanner");

		BannerDto bannerDto = bannerService.getBannerByBannerId(bannerForm.getBannerId());

		attribute.addFlashAttribute("bannerDto", bannerDto);
		return "redirect:/back/editBanner";
	}

	/**
	 * バナー詳細画面からバナー設定一覧画面へ戻る際の初期処理
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backListBannerToDetailBanner", method = RequestMethod.GET)
	public ModelAndView backListBannerToDetailBanner(HttpSession session) {
		logger.info("RegistBannerController-backListBannerToDetailBanner");
		// バナー情報のSESSIONを削除
		session.removeAttribute("bannerDto");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/back/listBanner");

		return mav;
	}

	/**
	 * バナー削除処理
	 *
	 * @param bannerId バナーID
	 *
	 * @return 削除対象バナーID
	 */
	@ResponseBody
	@RequestMapping(value = "/back/deleteBanner", method = RequestMethod.GET)
	public Integer deleteBanner(@Param(value="bannerId") Integer bannerId) {
		logger.info("RegistBannerController-backListBannerToDetailBanner");

		// バナー削除処理
		bannerService.deleteBanner(bannerId);

		// 表示順変更のため、全バナー情報を取得する
		List<BannerDto> bannerList = bannerService.getBannerList();

		String[] arrayBannerId = new String[bannerList.size()];
		int count = 0;
		// 削除したバナーIDをリストから除外する
		for (BannerDto bannerDto : bannerList) {
			if (bannerId != bannerDto.getBannerId()) {
				arrayBannerId[count] = String.valueOf(bannerDto.getBannerId());
				count++;
			}
		}
		bannerService.updateBannerDisplayNumber(arrayBannerId);

		return bannerId;
	}
}
