package jp.co.forrentsystem.dto;

import java.util.Date;

import jp.co.forrentsystem.constants.SystemUserClass;
import jp.co.forrentsystem.util.UtilService;

/**
 * システムユーザDTO
 * @author k.akahira
 *
 */
public class SystemUserDto {

	/** システムユーザID */
	private Integer systemUserId;
	/** ユーザ名称 */
	private String systemUserName;
	/** ログインID */
	private String systemUserLoginId;
	/** ユーザパスワード */
	private String systemUserPassword;
	/** システムユーザー区分 */
	private Integer systemUserClass;
	/** メールアドレス */
	private String systemUserAddress;
	/** 有効フラグ */
	private Integer availableFlag;
	/** 登録日 */
	private Date created;
	/** 更新日 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;


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
	public Integer getSystemUserClass() {
		return systemUserClass;
	}
	public void setSystemUserClass(Integer systemUserClass) {
		this.systemUserClass = systemUserClass;
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

	// =================================================================
	// 独自関数
	// =================================================================
	public String getSystemUserClassName() {
		return SystemUserClass.getTargetName(systemUserClass);
	}
	public String getAvailableFlagName() {
		return UtilService.getNameForFlag(availableFlag);
	}

}
