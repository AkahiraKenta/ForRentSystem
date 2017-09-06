package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.PopularityStationDto;
import jp.co.forrentsystem.dto.StationDto;

/**
 * 人気駅処理サービス
 * @author k.akhaira
 *
 */
public interface PopularityStationService {

	/**
	 * 人気駅情報を取得
	 *
	 * @return 人気駅DTOリスト
	 */
	public abstract List<PopularityStationDto> getPopularityStationList();

	/**
	 * 人気駅を登録
	 *
	 * @param stationId 駅ID
	 *
	 * @return 登録対象の人気駅DTO
	 */
	public abstract PopularityStationDto registPopularityStation(Integer stationId);

	/**
	 * 人気駅を削除
	 * @param stationId 駅ID
	 * @return 削除対象の人気駅DTO
	 */
	public abstract PopularityStationDto deletePopularityStation(
			Integer stationId);

	/**
	 * 人気駅の順位を更新
	 *
	 * @param stationIdArray 駅ID配列
	 */
	public abstract List<PopularityStationDto> updatePopularityStation(
			String[] stationIdArray);


	/**
	 * 沿線IDをキーに人気駅を除いた駅情報を取得
	 *
	 * @return 沿線ID
	 */
	public abstract List<StationDto> getStationListForPopularityStationByRouteId(
			Integer routeId);

	/**
	 * フロント表示件数分の人気駅情報取得
	 *
	 * @return
	 */
	public abstract List<PopularityStationDto> getPopularityStationListByViewNumber();

}
