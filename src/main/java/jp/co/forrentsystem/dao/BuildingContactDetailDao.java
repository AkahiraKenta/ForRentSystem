package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.BuildingContactDto;

public interface BuildingContactDetailDao {

	/**
	 * 物件問い合せ詳細情報を登録
	 *
	 * @param buildingContactDto 物件問い合せ情報
	 */
	public abstract void registBuildingContactDetail(BuildingContactDto buildingContactDto);

	/**
	 * 物件問い合わせIDのMAX値を取得
	 *
	 * @return 問い合わせID
	 */
	public abstract int getBuildingContactId();

	/**
	 * 物件問い合わせ情報を取得
	 *
	 * @return 物件問い合せ情報リスト
	 */
	public abstract List<BuildingContactDto> getNewBuildingContact();

	/**
	 * 物件お問合せ情報を取得
	 *
	 * @param buildingContactDto 物件お問合せ情報DTO
	 *
	 * @return 物件お問合せ情報
	 */
	public abstract List<BuildingContactDto> getBuildingContactList(
			BuildingContactDto buildingContactDto);

	/**
	 * 物件問い合せIDをキーに物件問い合せ情報を取得
	 *
	 * @param buildingContactId 物件問い合せID
	 *
	 * @return 物件問い合せ情報
	 */
	public abstract List<BuildingContactDto> getBuildingContactByContactId(
			Integer buildingContactId);

	/**
	 * 処理ステータスを更新する処理
	 *
	 * @param buildingContactDto 物件問い合わせDTO
	 *
	 */
	public abstract void updateBuildingContactForProcessStatus(
			BuildingContactDto buildingContactDto);

	/**
	 * 物件問い合わせID件数を取得
	 *
	 * @param processStatus 処理ステータス
	 *
	 * @return 対象物件問い合わせ件数
	 */
	public abstract int getBuildingContactCount(Integer processStatus);

}
