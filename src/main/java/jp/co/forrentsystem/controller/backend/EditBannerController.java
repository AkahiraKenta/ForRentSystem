package jp.co.forrentsystem.controller.backend;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.forrentsystem.constants.LinkClass;
import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.form.backend.BannerForm;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.util.FileUtil;
import jp.co.forrentsystem.util.UtilService;

/**
 * バナー設定編集画面用コントローラー
 * @author k.akahira
 *
 */
@Controller
public class EditBannerController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditBannerController.class);

	@Autowired
	private BannerService bannerService;

	/**
	 * 初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/editBanner", method = RequestMethod.GET)
	public ModelAndView execute(ModelMap model, HttpSession session) {
		logger.info("EditBannerController-execute");

		// バナーDTOをSESSIONから取得
		BannerDto bannerDto = (BannerDto)bannerService.reloadModel(model, session).get("bannerDto");

		BannerForm bannerForm = bannerService.getBannerInfo(bannerDto);

		ModelAndView mav = new ModelAndView();
		mav.addObject("bannerForm", bannerForm);
		mav.addObject("publicationFlagList", UtilService.getMasterDtoListForPublicationFlag());
		mav.addObject("linkClassList", LinkClass.getLinkClassList());
		mav.setViewName("./back/editBanner");

		return mav;
	}

	/**
	 * バナー設定の編集完了画面へ遷移
	 *
	 * @param bannerForm バナーForm
	 * @param file バナー画像ファイル
	 *
	 * @return 処理結果
	 *
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/back/editBannerAndImageExecute", method = RequestMethod.POST)
	public BannerForm editBannerAndImageExecute(@Valid BannerForm bannerForm, @RequestParam("fileupload") MultipartFile file) throws IOException {
		logger.info("EditBannerController-editBannerExecute");

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

		// バナー更新処理
		bannerService.updateBanner(bannerForm);

		// JSON形式にできないため、fileを空にする。
		bannerForm.setFile(null);
		return bannerForm;
	}

	/**
	 * バナー設定の編集完了画面へ遷移
	 *
	 * @return bannerForm バナーForm
	 */
	@ResponseBody
	@RequestMapping(value = "/back/editBannerExecute", method = RequestMethod.POST)
	public BannerForm editBannerExecute(@Valid BannerForm bannerForm) {
		logger.info("EditBannerController-editBannerExecute");

		// バナー更新処理
		bannerService.updateBanner(bannerForm);

		bannerForm.setEmptyFileCheckFlag(true);
		bannerForm.setFileSizeCheckFlag(true);
		return bannerForm;
	}

	/**
	 * バナー詳細画面へ戻る
	 *
	 * @return 画面遷移情報
	 */
	@RequestMapping(value = "/back/callEditCompleteBanner", params="back", method = RequestMethod.POST)
	public String backBannerDetail(@Valid BannerForm bannerForm, RedirectAttributes attribute) {
		logger.info("EditBannerController-editBannerExecute");

		// バナー更新処理
		attribute.addFlashAttribute("bannerId", bannerForm.getBannerId());
		return "redirect:/back/detailBanner";
	}
}
