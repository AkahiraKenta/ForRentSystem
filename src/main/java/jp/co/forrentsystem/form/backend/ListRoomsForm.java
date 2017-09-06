package jp.co.forrentsystem.form.backend;

import java.util.Date;

/**
 * 部屋一覧用Formクラス
 * @author k.akahira
 *
 */
public class ListRoomsForm {
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
	/** 部屋番号 */
	private String roomNumber;
	/** 階層区分ID */
	private Integer numberOfStoreysId;
	/** 階層名称 */
	private String numberOfStoreysName;
	/** 募集ステータス */
	private Integer recruitmentStatus;
	/** 募集ステータス名称 */
	private String recruitmentStatusName;
	/** 間取りID */
	private Integer floorPlanId;
	/** 間取りID */
	private String floorPlanName;
	/** 面積平米 */
	private Double space;
	/** 敷金区分 */
	private Integer securityDepositClass;
	/** 敷金区分名称 */
	private String securityDepositClassName;
	/** 敷金 */
	private Integer securityDeposit;
	/** 礼金区分 */
	private Integer keyMoneyClass;
	/** 礼金区分名称 */
	private String keyMoneyClassName;
	/** 礼金 */
	private Integer keyMoney;
	/** 賃料 */
	private Integer rent;
	/** 共益費区分 */
	private Integer commonServiceFeeClass;
	/** 共益費区分名称 */
	private String commonServiceFeeClassName;
	/** 共益費 */
	private Integer commonServiceFee;
	/** 管理費区分 */
	private Integer administrativeCostClass;
	/** 管理費区分名称 */
	private String administrativeCostClassName;
	/** 管理費 */
	private Integer administrativeCost;
	/** 更新料区分 */
	private Integer renewalFeeClass;
	/** 更新料区分名称 */
	private String renewalFeeClassName;
	/** 更新料 */
	private Integer renewalFee;
	/** 保証金 */
	private Integer securityMoney;
	/** 償却 */
	private String amortization;
	/** 保障会社必須フラグ */
	private Integer guarantyCompanyFlag;
	/** 保障会社必須フラグ名称 */
	private String guarantyCompanyFlagName;
	/** 公開フラグ */
	private Integer publicationFlag;
	/** 公開フラグ名称 */
	private String publicationFlagName;
	/** 契約形態 */
	private Integer contractForm;
	/**  契約形態名称 */
	private String contractFormName;
	/** 引渡方法 */
	private Integer deliveryMethod;
	/**  引渡方法名称 */
	private String deliveryMethodName;
	/** 引渡時期 */
	private String deliveryTime;
	/**  契約期間 */
	private String contractPeriod;
	/** 注意事項 */
	private String importantPoints;
	/** 登録日 */
	private Date created;
	/** 更新日 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;
	/** 設備情報 */
	private String[] equipmentArray;
	/** こだわり条件 */
	private String[] goodForConditionArray;

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
	public String getNumberOfStoreysName() {
		return numberOfStoreysName;
	}
	public void setNumberOfStoreysName(String numberOfStoreysName) {
		this.numberOfStoreysName = numberOfStoreysName;
	}
	public Integer getRecruitmentStatus() {
		return recruitmentStatus;
	}
	public void setRecruitmentStatus(Integer recruitmentStatus) {
		this.recruitmentStatus = recruitmentStatus;
	}
	public String getRecruitmentStatusName() {
		return recruitmentStatusName;
	}
	public void setRecruitmentStatusName(String recruitmentStatusName) {
		this.recruitmentStatusName = recruitmentStatusName;
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
	public Double getSpace() {
		return space;
	}
	public void setSpace(Double space) {
		this.space = space;
	}
	public Integer getSecurityDepositClass() {
		return securityDepositClass;
	}
	public void setSecurityDepositClass(Integer securityDepositClass) {
		this.securityDepositClass = securityDepositClass;
	}
	public String getSecurityDepositClassName() {
		return securityDepositClassName;
	}
	public void setSecurityDepositClassName(String securityDepositClassName) {
		this.securityDepositClassName = securityDepositClassName;
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
	public String getKeyMoneyClassName() {
		return keyMoneyClassName;
	}
	public void setKeyMoneyClassName(String keyMoneyClassName) {
		this.keyMoneyClassName = keyMoneyClassName;
	}
	public Integer getKeyMoney() {
		return keyMoney;
	}
	public void setKeyMoney(Integer keyMoney) {
		this.keyMoney = keyMoney;
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
	public String getCommonServiceFeeClassName() {
		return commonServiceFeeClassName;
	}
	public void setCommonServiceFeeClassName(String commonServiceFeeClassName) {
		this.commonServiceFeeClassName = commonServiceFeeClassName;
	}
	public Integer getCommonServiceFee() {
		return commonServiceFee;
	}
	public void setCommonServiceFee(Integer commonServiceFee) {
		this.commonServiceFee = commonServiceFee;
	}
	public Integer getAdministrativeCostClass() {
		return administrativeCostClass;
	}
	public void setAdministrativeCostClass(Integer administrativeCostClass) {
		this.administrativeCostClass = administrativeCostClass;
	}
	public String getAdministrativeCostClassName() {
		return administrativeCostClassName;
	}
	public void setAdministrativeCostClassName(String administrativeCostClassName) {
		this.administrativeCostClassName = administrativeCostClassName;
	}
	public Integer getAdministrativeCost() {
		return administrativeCost;
	}
	public void setAdministrativeCost(Integer administrativeCost) {
		this.administrativeCost = administrativeCost;
	}
	public Integer getRenewalFeeClass() {
		return renewalFeeClass;
	}
	public void setRenewalFeeClass(Integer renewalFeeClass) {
		this.renewalFeeClass = renewalFeeClass;
	}
	public String getRenewalFeeClassName() {
		return renewalFeeClassName;
	}
	public void setRenewalFeeClassName(String renewalFeeClassName) {
		this.renewalFeeClassName = renewalFeeClassName;
	}
	public Integer getRenewalFee() {
		return renewalFee;
	}
	public void setRenewalFee(Integer renewalFee) {
		this.renewalFee = renewalFee;
	}
	public Integer getSecurityMoney() {
		return securityMoney;
	}
	public void setSecurityMoney(Integer securityMoney) {
		this.securityMoney = securityMoney;
	}
	public String getAmortization() {
		return amortization;
	}
	public void setAmortization(String amortization) {
		this.amortization = amortization;
	}
	public Integer getGuarantyCompanyFlag() {
		return guarantyCompanyFlag;
	}
	public void setGuarantyCompanyFlag(Integer guarantyCompanyFlag) {
		this.guarantyCompanyFlag = guarantyCompanyFlag;
	}
	public String getGuarantyCompanyFlagName() {
		return guarantyCompanyFlagName;
	}
	public void setGuarantyCompanyFlagName(String guarantyCompanyFlagName) {
		this.guarantyCompanyFlagName = guarantyCompanyFlagName;
	}
	public Integer getPublicationFlag() {
		return publicationFlag;
	}
	public void setPublicationFlag(Integer publicationFlag) {
		this.publicationFlag = publicationFlag;
	}
	public String getPublicationFlagName() {
		return publicationFlagName;
	}
	public void setPublicationFlagName(String publicationFlagName) {
		this.publicationFlagName = publicationFlagName;
	}
	public Integer getContractForm() {
		return contractForm;
	}
	public void setContractForm(Integer contractForm) {
		this.contractForm = contractForm;
	}
	public String getContractFormName() {
		return contractFormName;
	}
	public void setContractFormName(String contractFormName) {
		this.contractFormName = contractFormName;
	}
	public Integer getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(Integer deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public String getDeliveryMethodName() {
		return deliveryMethodName;
	}
	public void setDeliveryMethodName(String deliveryMethodName) {
		this.deliveryMethodName = deliveryMethodName;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public String getImportantPoints() {
		return importantPoints;
	}
	public void setImportantPoints(String importantPoints) {
		this.importantPoints = importantPoints;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String[] getEquipmentArray() {
		return equipmentArray;
	}
	public void setEquipmentArray(String[] equipmentArray) {
		this.equipmentArray = equipmentArray;
	}
	public String[] getGoodForConditionArray() {
		return goodForConditionArray;
	}
	public void setGoodForConditionArray(String[] goodForConditionArray) {
		this.goodForConditionArray = goodForConditionArray;
	}
//	public List<RoomsDto> getRoomsDtoList() {
//		return roomsDtoList;
//	}
//	public void setRoomsDtoList(List<RoomsDto> roomsDtoList) {
//		this.roomsDtoList = roomsDtoList;
//	}
}
