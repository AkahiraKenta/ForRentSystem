package jp.co.forrentsystem.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.form.frontend.FContactForm;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.service.ContactService;
import jp.co.forrentsystem.service.RecommendedRoomsService;
import jp.co.forrentsystem.util.FileUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * フロントお問合わせ登録完了コントローラ
 * @author k.akahira
 */
@Controller
public class FRegistCompleteContactController {

	@Autowired
	private RecommendedRoomsService recommendedRoomsService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private ContactService contactService;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FRegistCompleteContactController.class);

	/**
	 * フロントお問合わせ登録完了画面初期表示
	 *
	 * @return 画面表示情報
	 * @throws Exception
	 */
	@RequestMapping(value = "/registCompleteContact", method = RequestMethod.POST)
	public ModelAndView init(@Valid FContactForm fContactForm, HttpSession session) throws Exception {
		logger.info("FRegistCompleteContactArticleController-init");

		session.removeAttribute("fContactArticleForm");

		// お問合せ登録
		contactService.registContact(fContactForm);

		// おすすめ
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();

		// おすすめ物件画像リスト
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		// バナーリスト
		mav.addObject("bannerList", bannerList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());

		mav.setViewName("/front/fRegistCompleteContact");

		return mav;
	}
}
