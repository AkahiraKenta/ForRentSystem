package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.dao.SystemUserDao;
import jp.co.forrentsystem.dto.SystemUserDto;
import jp.co.forrentsystem.form.backend.SystemUserForm;
import jp.co.forrentsystem.service.SystemUserService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * システムユーザマスタサービス実装クラス
 * @author k.akahira
 *
 */
@Service
public class SystemUserServiceImpl implements SystemUserService{

	private Logger logger = org.slf4j.LoggerFactory.getLogger(SystemUserServiceImpl.class);

	@Autowired
	private SystemUserDao systemUserDao;

	@Override
	public SystemUserDto login(String systemUserId, String systemUserPassword) {
		logger.info("SystemUserServiceImpl-login");

		// システムユーザ情報を取得
		SystemUserDto systemUserDto = systemUserDao.getSystemUserLoginId(systemUserId);
		if (systemUserDto == null) {
			// データが取得できなかった場合
			systemUserDto = null;
		} else if (!StringUtils.equals(systemUserDto.getSystemUserPassword(), systemUserPassword)) {
			// ユーザパスワードが一致しなかった場合
			systemUserDto = null;
		}
		return systemUserDto;
	}

	@Override
	public List<SystemUserDto> getSystemUserList() {
		logger.info("SystemUserServiceImpl-getSystemUserList");
		return systemUserDao.getSystemUserList();
	}

	@Override
	public SystemUserForm getTargetSystemUser(int systemUserId) {
		logger.info("SystemUserServiceImpl-getTargetSystemUser");
		return convertFormToDto(systemUserDao.getTargetSystemUser(systemUserId));
	}

	@Override
	public void registSystemUser(SystemUserForm systemUserForm) {
		logger.info("SystemUserServiceImpl-registSystemUser");
		systemUserDao.registSystemUser(convertDtoToForm(systemUserForm));
	}

	@Override
	public void updateSystemUser(SystemUserForm systemUserForm) {
		logger.info("SystemUserServiceImpl-updateSystemUser");
		systemUserDao.updateSystemUser(convertDtoToForm(systemUserForm));
	}

	@Override
	public boolean checkAvailableLoginId(String loginId) {
		logger.info("SystemUserServiceImpl-checkAvailableLoginId");

		// TODO 削除済みのユーザー情報の考慮はどうするか

		boolean result = false;

		// システムユーザ情報を取得
		SystemUserDto systemUserDto = systemUserDao.getSystemUserLoginId(loginId);

		if (systemUserDto == null) {
			result = true;
		}

		return result;
	}

	@Override
	public void deleteTargetSystemUser(int systemUserId) {
		logger.info("SystemUserServiceImpl-deletetargetSystemUser");

		// システムユーザ情報を削除
		systemUserDao.deleteSystemUser(systemUserId);
	}


	/**
	 * Dto → Form
	 * @param systemUserForm
	 * @return
	 */
	private SystemUserDto convertDtoToForm(SystemUserForm systemUserForm) {
		SystemUserDto systemUserDto = new SystemUserDto();

		systemUserDto.setSystemUserName(systemUserForm.getSystemUserName());
		systemUserDto.setSystemUserPassword(systemUserForm.getSystemUserPassword());
		systemUserDto.setSystemUserLoginId(systemUserForm.getSystemUserLoginId());
		systemUserDto.setSystemUserClass(systemUserForm.getSystemUserClass());
		systemUserDto.setSystemUserAddress(systemUserForm.getSystemUserAddress());
		systemUserDto.setAvailableFlag(systemUserForm.getAvailableFlag());
		systemUserDto.setSystemUserId(systemUserForm.getSystemUserId());
		systemUserDto.setCreated(systemUserForm.getCreated());
		systemUserDto.setModified(systemUserForm.getModified());

		return systemUserDto;

	}

	/**
	 * Form → Dto
	 * @param systemUserDto
	 * @return
	 */
	private SystemUserForm convertFormToDto(SystemUserDto systemUserDto) {
		SystemUserForm systemUserForm =  new SystemUserForm();

		systemUserForm.setCreated(systemUserDto.getCreated());
		systemUserForm.setAvailableFlag(systemUserDto.getAvailableFlag());
		systemUserForm.setModified(systemUserDto.getModified());
		systemUserForm.setSystemUserAddress(systemUserDto.getSystemUserAddress());
		systemUserForm.setSystemUserClass(systemUserDto.getSystemUserClass());
		systemUserForm.setSystemUserId(systemUserDto.getSystemUserId());
		systemUserForm.setSystemUserLoginId(systemUserDto.getSystemUserLoginId());
		systemUserForm.setSystemUserName(systemUserDto.getSystemUserName());
		systemUserForm.setSystemUserPassword(systemUserDto.getSystemUserPassword());
		systemUserForm.setSystemUserPasswordConfirm(systemUserDto.getSystemUserPassword());

		return systemUserForm;
	}

	@Override
	public boolean checkSystemUserPassword(SystemUserForm systemUserForm) {
		logger.info("SystemUserServiceImpl-checkSystemUserPassword");

		SystemUserDto systemUserDto = systemUserDao.getTargetSystemUser(systemUserForm.getSystemUserId());

		if (!StringUtils.equals(systemUserForm.getSystemUserPassword(),systemUserDto.getSystemUserPassword())) {
			// 不一致
			return false;
		}
		return true;
	}

	@Override
	public void updateSystemUserForPassword(SystemUserForm systemUserForm) {
		logger.info("SystemUserServiceImpl-updateSystemUserForPassword");

		SystemUserDto systemUserDto = new SystemUserDto();
		systemUserDto.setSystemUserId(systemUserForm.getSystemUserId());
		systemUserDto.setSystemUserPassword(systemUserForm.getSystemUserNewPassword());

		systemUserDao.updateSystemUserForPassword(systemUserDto);
	}
}
