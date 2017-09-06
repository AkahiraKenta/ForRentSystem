package jp.co.forrentsystem.controller.backend;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import jp.co.forrentsystem.constants.LinkClass;
import jp.co.forrentsystem.form.backend.BannerForm;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.util.FileUtil;
import jp.co.forrentsystem.util.UtilService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * バナー設定登録画面用コントローラー
 * @author k.akahira
 *
 */
@Controller
public class RegistBannerController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistBannerController.class);

	@Autowired
	private BannerService bannerService;

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registBanner", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("RegistBannerController-execute");

		ModelAndView mav = new ModelAndView();
		mav.addObject("bannerForm", new BannerForm());
		mav.addObject("publicationFlagList", UtilService.getMasterDtoListForPublicationFlag());
		mav.addObject("linkClassList", LinkClass.getLinkClassList());
		mav.setViewName("./back/registBanner");

		return mav;
	}

	/**
	 * バナー設定の新規登録完了画面へ遷移
	 *
	 * @param bannerForm バナーForm
	 * @param file バナー画像設定
	 *
	 * @return 処理結果
	 *
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/back/callRegistBanner", method = RequestMethod.POST)
	public BannerForm callRegistConfirmBanner(@Valid BannerForm bannerForm, @RequestParam("fileupload") MultipartFile file) throws IOException {
		logger.info("RegistBannerController-callRegistConfirmBanner");

		// 初期値設定
		bannerForm.setEmptyFileCheckFlag(true);
		bannerForm.setFileSizeCheckFlag(true);

		// 空ファイルチェック
		if (file.isEmpty() ) {
			// ファイルが空の場合
			bannerForm.setEmptyFileCheckFlag(false);
			return bannerForm;
		}

		// ファイルサイズチェック
		if(FileUtil.getFileUploadMaxSize() < file.getSize()) {
			// アップロード最大サイズ以上の場合
			bannerForm.setFileSizeCheckFlag(false);
			return bannerForm;
		}

		// ファイル名称を設定
		bannerForm.setFileName(file.getOriginalFilename());
		bannerForm.setFile(file);
		bannerForm.setPublicationName(UtilService.getNameForPublicationFlag(bannerForm.getPublicationFlag()));
		bannerForm.setTransitionName(LinkClass.getTargetName(bannerForm.getTransitionFlag()));

		// アップロードベースディレクトリ
		String baseDirectoryName = FileUtil.getFileBaseDirectory();
		String delimiter = FileUtil.getDirectoryDelimiter();
		String directoryPath = baseDirectoryName + FileUtil.getBannerPath() + delimiter;
		String fileName = bannerForm.getFileName();
		File targetDirectory = new File(directoryPath);


		// 建物IDに対応するディレクトリが存在するかチェックする
		if (targetDirectory.exists() == false) {
			// 存在しない場合は、作成する
			targetDirectory.mkdir();
		}

		try {
			bannerForm.getFile().transferTo(new File(directoryPath + fileName));
		} catch (IOException e) {
			// ファイルアップロードエラー処理
			throw e;
		}

		// バナー登録処理
		bannerService.registBanner(bannerForm);

		// JSON形式にできないため、fileを空にする。
		bannerForm.setFile(null);
		return bannerForm;
	}

	/**
	 * バナー設定完了画面へ遷移
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callRegistCompleteBanner", method = RequestMethod.GET)
	public ModelAndView callRegistCompleteBanner() {
		logger.info("RegistBannerController-callRegistConfirmBanner");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/back/registCompleteBanner");

		return mav;
	}


}
