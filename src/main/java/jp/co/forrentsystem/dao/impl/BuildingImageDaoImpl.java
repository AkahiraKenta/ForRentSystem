package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.BuildingImageDao;
import jp.co.forrentsystem.dto.BuildingImageDto;
import jp.co.forrentsystem.dto.NewArticleDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 建物画像DAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class BuildingImageDaoImpl extends SqlSessionDaoSupport implements BuildingImageDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(BuildingImageDaoImpl.class);


	@Override
	public Integer countBuildingImage(BuildingImageDto buildingImageDto) {
		logger.info("BuildingImageDaoImpl-countBuildingImage");
		// 建物画像登録済みチェック
		return getSqlSession().selectOne("countBuildingImage", buildingImageDto);
	}

	@Override
	public void registBuildingImage(BuildingImageDto buildingImageDto) {
		logger.info("BuildingImageDaoImpl-registBuildingImage");
		// 建物画像登録
		getSqlSession().insert("registBuildingImage", buildingImageDto);
	}

	@Override
	public BuildingImageDto getBuildingImage(Integer buildingId) {
		logger.info("BuildingImageDaoImpl-getBuildingImageList");
		// 建物画像情報取得
		return getSqlSession().selectOne("getBuildingImageList", buildingId);
	}

	@Override
	public void deleteBuildingImage(BuildingImageDto buildingImageDto) {
		logger.info("BuildingImageDaoImpl-deleteBuildingImage");
		// 建物画像情報削除
		getSqlSession().delete("deleteBuildingImage", buildingImageDto);
	}

	@Override
	public List<NewArticleDto> getBuildingImageByNewArticle(
			int newArticleViewNumber) {
		logger.info("BuildingImageDaoImpl-getBuildingImageByNewArticle");
		// 新着物件の建物画像情報を取得
		return getSqlSession().selectList("getBuildingImageByNewArticle",newArticleViewNumber );
	}

	@Override
	public void deleteBuildingImageByBuildingId(Integer buildingId) {
		logger.info("BuildingImageDaoImpl-deleteBuildingImageByBuildingId");
		// 新着物件の建物画像情報を取得
		getSqlSession().update("deleteBuildingImageByBuildingId",buildingId );
	}
}
