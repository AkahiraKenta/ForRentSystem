package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.FloorDao;
import jp.co.forrentsystem.dto.FloorDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 階数マスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class FloorDaoImpl extends SqlSessionDaoSupport implements FloorDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FloorDaoImpl.class);

	@Override
	public List<FloorDto> getFloorList() {
		logger.info("FloorDaoImpl-getFloorList");
		return getSqlSession().selectList("getFloorList");
	}

	@Override
	public FloorDto getFloorByFloorClassId(Integer floorClassId) {
		logger.info("FloorDaoImpl-getFloorByFloorClassId");
		return getSqlSession().selectOne("getFloorByFloorClassId", floorClassId);
	}


}
