package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.BuildingDao;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.SearchConditionDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 建物情報マスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class BuildingDaoImpl extends SqlSessionDaoSupport implements BuildingDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(BuildingDaoImpl.class);

	@Override
	public void registBuilding(BuildingDto buildingDto) {
		logger.info("BuildingDaoImpl-registBuilding");
		getSqlSession().insert("registBuilding", buildingDto);
	}

	@Override
	public Integer getBuildingId(BuildingDto buildingDto) {
		logger.info("BuildingDaoImpl-getBuildingId");
		return getSqlSession().selectOne("getBuildingId", buildingDto);
	}

	@Override
	public List<BuildingDto> searchBuildingList(BuildingDto buildingDto) {
		logger.info("BuildingDaoImpl-searchBuildingList");
		return getSqlSession().selectList("searchBuildingList", buildingDto);
	}

	@Override
	public BuildingDto getBuildingDtoByBuildingId(Integer buildingId) {
		logger.info("BuildingDaoImpl-getBuildingDtoByBuildingId");
		return getSqlSession().selectOne("getBuildingDtoByBuildingId", buildingId);
	}

	@Override
	public void updateBuilding(BuildingDto buildingDto) {
		logger.info("BuildingDaoImpl-getBuildingDtoByBuildingId");
		getSqlSession().update("updateBuilding", buildingDto);
	}

	@Override
	public List<BuildingDto> searchNewBuildingList() {
		logger.info("BuildingDaoImpl-searchNewBuildingList");
		return getSqlSession().selectList("searchNewBuildingList");
	}

	@Override
	public List<BuildingDto> getBuildingAddressList() {
		logger.info("BuildingDaoImpl-getBuildingAddressList");
		return getSqlSession().selectList("getBuildingAddressList");
	}

	@Override
	public List<BuildingDto> getAddressList(
			SearchConditionDto searchConditionDto) {
		logger.info("BuildingDaoImpl-getAddressList");
		return getSqlSession().selectList("getAddressList", searchConditionDto);
	}

	@Override
	public int countSearchBuildingList(BuildingDto buildingDto) {
		logger.info("BuildingDaoImpl-countSearchBuildingList");
		return getSqlSession().selectOne("countSearchBuildingList", buildingDto);
	}

	@Override
	public void deleteBuildingByBuildingId(Integer buildingId) {
		logger.info("BuildingDaoImpl-deleteBuildingByBuildingId");
		getSqlSession().update("deleteBuildingByBuildingId", buildingId);
	}
}
