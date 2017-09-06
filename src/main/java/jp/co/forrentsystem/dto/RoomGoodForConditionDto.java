package jp.co.forrentsystem.dto;

/**
 * 部屋こだわり条件DTO
 * @author k.akahira
 *
 */
public class RoomGoodForConditionDto {
	/** 建物ID */
	private Integer buildingId;
	/** 部屋ID */
	private Integer roomId;
	/** 条件ID */
	private Integer conditionId;

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
	public Integer getConditionId() {
		return conditionId;
	}
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}
}
