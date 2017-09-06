package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.NewsDto;


/**
 * ニュースDAO
 * @author k.akahira
 *
 */
public interface NewsDao {

	/**
	 * ニュース一覧情報を取得
	 *
	 * @return ニュース一覧情報
	 */
	public abstract List<NewsDto> getListNews();

	/**
	 * ニュース登録
	 *
	 * @param newsDto ニュースDTO
	 */
	public abstract void registNews(NewsDto newsDto);

	/**
	 * ニュースIDをキーにニュース情報を取得
	 *
	 * @param newsId ニュースID
	 *
	 * @return ニュース情報
	 */
	public abstract NewsDto getNewsByNewsId(Integer newsId);

	/**
	 * ニュース情報を更新
	 *
	 * @param newsDto ニュースDTO
	 */
	public abstract void updateNews(NewsDto newsDto);

	/**
	 * ニュース情報を削除
	 *
	 * @param newsId ニュースID
	 */
	public abstract void deleteNews(Integer newsId);

	/**
	 * ニュース表示件数分のニュース情報を取得
	 *
	 * @param newsViewNumber ニュース表示件数
	 *
	 * @return ニュース情報リスト
	 */
	public abstract List<NewsDto> getListNewsByViewNumber(int newsViewNumber);

	/**
	 * 登録したニュースIDを取得
	 *
	 * @return ニュースID
	 */
	public abstract int getMaxNewsId();


}
