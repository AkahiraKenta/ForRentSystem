package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.RouteDao;
import jp.co.forrentsystem.dto.RouteDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 沿線マスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class RouteDaoImpl extends SqlSessionDaoSupport implements RouteDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RouteDaoImpl.class);

	@Override
	public List<RouteDto> getAllRouteList() {
		logger.info("RouteDaoImpl-getAllRouteList");
		return getSqlSession().selectList("getAllRouteList");
	}

	@Override
	public RouteDto getRouteName(Integer nearestRoute1) {
		logger.info("RouteDaoImpl-getRouteName");
		return getSqlSession().selectOne("getRouteName", nearestRoute1);
	}

	@Override
	public List<RouteDto> getAllExistRouteList() {
		logger.info("RouteDaoImpl-getAllExistRouteList");
		return getSqlSession().selectList("getAllExistRouteList");
	}

	@Override
	public List<RouteDto> getPopularityRouteList() {
		logger.info("RouteDaoImpl-getPopularityRouteList");
		return getSqlSession().selectList("getPopularityRouteList");
	}
}
