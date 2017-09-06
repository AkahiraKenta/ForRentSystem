package jp.co.forrentsystem.dto;

import java.util.Date;

/**
 * 部屋設備DTO
 * @author k.akahira
 *
 */
public class RoomEquipmentDto {
	/** 建物ID */
	private Integer buildingId;
	/** 部屋ID */
	private Integer roomId;
	/** 設備ID */
	private Integer equipmentId;
	/** 登録日 */
	private Date created;
	/** 更新日 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;

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
	public Integer getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
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
