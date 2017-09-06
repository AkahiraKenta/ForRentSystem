package jp.co.forrentsystem.dto;

/**
 * ヘッダーフッターDTO
 * @author k.akahira
 *
 */
public class HdFtDto {
	/** ID */
	private Integer id;
	/** ヘッダーファイル名 */
	private String headerFileName;
	/** ヘッダーロゴ画像パス */
	private String headerFilePath;
	/** フッターファイル名 */
	private String footerFileName;
	/** フッターロゴ画像パス */
	private String footerFilePath;
	/** 会社名 */
	private String companyName;
	/** 電話番号 */
	private String tel;
	/** FAX */
	private String fax;
	/** メールアドレス */
	private String mailAddress;
	/** 遷移先URL */
	private String transitionUrl;
	/** 遷移先方法フラグ */
	private Integer transitionFlag;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHeaderFileName() {
		return headerFileName;
	}
	public void setHeaderFileName(String headerFileName) {
		this.headerFileName = headerFileName;
	}
	public String getHeaderFilePath() {
		return headerFilePath;
	}
	public void setHeaderFilePath(String headerFilePath) {
		this.headerFilePath = headerFilePath;
	}
	public String getFooterFileName() {
		return footerFileName;
	}
	public void setFooterFileName(String footerFileName) {
		this.footerFileName = footerFileName;
	}
	public String getFooterFilePath() {
		return footerFilePath;
	}
	public void setFooterFilePath(String footerFilePath) {
		this.footerFilePath = footerFilePath;
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
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getTransitionUrl() {
		return transitionUrl;
	}
	public void setTransitionUrl(String transitionUrl) {
		this.transitionUrl = transitionUrl;
	}
	public Integer getTransitionFlag() {
		return transitionFlag;
	}
	public void setTransitionFlag(Integer transitionFlag) {
		this.transitionFlag = transitionFlag;
	}

}
