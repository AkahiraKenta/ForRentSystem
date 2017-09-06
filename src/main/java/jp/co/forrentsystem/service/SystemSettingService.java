package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.SystemSettingDto;

/**
 * システム設定処理サービス
 * @author k.akhaira
 *
 */
public interface SystemSettingService {

	/**
	 * システム設定リストを取得する処理
	 *
	 * @return システム設定リスト
	 */
	public abstract List<SystemSettingDto> getSystemSettingList();

	/**
	 * システム設定の表示件数を更新
	 *
	 * @param systemSettingId システム設定ID
	 * @param displayNumberId 表示件数ID
	 */
	public abstract void updateDisplayNumber(Integer systemSettingId,
			Integer displayNumberId);

	/**
	 * 新着物件表示件数取得
	 *
	 * @return 新着物件表示件数
	 */
	public abstract Integer getSystemSettingForNewArticle();

	/**
	 * 人気駅表示件数取得
	 *
	 * @return 人気駅表示件数
	 */
	public abstract int getSystemSettingForPopularityStation();

	/**
	 * 人気エリア表示件数取得
	 *
	 * @return 人気エリア表示件数
	 */
	public abstract int getSystemSettingForPopularityArea();

	/**
	 * ニュース表示件数を取得
	 *
	 * @return ニュース表示件数
	 */
	public abstract int getSystemSettingForNewsViewNumber();

	/**
	 * おすすめ物件表示件数を取得
	 *
	 * @return おすすめ物件表示件数
	 */
	public abstract int getSystemSettingForRecommendedRoom();

	/**
	 * バナー表示件数を取得
	 *
	 * @return バナー表示件数
	 */
	public abstract int getSystemSettingForBanner();

	/**
	 * 物件一覧表示件数を取得
	 *
	 * @return 物件一覧表示件数
	 */
	public abstract int getSystemSettingForArticleList();

}
