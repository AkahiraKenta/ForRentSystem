package jp.co.forrentsystem.service;

import jp.co.forrentsystem.dto.HdFtDto;

/**
 * ヘッダーフッター処理サービス
 * @author k.akhaira
 *
 */
public interface HdFtService {

	/**
	 * ヘッダーフッター情報を取得する
	 *
	 * @return ヘッダーフッター情報
	 */
	public abstract HdFtDto getHdFt();

	/**
	 * ヘッダーフッター情報を更新する
	 *
	 * @param id ヘッダーフッターID
	 * @param headerFileName ヘッダーファイル名
	 * @param footerFileName フッターファイル名
	 * @param companyName 会社名
	 * @param tel 電話番号
	 * @param fax ファックス番号
	 * @param mailAddress メールアドレス
	 * @param transitionUrl 遷移先URL
	 * @param transitionFlag 遷移先方法フラグ
	 *
	 * @return ヘッダーフッターDTO
	 */
	public abstract HdFtDto updateHdFt(Integer id, String headerFileName, String footerFileName, String companyName,
			String tel, String fax, String mailAddress, String transitionUrl, Integer transitionFlag);
}
