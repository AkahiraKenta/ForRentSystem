package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.RoomEquipmentDao;
import jp.co.forrentsystem.dto.RoomEquipmentDto;
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
public class RoomEquipmentDaoImpl extends SqlSessionDaoSupport implements RoomEquipmentDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RoomEquipmentDaoImpl.class);

	@Override
	public void registRoomEquipment(RoomEquipmentDto roomEquipmentDto) {
		logger.info("RoomEquipmentDaoImpl-registRoomEquipment");
		getSqlSession().insert("registRoomEquipment", roomEquipmentDto);
	}

	@Override
	public List<Integer> getRoomEquipmentIdList(RoomEquipmentDto roomEquipmentDto) {
		logger.info("RoomEquipmentDaoImpl-registRoomEquipment");
		return getSqlSession().selectList("getRoomEquipmentIdList", roomEquipmentDto);
	}

	@Override
	public void deleteRoomEquipment(RoomEquipmentDto roomEquipmentDto) {
		logger.info("RoomEquipmentDaoImpl-deleteRoomEquipment");
		getSqlSession().delete("deleteRoomEquipment", roomEquipmentDto);
	}

	@Override
	public void deleteRoomEquipmentByBuildingId(Integer buildingId) {
		logger.info("RoomEquipmentDaoImpl-deleteRoomEquipmentByBuildingId");
		getSqlSession().update("deleteRoomEquipmentByBuildingId", buildingId);
	}

	@Override
	public void deleteRoomEquipmentByRoomId(RoomsDto roomsDto) {
		logger.info("RoomEquipmentDaoImpl-deleteRoomEquipmentByRoomId");
		getSqlSession().update("deleteRoomEquipmentByRoomId", roomsDto);
	}


}
