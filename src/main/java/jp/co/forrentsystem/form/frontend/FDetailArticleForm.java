package jp.co.forrentsystem.form.frontend;

import java.util.List;

public class FDetailArticleForm {

	/** 建物ID */
	private Integer buildingId;

	/** 建物コード */
	private String buildingCode;

	/** 建物名称 */
	private String buildingName;

	/** 部屋ID */
	private Integer roomId;

	/** 部屋コード */
	private String roomCode;

	/** 部屋名称 */
	private String roomName;

	/** 部屋PRタイトル */
	private String roomPrTitle;

	/** 間取りID */
	private Integer floorPlanId;

	/** 間取り名称 */
	private Integer floorPlanName;

	/** 賃料 */
	private Integer rent;

	/** 最寄駅１（沿線） */
	private String routeName1;

	/** 最寄駅１（駅） */
	private String stationName1;

	/** 最寄駅２（沿線） */
	private String routeName2;

	/** 最寄駅２（駅） */
	private String stationName2;

	/** 最寄駅３（沿線） */
	private String routeName3;

	/** 最寄駅３（駅） */
	private String stationName3;

	/** 部屋PR詳細 */
	private String roomPrDetail;

	/** 建物画像ファイル名 */
	private String buildingFileName;

	/** 部屋画像ファイル名 */
	private String roomFileName;

	/** 部屋画像区分 */
	private Integer roomImageClass;

	/** 部屋画像区分名称 */
	private String roomImageClassName;

	/** 建物種別 */
	private String buildingType;

	/** 建物種別名称 */
	private String buildingTypeName;

	/** 建物構造 */
	private String structureId;

	/** 建物構造名称 */
	private String structureName;

	/** 階建 */
	private Integer numberOfStructure;

	/** 築年月 */
	private String builtYears;

	/** 階数区分ID */
	private Integer floorId;

	/** 階数区分名称 */
	private String floorName;

	/** 面積 */
	private Double space;

	/** 管理費区分 */
	private Integer administrativeCostClass;

	/** 管理費 */
	private Integer administarativeCost;

	// TODO:保険料が部屋テーブルのカラムとして存在しない。
	/** 保険料 */

	/** 更新料区分 */
	private Integer renewalFeeClass;

	/** 更新料 */
	private Integer renewalFee;

	/** 敷金区分 */
	private Integer securityDepositClass;

	/** 敷金 */
	private Integer securityDeposit;

	/** 礼金区分 */
	private Integer keyMoneyClass;

	/** 礼金 */
	private Integer keyMoney;

	// TODO:入居可能日が部屋テーブルのカラムとして存在しない。
	/** 入居可能日 */

	/** 契約期間 */
	private String contractPeriod;

	/** 設備名称リスト */
	private List<String> equipmentList;

	/** 注意事項 */
	private String importantPoints;

	/** 郵便番号 */
	private String zipCode;

	/** 都道府県 */
	private String province;

	/** 市区町村 */
	private String city;

	/** 町域 */
	private String townArea;

	/** 町域以下 */
	private String townAreaBelow;

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

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomPrTitle() {
		return roomPrTitle;
	}

	public void setRoomPrTitle(String roomPrTitle) {
		this.roomPrTitle = roomPrTitle;
	}

	public Integer getFloorPlanId() {
		return floorPlanId;
	}

	public void setFloorPlanId(Integer floorPlanId) {
		this.floorPlanId = floorPlanId;
	}

	public Integer getFloorPlanName() {
		return floorPlanName;
	}

	public void setFloorPlanName(Integer floorPlanName) {
		this.floorPlanName = floorPlanName;
	}

	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
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

	public void setStationName1(String stationName1) {
		this.stationName1 = stationName1;
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

	public String getRoomPrDetail() {
		return roomPrDetail;
	}

	public void setRoomPrDetail(String roomPrDetail) {
		this.roomPrDetail = roomPrDetail;
	}

	public String getBuildingFileName() {
		return buildingFileName;
	}

	public void setBuildingFileName(String buildingFileName) {
		this.buildingFileName = buildingFileName;
	}

	public String getRoomFileName() {
		return roomFileName;
	}

	public void setRoomFileName(String roomFileName) {
		this.roomFileName = roomFileName;
	}

	public Integer getRoomImageClass() {
		return roomImageClass;
	}

	public void setRoomImageClass(Integer roomImageClass) {
		this.roomImageClass = roomImageClass;
	}

	public String getRoomImageClassName() {
		return roomImageClassName;
	}

	public void setRoomImageClassName(String roomImageClassName) {
		this.roomImageClassName = roomImageClassName;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getBuildingTypeName() {
		return buildingTypeName;
	}

	public void setBuildingTypeName(String buildingTypeName) {
		this.buildingTypeName = buildingTypeName;
	}

	public String getStructureId() {
		return structureId;
	}

	public void setStructureId(String structureId) {
		this.structureId = structureId;
	}

	public String getStructureName() {
		return structureName;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}

	public Integer getNumberOfStructure() {
		return numberOfStructure;
	}

	public void setNumberOfStructure(Integer numberOfStructure) {
		this.numberOfStructure = numberOfStructure;
	}

	public String getBuiltYears() {
		return builtYears;
	}

	public void setBuiltYears(String builtYears) {
		this.builtYears = builtYears;
	}

	public Integer getFloorId() {
		return floorId;
	}

	public void setFloorId(Integer floorId) {
		this.floorId = floorId;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public Double getSpace() {
		return space;
	}

	public void setSpace(Double space) {
		this.space = space;
	}

	public Integer getAdministrativeCostClass() {
		return administrativeCostClass;
	}

	public void setAdministrativeCostClass(Integer administrativeCostClass) {
		this.administrativeCostClass = administrativeCostClass;
	}

	public Integer getAdministarativeCost() {
		return administarativeCost;
	}

	public void setAdministarativeCost(Integer administarativeCost) {
		this.administarativeCost = administarativeCost;
	}

	public Integer getRenewalFeeClass() {
		return renewalFeeClass;
	}

	public void setRenewalFeeClass(Integer renewalFeeClass) {
		this.renewalFeeClass = renewalFeeClass;
	}

	public Integer getRenewalFee() {
		return renewalFee;
	}

	public void setRenewalFee(Integer renewalFee) {
		this.renewalFee = renewalFee;
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

	public String getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	public List<String> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<String> equipmentList) {
		this.equipmentList = equipmentList;
	}

	public String getImportantPoints() {
		return importantPoints;
	}

	public void setImportantPoints(String importantPoints) {
		this.importantPoints = importantPoints;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

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

	public String getTownAreaBelow() {
		return townAreaBelow;
	}

	public void setTownAreaBelow(String townAreaBelow) {
		this.townAreaBelow = townAreaBelow;
	}

}
