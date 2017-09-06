package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.BuildingImageDto;
import jp.co.forrentsystem.dto.NewArticleDto;

/**
 * 建物画像処理サービス
 * @author k.akhaira
 *
 */
public interface BuildingImageService {

	/**
	 * 建物画像登録処理
	 *
	 * @param targetBuildingId 建物ID
	 * @param buildingImageClass 建物画像区分
	 * @param fileName ファイル名
	 * @param imageCaption 画像見出し
	 * @param publicationFlag 公開フラグ
	 *
	 * @return 建物画像DTO
	 */
	public abstract BuildingImageDto registBuildingImage(Integer targetBuildingId,
			Integer buildingImageClass, String fileName,
			String imageCaption, Integer publicationFlag);

	/**
	 * 建物画像情報を取得
	 *
	 * @param buildingId 建物ID
	 * @return 建物画像DTO
	 */
	public abstract BuildingImageDto getBuildingImage(Integer buildingId);

	/**
	 * 建物画像情報を削除
	 *
	 * @param buildingId 建物ID
	 * @param imageId 画像ID
	 * @param fileName ファイル名
	 *
	 * @return 建物画像DTO
	 */
	public abstract BuildingImageDto deleteBuildingImage(Integer buildingId,
			Integer imageId, String fileName);

	/**
	 * 新着建物画像取得
	 *
	 * @return 新着建物画像リスト
	 */
	public abstract List<NewArticleDto> getBuildingImageByNewArticle();
}
