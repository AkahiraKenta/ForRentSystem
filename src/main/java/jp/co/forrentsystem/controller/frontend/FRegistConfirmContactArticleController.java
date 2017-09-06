package jp.co.forrentsystem.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.co.forrentsystem.constants.ProcessClass;
import jp.co.forrentsystem.constants.ResidentsHopeTimeClass;
import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.form.frontend.FContactArticleForm;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.service.RecommendedRoomsService;
import jp.co.forrentsystem.util.FileUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * フロント物件お問合わせ登録確認コントローラ
 * @author k.akahira
 */
@Controller
public class FRegistConfirmContactArticleController {

	@Autowired
	private RecommendedRoomsService recommendedRoomsService;
	@Autowired
	private BannerService bannerService;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FRegistConfirmContactArticleController.class);

	/**
	 * フロント物件お問合わせ登録確認画面初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/registConfirmContactArticle", method = RequestMethod.POST)
	public ModelAndView init(@Valid FContactArticleForm fContactArticleForm, BindingResult result, HttpSession session) {
		logger.info("FContactArticleController-init");

		session.setAttribute("fContactArticleForm", fContactArticleForm);

		if (fContactArticleForm.getProcessClass() != null) {
			// お問合せ種類名称を設定
			fContactArticleForm.setProcess(ProcessClass.getTargetName(fContactArticleForm.getProcessClass()));
		}
		if (fContactArticleForm.getResidentsHopeTime() != null) {
			// 入居希望時期名称を設定
			fContactArticleForm.setResidentsHopeTimeName(ResidentsHopeTimeClass.getTargetName(fContactArticleForm.getResidentsHopeTime()));
		}

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();

		mav.addObject("fContactArticleForm", fContactArticleForm);
		// おすすめ物件画像リスト
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		// バナーリスト
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());

		mav.setViewName("/front/fRegistConfirmContactArticle");

		return mav;
	}
}
