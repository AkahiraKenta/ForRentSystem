package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.PopularityAreaDao;
import jp.co.forrentsystem.dto.PopularityAreaDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 人気エリアDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class PopularityAreaDaoImpl extends SqlSessionDaoSupport implements PopularityAreaDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(PopularityAreaDaoImpl.class);

	@Override
	public List<PopularityAreaDto> getPopularityAreaList() {
		logger.info("PopularityAreaDaoImpl-getPopularityAreaList");
		return getSqlSession().selectList("getPopularityAreaList");
	}

	@Override
	public Integer getRank() {
		logger.info("PopularityAreaDaoImpl-getRank");
		return getSqlSession().selectOne("getRank");
	}

	@Override
	public void registPopularityArea(PopularityAreaDto popularityAreaDto) {
		logger.info("PopularityAreaDaoImpl-registPopularityArea");
		getSqlSession().insert("registPopularityArea", popularityAreaDto);
	}

	@Override
	public PopularityAreaDto getPopularityAreaByDto(
			PopularityAreaDto popularityAreaDto) {
		logger.info("PopularityAreaDaoImpl-getPopularityAreaByDto");
		return getSqlSession().selectOne("getPopularityAreaByDto", popularityAreaDto);
	}

	@Override
	public void deletePopularityArea(Integer popularityAreaId) {
		logger.info("PopularityAreaDaoImpl-deletePopularityArea");
		getSqlSession().delete("deletePopularityArea", popularityAreaId);
	}

	@Override
	public PopularityAreaDto getPopularityAreaByPopularitAreaId(
			Integer popularityAreaId) {
		logger.info("PopularityAreaDaoImpl-getPopularityAreaByPopularitAreaId");
		return getSqlSession().selectOne("getPopularityAreaByPopularitAreaId", popularityAreaId);
	}

	@Override
	public void updateAreaRank(PopularityAreaDto popularityAreaDto) {
		logger.info("PopularityAreaDaoImpl-updateAreaRank");
		getSqlSession().update("updateAreaRank", popularityAreaDto);
	}

	@Override
	public List<PopularityAreaDto> getPopularityAreaListByViewNumber(
			Integer popularityAreaViewNumber) {
		logger.info("PopularityAreaDaoImpl-getPopularityAreaListByViewNumber");
		getSqlSession().selectList("getPopularityAreaListByViewNumber", popularityAreaViewNumber);
		return null;
	}
}
