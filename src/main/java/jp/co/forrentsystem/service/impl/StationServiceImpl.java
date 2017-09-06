package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.dao.PopularityStationDao;
import jp.co.forrentsystem.dao.StationDao;
import jp.co.forrentsystem.dto.StationDto;
import jp.co.forrentsystem.service.StationService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 駅サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class StationServiceImpl implements StationService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(StationServiceImpl.class);

	@Autowired
	private StationDao stationDao;
	@Autowired
	private PopularityStationDao popularityStationDao;

	@Override
	public List<StationDto> getStationListByRouteId(Integer routeId) {
		logger.info("StationServiceImpl-getStationListByRouteId");

		// 沿線IDをキーに駅情報を取得
		return stationDao.getStationListByRouteId(routeId);
	}

	@Override
	public StationDto getStationName(Integer stationId) {
		logger.info("StationServiceImpl-getStationName");
		// 駅IDをキーに駅情報を取得
		return stationDao.getStationByStationId(stationId);
	}
}
