package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.FloorDto;


/**
 * 階数マスタDAO
 * @author k.akahira
 *
 */
public interface FloorDao {

	/**
	 * 階数情報リスト取得
	 *
	 * @return 階数情報リスト
	 */
	public abstract List<FloorDto> getFloorList();

	/**
	 * 階数区分IDをキーに階数情報を取得する
	 *
	 * @param floorClassId 階数区分ID
	 *
	 * @return 階数情報
	 */
	public abstract FloorDto getFloorByFloorClassId(Integer floorClassId);


}
