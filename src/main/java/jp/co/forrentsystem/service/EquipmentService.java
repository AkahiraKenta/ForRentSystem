package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.constants.MasterDto;

/**
 * 部屋設備処理サービス
 * @author k.akhaira
 *
 */
public interface EquipmentService {

	/**
	 * 部屋設備リストを取得する処理
	 *
	 * @return 建物構造リスト
	 */
	public abstract List<MasterDto> getEquipmentList();

}
