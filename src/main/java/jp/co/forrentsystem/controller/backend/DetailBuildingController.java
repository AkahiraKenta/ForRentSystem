package jp.co.forrentsystem.controller.backend;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.forrentsystem.constants.BuildingImageClass;
import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.BuildingImageDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.form.backend.ListRoomsForm;
import jp.co.forrentsystem.service.BuildingImageService;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.RoomsService;
import jp.co.forrentsystem.util.FileUtil;
import jp.co.forrentsystem.util.UtilService;

/**
 * 建物詳細情報コントローラ
 * @author k.akahira
 */
@Controller
public class DetailBuildingController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(DetailBuildingController.class);

	@Autowired
	private RoomsService roomsService;
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private BuildingImageService buildingImageService;

	/**
	 * 建物詳細画面初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/detailBuilding", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		logger.info("DetailBuildingController-init");

		// 建物詳細情報をセッションから取得
		DetailBuildingForm detailBuildingForm = (DetailBuildingForm)buildingService.reloadModel(model, session).get("detailBuildingForm");


		// 部屋一覧表示のため、部屋情報取得
		List<ListRoomsForm> roomsList = roomsService.getRoomsListByBuildingId(detailBuildingForm.getBuildingId());
		// 建物画像区分リスト
		List<MasterDto> buildingImageClassList = BuildingImageClass.getBuildingImageClassList();
		// 建物画像リスト
		BuildingImageDto buildingImage = buildingImageService.getBuildingImage(detailBuildingForm.getBuildingId());

		ModelAndView mav = new ModelAndView();
		mav.addObject("detailBuildingForm", detailBuildingForm);
		mav.addObject("listRoomsForm", roomsList);
		mav.addObject("buildingImageClassList", buildingImageClassList);
		mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
		mav.addObject("buildingImage", buildingImage);
		// メッセージ
		mav.addObject("message", model.get("message"));
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.setViewName("./back/detailBuilding");

		return mav;
	}

	/**
	 * 建物編集画面へ遷移
	 *
	 * @param detailBuildingForm 建物詳細Form
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callEditBuilding", method = RequestMethod.POST)
	public String callDetailBuilding(RedirectAttributes attributes, @Valid DetailBuildingForm detailBuildingForm) {
		logger.info("DetailBuildingController-callDetailBuilding");

		attributes.addFlashAttribute("detailBuildingForm", detailBuildingForm);

		// リダイレクト（建物編集画面）
		return "redirect:/back/editBuilding";
	}

	/**
	 * 建物一覧画面へ遷移
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backDetailBuilding", method = RequestMethod.GET)
	public String back(HttpSession session) {
		logger.info("DetailBuildingController-back");

		// 建物一覧へ戻るパターン
		return"redirect:/back/callListBuilding";
	}

	/**
	 * 部屋詳細画面へ遷移（詳細用）
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 * @param session セッション情報
	 *
	 * @return 部屋詳細画面遷移情報
	 */
	@RequestMapping(value = "/back/callDetailRoom", method = RequestMethod.GET)
	public String callDetailRoom(RedirectAttributes attributes, @Param(value="buildingId") Integer buildingId, @Param(value="roomId") Integer roomId
			, @Param(value="transactionFlag") Integer transactionFlag) {
		logger.info("DetailBuildingController-callDetailRoom");

		attributes.addFlashAttribute("buildingId", buildingId);
		attributes.addFlashAttribute("roomId", roomId);
		attributes.addFlashAttribute("transactionFlag", transactionFlag);

		return "redirect:/back/detailRoom";
	}

	/**
	 * 部屋詳細画面へ遷移(削除用）
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 * @param session セッション情報
	 *
	 * @return 部屋詳細画面遷移情報
	 */
	@RequestMapping(value = "/back/callDetailRoomDelete", method = RequestMethod.GET)
	public String callDetailRoomDelete(RedirectAttributes attributes, @Param(value="buildingId") Integer buildingId, @Param(value="roomId") Integer roomId
			, @Param(value="transactionFlag") Integer transactionFlag) {
		logger.info("DetailBuildingController-callDetailRoomDelete");

		attributes.addFlashAttribute("buildingId", buildingId);
		attributes.addFlashAttribute("roomId", roomId);
		attributes.addFlashAttribute("transactionFlag", transactionFlag);

		return "redirect:/back/detailRoom";
	}

	/**
	 * 部屋登録画面へ遷移
	 *
	 * @param registRoomsForm 部屋登録Form
	 * @param attribute
	 *
	 * @return 部屋登録画面遷移情報
	 */
	@RequestMapping(value = "/back/callRegistRoomForDetailBuilding", method = RequestMethod.GET)
	public String callRegistRoom(@Param(value="buildingId") Integer buildingId, RedirectAttributes attribute) {
		logger.info("DetailBuildingController-callDetailRoom");

		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);

		// 建物情報を建物詳細Formに設定する
		DetailBuildingForm detailBuildingForm = buildingService.getBuildingDtoForDetailBuildingForm(buildingDto);

		//建物情報を建物詳細Formをattributeに保存
		attribute.addFlashAttribute("detailBuildingForm", detailBuildingForm);

		// リダイレクト（部屋登録画面）
		return "redirect:/back/registRoom";
	}

	/**
	 * 建物画像ファイルアップロード
	 *
	 * @param file 建物画像ファイル
	 * @param targetBuildingId 建物ID
	 * @param buildingImageClass 建物画像区分
	 * @param imageCaption 画像見出し
	 * @param model モデル
	 *
	 * @return 建物画像DTO
	 *
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/back/uploadImageFile", method = RequestMethod.POST)
    public BuildingImageDto fileupload(@RequestParam("fileupload") MultipartFile file,
    					   @Param(value="targetBuildingId") Integer targetBuildingId,
    					   @Param(value="buildingImageClass") Integer buildingImageClass,
    					   @Param(value="imageCaption") String imageCaption,
    					   Model model) throws IOException {

		logger.info("DetailBuildingController-fileupload");

		BuildingImageDto buildingImageDto = new BuildingImageDto();
		// 初期値設定
		buildingImageDto.setEmptyFileCheckFlag(true);
		buildingImageDto.setFileSizeCheckFlag(true);
		buildingImageDto.setSameFileNameCheckFlag(true);
		//==================================================================
		// アップロード処理
		//==================================================================
		// 空ファイルチェック
		if (file.isEmpty() ) {
			// ファイルが空の場合
			buildingImageDto.setEmptyFileCheckFlag(false);
			return buildingImageDto;
		}

		// ファイルサイズチェック
		if(FileUtil.getFileUploadMaxSize() < file.getSize()) {
			// アップロード最大サイズ以上の場合
			buildingImageDto.setFileSizeCheckFlag(false);
			return buildingImageDto;
		}

		// 登録済み確認(念のため）
		BuildingImageDto checkBuildingImageDto = buildingImageService.getBuildingImage(targetBuildingId);
		// ファイル名チェック
		if (checkBuildingImageDto != null
				&& checkBuildingImageDto.getFileName() == file.getOriginalFilename()) {
			// ファイル名が同じだった場合
			buildingImageDto.setSameFileNameCheckFlag(false);
			return buildingImageDto;
		}

		// アップロードベースディレクトリ
		String baseDirectoryName = FileUtil.getFileBaseDirectory();
		String delimiter = FileUtil.getDirectoryDelimiter();
		String directoryPath = baseDirectoryName + targetBuildingId + delimiter;
		String fileName = file.getOriginalFilename();
		File targetDirectory = new File(directoryPath);

		// 建物IDに対応するディレクトリが存在するかチェックする
		if (targetDirectory.exists() == false) {
			// 存在しない場合は、作成する
			targetDirectory.mkdir();
		}

		try {
			file.transferTo(new File(directoryPath + fileName));
		} catch (IOException e) {
			// ファイルアップロードエラー処理
			throw e;
		}

		int publicationFlag = 1;
		//==================================================================
		// DB更新 建物画像テーブルにInsert
		//==================================================================
		buildingImageDto = buildingImageService.registBuildingImage(targetBuildingId, buildingImageClass, fileName, imageCaption, publicationFlag);
		// 空ファイルチェックOKを設定
		buildingImageDto.setEmptyFileCheckFlag(true);
		// ファイルサイズチェックOKを設定
		buildingImageDto.setFileSizeCheckFlag(true);
		// ファイル名チェックOKを設定
		buildingImageDto.setSameFileNameCheckFlag(true);
		return buildingImageDto;

	}

	/**
	 * 建物画像削除
	 *
	 * @param buildingId 建物ID
	 * @param imageId 画像ID
	 * @param fileName ファイル名
	 *
	 * @return 建物画像情報
	 *
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/back/deleteImageFile", method = RequestMethod.POST)
    public BuildingImageDto deleteBuildingImage(@Param(value="buildingId") Integer buildingId,
    					   @Param(value="imageId") Integer imageId,
    					   @Param(value="fileName") String fileName) throws IOException {
		logger.info("DetailBuildingController-deleteBuildingImage");
		// 画像ファイル情報
		String baseDirectoryName = FileUtil.getFileBaseDirectory();
		String delimiter = FileUtil.getDirectoryDelimiter();
		String directoryPath = baseDirectoryName + buildingId + delimiter;

		File file = new File(directoryPath+fileName);

		if (!file.exists()){
			throw new IOException();
		}
		// ファイル削除
		file.delete();

		//==================================================================
		// DB更新 建物画像テーブルにdelete
		//==================================================================
		BuildingImageDto buildingImageDto = buildingImageService.deleteBuildingImage(buildingId, imageId, fileName);

		return buildingImageDto;
	}

	/**
	 * 建物削除処理
	 *
	 * @param buildingId 建物ID
	 *
	 * @return 画面遷移情報
	 */
	@RequestMapping(value = "/back/deleteBuilding", method = RequestMethod.GET)
    public String deleteBuilding(@Param(value="buildingId") Integer buildingId, RedirectAttributes attributes) {

		// 建物情報に紐付く各情報を削除
		buildingService.deleteBuilding(buildingId);

        BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);

        ResourceBundle bundle = ResourceBundle.getBundle("Message_ja");

        String message = MessageFormat.format(bundle.getString("delete.building"), buildingDto.getBuildingCode(), buildingDto.getBuildingName());
        attributes.addFlashAttribute("message", message);

		return "redirect:/back/callListBuilding";
	}
}


