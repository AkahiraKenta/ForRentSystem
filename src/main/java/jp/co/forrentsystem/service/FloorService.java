package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.FloorDto;

/**
 * 階数処理サービス
 * @author k.akhaira
 *
 */
public interface FloorService {

	/**
	 * 階数リストを取得する処理
	 *
	 * @return 階数リスト
	 */
	public abstract List<FloorDto> getFloorList();

	/**
	 * 対象階数名称を取得する処理
	 *
	 * @param floorClassId 対象解消区分ID
	 *
	 * @return 対象階数名称
	 */
	public abstract FloorDto geFloorName(Integer floorClassId);
}
