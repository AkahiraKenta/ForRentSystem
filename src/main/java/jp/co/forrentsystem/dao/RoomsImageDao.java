package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.RoomsDto;
import jp.co.forrentsystem.dto.RoomsImageDto;


/**
 * 部屋画像DAO
 * @author k.akahira
 *
 */
public interface RoomsImageDao {

	/**
	 * 部屋画像リスト取得
	 *
	 * @param roomsImageDto 部屋画像DTO
	 *
	 * @return 部屋画像リスト
	 */
	public abstract List<RoomsImageDto> getRoomImageList(RoomsImageDto roomsImageDto);

	/**
	 * 部屋画像登録済確認
	 *
	 * @param roomsImageDto 部屋画像DTO
	 *
	 * @return 件数(1:登録済, 0:未登録)
	 */
	public abstract Integer countRoomImage(RoomsImageDto roomsImageDto);

	/**
	 * 部屋画像登録
	 *
	 * @param roomsImageDto 部屋画像DTO
	 */
	public abstract void registRoomImage(RoomsImageDto roomsImageDto);

	/**
	 * 部屋画像削除
	 *
	 * @param roomsImageDto 部屋画像DTO
	 */
	public abstract void deleteRoomImage(RoomsImageDto roomsImageDto);

	/**
	 * 建物IDをキーに部屋画像情報を削除
	 *
	 * @param buildingId 建物ID
	 */
	public abstract void deleteRoomImageByBuildingId(Integer buildingId);

	/**
	 * 建物IDと部屋IDをキーに部屋画像情報を削除
	 *
	 * @param roomsDto 部屋DTO
	 */
	public abstract void deleteRoomImageByRoomId(RoomsDto roomsDto);

}
