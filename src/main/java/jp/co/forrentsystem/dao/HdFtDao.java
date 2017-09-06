package jp.co.forrentsystem.dao;

import jp.co.forrentsystem.dto.HdFtDto;


/**
 * ヘッダーフッターDAO
 * @author k.akahira
 *
 */
public interface HdFtDao {

	/**
	 * ヘッダーフッター情報を取得
	 *
	 * @return ヘッダーフッター情報
	 */
	public abstract HdFtDto getHdFt();

	/**
	 * ヘッダーフッター情報を更新
	 *
	 * @param hdFtDto ヘッダーフッターDTO
	 */
	public abstract void updateHdFt(HdFtDto hdFtDto);


}
