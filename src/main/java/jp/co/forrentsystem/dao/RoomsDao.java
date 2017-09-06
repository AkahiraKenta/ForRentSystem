package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.dto.RoomsDetailDto;
import jp.co.forrentsystem.dto.RoomsDto;
import jp.co.forrentsystem.dto.SearchConditionDto;


/**
 * 部屋マスタDAO
 * @author k.akahira
 *
 */
public interface RoomsDao {

	/**
	 * 部屋情報登録処理
	 *
	 * @param roomsDto 部屋情報DTO
	 */
	public abstract void registRooms(RoomsDto roomsDto);

	/**
	 * 部屋ID取得処理
	 *
	 * @param roomsDto 部屋情報
	 *
	 * @return 部屋ID
	 */
	public abstract Integer getRoomId(RoomsDto roomsDto);

	/**
	 * 部屋情報一覧取得処理
	 *
	 * @param buildingId 建物ID
	 *
	 * @return 部屋情報DTOリスト
	 */
	public abstract List<RoomsDto> getRoomsListByBuildingId(Integer buildingId);

	/**
	 * 建物IDと部屋IDをキーに部屋情報を取得
	 *
	 * @param roomsDto 部屋情報
	 *
	 * @return 部屋詳細情報
	 */
	public abstract RoomsDetailDto getRoomsDtoByBuildingIdAndRoomId(RoomsDto roomsDto);

	/**
	 * 部屋情報更新処理
	 *
	 * @param roomsDto 部屋情報
	 */
	public abstract void updateRooms(RoomsDto roomsDto);

	/**
	 * 物件情報の対象全件数を取得
	 *
	 * @param articleDto 物件
	 *
	 * @return 対象全件数
	 */
	public abstract Integer getCountTotalNumberForRecommenededRoom(ArticleDto articleDto);

	/**
	 * 物件情報取得（物件情報＝建物情報＋部屋情報）
	 *
	 * @param articleDto 物件ページング情報
	 *
	 * @return 物件情報リスト
	 */
	public abstract List<ArticleDto> getArticleForRecommendedRoom(ArticleDto articleDto);

	/**
	 * 入力された検索条件をもとに物件情報取得
	 *
	 * @param searchConditionDto 検索条件DTO
	 *
	 * @return 物件情報リスト
	 */
	public abstract List<ArticleDto> getArticleList(SearchConditionDto searchConditionDto);

	/**
	 * 入力された検索条件をもとに物件件数を取得
	 *
	 * @param searchConditionDto 検索条件DTO
	 *
	 * @return 物件件数
	 */
	public abstract int countArticle(SearchConditionDto searchConditionDto);

	/**
	 * 物件詳細情報を取得
	 *
	 * @param articleDto 物件情報DTO（物件検索条件）
	 *
	 * @return 物件詳細情報
	 */
	public abstract ArticleDto getDetailArticle(
			ArticleDto articleDto);

	/**
	 * 建物IDをキーに空き状態の部屋情報を取得
	 *
	 * @param roomsDto 部屋DTO
	 *
	 * @return 部屋情報リスト
	 */
	public abstract List<RoomsDto> getRoomsListForVacancy(
			RoomsDto roomsDto);

	/**
	 * 建物IDをキーに部屋情報を削除
	 *
	 * @param buildingId 建物ID
	 */
	public abstract void deleteRoomByBuildingId(Integer buildingId);

	/**
	 * 建物IDと部屋IDをキーに部屋情報を削除
	 *
	 * @param roomsDto 部屋DTO
	 */
	public abstract void deleteRoomByRoomId(RoomsDto roomsDto);
}
