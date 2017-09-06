package jp.co.forrentsystem.service;

import java.util.List;
import java.util.Map;

import jp.co.forrentsystem.dto.NearestStationDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.form.backend.EditBuildingForm;
import jp.co.forrentsystem.form.backend.RegistBuildingForm;
import jp.co.forrentsystem.form.frontend.FSearchConditionForm;


/**
 * 最寄駅サービス
 * @author k.akahira
 *
 */
public interface NearestStationService {

	/**
	 * 最寄駅登録処理
	 *
	 * @param nearestStationCombinDtoList 最寄駅DTO（テーブル結合用）リスト
	 */
	public abstract void registNearestStation(List<NearestStationDto> nearestStationDtoList);

	/**
	 * 最寄駅情報リスト取得処理(建物登録用)
	 *
	 * @param registConfirmBuildingForm 建物登録確認FORM
	 * @param buildingId 建物ID
	 *
	 * @return 最寄駅情報リスト
	 */
	public abstract List<NearestStationDto> getNearestStationDtoList(
			RegistBuildingForm registConfirmBuildingForm, Integer buildingId);
	/**
	 * 最寄駅情報リスト取得処理(建物更新用)
	 *
	 * @param editConfirmBuildingForm 建物登録確認FORM
	 * @param buildingId 建物ID
	 *
	 * @return 最寄駅情報リスト
	 */
	public abstract List<NearestStationDto> getNearestStationDtoList(
			EditBuildingForm editConfirmBuildingForm, Integer buildingId);

	/**
	 * 最寄駅名称リスト取得処理
	 *
	 * @param buildingId 建物ID
	 *
	 * @return 最寄駅名称リスト
	 */
	public abstract List<NearestStationNameDto> getNearestStationNameList(
			Integer buildingId);

	/**
	 * 最寄駅情報更新処理
	 *
	 * @param buildingId 建物ID
	 * @param nearestStationCombinDtoList 最寄駅DTO（テーブル結合用）リスト
	 */
	public abstract void updateNearestStation(List<NearestStationDto> nearestStationDtoList, Integer buildingId);

	/**
	 * 建物情報と紐付く沿線駅情報を取得
	 *
	 * @return 沿線駅情報マップ
	 */
	public abstract Map<Integer, List<NearestStationNameDto>> getNearestStationNameListMap();

	/**
	 * 検索条件として指定された沿線名、駅名を取得
	 *
	 * @param fSearchConditionForm 検索条件Form
	 *
	 * @return 最寄駅DTOリスト
	 */
	public abstract List<NearestStationNameDto> getRouteAndStationNameList(
			FSearchConditionForm fSearchConditionForm);
}
