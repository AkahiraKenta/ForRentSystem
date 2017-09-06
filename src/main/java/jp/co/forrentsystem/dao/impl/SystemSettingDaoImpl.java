package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.SystemSettingDao;
import jp.co.forrentsystem.dto.SystemSettingDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SystemSettingDaoImpl extends SqlSessionDaoSupport implements SystemSettingDao {

	@Override
	public List<SystemSettingDto> getSystemSettingList() {
		logger.info("SystemSettingDaoImpl-getSystemSettingList");
		return getSqlSession().selectList("getSystemSettingList");
	}

	@Override
	public void updateDisplayNumber(SystemSettingDto systemSettingDto) {
		logger.info("SystemSettingDaoImpl-updateDisplayNumber");
		getSqlSession().update("updateDisplayNumber", systemSettingDto);
	}

}
