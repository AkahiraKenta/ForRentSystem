package jp.co.forrentsystem.dto;

import jp.co.forrentsystem.util.PagerDto;


public class ContactDto extends PagerDto{

	/** お問合わせID  */
	private Integer contactId;
	/** 処理ステータス  */
	private Integer processStatus;
	/** 氏名_姓 */
	private String lastName;
	/** 氏名_名 */
	private String firstName;
	/** 会社名 */
	private String companyName;
	/** 電話番号 */
	private String tel;
	/** メールアドレス */
	private String mailAddress;
	/** お問い合わせ内容 */
	private String contactContent;
	/** 登録日時 */
	private String created;

	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public Integer getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(Integer processStatus) {
		this.processStatus = processStatus;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getContactContent() {
		return contactContent;
	}
	public void setContactContent(String contactContent) {
		this.contactContent = contactContent;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
}
