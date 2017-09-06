package jp.co.forrentsystem.dto;

/**
 * 駅DTO
 * @author k.akahira
 *
 */
public class StationDto {
	/** 駅ID */
	private String stationId;
	/** 駅名称 */
	private String stationName;

	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
}
