package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.ContactDto;
import jp.co.forrentsystem.form.backend.ContactForm;
import jp.co.forrentsystem.form.frontend.FContactForm;

/**
 * 物件問い合せ処理サービス
 * @author k.akhaira
 *
 */
public interface ContactService {

	/**
	 * お問い合わせ情報を登録する処理
	 *
	 * @param fContactForm お問合せForm
	 */
	public abstract void registContact(FContactForm fContactForm) throws Exception;

	/**
	 * ページング情報を取得
	 *
	 * @param contactForm お問合せForm
	 *
	 * @return お問合せ情報
	 */
	public abstract ContactForm getPagerInfo(ContactForm contactForm);

	/**
	 * 問い合わせ情報リストを取得
	 *
	 * @param contactForm 問い合わせForm
	 *
	 * @return 問い合わせ情報リスト
	 */
	public abstract List<ContactDto> getContactList(ContactForm contactForm);

	/**
	 * お問合せIDをキーにお問合せ情報を取得
	 *
	 * @param contactId お問合せID
	 *
	 * @return 問い合わせ情報リスト
	 */
	public abstract List<ContactDto> getContactByContactId(int contactId);

	/**
	 * お問合せ情報を更新する
	 *
	 * @param contactId
	 * @param processStatus
	 */
	public abstract void updateContactForProcessStatus(Integer contactId,
			Integer processStatus);


}
