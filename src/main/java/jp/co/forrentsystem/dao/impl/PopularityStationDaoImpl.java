package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.PopularityStationDao;
import jp.co.forrentsystem.dto.PopularityStationDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 人気駅マスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class PopularityStationDaoImpl extends SqlSessionDaoSupport implements PopularityStationDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(PopularityStationDaoImpl.class);

	@Override
	public List<PopularityStationDto> getPopularityStationList() {
		logger.info("PopularityStationDaoImpl-getPopularityStationList");
		return getSqlSession().selectList("getPopularityStationList");
	}

	@Override
	public Integer getRank() {
		logger.info("PopularityStationDaoImpl-getRank");
		return getSqlSession().selectOne("getRank");
	}

	@Override
	public void registPopularityStation(PopularityStationDto popularityStationDto) {
		logger.info("PopularityStationDaoImpl-registPopularityStation");
		getSqlSession().insert("registPopularityStation", popularityStationDto);
	}

	@Override
	public void deletePopularityStation(
			PopularityStationDto popularityStationDto) {
		logger.info("PopularityStationDaoImpl-deletePopularityStation");
		getSqlSession().delete("deletePopularityStation", popularityStationDto);

	}

	@Override
	public void updateRank(PopularityStationDto popularityStationDto) {
		logger.info("PopularityStationDaoImpl-updateRank");
		getSqlSession().update("updateRank", popularityStationDto);
	}

	@Override
	public List<PopularityStationDto> getPopularityStationListByViewNumber(
			int popularityStationViewNumber) {
		logger.info("PopularityStationDaoImpl-getPopularityStationListByViewNumber");
		return getSqlSession().selectList("getPopularityStationListByViewNumber", popularityStationViewNumber);
	}
}
