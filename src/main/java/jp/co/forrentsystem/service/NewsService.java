package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.NewsDto;
import jp.co.forrentsystem.form.backend.NewsForm;

/**
 * ニュース処理サービス
 * @author k.akhaira
 *
 */
public interface NewsService {


	/**
	 * ニュース一覧情報を取得
	 *
	 * @return ニュース一覧情報
	 */
	public abstract List<NewsDto> getListNews();

	/**
	 * ニュース登録
	 *
	 * @param newsForm ニュースForm
	 */
	public abstract void registNews(NewsForm newsForm);

	/**
	 * ニュースIDに紐付くニュース情報を取得
	 *
	 * @param newsId ニュースID
	 *
	 * @return ニュース情報
	 */
	public abstract NewsForm getNewsByNewsId(Integer newsId);

	/**
	 * ニュース情報を更新
	 *
	 * @param newsForm ニュースForm
	 */
	public abstract void updateNews(NewsForm newsForm);

	/**
	 * ニュース情報を削除
	 * @param newsId ニュースID
	 */
	public abstract void deleteNews(Integer newsId);

	/**
	 * ニュース表示件数分のニュース情報を取得
	 *
	 * @return ニュース情報リスト
	 */
	public abstract List<NewsDto> getListNewsByViewNumber();

	/**
	 * 登録したニュースIDを取得
	 *
	 * @return ニュースID
	 */
	public abstract int getMaxNewsId();


}
