package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.RoomsImageDao;
import jp.co.forrentsystem.dto.RoomsDto;
import jp.co.forrentsystem.dto.RoomsImageDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 部屋画像DAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public  class RoomsImageDaoImpl extends SqlSessionDaoSupport implements RoomsImageDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RoomsImageDaoImpl.class);

	@Override
	public List<RoomsImageDto> getRoomImageList(RoomsImageDto roomsImageDto) {
		logger.info("RoomsImageDaoImpl-getRoomImageList");

		return getSqlSession().selectList("getRoomImageList", roomsImageDto);
	}

	@Override
	public Integer countRoomImage(RoomsImageDto roomsImageDto) {
		logger.info("RoomsImageDaoImpl-countRoomImage");
		return getSqlSession().selectOne("countRoomImage", roomsImageDto);
	}

	@Override
	public void registRoomImage(RoomsImageDto roomsImageDto) {
		logger.info("RoomsImageDaoImpl-registRoomImage");
		getSqlSession().insert("registRoomImage", roomsImageDto);
	}

	@Override
	public void deleteRoomImage(RoomsImageDto roomsImageDto) {
		logger.info("RoomsImageDaoImpl-deleteRoomImage");
		getSqlSession().delete("deleteRoomImage", roomsImageDto);
	}

	@Override
	public void deleteRoomImageByBuildingId(Integer buildingId) {
		logger.info("RoomsImageDaoImpl-deleteRoomImageByBuildingId");
		getSqlSession().update("deleteRoomImageByBuildingId", buildingId);
	}

	@Override
	public void deleteRoomImageByRoomId(RoomsDto roomsDto) {
		logger.info("RoomsImageDaoImpl-deleteRoomImageByRoomId");
		getSqlSession().update("deleteRoomImageByRoomId", roomsDto);
	}

}
