package jp.co.forrentsystem.form.backend;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * バナーForm
 * @author k.akahira
 *
 */
public class BannerForm {
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
	/** 遷移先方法フラグ */
	private Integer transitionFlag;
	/** 遷移先方法名称 */
	private String transitionName;
	/** 公開フラグ */
	private Integer publicationFlag;
	/** 公開名称 */
	private String publicationName;
	/** アップロードファイル */
	private  MultipartFile file;
	/** 登録日 */
	private Date created;
	/** 更新日 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;
	/** ファイルサイズチェックフラグ */
	private boolean fileSizeCheckFlag;
	/** 空ファイルチェックフラグ */
	private boolean emptyFileCheckFlag;

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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getTransitionName() {
		return transitionName;
	}
	public void setTransitionName(String transitionName) {
		this.transitionName = transitionName;
	}
	public String getPublicationName() {
		return publicationName;
	}
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}
	public boolean isFileSizeCheckFlag() {
		return fileSizeCheckFlag;
	}
	public void setFileSizeCheckFlag(boolean fileSizeCheckFlag) {
		this.fileSizeCheckFlag = fileSizeCheckFlag;
	}
	public boolean isEmptyFileCheckFlag() {
		return emptyFileCheckFlag;
	}
	public void setEmptyFileCheckFlag(boolean emptyFileCheckFlag) {
		this.emptyFileCheckFlag = emptyFileCheckFlag;
	}
}
