package jp.co.forrentsystem.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.form.backend.BannerForm;

/**
 * バナーサービス
 * @author k.akhaira
 *
 */
public interface BannerService {

	/**
	 * バナー設定情報リストを取得する処理
	 *
	 * @return バナー設定情報リスト
	 */
	public abstract List<BannerDto> getBannerList();

	/**
	 * バナー設定登録
	 *
	 * @param bannerForm バナーFORM
	 */
	public abstract void registBanner(BannerForm bannerForm) throws IOException;

	/**
	 * バナーIDをキーにバナー情報を取得
	 *
	 * @param bannerId バナーID
	 *
	 * @return バナーDTO
	 */
	public abstract BannerDto getBannerByBannerId(Integer bannerId);

	/**
	 * バナー情報をDTOから取得
	 *
	 * @param bannerDto バナー情報
	 *
	 * @return バナーForm
	 */
	public abstract BannerForm getBannerInfo(BannerDto bannerDto);

	/**
	 * バナー情報を更新
	 *
	 * @param bannerForm バナー情報
	 */
	public abstract void updateBanner(BannerForm bannerForm);

	/**
	 * バナー情報を削除
	 *
	 * @param bannerId バナーID
	 */
	public abstract void deleteBanner(Integer bannerId);

	/**
	 * バナー情報の表示順を更新
	 *
	 * @param bannerId バナーID配列
	 */
	public abstract void updateBannerDisplayNumber(String[] bannerId);

	/**
	 * バナー表示件数分のバナー情報を取得
	 *
	 * @return バナー情報DTOリスト
	 */
	public abstract List<BannerDto> getBannerListByViewNumber();

	/**
	 * パラメータ情報のリロード処理
	 * パラメータがnullの場合、sessionから取得する
	 *
	 * @param model パラメータ
	 * @param session セッション
	 */
	public abstract ModelMap reloadModel(ModelMap model, HttpSession session);
}
