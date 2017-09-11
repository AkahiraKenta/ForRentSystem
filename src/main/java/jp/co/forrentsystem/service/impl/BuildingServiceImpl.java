package jp.co.forrentsystem.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jp.co.forrentsystem.constants.BuildingType;
import jp.co.forrentsystem.dao.BuildingDao;
import jp.co.forrentsystem.dao.BuildingImageDao;
import jp.co.forrentsystem.dao.NearestStationDao;
import jp.co.forrentsystem.dao.RecommendedRoomDao;
import jp.co.forrentsystem.dao.RoomEquipmentDao;
import jp.co.forrentsystem.dao.RoomGoodForConditionDao;
import jp.co.forrentsystem.dao.RoomsDao;
import jp.co.forrentsystem.dao.RoomsImageDao;
import jp.co.forrentsystem.dao.StructureDao;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.NearestStationDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.dto.SearchConditionDto;
import jp.co.forrentsystem.dto.StructureDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.form.backend.EditBuildingForm;
import jp.co.forrentsystem.form.backend.ListBuildingForm;
import jp.co.forrentsystem.form.backend.RegistBuildingForm;
import jp.co.forrentsystem.form.backend.SearchBuildingForm;
import jp.co.forrentsystem.form.frontend.FSearchConditionForm;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.NearestStationService;
import jp.co.forrentsystem.util.FileUtil;
import jp.co.forrentsystem.util.PagerUtil;

/**
 * 建物サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class BuildingServiceImpl implements BuildingService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(BuildingServiceImpl.class);

	@Autowired
	private BuildingDao buildingDao;
	@Autowired
	private StructureDao structureDao;
	@Autowired
	private BuildingImageDao buildingImageDao;
	@Autowired
	private NearestStationDao nearestStationDao;
	@Autowired
	private RoomsDao roomsDao;
	@Autowired
	private RoomEquipmentDao roomEquipmentDao;
	@Autowired
	private RoomsImageDao roomsImageDao;
	@Autowired
	private RecommendedRoomDao recommendedRoomDao;
	@Autowired
	private RoomGoodForConditionDao roomGoodForConditionDao;
	@Autowired
	private NearestStationService nearestStationService;

	@Override
	public BuildingDto insertBuilding(RegistBuildingForm registBuildingForm) {
		logger.info("BuildingServiceImpl-insertBuilding");

		// 建物情報DTOを取得
		BuildingDto buildingDto = this.getRegistBuildingDto(registBuildingForm);
		// 建物情報登録
		buildingDao.registBuilding(buildingDto);

		// 建物ID取得
		Integer buildingId = this.getBuildingId(buildingDto);
		buildingDto.setBuildingId(buildingId);
		// 最寄駅情報登録
		List<NearestStationDto> nearestStationDtoList = nearestStationService.getNearestStationDtoList(registBuildingForm, buildingId);

		// 最寄駅登録処理
		nearestStationService.registNearestStation(nearestStationDtoList);

		return buildingDto;
	}

	/**
	 * ジオメトリーコード値を設定する
	 * @param latitude 経度
	 * @param longitude 緯度
	 * @return ジオメトリーコード
	 */
	private String combainGeoCode(Double latitude, Double longitude) {
		// 地図情報を設定
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("POINT(")
					 .append(String.valueOf(longitude))
					 .append(" ")
					 .append(String.valueOf(latitude))
					 .append(")");

		return stringBuilder.toString();
	}

	@Override
	public ListBuildingForm getPagerForSearchBuilding(ListBuildingForm listBuildingForm, SearchBuildingForm searchBuildingForm) {
		logger.info("BuildingServiceImpl-getPagerForSearchBuilding");

		// 検索条件をDTOに設定
		BuildingDto buildingDto = getSearchBuildingDto(searchBuildingForm);

		// 対象件数
		int totalNumber = buildingDao.countSearchBuildingList(buildingDto);
		// 表示件数
		int viewNumber = FileUtil.getArticleViewNumber();
		// 全件数
		listBuildingForm.setTotalNumber(totalNumber);
		// 表示件数
		listBuildingForm.setViewNumber(viewNumber);
		// 現在のページ
		listBuildingForm.setCurrentPage(listBuildingForm.getCurrentPage());
		// 全ページ数
		listBuildingForm.setPageTotalNumber(PagerUtil.getPageTotalNumber(totalNumber, viewNumber));

		return listBuildingForm;
	}

	@Override
	public List<BuildingDto> searchBuildingList(ListBuildingForm listBuildingForm, SearchBuildingForm searchBuildingForm) {
		logger.info("BuildingServiceImpl-searchBuildingList");

		// 検索条件をDTOに設定
		BuildingDto buildingDto = getSearchBuildingDto(searchBuildingForm);
		buildingDto.setFromNumber(PagerUtil.getNumberFrom(listBuildingForm.getCurrentPage(), listBuildingForm.getViewNumber()));
		buildingDto.setViewNumber(listBuildingForm.getViewNumber());

		return buildingDao.searchBuildingList(buildingDto);
	}

	@Override
	public BuildingDto getBuildingDtoByBuildingId(Integer buildingId) {
		logger.info("BuildingServiceImpl-getBuildingDtoByBuildingId");

		return buildingDao.getBuildingDtoByBuildingId(buildingId);
	}

	@Override
	public DetailBuildingForm getDetailBuildingForm(BuildingDto buildingDto,
			List<NearestStationNameDto> nearestStationNameDtoList,
			String buildingTypeName, StructureDto structureDto) {
		// 建物詳細情報をFormに設定する
		DetailBuildingForm detailBuildingForm = new DetailBuildingForm();
		detailBuildingForm.setBuildingId(buildingDto.getBuildingId());
		detailBuildingForm.setBuildingCode(buildingDto.getBuildingCode());
		detailBuildingForm.setBuildingName(buildingDto.getBuildingName());
		detailBuildingForm.setBuildingType(buildingDto.getBuildingType());
		detailBuildingForm.setBuildingTypeName(buildingTypeName);
		detailBuildingForm.setZipCode(buildingDto.getZipCode());
		detailBuildingForm.setProvince(buildingDto.getProvince());
		detailBuildingForm.setCity(buildingDto.getCity());
		detailBuildingForm.setCityName(buildingDto.getCity());
		detailBuildingForm.setTownArea(buildingDto.getTownArea());
		detailBuildingForm.setTownAreaName(buildingDto.getTownArea());
		detailBuildingForm.setTownAreaBelow(buildingDto.getTownAreaBelow());
		if (nearestStationNameDtoList.size() != 0) {
			detailBuildingForm.setNearestRoute1(nearestStationNameDtoList.get(0).getRouteId());
			detailBuildingForm.setNearestRouteName1(nearestStationNameDtoList.get(0).getRouteName());
			detailBuildingForm.setNearestStation1(nearestStationNameDtoList.get(0).getStationId());
			detailBuildingForm.setNearestStationName1(nearestStationNameDtoList.get(0).getStationName());
			detailBuildingForm.setMinutesWalk1(nearestStationNameDtoList.get(0).getMinutesWalk());

			if (nearestStationNameDtoList.size() >= 2) {
				detailBuildingForm.setNearestRoute2(nearestStationNameDtoList.get(1).getRouteId());
				detailBuildingForm.setNearestRouteName2(nearestStationNameDtoList.get(1).getRouteName());
				detailBuildingForm.setNearestStation2(nearestStationNameDtoList.get(1).getStationId());
				detailBuildingForm.setNearestStationName2(nearestStationNameDtoList.get(1).getStationName());
				detailBuildingForm.setMinutesWalk2(nearestStationNameDtoList.get(1).getMinutesWalk());

			}
			if (nearestStationNameDtoList.size() >= 3) {
				detailBuildingForm.setNearestRoute3(nearestStationNameDtoList.get(2).getRouteId());
				detailBuildingForm.setNearestRouteName3(nearestStationNameDtoList.get(2).getRouteName());
				detailBuildingForm.setNearestStation3(nearestStationNameDtoList.get(2).getStationId());
				detailBuildingForm.setNearestStationName3(nearestStationNameDtoList.get(2).getStationName());
				detailBuildingForm.setMinutesWalk3(nearestStationNameDtoList.get(2).getMinutesWalk());

			}
		}

		detailBuildingForm.setLatitude(buildingDto.getLatitude());
		detailBuildingForm.setLongitude(buildingDto.getLongitude());
		detailBuildingForm.setBuiltYear(buildingDto.getBuiltYear());
		detailBuildingForm.setBuiltMonth(buildingDto.getBuiltMonth());
		detailBuildingForm.setNumberOfStoreys(buildingDto.getNumberOfStoreys());
		detailBuildingForm.setStructureId(buildingDto.getStructureId());
		detailBuildingForm.setStructureName(structureDto.getStructureName());
		detailBuildingForm.setPrTitle(buildingDto.getPrTitle());
		detailBuildingForm.setPrDetail(buildingDto.getPrDetail());

		return detailBuildingForm;
	}

	@Override
	public void updateBuilding(EditBuildingForm editConfirmBuildingForm) {
		logger.info("BuildingServiceImpl-insertBuilding");

		// 建物情報DTOを取得
		BuildingDto buildingDto = this.getEditBuildingDto(editConfirmBuildingForm);
		// 建物情報を更新する
		buildingDao.updateBuilding(buildingDto);

		// 最寄駅情報更新
		List<NearestStationDto> nearestStationDtoList = nearestStationService.getNearestStationDtoList(editConfirmBuildingForm, editConfirmBuildingForm.getBuildingId());
		nearestStationService.updateNearestStation(nearestStationDtoList, editConfirmBuildingForm.getBuildingId());

	}

	@Override
	public DetailBuildingForm getBuildingDtoForDetailBuildingForm(BuildingDto buildingDto) {
		logger.info("BuildingServiceImpl-getDetailbuildingForm");

		List<NearestStationNameDto> nearestStationList = nearestStationDao.getNearestStationNameList(buildingDto.getBuildingId());

		StructureDto structureDto = structureDao.getStructureByStructureId(buildingDto.getStructureId());

		// 建物詳細情報をFormに設定する
		DetailBuildingForm detailBuildingForm = new DetailBuildingForm();
		detailBuildingForm.setBuildingId(buildingDto.getBuildingId());
		detailBuildingForm.setBuildingCode(buildingDto.getBuildingCode());
		detailBuildingForm.setBuildingName(buildingDto.getBuildingName());
		detailBuildingForm.setBuildingType(buildingDto.getBuildingType());
		detailBuildingForm.setBuildingTypeName(BuildingType.getTargetName(buildingDto.getBuildingType()));
		detailBuildingForm.setZipCode(buildingDto.getZipCode());
		detailBuildingForm.setProvince(buildingDto.getProvince());
		detailBuildingForm.setCity(buildingDto.getCity());
		detailBuildingForm.setTownArea(buildingDto.getTownArea());
		detailBuildingForm.setTownAreaBelow(buildingDto.getTownAreaBelow());
		if (nearestStationList.size() != 0) {
			detailBuildingForm.setNearestRoute1(nearestStationList.get(0).getRouteId());
			detailBuildingForm.setNearestRouteName1(nearestStationList.get(0).getRouteName());
			detailBuildingForm.setNearestStation1(nearestStationList.get(0).getStationId());
			detailBuildingForm.setNearestStationName1(nearestStationList.get(0).getStationName());
			detailBuildingForm.setMinutesWalk1(nearestStationList.get(0).getMinutesWalk());
			if (nearestStationList.size() >= 2) {
				detailBuildingForm.setNearestRoute2(nearestStationList.get(1).getRouteId());
				detailBuildingForm.setNearestRouteName2(nearestStationList.get(1).getRouteName());
				detailBuildingForm.setNearestStation2(nearestStationList.get(1).getStationId());
				detailBuildingForm.setNearestStationName2(nearestStationList.get(1).getStationName());
				detailBuildingForm.setMinutesWalk2(nearestStationList.get(1).getMinutesWalk());
			}
			if (nearestStationList.size() >= 3) {
				detailBuildingForm.setNearestRoute3(nearestStationList.get(2).getRouteId());
				detailBuildingForm.setNearestRouteName3(nearestStationList.get(2).getRouteName());
				detailBuildingForm.setNearestStation3(nearestStationList.get(2).getStationId());
				detailBuildingForm.setNearestStationName3(nearestStationList.get(2).getStationName());
				detailBuildingForm.setMinutesWalk3(nearestStationList.get(2).getMinutesWalk());
			}
		}
		detailBuildingForm.setLatitude(buildingDto.getLatitude());
		detailBuildingForm.setLongitude(buildingDto.getLongitude());
		detailBuildingForm.setBuiltYear(buildingDto.getBuiltYear());
		detailBuildingForm.setBuiltMonth(buildingDto.getBuiltMonth());
		detailBuildingForm.setNumberOfStoreys(buildingDto.getNumberOfStoreys());
		detailBuildingForm.setStructureId(buildingDto.getStructureId());
		detailBuildingForm.setStructureName(structureDto.getStructureName());
		detailBuildingForm.setPrTitle(buildingDto.getPrTitle());
		detailBuildingForm.setPrDetail(buildingDto.getPrDetail());

		return detailBuildingForm;
	}

	@Override
	public List<BuildingDto> searchNewBuildingList() {
		logger.info("BuildingServiceImpl-searchNewBuildingList");
		// 新着建物情報を取得する
		return buildingDao.searchNewBuildingList();
	}

	@Override
	public Map<String, Map<String, List<BuildingDto>>> getBuildingAddressListMap() {
		logger.info("BuildingServiceImpl-getBuildingAddressListMap");
		// 建物に紐付く住所を取得
		List<BuildingDto> buildingAddressList = buildingDao.getBuildingAddressList();

		// 都道府県単位Map
		Map<String, Map<String, List<BuildingDto>>> provinceMap = new LinkedHashMap<String, Map<String, List<BuildingDto>>>();

		// 市区町村単位MAP
		Map<String, List<BuildingDto>> cityMap = new LinkedHashMap<String, List<BuildingDto>>();

		// 町域用リスト
		List<BuildingDto> townAreaList = new LinkedList<BuildingDto>();

		// 市区町村用変数
		String backCity = null;

		// 都道府県用変数
		String backProvince = null;

		// 都道府県単位にまとめる
		for(BuildingDto buildingDto : buildingAddressList) {
			if (backCity == null) {
				// 初回は必ず変数に設定する
				// 市区町村名称を設定
				backCity = buildingDto.getCity();
				// 都道府県名称を設定
				backProvince = buildingDto.getProvince();
			} else {
				if (!StringUtils.equals(backCity, buildingDto.getCity())) {
					// 市区町村が異なる場合、市区町村用MAPにLISTを格納する
					cityMap.put(backCity, townAreaList);
					backCity = buildingDto.getCity();
					// リストの初期化
					townAreaList = new ArrayList<BuildingDto>();
				}
				if (!StringUtils.equals(backProvince, buildingDto.getProvince())) {
					// 都道府県が異なる場合、都道府県用MAPに市区町村MAPを格納する
					provinceMap.put(backProvince, cityMap);
					backProvince = buildingDto.getProvince();
					// 市区町村Mapの初期化
					cityMap = new HashMap<String, List<BuildingDto>>();
				}
			}
			townAreaList.add(buildingDto);
		}
		// 最後のリストを格納
		cityMap.put(townAreaList.get(0).getCity(), townAreaList);
		provinceMap.put(townAreaList.get(0).getProvince(), cityMap);

		return provinceMap;
	}

	@Override
	public List<BuildingDto> getAddressList(
			FSearchConditionForm fSearchConditionForm) {
		logger.info("BuildingServiceImpl-getAddressList");

		List<BuildingDto> resultList = new ArrayList<BuildingDto>();

		if (fSearchConditionForm.getSelectedTownArea() != null
				&& fSearchConditionForm.getSelectedTownArea().length != 0) {
			SearchConditionDto searchConditionDto = new SearchConditionDto();

			// 都道府県リスト格納用
			List<String> provinceList = new ArrayList<String>();
			// 市区町村リスト格納用
			List<String> cityList = new ArrayList<String>();
			// 町域リスト格納用
			List<String> townAreaList = new ArrayList<String>();

			if (fSearchConditionForm.getSelectedTownArea() != null) {
				// 町域が選択情報に存在する場合、都道府県リスト、市区町村リストと町域リストを作成する
				for (String area : fSearchConditionForm.getSelectedTownArea()) {
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

				searchConditionDto.setProvinceList(provinceList);
				searchConditionDto.setCityList(cityList);
				searchConditionDto.setTownAreaList(townAreaList);
			}

			resultList = buildingDao.getAddressList(searchConditionDto);
		}

		return resultList;
	}

	/**
	 * 検索条件を建物DTOへ設定する
	 *
	 * @param searchBuildingForm 検索条件Form
	 *
	 * @return 建物DTO
	 */
	private BuildingDto getSearchBuildingDto(SearchBuildingForm searchBuildingForm) {
		logger.info("BuildingServiceImpl-getSearchBuildingDto");
		BuildingDto buildingDto = new BuildingDto();

		// TODO:検索項目が確定次第コメントアウト除去する。
		buildingDto.setBuildingCode(searchBuildingForm.getBuildingCode());
		buildingDto.setBuildingName(searchBuildingForm.getBuildingName());
		buildingDto.setBuildingType(searchBuildingForm.getBuildingType());
		buildingDto.setZipCode(searchBuildingForm.getZipCode());
		buildingDto.setProvince(searchBuildingForm.getProvince());
		buildingDto.setCity(searchBuildingForm.getCityName());
//		buildingDto.setTownArea(searchBuildingForm.getTownAreaName());
//		buildingDto.setTownAreaBelow(searchBuildingForm.getTownAreaBelow());
//		buildingDto.setGeoCode(combainGeoCode(searchBuildingForm.getLatitude(),searchBuildingForm.getLongitude()));
//		buildingDto.setLatitude(searchBuildingForm.getLatitude());
//		buildingDto.setLongitude(searchBuildingForm.getLongitude());
		buildingDto.setBuiltYear(searchBuildingForm.getBuiltYear());
//		buildingDto.setBuiltMonth(searchBuildingForm.getBuiltMonth());
//		buildingDto.setNumberOfStoreys(searchBuildingForm.getNumberOfStoreys());
//		buildingDto.setStructureId(searchBuildingForm.getStructureId());
//		buildingDto.setPrTitle(searchBuildingForm.getPrTitle());
//		buildingDto.setPrDetail(searchBuildingForm.getPrDetail());
		buildingDto.setRouteId(searchBuildingForm.getRoute());
		buildingDto.setStationId(searchBuildingForm.getStation());
		buildingDto.setDeleteFlag(0);

		return buildingDto;
	}

	@Override
	public void deleteBuilding(Integer buildingId) {
		logger.info("BuildingServiceImpl-deleteBuilding");

		// 建物情報を削除
		buildingDao.deleteBuildingByBuildingId(buildingId);

		// 建物画像情報を削除
		buildingImageDao.deleteBuildingImageByBuildingId(buildingId);
		// 最寄駅情報を削除
		nearestStationDao.deleteNearestStationDeleteFlagByBuildingId(buildingId);
		// 部屋情報を削除
		roomsDao.deleteRoomByBuildingId(buildingId);
		// 部屋設備情報を削除
		roomEquipmentDao.deleteRoomEquipmentByBuildingId(buildingId);
		// 部屋画像情報を削除
		roomsImageDao.deleteRoomImageByBuildingId(buildingId);
		// おすすめ物件情報を削除
		recommendedRoomDao.deleteRecommendedByBuildingId(buildingId);
		// TODO：削除することにより、おすすめ物件の順番を更新する必要がある


		// 部屋こだわり条件を削除
		roomGoodForConditionDao.deleteRoomGoodForConditionByBuildingId(buildingId);


	}

	@Override
	public RegistBuildingForm getRegistBuildingForm(BuildingDto buildingDto) {

		List<NearestStationNameDto> nearestStationList = nearestStationDao.getNearestStationNameList(buildingDto.getBuildingId());

		// 建物詳細情報をFormに設定する
		RegistBuildingForm registBuildingForm = new RegistBuildingForm();
		registBuildingForm.setBuildingName(buildingDto.getBuildingName());
		registBuildingForm.setBuildingType(buildingDto.getBuildingType());
		registBuildingForm.setZipCode(buildingDto.getZipCode());
		registBuildingForm.setProvince(buildingDto.getProvince());
		registBuildingForm.setCity(buildingDto.getCity());
		registBuildingForm.setTownArea(buildingDto.getTownArea());
		registBuildingForm.setTownAreaBelow(buildingDto.getTownAreaBelow());
		if (nearestStationList.size() != 0) {
			registBuildingForm.setNearestRoute1(nearestStationList.get(0).getRouteId());
			registBuildingForm.setNearestRouteName1(nearestStationList.get(0).getRouteName());
			registBuildingForm.setNearestStation1(nearestStationList.get(0).getStationId());
			registBuildingForm.setNearestStationName1(nearestStationList.get(0).getStationName());
			registBuildingForm.setMinutesWalk1(nearestStationList.get(0).getMinutesWalk());
			if (nearestStationList.size() >= 2) {
				registBuildingForm.setNearestRoute2(nearestStationList.get(1).getRouteId());
				registBuildingForm.setNearestRouteName2(nearestStationList.get(1).getRouteName());
				registBuildingForm.setNearestStation2(nearestStationList.get(1).getStationId());
				registBuildingForm.setNearestStationName2(nearestStationList.get(1).getStationName());
				registBuildingForm.setMinutesWalk2(nearestStationList.get(1).getMinutesWalk());
			}
			if (nearestStationList.size() >= 3) {
				registBuildingForm.setNearestRoute3(nearestStationList.get(2).getRouteId());
				registBuildingForm.setNearestRouteName3(nearestStationList.get(2).getRouteName());
				registBuildingForm.setNearestStation3(nearestStationList.get(2).getStationId());
				registBuildingForm.setNearestStationName3(nearestStationList.get(2).getStationName());
				registBuildingForm.setMinutesWalk3(nearestStationList.get(2).getMinutesWalk());
			}
		}
		registBuildingForm.setLatitude(buildingDto.getLatitude());
		registBuildingForm.setLongitude(buildingDto.getLongitude());
		registBuildingForm.setBuiltYear(buildingDto.getBuiltYear());
		registBuildingForm.setBuiltMonth(buildingDto.getBuiltMonth());
		registBuildingForm.setNumberOfStoreys(buildingDto.getNumberOfStoreys());
		registBuildingForm.setStructureId(buildingDto.getStructureId());
		registBuildingForm.setPrTitle(buildingDto.getPrTitle());
		registBuildingForm.setPrDetail(buildingDto.getPrDetail());


		return registBuildingForm;
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

	/**
	 * 登録用建物情報Formから建物情報DTOに設定
	 *
	 * @param registBuildingForm 建物情報FORM
	 *
	 * @return 建物情報DTO
	 */
	private BuildingDto getRegistBuildingDto(RegistBuildingForm registBuildingForm) {
		logger.info("BuildingServiceImpl-getRegistBuildingDto");

		// 建物情報をDTOに設定
		BuildingDto buildingDto = new BuildingDto();
		buildingDto.setBuildingCode(registBuildingForm.getBuildingCode());
		buildingDto.setBuildingName(registBuildingForm.getBuildingName());
		buildingDto.setBuildingType(registBuildingForm.getBuildingType());
		buildingDto.setZipCode(registBuildingForm.getZipCode());
		buildingDto.setProvince(registBuildingForm.getProvince());
		buildingDto.setCity(registBuildingForm.getCityName());
		buildingDto.setTownArea(registBuildingForm.getTownAreaName());
		buildingDto.setTownAreaBelow(registBuildingForm.getTownAreaBelow());
		buildingDto.setGeoCode(combainGeoCode(registBuildingForm.getLatitude(),registBuildingForm.getLongitude()));
		buildingDto.setLatitude(registBuildingForm.getLatitude());
		buildingDto.setLongitude(registBuildingForm.getLongitude());
		buildingDto.setBuiltYear(registBuildingForm.getBuiltYear());
		buildingDto.setBuiltMonth(registBuildingForm.getBuiltMonth());
		buildingDto.setNumberOfStoreys(registBuildingForm.getNumberOfStoreys());
		buildingDto.setStructureId(registBuildingForm.getStructureId());
		buildingDto.setPrTitle(registBuildingForm.getPrTitle());
		buildingDto.setPrDetail(registBuildingForm.getPrDetail());
		buildingDto.setDeleteFlag(0);

		return buildingDto;
	}

	private Integer getBuildingId(BuildingDto buildingDto) {
		logger.info("BuildingServiceImpl-getBuildingId");

		return buildingDao.getBuildingId(buildingDto);
	}

	private BuildingDto getEditBuildingDto(EditBuildingForm editBuildingForm) {
		logger.info("BuildingServiceImpl-getRegistBuildingDto");

		// 建物情報をDTOに設定する
		BuildingDto buildingDto = new BuildingDto();
		buildingDto.setBuildingId(editBuildingForm.getBuildingId());
		buildingDto.setBuildingCode(editBuildingForm.getBuildingCode());
		buildingDto.setBuildingName(editBuildingForm.getBuildingName());
		buildingDto.setBuildingType(editBuildingForm.getBuildingType());
		buildingDto.setZipCode(editBuildingForm.getZipCode());
		buildingDto.setProvince(editBuildingForm.getProvince());
		buildingDto.setCity(editBuildingForm.getCityName());
		buildingDto.setTownArea(editBuildingForm.getTownAreaName());
		buildingDto.setTownAreaBelow(editBuildingForm.getTownAreaBelow());
		buildingDto.setGeoCode(combainGeoCode(editBuildingForm.getLatitude(),editBuildingForm.getLongitude()));
		buildingDto.setLatitude(editBuildingForm.getLatitude());
		buildingDto.setLongitude(editBuildingForm.getLongitude());
		buildingDto.setBuiltYear(editBuildingForm.getBuiltYear());
		buildingDto.setBuiltMonth(editBuildingForm.getBuiltMonth());
		buildingDto.setNumberOfStoreys(editBuildingForm.getNumberOfStoreys());
		buildingDto.setStructureId(editBuildingForm.getStructureId());
		buildingDto.setPrTitle(editBuildingForm.getPrTitle());
		buildingDto.setPrDetail(editBuildingForm.getPrDetail());
		buildingDto.setDeleteFlag(0);

		return buildingDto;
	}
}
