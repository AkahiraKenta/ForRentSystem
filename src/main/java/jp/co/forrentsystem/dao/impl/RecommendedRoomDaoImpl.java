package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.RecommendedRoomDao;
import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.dto.RecommendedRoomDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.dto.RoomsDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * おすすめ物件DAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class RecommendedRoomDaoImpl extends SqlSessionDaoSupport implements RecommendedRoomDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RecommendedRoomDaoImpl.class);

	@Override
	public Integer selectMaxRank() {
		logger.info("RecommendedRoomDaoImpl-selectMaxRank");
		return getSqlSession().selectOne("selectMaxRank");
	}

	@Override
	public void registRecommendedRoom(RecommendedRoomDto recommendedRoomDto) {
		logger.info("RecommendedRoomDaoImpl-registRecommendedRoom");
		getSqlSession().insert("registRecommendedRoom", recommendedRoomDto);
	}

	@Override
	public List<ArticleDto> getRecoomendedRoom() {
		logger.info("RecommendedRoomDaoImpl-getRecoomendedRoom");
		return getSqlSession().selectList("getRecoomendedRoom");
	}

	@Override
	public void deleteRecommendRoom(Integer id) {
		logger.info("RecommendedRoomDaoImpl-deleteRecommendRoom");
		getSqlSession().delete("deleteRecommendRoom", id);

	}

	@Override
	public void updateRankForRecommendRoom(ArticleDto articleDto) {
		logger.info("RecommendedRoomDaoImpl-updateRankForRecommendRoom");
		getSqlSession().update("updateRankForRecommendRoom", articleDto);

	}

	@Override
	public List<RecommendedRoomImageDto> getRecoomendedRoomListByViewNumber(
			int recommendedRoomViewNumber) {
		logger.info("RecommendedRoomDaoImpl-getRecoomendedRoomListByViewNumber");
		return getSqlSession().selectList("getRecoomendedRoomListByViewNumber", recommendedRoomViewNumber);
	}

	@Override
	public void deleteRecommendedByBuildingId(Integer buildingId) {
		logger.info("RecommendedRoomDaoImpl-deleteRecommendedByBuildingId");
		getSqlSession().update("deleteRecommendedByBuildingId", buildingId);
	}

	@Override
	public void deleteRecommendedByRoomId(RoomsDto roomsDto) {
		logger.info("RecommendedRoomDaoImpl-deleteRecommendedByRoomId");
		getSqlSession().update("deleteRecommendedByRoomId", roomsDto);
	}

}
