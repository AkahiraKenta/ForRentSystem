package jp.co.forrentsystem.dto;

import jp.co.forrentsystem.util.PagerDto;

public class BuildingContactDto extends PagerDto{

	/** お問合せID  */
	private Integer buildingContactId;
	/** 建物ID */
	private Integer buildingId;
	/** 部屋ID */
	private Integer roomId;
	/** 処理ステータス */
	private Integer processStatus;
	/** お問合せ種類ID  */
	private Integer processClass;
	/** お問合せ種類名称  */
	private String process;
	/** 氏名_姓 */
	private String lastName;
	/** 氏名_名 */
	private String firstName;
	/** メールアドレス */
	private String mailAddress;
	/** 電話番号 */
	private String tel;
	/** 連絡手段ID */
	private Integer contactMeansTime;
	/** 入居希望時期ID */
	private Integer residentsHopeTime;
	/** 入居希望時期名称 */
	private String residentsHopeTimeName;
	/** 連絡欄 */
	private String contactContent;
	/** 建物名称 */
	private String buildingName;
	/** 部屋番号 */
	private String roomNumber;
	/** 登録日時 */
	private String created;

	public Integer getBuildingContactId() {
		return buildingContactId;
	}
	public void setBuildingContactId(Integer buildingContactId) {
		this.buildingContactId = buildingContactId;
	}
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
	public Integer getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(Integer processStatus) {
		this.processStatus = processStatus;
	}
	public Integer getContactMeansTime() {
		return contactMeansTime;
	}
	public void setContactMeansTime(Integer contactMeansTime) {
		this.contactMeansTime = contactMeansTime;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
}
