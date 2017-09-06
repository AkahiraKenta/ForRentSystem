package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.FloorPlanDto;


/**
 * 間取りマスタDAO
 * @author k.akahira
 *
 */
public interface FloorPlanDao {

	/**
	 * 間取り情報リスト取得
	 *
	 * @return 階数情報リスト
	 */
	public abstract List<FloorPlanDto> getFloorPlanList();

	/**
	 * 間取りIDをキーに間取り情報を取得
	 *
	 * @param floorPlanId 間取りID
	 *
	 * @return 間取り情報
	 */
	public abstract FloorPlanDto getFloorPlanByFloorPlanId(Integer floorPlanId);

	/**
	 * 間取りを登録
	 *
	 * @param floorPlanDto
	 *
	 * @return 間取りID
	 */
	public abstract void registFloorPlan(FloorPlanDto floorPlanDto);

	/**
	 * 間取りIDをキーに間取りを削除
	 *
	 * @param floorPlanId 間取りID
	 */
	public abstract void deleteFloorPlan(Integer floorPlanId);

	/**
	 * 間取りIDをキーに間取り名称を更新
	 *
	 * @param floorPlanDto 間取りDTO
	 */
	public abstract void updateFloorPlan(FloorPlanDto floorPlanDto);

	/**
	 * 間取りID最大値の間取り情報
	 *
	 * @return 間取り情報
	 */
	public abstract FloorPlanDto getFloorPlanByMaxFloorPlanId();


}
