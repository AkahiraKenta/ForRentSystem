package jp.co.forrentsystem.dao;

import jp.co.forrentsystem.dto.BuildingContactDto;

public interface BuildingContactHeaderDao {

	/**
	 * 物件問い合せヘッダー情報を登録
	 *
	 * @param buildingContactDto 物件問い合せ情報
	 */
	public abstract void registBuildingContactHeader(BuildingContactDto buildingContactDto);

}
