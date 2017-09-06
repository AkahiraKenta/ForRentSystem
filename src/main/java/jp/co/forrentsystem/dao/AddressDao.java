package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.AddressDto;

/**
 * 住所マスタDAO
 * @author k.akahira
 *
 */
public interface AddressDao {

	/**
	 * 住所登録
	 *
	 * @param addressDto 住所DTO
	 */
	public abstract void insertAddress(AddressDto addressDto);

	/**
	 * 住所更新
	 *
	 * @param addressDto 住所DTO
	 */
	public abstract void deleteAddress(AddressDto addressDto);

	/**
	 * 郵便番号をキーに住所リスト取得
	 *
	 * @param zipCode 郵便番号
	 *
	 * @return 住所リスト
	 */
	public abstract List<AddressDto> getAddressListViewByZipCode(String zipCode);

	/**
	 * 人気エリア設定されていない都道府県を取得
	 *
	 * @return 住所リスト
	 */
	public abstract List<AddressDto> getProvinceListForPopularityArea();

	/**
	 * 都道府県をキーに人気エリア設定されていない住所情報を取得
	 *
	 * @param province 都道府県
	 *
	 * @return 住所DTOリスト
	 */
	public abstract List<AddressDto> getAddressListForPopularityAreaByProvince(
			String province);

	/**
	 * 郵便番号を取得
	 *
	 * @param addressDto 住所DTO
	 *
	 * @return 郵便番号
	 */
	public abstract AddressDto getZipCode(AddressDto addressDto);
}
