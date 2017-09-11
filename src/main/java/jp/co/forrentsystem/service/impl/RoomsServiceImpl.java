package jp.co.forrentsystem.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jp.co.forrentsystem.constants.Constants;
import jp.co.forrentsystem.constants.ContractForm;
import jp.co.forrentsystem.constants.DeliveryMethod;
import jp.co.forrentsystem.constants.KeyMoneyClass;
import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.constants.RecruitmentStatus;
import jp.co.forrentsystem.constants.SecurityDepositClass;
import jp.co.forrentsystem.constants.SecurityMoneyClass;
import jp.co.forrentsystem.dao.RecommendedRoomDao;
import jp.co.forrentsystem.dao.RoomEquipmentDao;
import jp.co.forrentsystem.dao.RoomGoodForConditionDao;
import jp.co.forrentsystem.dao.RoomsDao;
import jp.co.forrentsystem.dao.RoomsImageDao;
import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.RoomEquipmentDto;
import jp.co.forrentsystem.dto.RoomGoodForConditionDto;
import jp.co.forrentsystem.dto.RoomsDetailDto;
import jp.co.forrentsystem.dto.RoomsDto;
import jp.co.forrentsystem.dto.RoomsImageDto;
import jp.co.forrentsystem.dto.SearchConditionDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.form.backend.DetailRoomForm;
import jp.co.forrentsystem.form.backend.EditRoomsForm;
import jp.co.forrentsystem.form.backend.ListRoomsForm;
import jp.co.forrentsystem.form.backend.RegistRoomsForm;
import jp.co.forrentsystem.form.frontend.FSearchConditionForm;
import jp.co.forrentsystem.service.EquipmentService;
import jp.co.forrentsystem.service.GoodForConditionService;
import jp.co.forrentsystem.service.RoomEquipmentService;
import jp.co.forrentsystem.service.RoomGoodForConditionService;
import jp.co.forrentsystem.service.RoomsService;
import jp.co.forrentsystem.util.FileUtil;
import jp.co.forrentsystem.util.PagerUtil;
import jp.co.forrentsystem.util.UtilService;
import jp.co.forrentsystem.util.YearsUtil;

/**
 * 部屋サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class RoomsServiceImpl implements RoomsService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RoomsServiceImpl.class);

	@Autowired
	private RoomsDao roomsDao;
	@Autowired
	private RoomsImageDao roomsImageDao;
	@Autowired
	private RecommendedRoomDao recommendedRoomDao;
	@Autowired
	private RoomEquipmentDao roomEquipmentDao;
	@Autowired
	private RoomGoodForConditionDao roomGoodForConditionDao;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private GoodForConditionService goodForConditionService;
	@Autowired
	private RoomEquipmentService roomEquipmentService;
	@Autowired
	private RoomGoodForConditionService roomGoodForConditionService;

	@Override
	public RegistRoomsForm getBuildingInfoForRoom(DetailBuildingForm detailBuildingForm) {
		logger.info("RoomsServiceImpl-getBuildingInfo");

		// 部屋登録Formに建物情報を設定する
		RegistRoomsForm registRoomForm = new RegistRoomsForm();
		registRoomForm.setBuildingId(detailBuildingForm.getBuildingId());
		registRoomForm.setBuildingCode(detailBuildingForm.getBuildingCode());
		registRoomForm.setBuildingName(detailBuildingForm.getBuildingName());

		return registRoomForm;
	}

	@Override
	public RoomsDto getRoomsDto(EditRoomsForm editRoomForm) {
		logger.info("RoomsServiceImpl-getRoomsDto");

		// 入力された部屋編集FormをDTOに設定する
		RoomsDto roomsDto = new RoomsDto();
		roomsDto.setBuildingId(editRoomForm.getBuildingId());
		roomsDto.setRoomId(editRoomForm.getRoomId());
		roomsDto.setRoomCode(editRoomForm.getRoomCode());
		roomsDto.setRoomNumber(editRoomForm.getRoomNumber());
		roomsDto.setNumberOfStoreysId(editRoomForm.getNumberOfStoreysId());
		roomsDto.setRecruitmentStatus(editRoomForm.getRecruitmentStatus());
		roomsDto.setFloorPlanId(editRoomForm.getFloorPlanId());
		roomsDto.setSpace(editRoomForm.getSpace());
		roomsDto.setSecurityDepositClass(editRoomForm.getSecurityDepositClass());
		roomsDto.setSecurityDeposit(editRoomForm.getSecurityDeposit());
		roomsDto.setKeyMoneyClass(editRoomForm.getKeyMoneyClass());
		roomsDto.setKeyMoney(editRoomForm.getKeyMoney());
		roomsDto.setRent(editRoomForm.getRent());
		roomsDto.setCommonServiceFeeClass(editRoomForm.getCommonServiceFeeClass());
		roomsDto.setCommonServiceFee(editRoomForm.getCommonServiceFee());
		roomsDto.setAdministrativeCostClass(editRoomForm.getAdministrativeCostClass());
		roomsDto.setAdministrativeCost(editRoomForm.getAdministrativeCost());
		roomsDto.setPremiumClass(editRoomForm.getPremiumClass());
		roomsDto.setPremium(editRoomForm.getPremium());
		roomsDto.setRenewalFeeClass(editRoomForm.getRenewalFeeClass());
		roomsDto.setRenewalFee(editRoomForm.getRenewalFee());
		roomsDto.setSecurityMoneyClass(editRoomForm.getSecurityMoneyClass());
		roomsDto.setSecurityMoney(editRoomForm.getSecurityMoney());
		roomsDto.setAmortization(editRoomForm.getAmortization());
		roomsDto.setGuarantyCompanyFlag(editRoomForm.getGuarantyCompanyFlag());
		roomsDto.setPublicationFlag(editRoomForm.getPublicationFlag());
		roomsDto.setContractForm(editRoomForm.getContractForm());
		roomsDto.setDeliveryMethod(editRoomForm.getDeliveryMethod());
		roomsDto.setDeliveryTime(editRoomForm.getDeliveryTime());
		roomsDto.setContractPeriod(editRoomForm.getContractPeriod());
		roomsDto.setImportantPoints(editRoomForm.getImportantPoints());
		roomsDto.setRoomPrTitle(editRoomForm.getRoomPrTitle());
		roomsDto.setRoomPrDetail(editRoomForm.getRoomPrDetail());
		roomsDto.setDeleteFlag(Constants.DELETE_FLAG_FALSE);

		return roomsDto;
	}


	@Override
	public RoomsDto registRooms(RegistRoomsForm registRoomsForm) {
		logger.info("RoomsServiceImpl-insertRooms");

		List<MasterDto> equipmentList = equipmentService.getEquipmentList();
		List<MasterDto> goodForConditionList = goodForConditionService.getGoodForConditionList();

		// 部屋情報DTOに設定
		RoomsDto roomsDto = this.getRoomsDto(registRoomsForm);
		// 部屋登録
		roomsDao.registRooms(roomsDto);
		// 登録した部屋ID取得
		Integer roomId = this.getRoomId(roomsDto);

		String[] equipmentArray = registRoomsForm.getEquipmentArray();
		if (equipmentArray != null && equipmentArray.length != 0) {
			// 部屋設備情報をセッションから取得
			List<RoomEquipmentDto> roomEquipmentDtoList = roomEquipmentService.getRoomEquipmentList(registRoomsForm.getBuildingId(),
					roomId, equipmentArray,equipmentList);
			// 部屋設備登録処理
			roomEquipmentService.registRoomEquipment(roomEquipmentDtoList);
		}

		String[] goodForConditionArray = registRoomsForm.getGoodForConditionArray();
		if (goodForConditionArray != null && goodForConditionArray.length != 0) {
			// こだわり条件情報をセッションから取得
			List<RoomGoodForConditionDto> roomGoodForConditionDtoList = roomGoodForConditionService.getRoomGoodForConditionList(registRoomsForm.getBuildingId(),
					roomId, goodForConditionArray,goodForConditionList);
			// こだわり条件登録処理
			roomGoodForConditionService.registRoomGoodForCondition(roomGoodForConditionDtoList);
		}

		return roomsDto;
	}

	@Override
	public List<ListRoomsForm> getRoomsListByBuildingId(Integer buildingId) {
		logger.info("RoomsServiceImpl-getRoomsListByBuildingId");

		List<ListRoomsForm> roomsList = new ArrayList<ListRoomsForm>();

		// 部屋一覧情報をFormに設定する
		List<RoomsDto> roomsDtoList = roomsDao.getRoomsListByBuildingId(buildingId);
		for (RoomsDto roomsDto : roomsDtoList) {
			ListRoomsForm listRoomsForm = new ListRoomsForm();
			listRoomsForm.setBuildingId(roomsDto.getBuildingId());
			listRoomsForm.setRoomId(roomsDto.getRoomId());
			listRoomsForm.setRoomCode(roomsDto.getRoomCode());
			listRoomsForm.setRoomNumber(roomsDto.getRoomNumber());
			listRoomsForm.setRecruitmentStatus(roomsDto.getRecruitmentStatus());
			listRoomsForm.setRecruitmentStatusName(RecruitmentStatus.getTargetName(roomsDto.getRecruitmentStatus()));
			roomsList.add(listRoomsForm);
		}
		return roomsList;
	}

	@Override
	public RoomsDetailDto getRoomsDtoByBuildingIdAndRoomId(RoomsDto roomsDto) {
		logger.info("RoomsServiceImpl-getRoomsDtoByBuildingIdAndRoomId");

		// 建物ID、部屋IDをキーに部屋情報を取得
		return roomsDao.getRoomsDtoByBuildingIdAndRoomId(roomsDto);
	}

	@Override
	public RoomsDto getParamRoomsDto(Integer buildingId, Integer roomId) {
		logger.info("RoomsServiceImpl-getParamRoomsDto");

		// 部屋情報取得条件をDTOに設定
		RoomsDto roomsDto = new RoomsDto();
		roomsDto.setBuildingId(buildingId);
		roomsDto.setRoomId(roomId);
		return roomsDto;
	}

	@Override
	public DetailRoomForm getDetailRoomForm(RoomsDetailDto roomsDetailDto, BuildingDto buildingDto) {
		logger.info("RoomsServiceImpl-getDetailRoomForm");

		// 部屋詳細情報をFormに設定
		DetailRoomForm detailRoomForm = new DetailRoomForm();
		detailRoomForm.setBuildingId(roomsDetailDto.getBuildingId());
		detailRoomForm.setBuildingCode(buildingDto.getBuildingCode());
		detailRoomForm.setBuildingName(buildingDto.getBuildingName());
		detailRoomForm.setRoomId(roomsDetailDto.getRoomId());
		detailRoomForm.setRoomCode(roomsDetailDto.getRoomCode());
		detailRoomForm.setRoomNumber(roomsDetailDto.getRoomNumber());
		detailRoomForm.setNumberOfStoreysId(roomsDetailDto.getNumberOfStoreysId());
		detailRoomForm.setNumberOfStoreysName(roomsDetailDto.getNumberOfStoreysName());
		detailRoomForm.setRecruitmentStatus(roomsDetailDto.getRecruitmentStatus());
		detailRoomForm.setRecruitmentStatusName(RecruitmentStatus.getTargetName(roomsDetailDto.getRecruitmentStatus()));
		detailRoomForm.setFloorPlanId(roomsDetailDto.getFloorPlanId());
		detailRoomForm.setFloorPlanName(roomsDetailDto.getFloorPlanName());
		detailRoomForm.setSpace(roomsDetailDto.getSpace());
		detailRoomForm.setSecurityDepositClass(roomsDetailDto.getSecurityDepositClass());
		detailRoomForm.setSecurityDepositClassName(SecurityDepositClass.getTargetName(roomsDetailDto.getSecurityDepositClass()));
		detailRoomForm.setSecurityDeposit(roomsDetailDto.getSecurityDeposit());
		detailRoomForm.setKeyMoneyClass(roomsDetailDto.getKeyMoneyClass());
		detailRoomForm.setKeyMoneyClassName(KeyMoneyClass.getTargetName(roomsDetailDto.getKeyMoneyClass()));
		detailRoomForm.setKeyMoney(roomsDetailDto.getKeyMoney());
		detailRoomForm.setRent(roomsDetailDto.getRent());
		detailRoomForm.setCommonServiceFeeClass(roomsDetailDto.getCommonServiceFeeClass());
		detailRoomForm.setCommonServiceFeeClassName(UtilService.getNameForFlag(roomsDetailDto.getCommonServiceFeeClass()));
		detailRoomForm.setCommonServiceFee(roomsDetailDto.getCommonServiceFee());
		detailRoomForm.setAdministrativeCostClass(roomsDetailDto.getAdministrativeCostClass());
		detailRoomForm.setAdministrativeCostClassName(UtilService.getNameForFlag(roomsDetailDto.getAdministrativeCostClass()));
		detailRoomForm.setAdministrativeCost(roomsDetailDto.getAdministrativeCost());
		detailRoomForm.setPremiumClass(roomsDetailDto.getPremiumClass());
		detailRoomForm.setPremiumClassName(UtilService.getNameForFlag(roomsDetailDto.getPremiumClass()));
		detailRoomForm.setPremium(roomsDetailDto.getPremium());
		detailRoomForm.setRenewalFeeClass(roomsDetailDto.getRenewalFeeClass());
		detailRoomForm.setRenewalFeeClassName(UtilService.getNameForFlag(roomsDetailDto.getRenewalFeeClass()));
		detailRoomForm.setRenewalFee(roomsDetailDto.getRenewalFee());
		detailRoomForm.setSecurityMoneyClass(roomsDetailDto.getSecurityMoneyClass());
		detailRoomForm.setSecurityMoneyClassName(SecurityMoneyClass.getTargetName(roomsDetailDto.getSecurityMoneyClass()));
		detailRoomForm.setSecurityMoney(roomsDetailDto.getSecurityMoney());
		detailRoomForm.setAmortization(roomsDetailDto.getAmortization());
		detailRoomForm.setGuarantyCompanyFlag(roomsDetailDto.getGuarantyCompanyFlag());
		detailRoomForm.setGuarantyCompanyName(UtilService.getNameForFlag(roomsDetailDto.getGuarantyCompanyFlag()));
		detailRoomForm.setPublicationFlag(roomsDetailDto.getPublicationFlag());
		detailRoomForm.setPublicationName(UtilService.getNameForPublicationFlag(roomsDetailDto.getPublicationFlag()));
		detailRoomForm.setContractForm(roomsDetailDto.getContractForm());
		detailRoomForm.setContractFormName(ContractForm.getTargetName(roomsDetailDto.getContractForm()));
		detailRoomForm.setDeliveryMethod(roomsDetailDto.getDeliveryMethod());
		detailRoomForm.setDeliveryMethodName(DeliveryMethod.getTargetName(roomsDetailDto.getDeliveryMethod()));
		detailRoomForm.setDeliveryTime(roomsDetailDto.getDeliveryTime());
		detailRoomForm.setContractPeriod(roomsDetailDto.getContractPeriod());
		detailRoomForm.setImportantPoints(roomsDetailDto.getImportantPoints());
		detailRoomForm.setRoomPrTitle(roomsDetailDto.getRoomPrTitle());
		detailRoomForm.setRoomPrDetail(roomsDetailDto.getRoomPrDetail());
		detailRoomForm.setDeleteFlag(Constants.DELETE_FLAG_FALSE);

		return detailRoomForm;
	}

	@Override
	public void updateRooms(EditRoomsForm editRoomsForm) {
		logger.info("RoomsServiceImpl-updateRooms");

		// 部屋情報DTOに設定
		RoomsDto roomsDto = this.getRoomsDto(editRoomsForm);

		// 部屋情報更新
		roomsDao.updateRooms(roomsDto);

		// 部屋設備取得
		List<MasterDto> equipmentList =  equipmentService.getEquipmentList();
		// こだわり条件取得
		List<MasterDto> goodForConditionList =  goodForConditionService.getGoodForConditionList();

		// 部屋設備更新
		String[] equipmentArray = editRoomsForm.getEquipmentArray();
		if (equipmentArray != null && equipmentArray.length != 0) {
			// 部屋設備情報をセッションから取得
			List<RoomEquipmentDto> roomEquipmentDtoList = roomEquipmentService.getRoomEquipmentList(editRoomsForm.getBuildingId(),
					editRoomsForm.getRoomId(), equipmentArray, equipmentList);
			// 部屋設備登録処理
			roomEquipmentService.updateRoomEquipment(roomEquipmentDtoList);
		}

		// 部屋こだわり条件更新
		String[] goodForConditionArray = editRoomsForm.getGoodForConditionArray();
		if (goodForConditionArray != null && goodForConditionArray.length != 0) {
			// こだわり条件情報をセッションから取得
			List<RoomGoodForConditionDto> roomGoodForConditionDtoList = roomGoodForConditionService.getRoomGoodForConditionList(editRoomsForm.getBuildingId(),
					editRoomsForm.getRoomId(), goodForConditionArray, goodForConditionList);
			// こだわり条件登録処理
			roomGoodForConditionService.updateRoomGoodForCondition(roomGoodForConditionDtoList);
		}
	}

	@Override
	public List<RoomsImageDto> getRoomImageList(Integer buildingId,
			Integer roomId) {
		logger.info("RoomsServiceImpl-getRoomImageList");

		// 部屋画像取得条件をDTOに設定し、取得する
		RoomsImageDto roomsImageDto = new RoomsImageDto();
		roomsImageDto.setBuildingId(buildingId);
		roomsImageDto.setRoomId(roomId);
		return roomsImageDao.getRoomImageList(roomsImageDto);
	}

	@Override
	public RoomsImageDto registRoomImage(Integer targetBuildingId,
			Integer targetRoomId, Integer roomImageClass, String fileName,
			String imageCaption, Integer publicationFlag) {
		logger.info("RoomsServiceImpl-registRoomImage");

		// 部屋画像入力情報をDTOへ設定する
		RoomsImageDto roomsImageDto = new RoomsImageDto();
		roomsImageDto.setBuildingId(targetBuildingId);
		roomsImageDto.setRoomId(targetRoomId);
		roomsImageDto.setRoomImageClass(roomImageClass);
		roomsImageDto.setFileName(fileName);
		roomsImageDto.setImageCaption(imageCaption);
		roomsImageDto.setPublicationFlag(publicationFlag);
		roomsImageDto.setFilePath(FileUtil.getFileRelativePath());
		roomsImageDto.setDeleteFlag(Constants.DELETE_FLAG_FALSE);

		// 登録済みか確認
		Integer count = roomsImageDao.countRoomImage(roomsImageDto);
		if (count == 0) {
			// 未登録の場合
			// 建物画像情報を登録
			roomsImageDao.registRoomImage(roomsImageDto);
		} else {
			// 登録済みの場合
			// 建物画像DTOをnullとする
			roomsImageDto = null;
		}
		return roomsImageDto;

	}

	@Override
	public RoomsImageDto deleteRoomImage(Integer buildingId,
			Integer roomId, Integer imageId, String fileName) {
		logger.info("RoomsServiceImpl-deleteBuildingImage");

		// 部屋情報削除条件をDTOに設定
		RoomsImageDto roomsImageDto = new RoomsImageDto();
		roomsImageDto.setBuildingId(buildingId);
		roomsImageDto.setRoomId(roomId);
		roomsImageDto.setImageId(imageId);
		roomsImageDto.setFileName(fileName);

		// 建物画像情報取得
		roomsImageDao.deleteRoomImage(roomsImageDto);

		return roomsImageDto;
	}

	@Override
	public List<ArticleDto> getArticleList(
			FSearchConditionForm fSearchConditionForm) {
		logger.info("RoomsServiceImpl-getArticleList");

		// 検索条件をDTOに設定する
		SearchConditionDto searchConditionDto = this.getSearchConditionDto(fSearchConditionForm);

		return roomsDao.getArticleList(searchConditionDto);
	}

	@Override
	public int countArticleList(FSearchConditionForm fSearchConditionForm) {
		logger.info("RoomsServiceImpl-countArticleList");

		// 検索条件をDTOに設定する
		SearchConditionDto searchConditionDto = this.getSearchConditionDto(fSearchConditionForm);

		return roomsDao.countArticle(searchConditionDto);
	}

	@Override
	public ArticleDto getDetailArticle(Integer buildingId, Integer roomId) {
		logger.info("RoomsServiceImpl-getDetailArticle");

		ArticleDto articleDto = this.getDetailCondition(buildingId, roomId);

		return roomsDao.getDetailArticle(articleDto);
	}

	@Override
	public List<RoomsDto> getRoomsListForVacancy(Integer buildingId, Integer roomId) {
		logger.info("RoomsServiceImpl-getRoomsListForVacancyByBuildingId");
		RoomsDto roomsDto = new RoomsDto();
		roomsDto.setBuildingId(buildingId);
		roomsDto.setRoomId(roomId);

		List<RoomsDto> roomsList = roomsDao.getRoomsListForVacancy(roomsDto);
		return roomsList;
	}


	@Override
	public void deleteRoom(Integer buildingId, Integer roomId) {
		logger.info("RoomsServiceImpl-deleteRoom");

		RoomsDto roomsDto = new RoomsDto();
		roomsDto.setBuildingId(buildingId);
		roomsDto.setRoomId(roomId);

		// 部屋情報削除
		roomsDao.deleteRoomByRoomId(roomsDto);
		// 部屋画像情報削除
		roomsImageDao.deleteRoomImageByRoomId(roomsDto);
		// 部屋設備情報削除
		roomEquipmentDao.deleteRoomEquipmentByRoomId(roomsDto);
		// 部屋こだわり条件情報削除
		roomGoodForConditionDao.deleteRoomGoodForConditionByRoomId(roomsDto);
		// おすすめ物件削除
		recommendedRoomDao.deleteRecommendedByRoomId(roomsDto);

	}

	/**
	 * 検索条件Formから検索条件DTOに設定し、DTOを返却する
	 *
	 * @param fSearchConditionForm 検索条件Form
	 *
	 * @return 検索条件DTO
	 */
	private SearchConditionDto getSearchConditionDto(
			FSearchConditionForm fSearchConditionForm) {
		SearchConditionDto searchConditionDto = new SearchConditionDto();

		// 最寄駅情報をDTOへ設定
		if (fSearchConditionForm.getSelectedStationId() != null &&
				fSearchConditionForm.getSelectedStationId().length != 0) {
			// 駅IDリスト格納用
			List<Integer> stationIdList = new ArrayList<Integer>();

			// 沿線は、検索条件に含めないこと。（山手線新宿駅、総武線新宿駅の区別は行わない。）
			// 沿線と駅が選択情報が存在する場合、沿線IDリストと駅IDリストを作成する
			for (String routeAndStationId : fSearchConditionForm.getSelectedStationId()) {
				if (StringUtils.equals(routeAndStationId, "999")) {
					break;
				}
				String stationId = null;
				if (routeAndStationId.matches(".*_.*")) {
					stationId = routeAndStationId.split("_")[1];
					stationIdList.add(Integer.parseInt(stationId));
				} else {
					stationIdList.add(Integer.parseInt(routeAndStationId));
				}
			}
			if (!StringUtils.equals(fSearchConditionForm.getSelectedStationId()[0], "999")) {

				// 重複を除く
				Set<Integer> stationSet = new HashSet<Integer>();
				stationSet.addAll(stationIdList);

				List<Integer> stationList = new ArrayList<Integer>();
				stationList.addAll(stationSet);

				searchConditionDto.setStationIdList(stationList);
			}
		}

		// 住所情報をDTOに設定
		if (fSearchConditionForm.getSelectedTownArea() != null &&
				fSearchConditionForm.getSelectedTownArea().length != 0) {
			// 都道府県リスト格納用
			List<String> provinceList = new ArrayList<String>();
			// 市区町村リスト格納用
			List<String> cityList = new ArrayList<String>();
			// 町域リスト格納用
			List<String> townAreaList = new ArrayList<String>();

			// 町域が選択情報に存在する場合、都道府県リスト、市区町村リストと町域リストを作成する
			for (String area : fSearchConditionForm.getSelectedTownArea()) {
				if (StringUtils.equals(area, "999")) {
					break;
				}
				if (area.matches(".*_.*")) {
					String province = area.split("_")[0];
					String city = area.split("_")[1];
					String townArea = area.split("_")[2];
					provinceList.add(province);
					cityList.add(city);
					townAreaList.add(townArea);
				} else {
					townAreaList.add(area);
				}
			}
			if (!StringUtils.equals(fSearchConditionForm.getSelectedTownArea()[0], "999")) {
				searchConditionDto.setProvinceList(provinceList);
				searchConditionDto.setCityList(cityList);
				searchConditionDto.setTownAreaList(townAreaList);
			}
		}

		// 絞り込み条件【建物種別】をDTOに設定
		if (fSearchConditionForm.getSelectedBuildingType() != null &&
				fSearchConditionForm.getSelectedBuildingType().length != 0) {
			searchConditionDto.setBuildingTypeList(
					this.setSelectedList(fSearchConditionForm.getSelectedBuildingType()));
		}

		// 絞り込み条件【設備】をDTOに設定
		if (fSearchConditionForm.getSelectedEquipment() != null &&
				fSearchConditionForm.getSelectedEquipment().length != 0) {
			searchConditionDto.setEquipmentList(
					this.setSelectedList(fSearchConditionForm.getSelectedEquipment()));
		}

		// 絞り込み条件【賃料From】をDTOに設定
		if (fSearchConditionForm.getRentFromClassId() != null &&
				fSearchConditionForm.getRentFromClassId() != 0) {
			// 検索条件となる金額を取得
			searchConditionDto.setRentFrom(fSearchConditionForm.getRentFromClassId());
		}

		// 絞り込み条件【賃料To】をDTOに設定
		if (fSearchConditionForm.getRentToClassId() != null &&
				fSearchConditionForm.getRentToClassId() != 0) {
			// 検索条件となる金額を取得
			searchConditionDto.setRentTo(fSearchConditionForm.getRentToClassId());
		}

		// 絞り込み条件【間取り】をDTOに設定
		if (fSearchConditionForm.getSelectedFloorPlan() != null &&
				fSearchConditionForm.getSelectedFloorPlan().length != 0) {
			// 検索条件となる間取りIDを取得
			searchConditionDto.setFloorPlanIdList(
					this.setSelectedList(fSearchConditionForm.getSelectedFloorPlan()));
		}

		// 絞り込み条件【駅徒歩】をDTOに設定
		if (fSearchConditionForm.getSelectedMinutesWalkClass() != null &&
				fSearchConditionForm.getSelectedMinutesWalkClass() != 0) {
			// 検索条件となる徒歩分を取得
			searchConditionDto.setMinutesWalk(fSearchConditionForm.getSelectedMinutesWalkClass());
		}

		// 絞り込み条件【築年数】をDTOに設定
		if (fSearchConditionForm.getSelectedBuiltClass() != null &&
				fSearchConditionForm.getSelectedBuiltClass() != 0) {
			// 検索条件となる築年数を取得
			searchConditionDto.setBuiltYear(YearsUtil.getBuiltYear(fSearchConditionForm.getSelectedBuiltClass()));
			searchConditionDto.setBuiltMonth(YearsUtil.getBuiltMonth());
		}

		// 絞り込み条件【こだわり条件】をDTOに設定
		if (fSearchConditionForm.getSelectedGoodForCondition() != null &&
				fSearchConditionForm.getSelectedGoodForCondition().length != 0) {
			// 検索条件となるこだわり条件を取得
			searchConditionDto.setGoodForConditionList(
					this.setSelectedList(fSearchConditionForm.getSelectedGoodForCondition()));
		}

		searchConditionDto.setFromNumber(PagerUtil.getNumberFrom(fSearchConditionForm.getCurrentPage(), fSearchConditionForm.getViewNumber()));
		searchConditionDto.setViewNumber(fSearchConditionForm.getViewNumber());
		searchConditionDto.setSortArticleId(fSearchConditionForm.getSortArticleId());

		return searchConditionDto;
	}

	/**
	 * 選択された条件をリストに設定する
	 *
	 * @param targetArray 選択配列
	 *
	 * @return 条件値格納リスト
	 */
	private List<Integer> setSelectedList(String[] targetArray) {
		// 結果格納用リスト
		List<Integer> targetList = new ArrayList<Integer>();
		for (String target : targetArray) {
			if(!StringUtils.isBlank(target)) {
				targetList.add(Integer.parseInt(target));
			}
		}
		return targetList;
	}

	/**
	 * 物件詳細取得用条件をDTOに設定し、DTOを取得
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 *
	 * @return 物件情報DTO
	 */
	private ArticleDto getDetailCondition(int buildingId, int roomId) {

		// 物件情報DTO
		ArticleDto articleDto = new ArticleDto();

		articleDto.setBuildingId(buildingId);
		articleDto.setRoomId(roomId);

		return articleDto;
	}

	@Override
	public RegistRoomsForm getRegistForm(RoomsDetailDto roomsDetailDto, BuildingDto buildingDto) {
		logger.info("RoomsServiceImpl-getDetailRoomForm");

		// 部屋設備情報取得処理
		RoomEquipmentDto roomEquipmentDto = new RoomEquipmentDto();
		roomEquipmentDto.setBuildingId(roomsDetailDto.getBuildingId());
		roomEquipmentDto.setRoomId(roomsDetailDto.getRoomId());
		List<Integer> equipmentList = roomEquipmentDao.getRoomEquipmentIdList(roomEquipmentDto);

		// 部屋こだわり条件情報取得処理
		RoomGoodForConditionDto roomGoodForConditionDto = new RoomGoodForConditionDto();
		roomGoodForConditionDto.setBuildingId(roomsDetailDto.getBuildingId());
		roomGoodForConditionDto.setRoomId(roomsDetailDto.getRoomId());
		List<Integer> goodForConditionList = roomGoodForConditionDao.getRoomGoodForConditionIdList(roomGoodForConditionDto);


		// 部屋詳細情報をFormに設定
		RegistRoomsForm registRoomsForm = new RegistRoomsForm();
		registRoomsForm.setBuildingId(roomsDetailDto.getBuildingId());
		registRoomsForm.setBuildingCode(buildingDto.getBuildingCode());
		registRoomsForm.setBuildingName(buildingDto.getBuildingName());
		registRoomsForm.setRoomNumber(roomsDetailDto.getRoomNumber());
		registRoomsForm.setNumberOfStoreysId(roomsDetailDto.getNumberOfStoreysId());
		registRoomsForm.setNumberOfStoreysName(roomsDetailDto.getNumberOfStoreysName());
		registRoomsForm.setRecruitmentStatus(roomsDetailDto.getRecruitmentStatus());
		registRoomsForm.setRecruitmentStatusName(RecruitmentStatus.getTargetName(roomsDetailDto.getRecruitmentStatus()));
		registRoomsForm.setFloorPlanId(roomsDetailDto.getFloorPlanId());
		registRoomsForm.setFloorPlanName(roomsDetailDto.getFloorPlanName());
		registRoomsForm.setSpace(roomsDetailDto.getSpace());
		registRoomsForm.setSecurityDepositClass(roomsDetailDto.getSecurityDepositClass());
		registRoomsForm.setSecurityDepositClassName(UtilService.getNameForFlag(roomsDetailDto.getSecurityDepositClass()));
		registRoomsForm.setSecurityDeposit(roomsDetailDto.getSecurityDeposit());
		registRoomsForm.setKeyMoneyClass(roomsDetailDto.getKeyMoneyClass());
		registRoomsForm.setKeyMoneyClassName(UtilService.getNameForFlag(roomsDetailDto.getKeyMoneyClass()));
		registRoomsForm.setKeyMoney(roomsDetailDto.getKeyMoney());
		registRoomsForm.setRent(roomsDetailDto.getRent());
		registRoomsForm.setCommonServiceFeeClass(roomsDetailDto.getCommonServiceFeeClass());
		registRoomsForm.setCommonServiceFeeClassName(UtilService.getNameForFlag(roomsDetailDto.getCommonServiceFeeClass()));
		registRoomsForm.setCommonServiceFee(roomsDetailDto.getCommonServiceFee());
		registRoomsForm.setAdministrativeCostClass(roomsDetailDto.getAdministrativeCostClass());
		registRoomsForm.setAdministrativeCostClassName(UtilService.getNameForFlag(roomsDetailDto.getAdministrativeCostClass()));
		registRoomsForm.setAdministrativeCost(roomsDetailDto.getAdministrativeCost());
		registRoomsForm.setPremiumClass(roomsDetailDto.getPremiumClass());
		registRoomsForm.setPremiumClassName(UtilService.getNameForFlag(roomsDetailDto.getPremiumClass()));
		registRoomsForm.setPremium(roomsDetailDto.getPremium());
		registRoomsForm.setRenewalFeeClass(roomsDetailDto.getRenewalFeeClass());
		registRoomsForm.setRenewalFeeClassName(UtilService.getNameForFlag(roomsDetailDto.getRenewalFeeClass()));
		registRoomsForm.setRenewalFee(roomsDetailDto.getRenewalFee());
		registRoomsForm.setSecurityMoneyClass(roomsDetailDto.getSecurityMoneyClass());
		registRoomsForm.setSecurityMoneyClassName(SecurityMoneyClass.getTargetName(roomsDetailDto.getSecurityMoneyClass()));
		registRoomsForm.setSecurityMoney(roomsDetailDto.getSecurityMoney());
		registRoomsForm.setAmortization(roomsDetailDto.getAmortization());
		registRoomsForm.setGuarantyCompanyFlag(roomsDetailDto.getGuarantyCompanyFlag());
		registRoomsForm.setGuarantyCompanyName(UtilService.getNameForFlag(roomsDetailDto.getGuarantyCompanyFlag()));
		registRoomsForm.setPublicationFlag(roomsDetailDto.getPublicationFlag());
		registRoomsForm.setPublicationName(UtilService.getNameForFlag(roomsDetailDto.getPublicationFlag()));
		registRoomsForm.setContractForm(roomsDetailDto.getContractForm());
		registRoomsForm.setContractFormName(ContractForm.getTargetName(roomsDetailDto.getContractForm()));
		registRoomsForm.setDeliveryMethod(roomsDetailDto.getDeliveryMethod());
		registRoomsForm.setDeliveryMethodName(DeliveryMethod.getTargetName(roomsDetailDto.getDeliveryMethod()));
		registRoomsForm.setDeliveryTime(roomsDetailDto.getDeliveryTime());
		registRoomsForm.setContractPeriod(roomsDetailDto.getContractPeriod());
		registRoomsForm.setImportantPoints(roomsDetailDto.getImportantPoints());
		registRoomsForm.setRoomPrTitle(roomsDetailDto.getRoomPrTitle());
		registRoomsForm.setRoomPrDetail(roomsDetailDto.getRoomPrDetail());
		registRoomsForm.setEquipmentArray(UtilService.changeArray(equipmentList));
		registRoomsForm.setGoodForConditionArray(UtilService.changeArray(goodForConditionList));
		registRoomsForm.setDeleteFlag(Constants.DELETE_FLAG_FALSE);

		return registRoomsForm;
	}

	private RoomsDto getRoomsDto(RegistRoomsForm registRoomForm) {
		logger.info("RoomsServiceImpl-getRoomsDto");

		// 入力された部屋登録情報をDTOに設定する
		RoomsDto roomsDto = new RoomsDto();
		roomsDto.setBuildingId(registRoomForm.getBuildingId());
		roomsDto.setRoomCode(registRoomForm.getRoomCode());
		roomsDto.setRoomNumber(registRoomForm.getRoomNumber());
		roomsDto.setNumberOfStoreysId(registRoomForm.getNumberOfStoreysId());
		roomsDto.setRecruitmentStatus(registRoomForm.getRecruitmentStatus());
		roomsDto.setFloorPlanId(registRoomForm.getFloorPlanId());
		roomsDto.setSpace(registRoomForm.getSpace());
		roomsDto.setSecurityDepositClass(registRoomForm.getSecurityDepositClass());
		roomsDto.setSecurityDeposit(registRoomForm.getSecurityDeposit());
		roomsDto.setKeyMoneyClass(registRoomForm.getKeyMoneyClass());
		roomsDto.setKeyMoney(registRoomForm.getKeyMoney());
		roomsDto.setRent(registRoomForm.getRent());
		roomsDto.setCommonServiceFeeClass(registRoomForm.getCommonServiceFeeClass());
		roomsDto.setCommonServiceFee(registRoomForm.getCommonServiceFee());
		roomsDto.setAdministrativeCostClass(registRoomForm.getAdministrativeCostClass());
		roomsDto.setAdministrativeCost(registRoomForm.getAdministrativeCost());
		roomsDto.setPremiumClass(registRoomForm.getPremiumClass());
		roomsDto.setPremium(registRoomForm.getPremium());
		roomsDto.setRenewalFeeClass(registRoomForm.getRenewalFeeClass());
		roomsDto.setRenewalFee(registRoomForm.getRenewalFee());
		roomsDto.setSecurityMoneyClass(registRoomForm.getSecurityMoneyClass());
		roomsDto.setSecurityMoney(registRoomForm.getSecurityMoney());
		roomsDto.setAmortization(registRoomForm.getAmortization());
		roomsDto.setGuarantyCompanyFlag(registRoomForm.getGuarantyCompanyFlag());
		roomsDto.setPublicationFlag(registRoomForm.getPublicationFlag());
		roomsDto.setContractForm(registRoomForm.getContractForm());
		roomsDto.setDeliveryMethod(registRoomForm.getDeliveryMethod());
		roomsDto.setDeliveryTime(registRoomForm.getDeliveryTime());
		roomsDto.setContractPeriod(registRoomForm.getContractPeriod());
		roomsDto.setImportantPoints(registRoomForm.getImportantPoints());
		roomsDto.setRoomPrTitle(registRoomForm.getRoomPrTitle());
		roomsDto.setRoomPrDetail(registRoomForm.getRoomPrDetail());
		roomsDto.setDeleteFlag(Constants.DELETE_FLAG_FALSE);

		return roomsDto;
	}

	private Integer getRoomId(RoomsDto roomsDto) {
		logger.info("RoomsServiceImpl-getRoomId");

		// 部屋ID取得
		return roomsDao.getRoomId(roomsDto);
	}

	@Override
	public ModelMap reloadModel(ModelMap model, HttpSession session) {
		if (model.isEmpty() == false) {
			session.setAttribute("model", model);
		} else {
			model = (ModelMap)session.getAttribute("model");
		}
		return model;
	}
}
