package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.BuildingImageDto;
import jp.co.forrentsystem.dto.NewArticleDto;


/**
 * 建物画像テーブルDAO
 * @author k.akahira
 *
 */
public interface BuildingImageDao {


	/**
	 * 建物画像登録済みチェック処理
	 *
	 * @param buildingImageDto 建物画像
	 *
	 * @return 件数(1:登録済み,0:未登録)
	 */
	public abstract Integer countBuildingImage(BuildingImageDto buildingImageDto);

	/**
	 * 建物画像登録処理
	 *
	 * @param buildingImageDto 建物画像
	 */
	public abstract void registBuildingImage(BuildingImageDto buildingImageDto);

	/**
	 * 建物画像情報を取得
	 *
	 * @param buildingId 建物ID
	 *
	 * @return 建物画像DTO
	 */
	public abstract BuildingImageDto getBuildingImage(Integer buildingId);

	/**
	 * 建物画像情報を削除
	 *
	 * @param buildingImageDto 建物画像情報
	 */
	public abstract void deleteBuildingImage(BuildingImageDto buildingImageDto);

	/**
	 * 新着物件の建物画像情報を取得
	 *
	 * @param newArticleViewNumber 新着物件表示件数
	 *
	 * @return 新着物件画像情報リスト
	 */
	public abstract List<NewArticleDto> getBuildingImageByNewArticle(
			int newArticleViewNumber);

	/**
	 * 建物画像情報を削除
	 *
	 * @param buildingId 建物ID
	 */
	public abstract void deleteBuildingImageByBuildingId(Integer buildingId);

}
