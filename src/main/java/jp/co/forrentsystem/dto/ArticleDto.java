package jp.co.forrentsystem.dto;

import jp.co.forrentsystem.util.PagerDto;

/**
 * 物件DTO
 * @author k.akahira
 *
 */
public class ArticleDto extends PagerDto {
	/** ID */
	private Integer id;
	/** 建物ID */
	private Integer buildingId;
	/** 建物コード */
	private String buildingCode;
	/** 建物名称 */
	private String buildingName;
	/** 建物種別 */
	private Integer buildingType;
	/** 部屋ID */
	private Integer roomId;
	/** 部屋コード */
	private String roomCode;
	/** 部屋番号 */
	private String roomNumber;
	/** 階建 */
	private Integer numberOfStoreys;
	/** 階層区分ID */
	private Integer numberOfStoreysId;
	/** 面積平米 */
	private Double space;
	/** 賃料 */
	private Integer rent;
	/** 共益費区分 */
	private Integer commonServiceFeeClass;
	/** 共益費 */
	private Integer commonServiceFee;
	/** 部屋PRタイトル */
	private String roomPrTitle;
	/** 面積平米(FROM) */
	private Double spaceFrom;
	/** 賃料(FROM) */
	private Integer rentFrom;
	/** 面積平米(TO) */
	private Double spaceTo;
	/** 賃料(TO) */
	private Integer rentTo;
	/** 順位 */
	private Integer rank;
	/** 間取りID */
	private Integer floorPlanId;
	/** 間取り名称 */
	private String floorPlanName;
	/** 敷金区分 */
	private Integer securityDepositClass;
	/** 敷金金額 */
	private Integer securityDeposit;
	/** 礼金区分 */
	private Integer keyMoneyClass;
	/** 礼金 */
	private Integer keyMoney;
	/** 画像ファイル名 */
	private String fileName;
	/** 最寄駅1 沿線ID */
	private Integer routeId1;
	/** 最寄駅1 駅ID */
	private Integer stationId1;
	/** 最寄駅1 沿線名称 */
	private String routeName1;
	/** 最寄駅1 駅名称 */
	private String stationName1;
	/** 最寄駅1 徒歩分 */
	private Integer minutesWalk1;
	/** 最寄駅2 沿線ID */
	private Integer routeId2;
	/** 最寄駅2 駅ID */
	private Integer stationId2;
	/** 最寄駅2 沿線名称 */
	private String routeName2;
	/** 最寄駅2 駅名称 */
	private String stationName2;
	/** 最寄駅2 徒歩分 */
	private Integer minutesWalk2;
	/** 最寄駅3 沿線ID */
	private Integer routeId3;
	/** 最寄駅3 駅ID */
	private Integer stationId3;
	/** 最寄駅3 沿線名称 */
	private String routeName3;
	/** 最寄駅3 駅名称 */
	private String stationName3;
	/** 最寄駅3 徒歩分 */
	private Integer minutesWalk3;
	/** 都道府県 */
	private String province;
	/** 市区町村 */
	private String city;
	/** 取得件数 */
	private Integer viewCount;
	/** 町域 */
	private String townArea;
	/** 建物画像ファイルパス */
	private String buildingFileName;
	/** 建物画像見出し */
	private String buildingImageCaption;
	/** 部屋画像区分 */
	private Integer roomImageClass;
	/** 部屋画像ファイルパス */
	private String roomsFileName;
	/** 町域以下 */
	private String townAreaBelow;
	/** 管理費区分 */
	private Integer administrativeCostClass;
	/** 管理費 */
	private Integer administrativeCost;
	/** 部屋PR詳細 */
	private String roomPrDetail;
	/** 構造ID */
	private Integer structureId;
	/** 築年数（年) */
	private Integer builtYear;
	/** 築年数（月） */
	private Integer builtMonth;
	/** 保険料区分 */
	private Integer premiumClass;
	/** 保険料 */
	private Integer premium;
	/** 更新料区分 */
	private Integer renewalFeeClass;
	/** 更新料区分名称 */
	private String renewalFee;
	/** 権利金区分 */
	private Integer foregiftClass;
	/** 権利金 */
	private Integer foregift;
	/** 契約期間 */
	private String contractPeriod;
	/** 郵便番号 */
	private String zipCode;
	/** 注意事項 */
	private String importantPoints;
	/** 階数名称 */
	private String floorName;
	/** 緯度 */
	private Double latitude;
	/** 経度 */
	private Double longitude;
	/** 入居可能日 */
	private String deliveryTime;
	/** 保証金区分 */
	private Integer securityMoneyClass;
	/** 保証金 */
	private Integer securityMoney;


	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTownArea() {
		return townArea;
	}
	public void setTownArea(String townArea) {
		this.townArea = townArea;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingCode() {
		return buildingCode;
	}
	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public Integer getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(Integer buildingType) {
		this.buildingType = buildingType;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Integer getNumberOfStoreysId() {
		return numberOfStoreysId;
	}
	public void setNumberOfStoreysId(Integer numberOfStoreysId) {
		this.numberOfStoreysId = numberOfStoreysId;
	}
	public Double getSpace() {
		return space;
	}
	public void setSpace(Double space) {
		this.space = space;
	}
	public Integer getRent() {
		return rent;
	}
	public void setRent(Integer rent) {
		this.rent = rent;
	}
	public Integer getCommonServiceFeeClass() {
		return commonServiceFeeClass;
	}
	public void setCommonServiceFeeClass(Integer commonServiceFeeClass) {
		this.commonServiceFeeClass = commonServiceFeeClass;
	}
	public Integer getCommonServiceFee() {
		return commonServiceFee;
	}
	public void setCommonServiceFee(Integer commonServiceFee) {
		this.commonServiceFee = commonServiceFee;
	}
	public Double getSpaceFrom() {
		return spaceFrom;
	}
	public void setSpaceFrom(Double spaceFrom) {
		this.spaceFrom = spaceFrom;
	}
	public Integer getRentFrom() {
		return rentFrom;
	}
	public void setRentFrom(Integer rentFrom) {
		this.rentFrom = rentFrom;
	}
	public Double getSpaceTo() {
		return spaceTo;
	}
	public void setSpaceTo(Double spaceTo) {
		this.spaceTo = spaceTo;
	}
	public Integer getRentTo() {
		return rentTo;
	}
	public void setRentTo(Integer rentTo) {
		this.rentTo = rentTo;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getFloorPlanId() {
		return floorPlanId;
	}
	public void setFloorPlanId(Integer floorPlanId) {
		this.floorPlanId = floorPlanId;
	}
	public String getFloorPlanName() {
		return floorPlanName;
	}
	public void setFloorPlanName(String floorPlanName) {
		this.floorPlanName = floorPlanName;
	}
	public Integer getSecurityDepositClass() {
		return securityDepositClass;
	}
	public void setSecurityDepositClass(Integer securityDepositClass) {
		this.securityDepositClass = securityDepositClass;
	}
	public Integer getSecurityDeposit() {
		return securityDeposit;
	}
	public void setSecurityDeposit(Integer securityDeposit) {
		this.securityDeposit = securityDeposit;
	}
	public Integer getKeyMoneyClass() {
		return keyMoneyClass;
	}
	public void setKeyMoneyClass(Integer keyMoneyClass) {
		this.keyMoneyClass = keyMoneyClass;
	}
	public Integer getKeyMoney() {
		return keyMoney;
	}
	public void setKeyMoney(Integer keyMoney) {
		this.keyMoney = keyMoney;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getRouteId1() {
		return routeId1;
	}
	public void setRouteId1(Integer routeId1) {
		this.routeId1 = routeId1;
	}
	public Integer getStationId1() {
		return stationId1;
	}
	public void setStationId1(Integer stationId1) {
		this.stationId1 = stationId1;
	}
	public String getRouteName1() {
		return routeName1;
	}
	public void setRouteName1(String routeName1) {
		this.routeName1 = routeName1;
	}
	public String getStationName1() {
		return stationName1;
	}
	public Integer getMinutesWalk1() {
		return minutesWalk1;
	}
	public void setMinutesWalk1(Integer minutesWalk1) {
		this.minutesWalk1 = minutesWalk1;
	}
	public void setStationName1(String stationName1) {
		this.stationName1 = stationName1;
	}
	public Integer getRouteId2() {
		return routeId2;
	}
	public void setRouteId2(Integer routeId2) {
		this.routeId2 = routeId2;
	}
	public Integer getStationId2() {
		return stationId2;
	}
	public void setStationId2(Integer stationId2) {
		this.stationId2 = stationId2;
	}
	public String getRouteName2() {
		return routeName2;
	}
	public void setRouteName2(String routeName2) {
		this.routeName2 = routeName2;
	}
	public String getStationName2() {
		return stationName2;
	}
	public void setStationName2(String stationName2) {
		this.stationName2 = stationName2;
	}
	public Integer getMinutesWalk2() {
		return minutesWalk2;
	}
	public void setMinutesWalk2(Integer minutesWalk2) {
		this.minutesWalk2 = minutesWalk2;
	}
	public Integer getRouteId3() {
		return routeId3;
	}
	public void setRouteId3(Integer routeId3) {
		this.routeId3 = routeId3;
	}
	public Integer getStationId3() {
		return stationId3;
	}
	public void setStationId3(Integer stationId3) {
		this.stationId3 = stationId3;
	}
	public String getRouteName3() {
		return routeName3;
	}
	public void setRouteName3(String routeName3) {
		this.routeName3 = routeName3;
	}
	public String getStationName3() {
		return stationName3;
	}
	public void setStationName3(String stationName3) {
		this.stationName3 = stationName3;
	}
	public Integer getMinutesWalk3() {
		return minutesWalk3;
	}
	public void setMinutesWalk3(Integer minutesWalk3) {
		this.minutesWalk3 = minutesWalk3;
	}
	public String getRoomPrTitle() {
		return roomPrTitle;
	}
	public void setRoomPrTitle(String roomPrTitle) {
		this.roomPrTitle = roomPrTitle;
	}
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	public Integer getNumberOfStoreys() {
		return numberOfStoreys;
	}
	public void setNumberOfStoreys(Integer numberOfStoreys) {
		this.numberOfStoreys = numberOfStoreys;
	}
	public String getBuildingFileName() {
		return buildingFileName;
	}
	public void setBuildingFileName(String buildingFileName) {
		this.buildingFileName = buildingFileName;
	}
	public Integer getRoomImageClass() {
		return roomImageClass;
	}
	public void setRoomImageClass(Integer roomImageClass) {
		this.roomImageClass = roomImageClass;
	}
	public String getRoomsFileName() {
		return roomsFileName;
	}
	public void setRoomsFileName(String roomsFileName) {
		this.roomsFileName = roomsFileName;
	}
	public String getTownAreaBelow() {
		return townAreaBelow;
	}
	public void setTownAreaBelow(String townAreaBelow) {
		this.townAreaBelow = townAreaBelow;
	}
	public Integer getAdministrativeCostClass() {
		return administrativeCostClass;
	}
	public void setAdministrativeCostClass(Integer administrativeCostClass) {
		this.administrativeCostClass = administrativeCostClass;
	}
	public Integer getAdministrativeCost() {
		return administrativeCost;
	}
	public void setAdministrativeCost(Integer administrativeCost) {
		this.administrativeCost = administrativeCost;
	}
	public String getRoomPrDetail() {
		return roomPrDetail;
	}
	public void setRoomPrDetail(String roomPrDetail) {
		this.roomPrDetail = roomPrDetail;
	}
	public Integer getStructureId() {
		return structureId;
	}
	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
	}
	public Integer getBuiltYear() {
		return builtYear;
	}
	public void setBuiltYear(Integer builtYear) {
		this.builtYear = builtYear;
	}
	public Integer getBuiltMonth() {
		return builtMonth;
	}
	public void setBuiltMonth(Integer builtMonth) {
		this.builtMonth = builtMonth;
	}
	public Integer getRenewalFeeClass() {
		return renewalFeeClass;
	}
	public void setRenewalFeeClass(Integer renewalFeeClass) {
		this.renewalFeeClass = renewalFeeClass;
	}
	public String getRenewalFee() {
		return renewalFee;
	}
	public void setRenewalFee(String renewalFee) {
		this.renewalFee = renewalFee;
	}
	public String getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getImportantPoints() {
		return importantPoints;
	}
	public void setImportantPoints(String importantPoints) {
		this.importantPoints = importantPoints;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public String getBuildingImageCaption() {
		return buildingImageCaption;
	}
	public void setBuildingImageCaption(String buildingImageCaption) {
		this.buildingImageCaption = buildingImageCaption;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getPremiumClass() {
		return premiumClass;
	}
	public void setPremiumClass(Integer premiumClass) {
		this.premiumClass = premiumClass;
	}
	public Integer getPremium() {
		return premium;
	}
	public void setPremium(Integer premium) {
		this.premium = premium;
	}
	public Integer getForegiftClass() {
		return foregiftClass;
	}
	public void setForegiftClass(Integer foregiftClass) {
		this.foregiftClass = foregiftClass;
	}
	public Integer getForegift() {
		return foregift;
	}
	public void setForegift(Integer foregift) {
		this.foregift = foregift;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Integer getSecurityMoneyClass() {
		return securityMoneyClass;
	}
	public void setSecurityMoneyClass(Integer securityMoneyClass) {
		this.securityMoneyClass = securityMoneyClass;
	}
	public Integer getSecurityMoney() {
		return securityMoney;
	}
	public void setSecurityMoney(Integer securityMoney) {
		this.securityMoney = securityMoney;
	}
}
