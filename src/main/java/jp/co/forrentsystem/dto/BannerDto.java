package jp.co.forrentsystem.dto;

import java.util.Date;

/**
 * バナーDTO
 * @author k.akahira
 *
 */
public class BannerDto {
	/** バナーID */
	private Integer bannerId;
	/** 表示順 */
	private Integer displayNumber;
	/** ファイル名 */
	private String fileName;
	/** ファイルパス */
	private String filePath;
	/** 遷移先URL */
	private String transitionUrl;
	/** 移先方法フラグ */
	private Integer transitionFlag;
	/** 公開フラグ */
	private Integer publicationFlag;
	/** 登録日 */
	private Date created;
	/** 更新日 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;

	public Integer getBannerId() {
		return bannerId;
	}
	public void setBannerId(Integer bannerId) {
		this.bannerId = bannerId;
	}
	public Integer getDisplayNumber() {
		return displayNumber;
	}
	public void setDisplayNumber(Integer displayNumber) {
		this.displayNumber = displayNumber;
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
	public Integer getPublicationFlag() {
		return publicationFlag;
	}
	public void setPublicationFlag(Integer publicationFlag) {
		this.publicationFlag = publicationFlag;
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
