package jp.co.forrentsystem.form.frontend;


public class FContactForm {

	/** 氏名_姓 */
	private String lastName;
	/** 氏名_名 */
	private String firstName;
	/** 会社名 */
	private String companyName;
	/** メールアドレス */
	private String mailAddress;
	/** 電話番号 */
	private String tel;
	/** お問い合わせ内容 */
	private String contactContent;

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
	public String getContactContent() {
		return contactContent;
	}
	public void setContactContent(String contactContent) {
		this.contactContent = contactContent;
	}
}
