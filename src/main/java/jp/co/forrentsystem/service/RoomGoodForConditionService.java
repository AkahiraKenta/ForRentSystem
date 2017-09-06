package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dto.RoomGoodForConditionDto;

/**
 * 部屋こだわり条件処理サービス
 * @author k.akhaira
 *
 */
public interface RoomGoodForConditionService {

	/**
	 * 部屋こだわり条件DTOを取得する処理
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 * @param goodForConditionArray 選択されたこだわり条件ID配列
	 * @param goodForConditionList こだわり条件リスト
	 *
	 * @return 部屋こだわり条件DTOリスト
	 */
	public abstract List<RoomGoodForConditionDto> getRoomGoodForConditionList(Integer buildingId, Integer roomId,
			String[] goodForConditionArray, List<MasterDto> goodForConditionList);

	/**
	 * 部屋こだわり条件登録処理
	 *
	 * @param roomGoodForConditionDtoList 部屋こだわり条件DTOリスト
	 */
	public abstract void registRoomGoodForCondition(
			List<RoomGoodForConditionDto> roomGoodForConditionDtoList);

	/**
	 * 建物IDと部屋IDをキーに部屋こだわり条件を取得
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 *
	 * @return こだわり条件IDリスト
	 */
	public abstract List<Integer> getRoomGoodForConditionIdList(Integer buildingId, Integer roomId);

	/**
	 * 部屋こだわり条件更新処理
	 *
	 * @param roomGoodForConditionDtoList 部屋こだわり条件DTOリスト
	 */
	public abstract void updateRoomGoodForCondition(
			List<RoomGoodForConditionDto> roomGoodForConditionDtoList);
}
