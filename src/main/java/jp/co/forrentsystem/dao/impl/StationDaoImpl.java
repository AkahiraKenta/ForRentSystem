package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.StationDao;
import jp.co.forrentsystem.dto.StationDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 駅マスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class StationDaoImpl extends SqlSessionDaoSupport implements StationDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(StationDaoImpl.class);

	@Override
	public List<StationDto> getStationListByRouteId(Integer routeId) {
		logger.info("StationDaoImpl-getStationListByRouteId");
		return getSqlSession().selectList("getStationListByRouteId", routeId);
	}

	@Override
	public StationDto getStationByStationId(Integer stationId) {
		logger.info("StationDaoImpl-getStationByStationId");
		return getSqlSession().selectOne("getStationByStationId", stationId);
	}

	@Override
	public List<StationDto> getStationListForPopularityStationByRouteId(
			Integer routeId) {
		logger.info("StationDaoImpl-getStationListForPopularityStationByRouteId");
		return getSqlSession().selectList("getStationListForPopularityStationByRouteId", routeId);
	}
}
