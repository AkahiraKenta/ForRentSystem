package jp.co.forrentsystem.dto;

import java.util.Date;

/**
 * 部屋詳細DTO
 * @author k.akahira
 *
 */
public class RoomsDetailDto {
	/** 建物ID */
	private Integer buildingId;
	/** 部屋ID */
	private Integer roomId;
	/** 部屋コード */
	private String roomCode;
	/** 部屋番号 */
	private String roomNumber;
	/** 階層区分ID */
	private Integer numberOfStoreysId;
	/** 階層区分名称 */
	private String numberOfStoreysName;
	/** 募集ステータス */
	private Integer recruitmentStatus;
	/** 間取りID */
	private Integer floorPlanId;
	/** 間取り名称 */
	private String floorPlanName;
	/** 面積平米 */
	private Double space;
	/** 敷金区分 */
	private Integer securityDepositClass;
	/** 敷金 */
	private Integer securityDeposit;
	/** 礼金区分 */
	private Integer keyMoneyClass;
	/** 礼金 */
	private Integer keyMoney;
	/** 賃料 */
	private Integer rent;
	/** 共益費区分 */
	private Integer commonServiceFeeClass;
	/** 共益費 */
	private Integer commonServiceFee;
	/** 管理費区分 */
	private Integer administrativeCostClass;
	/** 管理費 */
	private Integer administrativeCost;
	/** 保険料区分 */
	private Integer premiumClass;
	/** 保険料区分名称 */
	private String premiumClassName;
	/** 保険料 */
	private Integer premium;
	/** 更新料区分 */
	private Integer renewalFeeClass;
	/** 更新料 */
	private Integer renewalFee;
	/** 保証金区分 */
	private Integer securityMoneyClass;
	/** 保証金 */
	private Integer securityMoney;
	/** 償却 */
	private String amortization;
	/** 保障会社必須フラグ */
	private Integer guarantyCompanyFlag;
	/** 公開フラグ */
	private Integer publicationFlag;
	/** 契約形態 */
	private Integer contractForm;
	/** 引渡方法 */
	private Integer deliveryMethod;
	/** 引渡時期 */
	private String deliveryTime;
	/** 契約期間 */
	private String contractPeriod;
	/** 注意事項 */
	private String importantPoints;
	/** 部屋PRタイトル */
	private String roomPrTitle;
	/** 部屋PR詳細 */
	private String roomPrDetail;
	/** 登録日 */
	private Date created;
	/** 更新日 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;

	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
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
	public Integer getPremiumClass() {
		return premiumClass;
	}
	public void setPremiumClass(Integer premiumClass) {
		this.premiumClass = premiumClass;
	}
	public String getPremiumClassName() {
		return premiumClassName;
	}
	public void setPremiumClassName(String premiumClassName) {
		this.premiumClassName = premiumClassName;
	}
	public Integer getPremium() {
		return premium;
	}
	public void setPremium(Integer premium) {
		this.premium = premium;
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
	public Integer getPublicationFlag() {
		return publicationFlag;
	}
	public void setPublicationFlag(Integer publicationFlag) {
		this.publicationFlag = publicationFlag;
	}
	public Integer getContractForm() {
		return contractForm;
	}
	public void setContractForm(Integer contractForm) {
		this.contractForm = contractForm;
	}
	public Integer getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(Integer deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
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
	public String getRoomPrTitle() {
		return roomPrTitle;
	}
	public void setRoomPrTitle(String roomPrTitle) {
		this.roomPrTitle = roomPrTitle;
	}
	public String getRoomPrDetail() {
		return roomPrDetail;
	}
	public void setRoomPrDetail(String roomPrDetail) {
		this.roomPrDetail = roomPrDetail;
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
	public Integer getSecurityMoneyClass() {
		return securityMoneyClass;
	}
	public void setSecurityMoneyClass(Integer securityMoneyClass) {
		this.securityMoneyClass = securityMoneyClass;
	}
}
