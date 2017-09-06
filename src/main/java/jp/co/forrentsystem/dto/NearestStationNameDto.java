package jp.co.forrentsystem.dto;

/**
 * 最寄駅名称DTO
 * @author k.akahira
 *
 */
public class NearestStationNameDto {
	/** 建物ID */
	private Integer buildingId;
	/** 沿線ID */
	private Integer routeId;
	/** 沿線名称 */
	private String routeName;
	/** 駅ID */
	private Integer stationId;
	/** 駅名称 */
	private String stationName;
	/** 徒歩分 */
	private Integer minutesWalk;
	/** 件数 */
	private Integer count;

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
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public Integer getMinutesWalk() {
		return minutesWalk;
	}
	public void setMinutesWalk(Integer minutesWalk) {
		this.minutesWalk = minutesWalk;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
