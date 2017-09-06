package jp.co.forrentsystem.dto;


/**
 * おすすめ物件画像DTO
 * @author webridge
 *
 */
public class RecommendedRoomImageDto {
	/** おすすめ物件ID */
	private Integer id;
	/** 建物ID */
	private Integer buildingId;
	/** 部屋ID */
	private Integer roomId;
	/** 順位 */
	private Integer rank;
	/** ファイル名称 */
	private String fileName;
	/** 建物名称 */
	private String buildingName;
	/** 部屋番号 */
	private String roomNumber;
	/** 部屋PRタイトル */
	private String roomPrTitle;
	/** 賃料 */
	private Integer rent;

	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRent() {
		return rent;
	}
	public void setRent(Integer rent) {
		this.rent = rent;
	}
}
