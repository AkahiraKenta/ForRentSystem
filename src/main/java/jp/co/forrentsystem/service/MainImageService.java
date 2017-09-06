package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.MainImageDto;

/**
 * メイン画像サービス
 * @author k.akhaira
 *
 */
public interface MainImageService {

	/**
	 * メイン画像情報を取得
	 *
	 * @return メイン画像情報リスト
	 */
	public abstract List<MainImageDto> getMainImageList();

	/**
	 * 表示が有効となっているメイン画像情報を取得
	 *
	 * @return メイン画像情報リスト
	 */
	public abstract List<MainImageDto> getMainImageViewList();
}
