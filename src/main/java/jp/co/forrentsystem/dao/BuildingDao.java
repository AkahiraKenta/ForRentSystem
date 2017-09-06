package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.SearchConditionDto;


/**
 * 建物情報DAO
 * @author k.akahira
 *
 */
public interface BuildingDao {

	/**
	 * 建物情報を登録
	 *
	 * @param buildingDto 建物情報DTO
	 */
	public abstract void registBuilding(BuildingDto buildingDto);

	/**
	 * 建物IDを取得
	 *
	 * @param buildingDto 建物情報DTO
	 *
	 * @return 建物ID
	 */
	public abstract Integer getBuildingId(BuildingDto buildingDto);

	/**
	 * 建物検索結果を取得
	 *
	 * @param buildingDto 建物情報DTO
	 *
	 * @return 建物情報リスト
	 */
	public abstract List<BuildingDto> searchBuildingList(BuildingDto buildingDto);

	/**
	 * 建物IDをキーに建物情報を取得
	 *
	 * @param buildingId 建物ID
	 *
	 * @return 建物情報
	 */
	public abstract BuildingDto getBuildingDtoByBuildingId(Integer buildingId);

	/**
	 * 建物IDをキーに建物情報を更新
	 *
	 * @param buildingDto 建物DTO
	 */
	public abstract void updateBuilding(BuildingDto buildingDto);

	/**
	 * 新着建物検索結果を取得
	 *
	 * @return 建物情報リスト
	 */
	public abstract List<BuildingDto> searchNewBuildingList();

	/**
	 * 建物情報と紐付く住所を取得
	 *
	 * @return
	 */
	public abstract List<BuildingDto> getBuildingAddressList();

	/**
	 * 検索条件として指定された住所を取得
	 *
	 * @param searchConditionDto 検索条件DTO
	 *
	 * @return 住所リスト
	 */
	public abstract List<BuildingDto> getAddressList(
			SearchConditionDto searchConditionDto);

	/**
	 * 建物一覧表示件数を取得
	 *
	 * @param buildingDto 検索条件
	 *
	 * @return 件数
	 */
	public abstract int countSearchBuildingList(BuildingDto buildingDto);

	/**
	 * 建物IDをキーに建物情報を削除
	 *
	 * @param buildingId 建物ID
	 */
	public abstract void deleteBuildingByBuildingId(Integer buildingId);


}
