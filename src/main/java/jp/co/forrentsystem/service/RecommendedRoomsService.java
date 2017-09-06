package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.form.backend.SearchRecommendedRoomForm;


/**
 * おすすめ物件情報処理サービス
 * @author k.akhaira
 *
 */
public interface RecommendedRoomsService {

	/**
	 * おすすめ物件の対象件数を取得
	 *
	 * @param searchRecommendedRoom お勧め物件Form
	 *
	 * @return お勧め物件Form
	 */
	public abstract SearchRecommendedRoomForm getPagerForSearchRecommendedRoom(SearchRecommendedRoomForm searchRecommendedRoomForm);

	/**
	 * おすすめ物件設定対象の物件情報取得（物件情報＝建物情報＋部屋情報）
	 *
	 * @param searchRecommendedRoomForm 物件検索Form(おすすめ物件用)
	 *
	 * @return 物件情報リスト
	 */
	public abstract List<ArticleDto> getArticleForRecommendedRoom(SearchRecommendedRoomForm searchRecommendedRoomForm);

	/**
	 * おすすめ物件登録
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 */
	public abstract void registRecommendedRoom(Integer buildingId,
			Integer roomId);

	/**
	 * おすすめ物件リスト取得
	 *
	 * @return 物件DTOリスト
	 */
	public abstract List<ArticleDto> getRecoomendedRoom();

	/**
	 * おすすめ物件削除
	 *
	 * @param id おすすめ物件ID
	 *
	 * @return 削除対象おすすめ物件ID
	 */
	public abstract Integer deleteRecommendRoom(Integer id);

	/**
	 * おすすめ物件更新
	 *
	 * @param id おすすめ物件ID配列
	 *
	 * @return おすすめ物件DTOリスト
	 */
	public abstract List<ArticleDto> updateRecommendRoom(String[] id);

	/**
	 * おすすめ物件表示件数分のおすすめ物件情報を取得
	 *
	 * @return おすすめ物件DTOリスト
	 */
	public abstract List<RecommendedRoomImageDto> getRecoomendedRoomListByViewNumber();

}
