package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.BuildingContactDetailDao;
import jp.co.forrentsystem.dto.BuildingContactDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BuildingContactDetailDaoImpl extends SqlSessionDaoSupport implements BuildingContactDetailDao {

	@Override
	public void registBuildingContactDetail(
			BuildingContactDto buildingContactDto) {
		logger.info("BuildingContactDetailDaoImpl-registBuildingContactDetail");
		getSqlSession().insert("registBuildingContactDetail", buildingContactDto);
	}

	@Override
	public int getBuildingContactId() {
		logger.info("BuildingContactDetailDaoImpl-getBuildingContactId");

		return getSqlSession().selectOne("getBuildingContactId");
	}

	@Override
	public List<BuildingContactDto> getNewBuildingContact() {
		logger.info("BuildingContactDetailDaoImpl-getNewBuildingContact");

		return getSqlSession().selectList("getNewBuildingContact");
	}

	@Override
	public List<BuildingContactDto> getBuildingContactList(BuildingContactDto buildingContactDto) {
		logger.info("BuildingContactDetailDaoImpl-getBuildingContactList");

		return getSqlSession().selectList("getBuildingContactList", buildingContactDto);
	}

	@Override
	public List<BuildingContactDto> getBuildingContactByContactId(
			Integer buildingContactId) {
		logger.info("BuildingContactDetailDaoImpl-getBuildingContactByContactId");
		return getSqlSession().selectList("getBuildingContactByContactId", buildingContactId);
	}

	@Override
	public void updateBuildingContactForProcessStatus(
			BuildingContactDto buildingContactDto) {
		logger.info("BuildingContactDetailDaoImpl-updateBuildingContactForProcessStatus");
		getSqlSession().update("updateBuildingContactForProcessStatus", buildingContactDto);
	}

	@Override
	public int getBuildingContactCount(Integer processStatus) {
		logger.info("BuildingContactDetailDaoImpl-getBuildingContactCount");
		return getSqlSession().selectOne("getBuildingContactCount", processStatus);
	}
}
