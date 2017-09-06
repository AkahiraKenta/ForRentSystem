package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.RoomsDao;
import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.dto.RoomsDetailDto;
import jp.co.forrentsystem.dto.RoomsDto;
import jp.co.forrentsystem.dto.SearchConditionDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 部屋マスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class RoomsDaoImpl extends SqlSessionDaoSupport implements RoomsDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RoomsDaoImpl.class);

	@Override
	public void registRooms(RoomsDto roomsDto) {
		logger.info("RoomsDaoImpl-registRooms");
		getSqlSession().insert("registRooms", roomsDto);
	}

	@Override
	public Integer getRoomId(RoomsDto roomsDto) {
		logger.info("RoomsDaoImpl-getRoomId");
		return getSqlSession().selectOne("getRoomId", roomsDto);
	}

	@Override
	public List<RoomsDto> getRoomsListByBuildingId(Integer buildingId) {
		logger.info("RoomsDaoImpl-getRoomsListByBuildingId");
		return getSqlSession().selectList("getRoomsListByBuildingId", buildingId);
	}

	@Override
	public RoomsDetailDto getRoomsDtoByBuildingIdAndRoomId(RoomsDto roomsDto) {
		logger.info("RoomsDaoImpl-getRoomsDtoByBuildingIdAndRoomId");
		return getSqlSession().selectOne("getRoomsListByBuildingId", roomsDto);
	}

	@Override
	public void updateRooms(RoomsDto roomsDto) {
		logger.info("RoomsDaoImpl-updateRooms");
		getSqlSession().update("updateRooms", roomsDto);
	}

	@Override
	public Integer getCountTotalNumberForRecommenededRoom(ArticleDto articleDto) {
		logger.info("RoomsDaoImpl-getCountTotalNumberForRecommenededRoom");
		return getSqlSession().selectOne("getCountTotalNumberForRecommenededRoom", articleDto);
	}

	@Override
	public List<ArticleDto> getArticleForRecommendedRoom(ArticleDto articleDto) {
		logger.info("RoomsDaoImpl-getArticleForRecommendedRoom");
		return getSqlSession().selectList("getArticleForRecommendedRoom", articleDto);
	}

	@Override
	public List<ArticleDto> getArticleList(SearchConditionDto searchConditionDto) {
		logger.info("RoomsDaoImpl-getArticleList");
		return getSqlSession().selectList("getArticleList", searchConditionDto);
	}

	@Override
	public int countArticle(SearchConditionDto searchConditionDto) {
		logger.info("RoomsDaoImpl-countArticle");
		return getSqlSession().selectOne("countArticle", searchConditionDto);
	}

	@Override
	public ArticleDto getDetailArticle(ArticleDto articleDto) {
		logger.info("RoomsDaoImpl-getDetailArticle");
		return getSqlSession().selectOne("getDetailArticle", articleDto);
	}

	@Override
	public List<RoomsDto> getRoomsListForVacancy(RoomsDto roomsDto) {
		logger.info("RoomsDaoImpl-getRoomsListForVacancy");
		return getSqlSession().selectList("getRoomsListForVacancy", roomsDto);
	}

	@Override
	public void deleteRoomByBuildingId(Integer buildingId) {
		logger.info("RoomsDaoImpl-deleteRoomByBuildingId");
		getSqlSession().update("deleteRoomByBuildingId", buildingId);
	}

	@Override
	public void deleteRoomByRoomId(RoomsDto roomsDto) {
		logger.info("RoomsDaoImpl-deleteRoomByRoomId");
		getSqlSession().update("deleteRoomByRoomId", roomsDto);
	}
}
