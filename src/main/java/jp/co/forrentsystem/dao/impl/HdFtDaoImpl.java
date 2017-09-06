package jp.co.forrentsystem.dao.impl;

import jp.co.forrentsystem.dao.HdFtDao;
import jp.co.forrentsystem.dto.HdFtDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * ヘッダーフッターマスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class HdFtDaoImpl extends SqlSessionDaoSupport implements HdFtDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(HdFtDaoImpl.class);

	@Override
	public HdFtDto getHdFt() {
		logger.info("HdFtDaoImpl-getHdFt");
		return getSqlSession().selectOne("getHdFt");
	}

	@Override
	public void updateHdFt(HdFtDto hdFtDto) {
		logger.info("HdFtDaoImpl-updateHdFt");
		getSqlSession().update("updateHdFt", hdFtDto);
	}
}
