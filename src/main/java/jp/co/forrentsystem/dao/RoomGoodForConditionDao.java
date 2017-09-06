package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.RoomGoodForConditionDto;
import jp.co.forrentsystem.dto.RoomsDto;


/**
 * 部屋こだわり条件DAO
 * @author k.akahira
 *
 */
public interface RoomGoodForConditionDao {

	/**
	 * 部屋こだわり条件登録処理
	 *
	 * @param roomGoodForConditionDto 部屋こだわり条件DTO
	 */
	public abstract void registRoomGoodForCondition(
			RoomGoodForConditionDto roomGoodForConditionDto);

	/**
	 * 建物IDと部屋IDをキーに部屋こだわり条件を取得
	 *
	 * @param roomGoodForConditionDto 部屋こだわり条件DTO
	 *
	 * @return こだわり条件IDリスト
	 */
	public abstract List<Integer> getRoomGoodForConditionIdList(
			RoomGoodForConditionDto roomGoodForConditionDto);

	/**
	 * 部屋こだわり条件削除処理
	 *
	 * @param roomGoodForConditionDto 部屋こだわり条件DTO
	 */
	public abstract void deleteRoomGoodForCondition(
			RoomGoodForConditionDto roomGoodForConditionDto);

	/**
	 * 建物IDをキーにおすすめ物件を削除
	 *
	 * @param buildingId 建物ID
	 */
	public abstract void deleteRoomGoodForConditionByBuildingId(
			Integer buildingId);

	/**
	 * 建物IDと部屋IDをキーにおすすめ物件を削除
	 *
	 * @param roomsDto 部屋DTO
	 */
	public abstract void deleteRoomGoodForConditionByRoomId(RoomsDto roomsDto);
}
