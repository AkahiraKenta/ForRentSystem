package jp.co.forrentsystem.form.backend;

import java.util.Date;

/**
 * メイン画像Form
 * @author k.akahira
 *
 */
public class MainImageForm {

	/** メイン画像ID */
	private Integer mainImageId;
	/** ファイル名称 */
	private String fileName;
	/** ファイルパス */
	private String filePath;
	/** 表示フラグ */
	private String displayFlag;
	/** 遷移先URL */
	private String transitionUrl;
	/** 遷移先方法フラグ */
	private String transitionFlag;
	/** 登録日 */
	private Date created;
	/** 更新日 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;

	public Integer getMainImageId() {
		return mainImageId;
	}
	public void setMainImageId(Integer mainImageId) {
		this.mainImageId = mainImageId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getDisplayFlag() {
		return displayFlag;
	}
	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}
	public String getTransitionUrl() {
		return transitionUrl;
	}
	public void setTransitionUrl(String transitionUrl) {
		this.transitionUrl = transitionUrl;
	}
	public String getTransitionFlag() {
		return transitionFlag;
	}
	public void setTransitionFlag(String transitionFlag) {
		this.transitionFlag = transitionFlag;
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
}
