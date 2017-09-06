package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.RoomGoodForConditionDao;
import jp.co.forrentsystem.dto.RoomGoodForConditionDto;
import jp.co.forrentsystem.dto.RoomsDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 部屋設備DAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class RoomGoodForConditionDaoImpl extends SqlSessionDaoSupport implements RoomGoodForConditionDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RoomGoodForConditionDaoImpl.class);

	@Override
	public void registRoomGoodForCondition(
			RoomGoodForConditionDto roomGoodForConditionDto) {
		logger.info("RoomGoodForConditionDaoImpl-registRoomGoodForCondition");
		getSqlSession().insert("registRoomGoodForCondition", roomGoodForConditionDto);
	}

	@Override
	public List<Integer> getRoomGoodForConditionIdList(
			RoomGoodForConditionDto roomGoodForConditionDto) {
		logger.info("RoomGoodForConditionDaoImpl-getRoomGoodForConditionIdList");
		return getSqlSession().selectList("getRoomGoodForConditionIdList", roomGoodForConditionDto);
	}

	@Override
	public void deleteRoomGoodForCondition(
			RoomGoodForConditionDto roomGoodForConditionDto) {
		logger.info("RoomGoodForConditionDaoImpl-deleteRoomGoodForCondition");
		getSqlSession().delete("deleteRoomGoodForCondition", roomGoodForConditionDto);
	}

	@Override
	public void deleteRoomGoodForConditionByBuildingId(Integer buildingId) {
		logger.info("RoomGoodForConditionDaoImpl-deleteRoomGoodForConditionByBuildingId");
		getSqlSession().update("deleteRoomGoodForConditionByBuildingId", buildingId);
	}

	@Override
	public void deleteRoomGoodForConditionByRoomId(RoomsDto roomsDto) {
		logger.info("RoomGoodForConditionDaoImpl-deleteRoomGoodForConditionByRoomId");
		getSqlSession().update("deleteRoomGoodForConditionByRoomId", roomsDto);
	}
}
