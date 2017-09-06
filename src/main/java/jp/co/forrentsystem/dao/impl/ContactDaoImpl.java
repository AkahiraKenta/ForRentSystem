package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.ContactDao;
import jp.co.forrentsystem.dto.ContactDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDaoImpl extends SqlSessionDaoSupport implements ContactDao {

	@Override
	public void registContact(ContactDto contactDto) {
		logger.info("ContactDaoImpl-registContact");
		getSqlSession().insert("registContact", contactDto);
	}

	@Override
	public int getContactId() {
		logger.info("ContactDaoImpl-getContactId");
		return getSqlSession().selectOne("getContactId");
	}

	@Override
	public int getContactCount(Integer processStatus) {
		logger.info("ContactDaoImpl-getContactCount");
		return getSqlSession().selectOne("getContactCount", processStatus);
	}

	@Override
	public List<ContactDto> getContactList(ContactDto contactDto) {
		logger.info("ContactDaoImpl-getContactList");
		return getSqlSession().selectList("getContactList", contactDto);
	}

	@Override
	public List<ContactDto> getContactByContactId(int contactId) {
		logger.info("ContactDaoImpl-getContactByContactId");
		return getSqlSession().selectList("getContactByContactId", contactId);
	}

	@Override
	public void updateContactForProcessStatus(ContactDto contactDto) {
		logger.info("ContactDaoImpl-updateContactForProcessStatus");
		getSqlSession().update("updateContactForProcessStatus", contactDto);
	}
}
