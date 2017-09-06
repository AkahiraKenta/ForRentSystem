package jp.co.forrentsystem.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.co.forrentsystem.constants.BuildingType;
import jp.co.forrentsystem.constants.KeyMoneyClass;
import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.constants.RenewalFeeClass;
import jp.co.forrentsystem.constants.SecurityDepositClass;
import jp.co.forrentsystem.constants.SecurityMoneyClass;
import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.dto.RoomsDto;
import jp.co.forrentsystem.dto.RoomsImageDto;
import jp.co.forrentsystem.form.frontend.FDetailArticleForm;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.service.EquipmentService;
import jp.co.forrentsystem.service.GoodForConditionService;
import jp.co.forrentsystem.service.RecommendedRoomsService;
import jp.co.forrentsystem.service.RoomEquipmentService;
import jp.co.forrentsystem.service.RoomGoodForConditionService;
import jp.co.forrentsystem.service.RoomsService;
import jp.co.forrentsystem.service.StructureService;
import jp.co.forrentsystem.util.FileUtil;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * フロント物件詳細コントローラ
 * @author k.akahira
 */
@Controller
public class FDetailArticleController {

	@Autowired
	private RoomsService roomsService;
	@Autowired
	private StructureService structureService;
	@Autowired
	private RecommendedRoomsService recommendedRoomsService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private RoomEquipmentService roomEquipmentService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private GoodForConditionService goodForConditionService;
	@Autowired
	private RoomGoodForConditionService roomGoodForConditionService;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FDetailArticleController.class);

	/**
	 * フロント物件詳細画面初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/callDetailArticle", method = RequestMethod.POST)
	public ModelAndView init(@Valid  FDetailArticleForm fDetailArticleForm) {
		logger.info("FDetailArticleController-init");

		int buildingId = fDetailArticleForm.getBuildingId();
		int roomId = fDetailArticleForm.getRoomId();

		// 物件詳細情報取得
		ArticleDto articleDto = roomsService.getDetailArticle(buildingId, roomId);

		// 対象の部屋設備IDを取得
		List<Integer> roomEquipmentList = roomEquipmentService.getRoomEquipmentIdList(buildingId, roomId);
		// 設備リスト
		List<MasterDto> equipmentList = equipmentService.getEquipmentList();

		// 対象のこだわり条件IDを取得
		List<Integer> roomGoodForConditionList = roomGoodForConditionService.getRoomGoodForConditionIdList(buildingId, roomId);
		// こだわり条件リスト
		List<MasterDto> goodForConditionList = goodForConditionService.getGoodForConditionList();

		// 部屋画像取得
		List<RoomsImageDto> roomsImageList = roomsService.getRoomImageList(buildingId, roomId);

		// 部屋一覧取得
		List<RoomsDto> roomsList = roomsService.getRoomsListForVacancy(buildingId, roomId);

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fDetailArticleForm", fDetailArticleForm);
		mav.addObject("article", articleDto);
		// 建物種別リスト
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 構造リスト
		mav.addObject("structureList", structureService.getStructureList());
		// 敷金区分リスト
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 保証金区分リスト
		mav.addObject("securityMoneyClassList", SecurityMoneyClass.getSecurityMoneyClassList());
		// 礼金区分
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());
		// 更新料区分リスト
		mav.addObject("renewalFeeClassList", RenewalFeeClass.getRenewalFeeClassList());
		// 部屋設備IDリスト
		mav.addObject("roomEquipmentList", roomEquipmentList);
		// 設備リスト
		mav.addObject("equipmentList", equipmentList);
		// 部屋こだわり条件IDリスト
		mav.addObject("roomGoodForConditionList", roomGoodForConditionList);
		// こだわり条件リスト
		mav.addObject("goodForConditionList", goodForConditionList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		// 部屋画像リスト
		mav.addObject("roomsImageList", roomsImageList);
		// 部屋リスト
		mav.addObject("roomsList", roomsList);

		// おすすめ物件画像リスト
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		// バナーリスト
		mav.addObject("bannerList", bannerList);

		mav.setViewName("/front/fDetailArticle");


		return mav;
	}

	/**
	 * フロント物件詳細画面初期表示(TOP画面から直接遷移する場合）
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/callNewArticle", method = RequestMethod.GET)
	public ModelAndView callNewArticle(@Param (value="buildingId") Integer buildingId, @Param (value="roomId") Integer roomId, HttpSession session) {
		logger.info("FDetailArticleController-callNewArticle");
		// 物件問い合わせ情報削除（メニューを押下した場合の対処）
		session.removeAttribute("fContactArticleForm");
		session.removeAttribute("fContactForm");

		// 物件詳細情報取得
		ArticleDto articleDto = roomsService.getDetailArticle(buildingId, roomId);

		// 対象の部屋設備IDを取得
		List<Integer> roomEquipmentList = roomEquipmentService.getRoomEquipmentIdList(buildingId, roomId);
		// 設備リスト
		List<MasterDto> equipmentList = equipmentService.getEquipmentList();

		// 対象のこだわり条件IDを取得
		List<Integer> roomGoodForConditionList = roomGoodForConditionService.getRoomGoodForConditionIdList(buildingId, roomId);
		// こだわり条件リスト
		List<MasterDto> goodForConditionList = goodForConditionService.getGoodForConditionList();

		// 部屋画像取得
		List<RoomsImageDto> roomsImageList = roomsService.getRoomImageList(buildingId, roomId);

		// 部屋一覧取得
		List<RoomsDto> roomsList = roomsService.getRoomsListForVacancy(buildingId, roomId);

		// おすすめ物件
		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();

		// バナー
		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();

		ModelAndView mav = new ModelAndView();
		mav.addObject("fDetailArticleForm", new FDetailArticleForm());
		mav.addObject("article", articleDto);
		// 建物種別リスト
		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
		// 構造リスト
		mav.addObject("structureList", structureService.getStructureList());
		// 敷金区分リスト
		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
		// 保証金区分リスト
		mav.addObject("securityMoneyClassList", SecurityMoneyClass.getSecurityMoneyClassList());
		// 礼金区分
		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());
		// 更新料区分リスト
		mav.addObject("renewalFeeClassList", RenewalFeeClass.getRenewalFeeClassList());
		// 部屋設備IDリスト
		mav.addObject("roomEquipmentList", roomEquipmentList);
		// 設備リスト
		mav.addObject("equipmentList", equipmentList);
		// 部屋こだわり条件IDリスト
		mav.addObject("roomGoodForConditionList", roomGoodForConditionList);
		// こだわり条件リスト
		mav.addObject("goodForConditionList", goodForConditionList);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		// 部屋画像リスト
		mav.addObject("roomsImageList", roomsImageList);
		// 部屋リスト
		mav.addObject("roomsList", roomsList);

		// おすすめ物件画像リスト
		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
		// バナーリスト
		mav.addObject("bannerList", bannerList);

		mav.setViewName("/front/fDetailArticle");


		return mav;
	}
}
