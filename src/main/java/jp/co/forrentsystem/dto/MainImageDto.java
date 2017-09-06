package jp.co.forrentsystem.dto;

/**
 * メイン画像DTO
 * @author k.akahira
 *
 */
public class MainImageDto {
	/** ID */
	private Integer mainImageId;
	/** ファイル名 */
	private String fileName;
	/** ファイルパス */
	private String filePath;
	/** 表示フラグ */
	private String displayFlag;
	/** 遷移先URL */
	private String transitionUrl;
	/** 遷移先方法フラグ */
	private Integer transitionFlag;

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
	public Integer getTransitionFlag() {
		return transitionFlag;
	}
	public void setTransitionFlag(Integer transitionFlag) {
		this.transitionFlag = transitionFlag;
	}
}
