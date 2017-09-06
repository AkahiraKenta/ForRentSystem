package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.AddressDto;
import jp.co.forrentsystem.dto.PopularityAreaDto;

/**
 * 人気エリア情報処理サービス
 * @author k.akhaira
 *
 */
public interface PopularityAreaService {

	/**
	 * 人気エリアに設定されていない都道府県を取得
	 *
	 * @return 住所DTOリスト
	 */
	public abstract List<AddressDto> getProvinceListForPopularityArea();

	/**
	 * 人気エリア情報を取得
	 *
	 * @return 人気エリアDTOリスト
	 */
	public abstract List<PopularityAreaDto> getPopularityAreaList();

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
	 * 人気エリアを登録
	 *
	 * @param province 都道府県
	 * @param city 市区町村
	 * @param townArea 町域
	 *
	 * @return 人気エリアDTO
	 */
	public abstract PopularityAreaDto registPopularityArea(
			String province, String city, String townArea);

	/**
	 * 人気エリアを削除
	 *
	 * @param popularityAreaId 人気エリアID
	 *
	 * @return 人気エリアDTO
	 */
	public abstract PopularityAreaDto deletePopularityArea(
			Integer popularityAreaId);

	/**
	 * 人気エリアを更新
	 *
	 * @param popularityAreaIdArray 人気エリアID配列
	 *
	 * @return 人気エリアDTOリスト
	 */
	public abstract List<PopularityAreaDto> updatePopularityArea(
			String[] popularityAreaIdArray);

	/**
	 * 人気エリア表示件数分の人気エリア情報を取得
	 *
	 * @return 人気エリアDTOリスト
	 */
	public abstract List<PopularityAreaDto> getPopularityAreaListByViewNumber();
}
