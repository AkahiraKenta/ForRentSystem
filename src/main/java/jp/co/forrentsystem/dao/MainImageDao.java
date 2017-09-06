package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.MainImageDto;


/**
 * メイン画像マスタDAO
 * @author k.akahira
 *
 */
public interface MainImageDao {

	/**
	 * メイン画像情報リストを取得
	 *
	 * @return メイン画像情報リスト
	 */
	public abstract List<MainImageDto> getMainImageList();

	/**
	 * 表示対象のメイン画像情報を取得
	 *
	 * @return メイン画像情報リスト
	 */
	public abstract List<MainImageDto> getMainImageViewList();

}
