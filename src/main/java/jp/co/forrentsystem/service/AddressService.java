package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.AddressDto;

/**
 * 住所管理情報処理サービス
 * @author k.akhaira
 *
 */
public interface AddressService {

// TODO:住所マスタ登録を一旦止めてるためコメントアウト

//	/**
//	 * 住所取込履歴情報を取得
//	 *
//	 * @return 住所取込履歴DTO
//	 */
//	public abstract AddressImportHistoryDto getAddressImportHistoryToMaxYears();
//
//	/**
//	 * 追加する住所管理情報を取得
//	 * @param addressImportHistoryDto 住所取込履歴DTO
//	 *
//	 * @return 住所管理情報DTOリスト
//	 * @throws IOException ファイル読込エラー
//	 */
//	public abstract Map<String, List<AddressDto>> getAddressListForRegist(
//			AddressImportHistoryDto addressImportHistoryDto) throws IOException;
//
//	/**
//	 * 削除する住所管理情報を取得
//	 * @param addressImportHistoryDto 住所取込履歴DTO
//	 *
//	 * @return 住所管理情報DTOリスト
//	 * @throws IOException ファイル読込エラー
//	 */
//	public abstract Map<String, List<AddressDto>> getAddressListForDelete(
//			AddressImportHistoryDto addressImportHistoryDto) throws IOException;
//
//	/**
//	 * 住所管理情報を登録
//	 * @param addressDtoListForRegistMap 住所管理DTOリスト（追加用）
//	 *
//	 * @return 登録結果
//	 * @throws IOException ファイル読込エラー
//	 */
//	public abstract boolean registAddress(Map<String, List<AddressDto>> addressDtoListForRegistMap)
//			throws IOException;
//
//	/**
//	 * 住所管理情報を削除
//	 * @param addressDtoListForDelete 住所管理DTOリスト（削除用）
//	 *
//	 * @return 削除結果
//	 */
//	public abstract boolean deleteAddress(Map<String, List<AddressDto>> addressDtoListForDeleteMap);
//
//	// TODO:処理対象となった年月が必要。マップを引数とするのは問題あり。
//	/**
//	 * 住所取込情報を登録
//	 * @param addressDtoListForDeleteMap 削除対象郵政住所マップ
//	 *
//	 * @return 登録結果
//	 */
//	public abstract boolean registAddressImportHistroty(Map<String, List<AddressDto>> addressDtoListForDeleteMap);

	/**
	 * 郵便番号をキーに住所リストを取得
	 *
	 * @param zipCode 郵便番号
	 *
	 * @return 住所リスト
	 */
	public abstract List<AddressDto> getAddressListViewByZipCode(String zipCode);

	/**
	 * 郵便番号を取得
	 *
	 * @param province 都道府県
	 * @param city 市区町村
	 * @param town 町域
	 *
	 * @return 住所DTO
	 */
	public abstract AddressDto getZipCode(String province, String city,
			String town);
}
