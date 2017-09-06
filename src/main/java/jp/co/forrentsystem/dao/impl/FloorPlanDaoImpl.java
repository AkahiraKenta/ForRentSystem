package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.FloorPlanDao;
import jp.co.forrentsystem.dto.FloorPlanDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 間取りマスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class FloorPlanDaoImpl extends SqlSessionDaoSupport implements FloorPlanDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FloorPlanDaoImpl.class);

	@Override
	public List<FloorPlanDto> getFloorPlanList() {
		logger.info("FloorPlanDaoImpl-getFloorPlanList");
		return getSqlSession().selectList("getFloorPlanList");
	}

	@Override
	public FloorPlanDto getFloorPlanByFloorPlanId(Integer floorPlanId) {
		logger.info("FloorPlanDaoImpl-getFloorByFloorPlanId");
		return getSqlSession().selectOne("getFloorPlanByFloorClassId", floorPlanId);
	}

	@Override
	public void registFloorPlan(FloorPlanDto floorPlanDto) {
		logger.info("FloorPlanDaoImpl-registFloorPlan");
	}

	@Override
	public void deleteFloorPlan(Integer floorPlanId) {
		logger.info("FloorPlanDaoImpl-deleteFloorPlan");
		getSqlSession().delete("deleteFloorPlan", floorPlanId);
	}

	@Override
	public void updateFloorPlan(FloorPlanDto floorPlanDto) {
		logger.info("FloorPlanDaoImpl-updateFloorPlan");
		getSqlSession().update("updateFloorPlan", floorPlanDto);
	}

	@Override
	public FloorPlanDto getFloorPlanByMaxFloorPlanId() {
		logger.info("FloorPlanDaoImpl-getFloorPlanByMaxFloorPlanId");
		return getSqlSession().selectOne("getFloorPlanByMaxFloorPlanId");
	}


}
