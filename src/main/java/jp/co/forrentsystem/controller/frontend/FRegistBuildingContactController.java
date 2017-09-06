package jp.co.forrentsystem.controller.frontend;

import org.springframework.stereotype.Controller;

/**
 * フロント物件お問合わせ登録コントローラ
 * @author k.akahira
 */
@Controller
public class FRegistBuildingContactController {

//	@Autowired
//	private RoomsService roomsService;
//	@Autowired
//	private StructureService structureService;
//	@Autowired
//	private RecommendedRoomsService recommendedRoomsService;
//	@Autowired
//	private BannerService bannerService;
//	@Autowired
//	private RoomEquipmentService roomEquipmentService;
//	@Autowired
//	private EquipmentService equipmentService;
//
//	private Logger logger = org.slf4j.LoggerFactory.getLogger(FRegistBuildingContactController.class);
//
//	/**
//	 * フロント物件詳細画面初期表示
//	 *
//	 * @return 画面表示情報
//	 */
//	@RequestMapping(value = "/callBuildingContactDetail", method = RequestMethod.POST)
//	public ModelAndView init(@Valid  FDetailArticleForm fDetailArticleForm) {
//		logger.info("FSearchStation-init");
//
//		int buildingId = fDetailArticleForm.getBuildingId();
//		int roomId = fDetailArticleForm.getRoomId();
//
//		// 物件詳細情報取得
//		ArticleDto articleDto = roomsService.getDetailArticle(buildingId, roomId);
//
//		// 対象の部屋設備IDを取得
//		List<Integer> roomEquipmentList = roomEquipmentService.getRoomEquipmentIdList(buildingId, roomId);
//
//		// 設備リスト
//		List<MasterDto> equipmentList = equipmentService.getEquipmentList();
//
//		// 部屋画像取得
//		List<RoomsImageDto> roomsImageList = roomsService.getRoomImageList(buildingId, roomId);
//
//		// おすすめ物件
//		List<RecommendedRoomImageDto> recommendedRoomImageList = recommendedRoomsService.getRecoomendedRoomListByViewNumber();
//
//		// バナー
//		List<BannerDto> bannerList = bannerService.getBannerListByViewNumber();
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("fDetailArticleForm", fDetailArticleForm);
//		mav.addObject("article", articleDto);
//		// 建物種別リスト
//		mav.addObject("buildingTypeList", BuildingType.getBuildingTypeList());
//		// 構造リスト
//		mav.addObject("structureList", structureService.getStructureList());
//		// 敷金区分リスト
//		mav.addObject("securityDepositClassList", SecurityDepositClass.getSecurityDepositClassList());
//		// 礼金区分
//		mav.addObject("keyMoneyClassList", KeyMoneyClass.getKeyMoneyClassList());
//		// 更新料区分リスト
//		mav.addObject("renewalFeeClassList", RenewalFeeClass.getRenewalFeeClassList());
//		// 部屋設備IDリスト
//		mav.addObject("roomEquipmentList", roomEquipmentList);
//		// 設備リスト
//		mav.addObject("equipmentList", equipmentList);
//		// 建物画像ファイルパスを設定
//		mav.addObject("filePath", FileUtil.getFileRelativePath());
//		// 部屋画像リスト
//		mav.addObject("roomsImageList", roomsImageList);
//
//		// おすすめ物件画像リスト
//		mav.addObject("recommendedRoomImageList", recommendedRoomImageList);
//		// バナーリスト
//		mav.addObject("bannerList", bannerList);
//
//		mav.setViewName("/front/fDetailArticle");
//
//
//		return mav;
//	}
}
