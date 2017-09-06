package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.RoomEquipmentDto;
import jp.co.forrentsystem.dto.RoomsDto;


/**
 * 部屋設備DAO
 * @author k.akahira
 *
 */
public interface RoomEquipmentDao {

	/**
	 * 部屋設備登録処理
	 *
	 * @param roomEquipmentDto 部屋設備DTO
	 */
	public abstract void registRoomEquipment(RoomEquipmentDto roomEquipmentDto);

	/**
	 * 部屋設備情報取得
	 *
	 * @param roomEquipmentDto 部屋設備DTO
	 *
	 * @return 設備IDOリスト
	 */
	public abstract List<Integer> getRoomEquipmentIdList(RoomEquipmentDto roomEquipmentDto);

	/**
	 * 部屋設備削除処理
	 *
	 * @param roomEquipmentDto 部屋設備情報
	 */
	public abstract void deleteRoomEquipment(RoomEquipmentDto roomEquipmentDto);

	/**
	 * 建物IDをキーに部屋設備を削除
	 *
	 * @param buildingId 建物ID
	 */
	public abstract void deleteRoomEquipmentByBuildingId(Integer buildingId);

	/**
	 * 建物IDと部屋IDをキーに部屋設備を削除
	 *
	 * @param roomsDto 部屋DTO
	 */
	public abstract void deleteRoomEquipmentByRoomId(RoomsDto roomsDto);

}
