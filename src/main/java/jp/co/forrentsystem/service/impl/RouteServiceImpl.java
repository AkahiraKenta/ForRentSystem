package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.dao.RouteDao;
import jp.co.forrentsystem.dto.RouteDto;
import jp.co.forrentsystem.service.RouteService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 沿線サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class RouteServiceImpl implements RouteService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RouteServiceImpl.class);

	@Autowired
	private RouteDao routeDao;

	@Override
	public List<RouteDto> getAllRouteList() {
		logger.info("RouteServiceImpl-getAllRouteList");

		// 沿線情報を取得
		return routeDao.getAllRouteList();
	}

	@Override
	public RouteDto getRouteName(Integer nearestRoute) {
		logger.info("RouteServiceImpl-getRouteName");

		// 沿線名称を取得
		return routeDao.getRouteName(nearestRoute);
	}

	@Override
	public List<RouteDto> getAllExistRouteList() {
		logger.info("RouteServiceImpl-getAllExistRouteList");

		// 建物情報が存在する沿線情報を取得
		return routeDao.getAllExistRouteList();
	}

	@Override
	public List<RouteDto> getPopularityRouteList() {
		logger.info("RouteServiceImpl-getPopularityRouteList");

		// 建物情報が存在する沿線情報を取得
		return routeDao.getPopularityRouteList();
	}
}
