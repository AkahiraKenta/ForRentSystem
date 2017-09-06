package jp.co.forrentsystem.dto;

import java.util.Date;

/**
 * システム設定DTO
 * @author k.akahira
 *
 */
public class SystemSettingDto {

	/** システム設定ID */
	private Integer systemSettingId;;
	/** システム設定名称 */
	private String systemSettingName;
	/** 表示件数 */
	private Integer displayNumber;
	/** 登録日 */
	private Date created;
	/** 更新日 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;

	public Integer getSystemSettingId() {
		return systemSettingId;
	}
	public void setSystemSettingId(Integer systemSettingId) {
		this.systemSettingId = systemSettingId;
	}
	public String getSystemSettingName() {
		return systemSettingName;
	}
	public void setSystemSettingName(String systemSettingName) {
		this.systemSettingName = systemSettingName;
	}
	public Integer getDisplayNumber() {
		return displayNumber;
	}
	public void setDisplayNumber(Integer displayNumber) {
		this.displayNumber = displayNumber;
	}
	/**
	 * 登録日取得
	 * @return 登録日
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * 登録日設定
	 * @param created 登録日
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * 更新日取得
	 * @return 更新日
	 */
	public Date getModified() {
		return modified;
	}
	/**
	 * 更新日設定
	 * @param modified 更新日
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}
	/**
	 * 削除フラグ取得
	 * @return 削除フラグ
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	/**
	 * 削除フラグ設定
	 * @param delFlg 削除フラグ
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
