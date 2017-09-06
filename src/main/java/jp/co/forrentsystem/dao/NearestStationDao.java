package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.NearestStationDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.dto.SearchConditionDto;



/**
 * 最寄駅マスタDAO
 * @author k.akahira
 *
 */
public interface NearestStationDao {

	/**
	 * 最寄駅情報登録
	 *
	 * @param nearestStationCombinDto 最寄駅情報DTO（テーブル結合用）
	 */
	public abstract void registNearestStation(NearestStationDto nearestStationDto);

	/**
	 * 最寄駅名称リスト取得
	 *
	 * @param buildingId 建物ID
	 *
	 * @return 最寄駅名称リスト
	 */
	public abstract List<NearestStationNameDto> getNearestStationNameList(
			Integer buildingId);

	/**
	 * 建物IDをキーに登録済みの最寄駅情報件数を取得
	 *
	 * @param buildingId 建物ID
	 *
	 * @return 最寄駅情報件数
	 */
	public abstract Integer countNearestStationByBuildingId(Integer buildingId);

	/**
	 * 建物IDをキーに最寄駅情報を削除
	 *
	 * @param buildingId 建物ID
	 */
	public abstract void deleteNearestStationByBuildingId(Integer buildingId);

	/**
	 * 建物情報と紐付く沿線駅情報を取得
	 *
	 * @return 沿線駅情報リスト
	 */
	public abstract List<NearestStationNameDto> getRouteAndStationList();

	/**
	 * 検索条件として指定された沿線名、駅名を取得
	 *
	 * @param searchConditionDto 検索条件DTO
	 *
	 * @return 最寄駅名称リスト
	 */
	public abstract List<NearestStationNameDto> getRouteAndStationNameList(
			SearchConditionDto searchConditionDto);

	/**
	 * 建物IDをキーに最寄駅情報を削除
	 *
	 * @param buildingId 建物ID
	 */
	public abstract void deleteNearestStationDeleteFlagByBuildingId(
			Integer buildingId);

}
