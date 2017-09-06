package jp.co.forrentsystem.dto;

/**
 * 人気駅DTO
 * @author k.akahira
 *
 */
public class PopularityStationDto {
	/** 駅ID */
	private Integer stationId;
	/** 駅名称 */
	private String stationName;
	/** 順位 */
	private Integer rank;
	/** 削除フラグ */
	private Integer deleteFlag;
	/** 人気駅件数 */
	private Integer popularityStationCount;

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
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Integer getPopularityStationCount() {
		return popularityStationCount;
	}
	public void setPopularityStationCount(Integer popularityStationCount) {
		this.popularityStationCount = popularityStationCount;
	}
}
