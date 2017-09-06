package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dto.RoomEquipmentDto;

/**
 * 部屋設備処理サービス
 * @author k.akhaira
 *
 */
public interface RoomEquipmentService {

	/**
	 * 部屋設備DTOを取得する処理
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 * @param equipmrntArray 選択された設備ID配列
	 * @param equipmentList 設備リスト
	 *
	 * @return 部屋設備DTOリスト
	 */
	public abstract List<RoomEquipmentDto> getRoomEquipmentList(Integer buildingId, Integer roomId,
			String[] equipmentArray, List<MasterDto> equipmentList);

	/**
	 * 部屋設備登録処理
	 *
	 * @param roomEquipmentDtoList 部屋設備DTOリスト
	 */
	public abstract void registRoomEquipment(
			List<RoomEquipmentDto> roomEquipmentDtoList);

	/**
	 * 建物IDと部屋IDをキーに部屋設備DTOを取得する処理
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 *
	 * @return 設備IDリスト
	 */
	public abstract List<Integer> getRoomEquipmentIdList(Integer buildingId, Integer roomId);

	/**
	 * 部屋設備更新処理
	 *
	 * @param roomEquipmentDtoList 部屋設備DTOリスト
	 */
	public abstract void updateRoomEquipment(
			List<RoomEquipmentDto> roomEquipmentDtoList);
}
