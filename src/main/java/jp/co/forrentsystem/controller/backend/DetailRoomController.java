package jp.co.forrentsystem.controller.backend;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
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

import jp.co.forrentsystem.constants.BuildingType;
import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.constants.RoomImageClass;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.dto.RoomsDetailDto;
import jp.co.forrentsystem.dto.RoomsDto;
import jp.co.forrentsystem.dto.RoomsImageDto;
import jp.co.forrentsystem.dto.StructureDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.form.backend.DetailRoomForm;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.EquipmentService;
import jp.co.forrentsystem.service.GoodForConditionService;
import jp.co.forrentsystem.service.NearestStationService;
import jp.co.forrentsystem.service.RoomEquipmentService;
import jp.co.forrentsystem.service.RoomGoodForConditionService;
import jp.co.forrentsystem.service.RoomsService;
import jp.co.forrentsystem.service.StructureService;
import jp.co.forrentsystem.util.FileUtil;
import jp.co.forrentsystem.util.UtilService;

/**
 * 部屋情報詳細コントローラ
 * @author k.akahira
 */
@Controller
public class DetailRoomController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(DetailRoomController.class);

	@Autowired
	private RoomsService roomsService;
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private RoomEquipmentService roomEquipmentService;
	@Autowired
	private RoomGoodForConditionService roomGoodForConditionService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private GoodForConditionService goodForConditionService;
	@Autowired
	private NearestStationService nearestStationService;
	@Autowired
	private StructureService structureService;

	/**
	 * 初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/detailRoom", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		logger.info("DetailRoomController-init");

		model = roomsService.reloadModel(model, session);

		int buildingId = (int)model.get("buildingId");
		int roomId = (int)model.get("roomId");
		int transactionFlag = model.get("transactionFlag") == null ? 1 : (int)model.get("transactionFlag");

		// 部屋情報キー項目をDTOに設定
		RoomsDto paramRoomsDto = roomsService.getParamRoomsDto(buildingId, roomId);
		// 建物情報取得
		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);
		// 建物IDと部屋IDをキーに部屋情報を取得
		RoomsDetailDto roomsDetailDto = roomsService.getRoomsDtoByBuildingIdAndRoomId(paramRoomsDto);
		// 部屋詳細FORMを取得
		DetailRoomForm detailRoomForm = roomsService.getDetailRoomForm(roomsDetailDto, buildingDto);
		detailRoomForm.setTransactionFlag(transactionFlag);

		// 部屋画像リスト
		List<RoomsImageDto> roomImageDtoList = roomsService.getRoomImageList(buildingId, roomId);
		// 部屋画像区分リスト
		List<MasterDto> roomImageClassList = RoomImageClass.getRoomImageClassList();

		// 部屋設備取得
		List<Integer> roomEquilpmentIdList = roomEquipmentService.getRoomEquipmentIdList(buildingId, roomId);
		// 部屋こだわり条件取得
		List<Integer> roomGoodForConditionIdList = roomGoodForConditionService.getRoomGoodForConditionIdList(buildingId, roomId);

		int buildingContactId = 0;
		if(session.getAttribute("buildingContactId") != null) {
			buildingContactId = (Integer)session.getAttribute("buildingContactId");
		}


		ModelAndView mav = new ModelAndView();
		mav.addObject("detailRoomForm", detailRoomForm);
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		mav.addObject("roomEquilpmentIdList", roomEquilpmentIdList);
		mav.addObject("roomGoodForConditionIdList", roomGoodForConditionIdList);
		mav.addObject("roomImageList", roomImageDtoList);
		mav.addObject("roomImageClassList", roomImageClassList);
		mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.addObject("buildingContactId", buildingContactId);

		mav.setViewName("./back/detailRoom");

		return mav;
	}

	/**
	 * 部屋編集画面へ遷移
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callEditRoom", method = RequestMethod.POST)
	public String callEditRoom(RedirectAttributes attributes, @Valid DetailRoomForm detailRoomForm) {
		logger.info("DetailRoomController-callEditRoom");

		attributes.addFlashAttribute("detailRoomForm", detailRoomForm);

		// リダイレクト（部屋編集画面）
		return"redirect:/back/editRoom";
	}

	/**
	 * 建物詳細画面へ戻る
	 *
	 * @param buildingId 建物ID
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backDetailRoom", method = RequestMethod.GET)
	public String back(@Param(value="buildingId") Integer buildingId, RedirectAttributes attribute) {
		logger.info("DetailRoomController-back");

		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);

		// 建物情報を建物詳細Formに設定する
		DetailBuildingForm detailBuildingForm = buildingService.getBuildingDtoForDetailBuildingForm(buildingDto);

		//建物情報を建物詳細Formをattributeに保存
		attribute.addFlashAttribute("detailBuildingForm", detailBuildingForm);

		// リダイレクト（建物検索画面）
		return "redirect:/back/detailBuilding";
	}

	/**
	 * 物件問い合わせ詳細画面へ戻る
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backDetailBuildingContact", method = RequestMethod.GET)
	public String backDetailBuildingContact(@Param(value="buildingContactId") Integer buildingContactId, HttpSession session, RedirectAttributes attributes) {
		logger.info("DetailRoomController-backDetailBuildingContact");
		attributes.addFlashAttribute("buildingContactId", buildingContactId);
		session.removeAttribute("buildingContactId");

		// リダイレクト（物件問い合わせ画面）
		return "redirect:/back/initDetailBuildingContact";
	}


	/**
	 * 部屋画像登録
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 * @param imageId 画像ID
	 * @param fileName ファイル名
	 *
	 * @return 部屋画像情報
	 *
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/back/uploadRoomsImageFile", method = RequestMethod.POST)
    public RoomsImageDto fileupload(@RequestParam("fileupload") MultipartFile file,
    					   @Param(value="targetBuildingId") Integer targetBuildingId,
    					   @Param(value="targetRoomId") Integer targetRoomId,
    					   @Param(value="roomImageClass") Integer roomImageClass,
    					   @Param(value="imageCaption") String imageCaption) throws IOException {

		logger.info("DetailRoomController-fileupload");

		RoomsImageDto roomsImageDto = new RoomsImageDto();
		// 初期値設定
		roomsImageDto.setEmptyFileCheckFlag(true);
		roomsImageDto.setFileSizeCheckFlag(true);
		roomsImageDto.setSameFileNameCheckFlag(true);
		//==================================================================
		// アップロード処理
		//==================================================================
		// 空ファイルチェック
		if (file.isEmpty() ) {
			// ファイル内空の場合
			roomsImageDto.setEmptyFileCheckFlag(false);
			return roomsImageDto;
		}

		// ファイルサイズチェック
		if(FileUtil.getFileUploadMaxSize() < file.getSize()) {
			// アップロード最大サイズ以上の場合
			roomsImageDto.setFileSizeCheckFlag(false);
			return roomsImageDto;
		}

		// 登録済み確認
		List<RoomsImageDto> checkRoomsImageDtoList = roomsService.getRoomImageList(targetBuildingId, targetRoomId);
		// ファイル名チェック
		if (checkRoomsImageDtoList != null) {
			for (RoomsImageDto tmpRoomsImageDto : checkRoomsImageDtoList) {
				if (StringUtils.equals(tmpRoomsImageDto.getFileName(),file.getOriginalFilename())) {
					// ファイル名が同じだった場合
					roomsImageDto.setSameFileNameCheckFlag(false);
					return roomsImageDto;
				}
			}
		}

		// アップロードベースディレクトリ
		String baseDirectoryName = FileUtil.getFileBaseDirectory();
		String delimiter = FileUtil.getDirectoryDelimiter();
		String directoryPath = baseDirectoryName + targetBuildingId + delimiter + targetRoomId + delimiter;
		String fileName = new String(file.getOriginalFilename().getBytes("iso-8859-1"),"utf-8");
		File targetDirectory = new File(directoryPath);

		logger.info("★★★file.getOriginalFilename():" + file.getOriginalFilename());
		logger.info("★★★file.getOriginalFilename().getBytes_iso-8859-1:" + file.getOriginalFilename().getBytes("iso-8859-1"),"utf-8");
		logger.info("★★★file.getOriginalFilename().getBytes_ms932:" + file.getOriginalFilename().getBytes("ms932"),"utf-8");

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
		roomsImageDto = roomsService.registRoomImage(targetBuildingId, targetRoomId,
				roomImageClass, fileName, imageCaption, publicationFlag);
		// 空ファイルチェックOKを設定
		roomsImageDto.setEmptyFileCheckFlag(true);
		// ファイルサイズチェックOKを設定
		roomsImageDto.setFileSizeCheckFlag(true);
		// ファイル名チェックOKを設定
		roomsImageDto.setSameFileNameCheckFlag(true);

		return roomsImageDto;

	}
	/**
	 * 部屋画像削除
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 * @param imageId 画像ID
	 * @param fileName ファイル名
	 *
	 * @return 部屋画像情報
	 *
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/back/deleteRoomImageFile", method = RequestMethod.POST)
    public RoomsImageDto deleteRoomImage(@Param(value="buildingId") Integer buildingId,
    						@Param(value="roomId") Integer roomId,
							@Param(value="imageId") Integer imageId,
							@Param(value="fileName") String fileName) throws IOException {
		logger.info("DetailRoomController-deleteRoomImage");
		// 画像ファイル情報
		String baseDirectoryName = FileUtil.getFileBaseDirectory();
		String delimiter = FileUtil.getDirectoryDelimiter();
		String directoryPath = baseDirectoryName + buildingId + delimiter + roomId + delimiter;

		File file = new File(directoryPath+fileName);

		if (!file.exists()){
			throw new IOException();
		}
		// ファイル削除
		file.delete();

		//==================================================================
		// DB更新 建物画像テーブルにdelete
		//==================================================================
		RoomsImageDto roomsImageDto = roomsService.deleteRoomImage(buildingId, roomId, imageId, fileName);

		return roomsImageDto;
	}

	/**
	 * 部屋削除処理
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 *
	 * @return 画面遷移情報
	 */
	@RequestMapping(value = "/back/deleteRoom", method = RequestMethod.GET)
    public String deleteRoom(@Param(value="buildingId") Integer buildingId, @Param(value="roomId") Integer roomId, RedirectAttributes attributes) {
		logger.info("DetailRoomController-deleteRoom");
		RoomsDto roomsDto = new RoomsDto();
		roomsDto.setBuildingId(buildingId);
		roomsDto.setRoomId(roomId);

		RoomsDetailDto roomsDetailDto = roomsService.getRoomsDtoByBuildingIdAndRoomId(roomsDto);

		// 部屋情報削除
		roomsService.deleteRoom(buildingId, roomId);

		// 建物IDをキーに建物情報取得
		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);
		// 最寄駅名称取得
		List<NearestStationNameDto> nearestStationNameDtoList = nearestStationService.getNearestStationNameList(buildingId);
		// 建物種別名称取得
		String buildingTypeName = BuildingType.getTargetName(buildingDto.getBuildingType());
		// 建物構造名称取得
		StructureDto structureDto = structureService.getStructureName(buildingDto.getStructureId());

		DetailBuildingForm detailBuildingForm = buildingService.getDetailBuildingForm(buildingDto, nearestStationNameDtoList
				,buildingTypeName, structureDto);

		// 建物詳細FormをSESSIONに設定
		attributes.addFlashAttribute("detailBuildingForm", detailBuildingForm);

        ResourceBundle bundle = ResourceBundle.getBundle("Message_ja");

        String message = MessageFormat.format(bundle.getString("delete.room"), roomsDetailDto.getRoomCode(), roomsDetailDto.getRoomNumber());
        attributes.addFlashAttribute("message", message);

		return "redirect:/back/detailBuilding";
	}

}
