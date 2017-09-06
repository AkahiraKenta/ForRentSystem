package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dto.GoodForConditionDto;

public interface GoodForConditionDao {

	/**
	 * こだわり条件リストを取得する処理
	 *
	 * @return こだわり条件リスト
	 */
	public abstract List<MasterDto> getGoodForConditionList();

	/**
	 * 対象こだわり条件名称を取得する処理
	 *
	 * @param conditionIdList 対象こだわり条件IDリスト
	 *
	 * @return こだわり条件リスト
	 */
	public abstract List<MasterDto> getGoodForConditionNameList(List<Integer> conditionIdList);

	/**
	 * 表示順順にこだわり条件を取得
	 *
	 * @return こだわり条件DTOリスト
	 */
	public abstract List<GoodForConditionDto> getGoodForConditionListOrderByDisplayNumber();

	/**
	 * こだわり条件表示順の最大値を取得
	 *
	 * @return こだわり条件表示順の最大値
	 */
	public abstract int getGoodForConditionMaxDisplayNumber();

	/**
	 * こだわり情報を登録
	 *
	 * @param goodForConditionDto こだわり条件DTO
	 */
	public abstract void registGoodForCondition(
			GoodForConditionDto goodForConditionDto);

	/**
	 * こだわり条件を削除
	 *
	 * @param conditionId こだわり条件ID
	 */
	public abstract void deleteGoodForCondition(Integer conditionId);

	/**
	 * こだわり条件を更新
	 *
	 * @param goodForConditionDto こだわり条件DTO
	 */
	public abstract void updateGoodForCondition(GoodForConditionDto goodForConditionDto);

	/**
	 * こだわり条件の表示順を更新
	 *
	 * @param goodForConditionDto こだわり条件DTO
	 */
	public abstract void updateGoodForConditionDisplayNumber(
			GoodForConditionDto goodForConditionDto);
}
