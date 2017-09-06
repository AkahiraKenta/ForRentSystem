package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.NearestStationDao;
import jp.co.forrentsystem.dto.NearestStationDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.dto.SearchConditionDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 最寄駅マスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class NearestStationDaoImpl extends SqlSessionDaoSupport implements NearestStationDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(NearestStationDaoImpl.class);

	@Override
	public void registNearestStation(NearestStationDto nearestStationDto) {
		logger.info("NearestStationDaoImpl-registNearestStation");
		getSqlSession().insert("registNearestStation", nearestStationDto);
	}

	@Override
	public List<NearestStationNameDto> getNearestStationNameList(
			Integer buildingId) {
		logger.info("NearestStationDaoImpl-getNearestStationNameList");
		return getSqlSession().selectList("getNearestStationNameList", buildingId);
	}

	@Override
	public Integer countNearestStationByBuildingId(Integer buildingId) {
		logger.info("NearestStationDaoImpl-countNearestStationByBuildingId");
		return getSqlSession().delete("countNearestStationByBuildingId", buildingId);
	}

	@Override
	public void deleteNearestStationByBuildingId(Integer buildingId) {
		logger.info("NearestStationDaoImpl-deleteNearestStationByBuildingId");
		getSqlSession().delete("deleteNearestStation", buildingId);
	}

	@Override
	public List<NearestStationNameDto> getRouteAndStationList() {
		logger.info("NearestStationDaoImpl-getRouteAndStationList");

		return getSqlSession().selectList("getRouteAndStationList");
	}

	@Override
	public List<NearestStationNameDto> getRouteAndStationNameList(
			SearchConditionDto searchConditionDto) {
		logger.info("NearestStationDaoImpl-getRouteAndStationNameList");

		return getSqlSession().selectList("getRouteAndStationNameList", searchConditionDto);
	}

	@Override
	public void deleteNearestStationDeleteFlagByBuildingId(Integer buildingId) {
		logger.info("NearestStationDaoImpl-deleteNearestStationDeleteFlagByBuildingId");
		getSqlSession().update("deleteNearestStationDeleteFlagByBuildingId", buildingId);
	}
}
