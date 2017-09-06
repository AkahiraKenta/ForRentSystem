package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.SystemUserDao;
import jp.co.forrentsystem.dto.SystemUserDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * システムユーザマスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class SystemUserDaoImpl extends SqlSessionDaoSupport implements SystemUserDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(SystemUserDaoImpl.class);

	@Override
	public SystemUserDto getSystemUserLoginId(String systemUserLoginId) {
		logger.info("SystemUserDaoImpl-getLoginId");
		return getSqlSession().selectOne("getSystemUserLoginId", systemUserLoginId);
	}

	@Override
	public List<SystemUserDto> getSystemUserList() {
		logger.info("SystemUserDaoImpl-getSystemUserList");
		return getSqlSession().selectList("getSystemUserList");
	}

	@Override
	public SystemUserDto getTargetSystemUser(int systemUserId) {
		logger.info("SystemUserDaoImpl-getTargetSystemUser");
		return getSqlSession().selectOne("getTargetSystemUser", systemUserId);
	}

	@Override
	public void registSystemUser(SystemUserDto systemUserDto) {
		logger.info("SystemUserDaoImpl-registSystemUser");
		getSqlSession().insert("registSystemUser", systemUserDto);
	}

	@Override
	public void updateSystemUser(SystemUserDto systemUserDto) {
		logger.info("SystemUserDaoImpl-updateSystemUser");
		getSqlSession().update("updateSystemUser", systemUserDto);

	}

	@Override
	public void deleteSystemUser(int systemUserId) {
		logger.info("SystemUserDaoImpl-deleteSystemUser");
		getSqlSession().update("deleteSystemUser", systemUserId);
	}

	@Override
	public void updateSystemUserForPassword(SystemUserDto systemUserDto) {
		logger.info("SystemUserDaoImpl-updateSystemUserForPassword");
		getSqlSession().update("updateSystemUserForPassword", systemUserDto);
	}

}
