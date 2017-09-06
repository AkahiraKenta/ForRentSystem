package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.dto.RecommendedRoomDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.dto.RoomsDto;


/**
 * おすすめ物件DAO
 * @author k.akahira
 *
 */
public interface RecommendedRoomDao {

	/**
	 * 順位の最大値+1を取得
	 *
	 * @return 順位の最大値＋１
	 */
	public abstract Integer selectMaxRank();

	/**
	 * おすすめ物件登録
	 *
	 * @param recommendedRoomDto おすすめ物件DTO
	 */
	public abstract void registRecommendedRoom(
			RecommendedRoomDto recommendedRoomDto);

	/**
	 * おすすめ物件リスト取得
	 *
	 * @return おすすめ物件DTOリスト
	 */
	public abstract List<ArticleDto> getRecoomendedRoom();

	/**
	 * おすすめ物件削除
	 *
	 * @param id おすすめ物件ID
	 */
	public abstract void deleteRecommendRoom(Integer id);

	/**
	 * おすすめ物件更新
	 *
	 * @param articleDto おすすめ物件DTO
	 */
	public abstract void updateRankForRecommendRoom(ArticleDto articleDto);

	/**
	 * おすすめ物件表示件数分のおすすめ物件情報を取得
	 *
	 * @param recommendedRoomViewNumber おすすめ物件表示件数
	 * @return おすすめ物件DTOリスト
	 */
	public abstract List<RecommendedRoomImageDto> getRecoomendedRoomListByViewNumber(
			int recommendedRoomViewNumber);

	/**
	 * 建物IDキーにおすすめ物件を削除
	 *
	 * @param buildingId 建物ID
	 */
	public abstract void deleteRecommendedByBuildingId(Integer buildingId);

	/**
	 * 建物IDと部屋IDをキーにおすすめ物件を削除
	 *
	 * @param roomsDto 部屋DTO
	 */
	public abstract void deleteRecommendedByRoomId(RoomsDto roomsDto);

}
