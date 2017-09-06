package jp.co.forrentsystem.dto;

/**
 * 建物画像DTO
 * @author k.akahira
 *
 */
public class BuildingImageDto {
	/** 建物ID */
	private Integer buildingId;
	/** 画像ID */
	private Integer imageId;
	/** 建物画像区分 */
	private Integer buildingImageClass;
	/** 画像ファイル名 */
	private String fileName;
	/** 画像見出し */
	private String imageCaption;
	/** 公開フラグ */
	private Integer publicationFlag;
	/** 登録日 */
	private String created;
	/** 更新日 */
	private String modified;
	/** 削除フラグ */
	private Integer deleteFlag;
	/** 建物画像ファイルパス */
	private String filePath;
	/** ファイルサイズチェックフラグ */
	private boolean fileSizeCheckFlag;
	/** 空ファイルチェックフラグ */
	private boolean emptyFileCheckFlag;
	/** 同名ファイルアップロードチェックフラグ */
	private boolean sameFileNameCheckFlag;

	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public Integer getBuildingImageClass() {
		return buildingImageClass;
	}
	public void setBuildingImageClass(Integer buildingImageClass) {
		this.buildingImageClass = buildingImageClass;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getImageCaption() {
		return imageCaption;
	}
	public void setImageCaption(String imageCaption) {
		this.imageCaption = imageCaption;
	}
	public Integer getPublicationFlag() {
		return publicationFlag;
	}
	public void setPublicationFlag(Integer publicationFlag) {
		this.publicationFlag = publicationFlag;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	public boolean isSameFileNameCheckFlag() {
		return sameFileNameCheckFlag;
	}
	public void setSameFileNameCheckFlag(boolean sameFileNameCheckFlag) {
		this.sameFileNameCheckFlag = sameFileNameCheckFlag;
	}
}
