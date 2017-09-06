package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.BannerDto;

/**
 * バナーマスタDAO
 * @author k.akahira
 *
 */
public interface BannerDao {

	/**
	 * バナー設定情報リストを取得
	 *
	 * @return バナー設定情報リスト
	 */
	public abstract List<BannerDto> getBannerList();

	/**
	 * バナー設定登録
	 *
	 * @param bannerDto バナーDTO
	 */
	public abstract void registBanner(BannerDto bannerDto);

	/**
	 * バナー表示順の最大値を取得
	 *
	 * @return 表示順の最大値
	 */
	public abstract int getMaxDisplayNumber();

	/**
	 * バナーIDをキーにバナー情報を取得
	 *
	 * @param bannerId バナーID
	 *
	 * @return バナー情報
	 */
	public abstract BannerDto getBannerByBannerId(Integer bannerId);

	/**
	 * バナー情報を更新
	 *
	 * @param bannerDto バナー情報
	 */
	public abstract void updateBanner(BannerDto bannerDto);

	/**
	 * バナー情報を削除
	 *
	 * @param bannerId バナーID
	 */
	public abstract void deleteBanner(Integer bannerId);

	/**
	 * バナー情報の表示順を更新
	 *
	 * @param bannerDto バナー情報
	 */
	public abstract void updateBannerDisplayNumber(BannerDto bannerDto);

	/**
	 * バナー表示件数分のバナー情報を取得
	 *
	 * @param bannerViewNumber バナー表示件数
	 *
	 * @return バナー情報DTOリスト
	 */
	public abstract List<BannerDto> getBannerListByViewNumber(
			int bannerViewNumber);


}
