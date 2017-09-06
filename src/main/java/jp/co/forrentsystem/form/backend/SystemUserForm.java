package jp.co.forrentsystem.form.backend;

import java.util.Date;

import jp.co.forrentsystem.util.UtilService;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * システムユーザー登録・編集画面用Formクラス
 * @author d.kitajima
 *
 */
public class SystemUserForm {

	public interface RegistCheck{}
	public interface UpdateCheck{}


	/** システムユーザーID */
	private Integer systemUserId;

	/** システムユーザー名 */
	@NotEmpty(groups = { RegistCheck.class, UpdateCheck.class})
	private String systemUserName;

	/** システムユーザーログインID */
	@NotEmpty(groups = { RegistCheck.class})
	private String systemUserLoginId;

	/** システムユーザーパスワード */
	@NotEmpty(groups = {RegistCheck.class})
	private String systemUserPassword;

	/** システムユーザーパスワード(確認用) */
	@NotEmpty(groups = { RegistCheck.class})
	private String systemUserPasswordConfirm;

	/** システムユーザー新しいパスワード */
	private String systemUserNewPassword;

	/** システムユーザー新しいパスワード(確認用) */
	private String systemUserNewPasswordConfirm;

	/** システムユーザーアドレス */
	@NotEmpty(groups = { RegistCheck.class,UpdateCheck.class})
	private String systemUserAddress;

	/** システムユーザー区分 */
	private Integer systemUserClass;

	/** 有効フラグ */
	private Integer availableFlag;

	/** 削除フラグ */
	private Integer deleteFlag;

	/** 登録日 */
	private Date created;

	/** 更新日 */
	private Date modified;

	public Integer getSystemUserId() {
		return systemUserId;
	}
	public void setSystemUserId(Integer systemUserId) {
		this.systemUserId = systemUserId;
	}
	public String getSystemUserName() {
		return systemUserName;
	}
	public void setSystemUserName(String systemUserName) {
		this.systemUserName = systemUserName;
	}
	public String getSystemUserLoginId() {
		return systemUserLoginId;
	}
	public void setSystemUserLoginId(String systemUserLoginId) {
		this.systemUserLoginId = systemUserLoginId;
	}
	public String getSystemUserPassword() {
		return systemUserPassword;
	}
	public void setSystemUserPassword(String systemUserPassword) {
		this.systemUserPassword = systemUserPassword;
	}
	public String getSystemUserPasswordConfirm() {
		return systemUserPasswordConfirm;
	}
	public void setSystemUserPasswordConfirm(String systemUserPasswordConfirm) {
		this.systemUserPasswordConfirm = systemUserPasswordConfirm;
	}
	public String getSystemUserNewPassword() {
		return systemUserNewPassword;
	}
	public void setSystemUserNewPassword(String systemUserNewPassword) {
		this.systemUserNewPassword = systemUserNewPassword;
	}
	public String getSystemUserNewPasswordConfirm() {
		return systemUserNewPasswordConfirm;
	}
	public void setSystemUserNewPasswordConfirm(String systemUserNewPasswordConfirm) {
		this.systemUserNewPasswordConfirm = systemUserNewPasswordConfirm;
	}
	public Integer getSystemUserClass() {
		return systemUserClass;
	}
	public void setSystemUserClass(Integer systemUserClass) {
		this.systemUserClass = systemUserClass;
	}
	public String getSystemUserClassName() {
		return UtilService.getNameForFlag(systemUserClass);
	}
	public String getSystemUserAddress() {
		return systemUserAddress;
	}
	public void setSystemUserAddress(String systemUserAddress) {
		this.systemUserAddress = systemUserAddress;
	}
	public Integer getAvailableFlag() {
		return availableFlag;
	}
	public void setAvailableFlag(Integer availableFlag) {
		this.availableFlag = availableFlag;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
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
}
