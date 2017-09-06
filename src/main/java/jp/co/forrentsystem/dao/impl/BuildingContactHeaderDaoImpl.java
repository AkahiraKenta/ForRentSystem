package jp.co.forrentsystem.dao.impl;

import jp.co.forrentsystem.dao.BuildingContactHeaderDao;
import jp.co.forrentsystem.dto.BuildingContactDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BuildingContactHeaderDaoImpl extends SqlSessionDaoSupport implements BuildingContactHeaderDao {

	@Override
	public void registBuildingContactHeader(
			BuildingContactDto buildingContactDto) {
		logger.info("BuildingContactHeaderDaoImpl-registBuildingContactHeader");
		getSqlSession().insert("registBuildingContactHeader", buildingContactDto);
	}
}
