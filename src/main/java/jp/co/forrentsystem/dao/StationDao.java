package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.StationDto;


/**
 * 駅マスタDAO
 * @author k.akahira
 *
 */
public interface StationDao {

	/**
	 * 沿線をキーに駅情報を取得
	 *
	 * @return 駅DTOリスト
	 */
	public abstract List<StationDto> getStationListByRouteId(Integer routeId);

	/**
	 * 駅IDをキーに駅名称を取得
	 *
	 * @param stationId 駅ID
	 *
	 * @return 駅DTO
	 */
	public abstract StationDto getStationByStationId(Integer stationId);

	/**
	 * 沿線IDをキーに人気駅に設定されていない駅情報を取得
	 *
	 * @return 駅DTOリスト
	 */
	public abstract List<StationDto> getStationListForPopularityStationByRouteId(
			Integer routeId);
}
