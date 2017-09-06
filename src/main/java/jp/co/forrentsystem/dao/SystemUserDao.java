package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.SystemUserDto;

/**
 * システムユーザマスタDAO
 * @author k.akahira
 *
 */
public interface SystemUserDao {

	/**
	 * システムユーザログイン情報を取得
	 *
	 * @param systemUserLoginId ログインID
	 *
	 * @return システムユーザ情報
	 */
	public abstract SystemUserDto getSystemUserLoginId(String systemUserLoginId);

	/**
	 * システムユーザーの一覧を取得
	 * @return
	 */
	public abstract List<SystemUserDto> getSystemUserList();

	/**
	 * 対象のシステムユーザー情報を取得する
	 * @return
	 */
	public abstract SystemUserDto getTargetSystemUser(int systemUserId);

	/**
	 * システムユーザー情報を登録する
	 * @param systemUserForm
	 */
	public abstract void registSystemUser(SystemUserDto systemUserDto);

	/**
	 * システムユーザー情報を更新する
	 * @param systemUserForm
	 */
	public abstract void updateSystemUser(SystemUserDto systemUserDto);

	/**
	 * システムユーザ情報を削除する
	 * @param systemUserId システムユーザID
	 */
	public abstract void deleteSystemUser(int systemUserId);

	/**
	 * システムユーザ情報のパスワードを更新
	 * @param systemUserDto システムユーザ情報
	 */
	public abstract void updateSystemUserForPassword(SystemUserDto systemUserDto);
}
