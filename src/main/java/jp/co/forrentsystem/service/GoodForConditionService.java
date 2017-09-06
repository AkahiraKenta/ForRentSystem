package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dto.GoodForConditionDto;

/**
 * こだわり条件処理サービス
 * @author k.akhaira
 *
 */
public interface GoodForConditionService {

	/**
	 * こだわり条件リストを取得する処理
	 *
	 * @return こだわり条件リスト
	 */
	public abstract List<MasterDto> getGoodForConditionList();

	/**
	 * 対象こだわり条件名称を取得する処理
	 *
	 * @param conditionId 対象こだわり条件ID
	 *
	 * @return こだわり条件リスト
	 */
	public abstract List<MasterDto> getGoodForConditionNameList(List<Integer> conditionIdList);

	/**
	 * 表示順にこだわり条件を取得
	 *
	 * @return こだわり条件DTOリスト
	 */
	public abstract List<GoodForConditionDto> getGoodForConditionListOrderByDisplayNumber();

	/**
	 * こだわり条件を登録
	 *
	 * @return こだわり条件DTO
	 */
	public abstract GoodForConditionDto registGoodForCondition();

	/**
	 * こだわり条件を削除
	 *
	 * @param conditionId こだわり条件ID
	 *
	 * @return こだわり条件ID
	 */
	public abstract void deleteGoodForCondition(Integer conditionId);

	/**
	 * こだわり条件を更新
	 *
	 * @param conditionId こだわり条件ID
	 *
	 * @param conditionName こだわり条件名称
	 */
	public abstract void updateGoodForCondition(Integer conditionId,
			String conditionName);

	/**
	 * こだわり条件の表示順を更新
	 *
	 * @param conditionId こだわり条件ID
	 */
	public abstract void updateGoodForConditionDisplayNumber(
			String[] conditionId);
}
