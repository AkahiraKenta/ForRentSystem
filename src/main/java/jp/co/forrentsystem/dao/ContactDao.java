package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.ContactDto;

public interface ContactDao {

	/**
	 * 問い合せ情報を登録
	 *
	 * @param contactDto 問い合せ情報
	 */
	public abstract void registContact(ContactDto contactDto);

	/**
	 * 問い合せ情報を取得
	 *
	 * @return 問い合せID
	 */
	public abstract int getContactId();

	/**
	 * 処理ステータスをキーにお問合せ情報件数を取得
	 *
	 * @param processStatus 処理ステータス
	 *
	 * @return お問合せ件数
	 */
	public abstract int getContactCount(Integer processStatus);

	/**
	 * 問い合わせ情報を取得
	 *
	 * @param contactDto 問い合わせDto
	 *
	 * @return 問い合わせ情報リスト
	 */
	public abstract List<ContactDto> getContactList(ContactDto contactDto);

	/**
	 * 問い合わせ情報を1件取得
	 *
	 * @param contactId 問い合わせID
	 *
	 * @return 問い合わせ情報リスト
	 */
	public abstract List<ContactDto> getContactByContactId(int contactId);

	/**
	 * お問合せ情報を更新する
	 *
	 * @param contactDto お問合せ情報
	 */
	public abstract void updateContactForProcessStatus(ContactDto contactDto);

}
