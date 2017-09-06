package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.SystemSettingDto;

/**
 * システム設定マスタDAO
 * @author k.akahira
 *
 */
public interface SystemSettingDao {

	/**
	 * システム設定リストを取得
	 * @return
	 */
	public abstract List<SystemSettingDto> getSystemSettingList();

	/**
	 * システム設定の表示件数を更新
	 *
	 * @param systemSettingDto システム設定DTO
	 */
	public abstract void updateDisplayNumber(SystemSettingDto systemSettingDto);


}
