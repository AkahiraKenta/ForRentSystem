package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.FloorPlanDto;

/**
 * 間取り処理サービス
 * @author k.akhaira
 *
 */
public interface FloorPlanService {

	/**
	 * 間取りリストを取得する処理
	 *
	 * @return 間取りリスト
	 */
	public abstract List<FloorPlanDto> getFloorPlanList();

	/**
	 * 対象間取り名称を取得する処理
	 *
	 * @param floorClassId 対象間取りID
	 *
	 * @return 対象間取り名称
	 */
	public abstract FloorPlanDto geFloorPlanName(Integer floorPlanId);

	/**
	 * 間取りマスタに登録
	 *
	 * @return 追加した間取り情報DTO
	 */
	public abstract FloorPlanDto registFloorPlan();

	/**
	 * 間取りIDをキーに間取りマスタ情報を削除
	 *
	 * @param floorPlanId 間取りID
	 *
	 * @return 削除対象の間取りID
	 */
	public abstract Integer deleteFloorPlan(Integer floorPlanId);

	/**
	 * 間取りIDをキーに間取りマスタの間取り名称を更新
	 *
	 * @param floorPlanId 間取りID
	 * @param floorPlanName 間取り名称
	 *
	 * @return 間取り情報
	 */
	public abstract FloorPlanDto updateFloorPlan(Integer floorPlanId,
			String floorPlanName);

}
