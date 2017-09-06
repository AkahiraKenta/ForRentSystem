package jp.co.forrentsystem.form.frontend;

public class FContactArticleForm {

	/** 建物ID */
	private Integer buildingId;
	/** 部屋ID */
	private Integer roomId;
	/** 建物コード */
	private String buildingCode;
	/** 建物名称 */
	private String buildingName;
	/** 部屋コード */
	private String roomCode;
	/** 部屋名称 */
	private String roomNumber;
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
	/** 間取りID */
	private Integer floorPlanId;
	/** 間取り名称 */
	private String floorPlanName;
	/** 賃料 */
	private Integer rent;
	/** 管理費区分 */
	private Integer administrativeCostClass;
	/** 管理費 */
	private Integer administrativeCost;
	/** 共益費区分 */
	private Integer commonServiceFeeClass;
	/** 共益費 */
	private Integer commonServiceFee;
	/** お問合わせ種類ID  */
	private Integer processClass;
	/** お問合わせ種類名称  */
	private String process;
	/** 氏名_姓 */
	private String lastName;
	/** 氏名_名 */
	private String firstName;
	/** メールアドレス */
	private String mailAddress;
	/** 電話番号 */
	private String tel;
	/** 入居希望時期ID */
	private Integer residentsHopeTime;
	/** 入居希望時期名称 */
	private String residentsHopeTimeName;
	/** 連絡欄 */
	private String contactContent;

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
	public Integer getRent() {
		return rent;
	}
	public void setRent(Integer rent) {
		this.rent = rent;
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
	public Integer getProcessClass() {
		return processClass;
	}
	public void setProcessClass(Integer processClass) {
		this.processClass = processClass;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getResidentsHopeTime() {
		return residentsHopeTime;
	}
	public void setResidentsHopeTime(Integer residentsHopeTime) {
		this.residentsHopeTime = residentsHopeTime;
	}
	public String getResidentsHopeTimeName() {
		return residentsHopeTimeName;
	}
	public void setResidentsHopeTimeName(String residentsHopeTimeName) {
		this.residentsHopeTimeName = residentsHopeTimeName;
	}
	public String getContactContent() {
		return contactContent;
	}
	public void setContactContent(String contactContent) {
		this.contactContent = contactContent;
	}
}
