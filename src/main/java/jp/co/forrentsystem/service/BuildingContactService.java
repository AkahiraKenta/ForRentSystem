package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.BuildingContactDto;
import jp.co.forrentsystem.form.backend.BuildingContactForm;
import jp.co.forrentsystem.form.frontend.FContactArticleForm;

/**
 * 物件問い合せ処理サービス
 * @author k.akhaira
 *
 */
public interface BuildingContactService {

	/**
	 * 物件お問い合わせ情報を登録する処理
	 *
	 * @param fContactArticleForm お問合せ物件Form
	 */
	public abstract void registBuildingContact(FContactArticleForm fContactArticleForm) throws Exception;

	/**
	 * 新着物件お問い合わせ情報を取得する処理
	 *
	 * @return 物件問い合わせ情報DTO
	 */
	public abstract List<BuildingContactDto> getNewBuildingContact();

	/**
	 * 物件お問合せ情報を取得する処理
	 *
	 * @param buildingContactForm 物件問い合せ情報Form
	 *
	 * @return 物件お問合せ情報
	 */
	public abstract List<BuildingContactDto> getBuildingContactList(BuildingContactForm buildingContactForm);

	/**
	 * 物件問い合わせIDをキーに物件お問合せ情報を取得する処理
	 *
	 * @param buildingContactId 物件問い合わせID
	 *
	 * @return 物件お問合せ情報
	 */
	public abstract List<BuildingContactDto> getBuildingContactByContactId(
			Integer buildingContactId);

	/**
	 * 処理ステータスを更新する処理
	 *
	 * @param buildingContactId
	 * @param processStatus
	 */
	public abstract void updateBuildingContactForProcessStatus(
			Integer buildingContactId, Integer processStatus);

	/**
	 * ページング情報を取得
	 *
	 * @param buildingContactForm 物件問い合わせ情報Form
	 *
	 * @return 物件問い合わせ情報Form
	 */
	public abstract BuildingContactForm getPagerInfo(
			BuildingContactForm buildingContactForm);

}
