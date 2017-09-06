package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.SystemUserDto;
import jp.co.forrentsystem.form.backend.SystemUserForm;

/**
 * ログインサービス
 * @author k.akahira
 *
 */
public interface SystemUserService {

	/**
	 * ログイン処理
	 *
	 * @param loginId ログインID
	 * @param userPassword パスワード
	 *
	 * @return システムユーザ情報
	 */
	public abstract SystemUserDto login(String loginId, String userPassword);

	/**
	 * 利用可能なログインIDかチェックする
	 * @param loginId
	 * @return
	 */
	public abstract boolean checkAvailableLoginId(String loginId);

	/**
	 * システムユーザーの一覧を取得する
	 * @return
	 */
	public abstract List<SystemUserDto> getSystemUserList();

	/**
	 * 対象のシステムユーザー情報を取得する
	 * @return
	 */
	public abstract SystemUserForm getTargetSystemUser(int systemUserId);

	/**
	 * システムユーザー情報を登録する
	 * @param systemUserForm
	 */
	public abstract void registSystemUser(SystemUserForm systemUserForm);

	/**
	 * システムユーザー情報を更新する
	 * @param systemUserForm
	 */
	public abstract void updateSystemUser(SystemUserForm systemUserForm);

	/**
	 * システムユーザ情報を削除する
	 * @param systemUserId システムユーザID
	 */
	public abstract void deleteTargetSystemUser(int systemUserId);

	/**
	 * システムユーザ情報のパスワードチェック（登録値と入力値）
	 * @param systemUserForm システムユーザForm
	 */
	public abstract boolean checkSystemUserPassword(SystemUserForm systemUserForm);

	/**
	 *システムユーザ情報のパスワードを更新
	 * @param systemUserForm システムユーザForm
	 */
	public abstract void updateSystemUserForPassword(SystemUserForm systemUserForm);
}
