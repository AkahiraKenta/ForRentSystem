package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.constants.MasterDto;


/**
 * 設備マスタDAO
 * @author k.akahira
 *
 */
public interface EquipmentDao {

	/**
	 * 設備情報リスト取得
	 *
	 * @return 設備情報リスト
	 */
	public abstract List<MasterDto> getEquipmentList();

	/**
	 * 設備名称リスト取得
	 *
	 * @param equipmentIdList 設備IDリスト
	 *
	 * @return 設備情報
	 */
	public abstract List<MasterDto> getEquipmentNameList(List<Integer> equipmentIdList);
}
