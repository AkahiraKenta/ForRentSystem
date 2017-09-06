package jp.co.forrentsystem.form.backend;

import jp.co.forrentsystem.util.PagerForm;

/**
 * 建物検索用Formクラス
 * @author k.akahira
 */
public class SearchRecommendedRoomForm extends PagerForm{
	/** 建物ID */
	private Integer buildingId;
	/** 建物コード */
	private String buildingCode;
	/** 建物名称 */
	private String buildingName;
	/** 建物種別 */
	private Integer buildingType;
	/** 部屋ID */
	private Integer roomId;
	/** 部屋コード */
	private String roomCode;
	/** 部屋番号 */
	private String roomNumber;
	/** 階層区分ID */
	private Integer numberOfStoreysId;
	/** 面積平米 */
	private Double space;
	/** 賃料 */
	private Integer rent;
	/** 面積平米(FROM) */
	private Double spaceFrom;
	/** 賃料(FROM) */
	private Integer rentFrom;
	/** 面積平米(TO) */
	private Double spaceTo;
	/** 賃料(TO) */
	private Integer rentTo;

	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingCode() {
		return buildingCode;
	}
	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public Integer getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(Integer buildingType) {
		this.buildingType = buildingType;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Integer getNumberOfStoreysId() {
		return numberOfStoreysId;
	}
	public void setNumberOfStoreysId(Integer numberOfStoreysId) {
		this.numberOfStoreysId = numberOfStoreysId;
	}
	public Double getSpace() {
		return space;
	}
	public void setSpace(Double space) {
		this.space = space;
	}
	public Integer getRent() {
		return rent;
	}
	public void setRent(Integer rent) {
		this.rent = rent;
	}
	public Double getSpaceFrom() {
		return spaceFrom;
	}
	public void setSpaceFrom(Double spaceFrom) {
		this.spaceFrom = spaceFrom;
	}
	public Integer getRentFrom() {
		return rentFrom;
	}
	public void setRentFrom(Integer rentFrom) {
		this.rentFrom = rentFrom;
	}
	public Double getSpaceTo() {
		return spaceTo;
	}
	public void setSpaceTo(Double spaceTo) {
		this.spaceTo = spaceTo;
	}
	public Integer getRentTo() {
		return rentTo;
	}
	public void setRentTo(Integer rentTo) {
		this.rentTo = rentTo;
	}
}
