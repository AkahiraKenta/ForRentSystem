package jp.co.forrentsystem.dto;

public class NewArticleDto {

	/** 建物ID */
	private Integer buildingId;
	/** 建物名称 */
	private String buildingName;
	/** 画像ID */
	private Integer imageId;
	/** 画像ファイル名 */
	private String fileName;
	/** 部屋ID */
	private Integer roomId;
	/** 部屋名称 */
	private String roomNumber;
	/** 部屋PRタイトル */
	private String roomPrTitle;
	/** 賃料 */
	private String rent;

	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomPrTitle() {
		return roomPrTitle;
	}
	public void setRoomPrTitle(String roomPrTitle) {
		this.roomPrTitle = roomPrTitle;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}



}
