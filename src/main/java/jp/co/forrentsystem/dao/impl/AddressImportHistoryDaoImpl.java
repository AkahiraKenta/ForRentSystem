package jp.co.forrentsystem.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 住所取込履歴DAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class AddressImportHistoryDaoImpl extends SqlSessionDaoSupport implements AddressImportHistoryDao {

//	private Logger logger = org.slf4j.LoggerFactory.getLogger(AddressImportHistoryDaoImpl.class);
//
//	@Override
//	public AddressImportHistoryDto getAddressImportHistoryToMaxYears() {
//		logger.info("AddressImportHistoryDaoImpl-getAddressImportHistoryToMaxYears");
//		return getSqlSession().selectOne("getAddressImportHistoryToMaxYears");
//	}
//
//	@Override
//	public void insert(AddressImportHistoryDto addressImportHistoryDto) {
//		logger.info("AddressImportHistoryDaoImpl-insert");
//
//	}

}
