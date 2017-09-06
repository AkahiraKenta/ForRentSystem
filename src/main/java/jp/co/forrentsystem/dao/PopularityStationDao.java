package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.PopularityStationDto;


/**
 * 人気駅DAO
 * @author k.akahira
 *
 */
public interface PopularityStationDao {

	/**
	 * 人気駅情報を取得
	 *
	 * @return 人気駅DTOリスト
	 */
	public abstract List<PopularityStationDto> getPopularityStationList();

	/**
	 * 人気駅順位の最大値を取得
	 *
	 * @return 順位(最大値)
	 */
	public abstract Integer getRank();

	/**
	 * 人気駅を登録
	 *
	 * @param popularityStationDto 人気駅DTO
	 */
	public abstract void registPopularityStation(PopularityStationDto popularityStationDto);

	/**
	 * 人気駅を削除
	 *
	 * @param popularityStationDto 人気駅DTO
	 */
	public abstract void deletePopularityStation(PopularityStationDto popularityStationDto);

	/**
	 * 人気駅の順位を更新
	 *
	 * @param popularityStationDto 人気駅DTO
	 */
	public abstract void updateRank(PopularityStationDto popularityStationDto);

	/**
	 * 人気駅情報を表示件数分取得
	 *
	 * @param popularityStationViewNumber 人気駅表示件数
	 *
	 * @return 人気駅情報リスト
	 */
	public abstract List<PopularityStationDto> getPopularityStationListByViewNumber(
			int popularityStationViewNumber);

}
