package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.StationDto;

/**
 * 駅処理サービス
 * @author k.akhaira
 *
 */
public interface StationService {

	/**
	 * 沿線IDをキーに駅情報を取得する処理
	 *
	 * @return 駅DTOリスト
	 */
	public abstract List<StationDto> getStationListByRouteId(Integer routeId);

	/**
	 * 駅名称を取得
	 *
	 * @param stationId 駅ID
	 *
	 * @return 駅DTO
	 */
	public abstract StationDto getStationName(Integer stationId);

}
