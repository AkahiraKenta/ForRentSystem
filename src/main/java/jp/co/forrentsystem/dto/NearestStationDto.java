package jp.co.forrentsystem.dto;

import java.util.Date;

/**
 * 最寄駅DTO
 * @author k.akahira
 *
 */
public class NearestStationDto {
	/** 建物ID */
	private Integer buildingId;
	/** 沿線ID */
	private Integer routeId;
	/** 駅ID */
	private Integer stationId;
	/** 徒歩分 */
	private Integer minutesWalk;
	/** 表示順 */
	private Integer displayNumber;
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
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	public Integer getMinutesWalk() {
		return minutesWalk;
	}
	public void setMinutesWalk(Integer minutesWalk) {
		this.minutesWalk = minutesWalk;
	}
	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return this.modified;
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
	public Integer getDisplayNumber() {
		return displayNumber;
	}
	public void setDisplayNumber(Integer displayNumber) {
		this.displayNumber = displayNumber;
	}
}
