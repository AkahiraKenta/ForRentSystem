package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dao.EquipmentDao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * ユーザマスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class EquipmentDaoImpl extends SqlSessionDaoSupport implements EquipmentDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EquipmentDaoImpl.class);

	@Override
	public List<MasterDto> getEquipmentList() {
		logger.info("EquipmentDaoImpl-getEquipmentList");
		return getSqlSession().selectList("getEquipmentList");
	}

	@Override
	public List<MasterDto> getEquipmentNameList(List<Integer> equipmentIdList) {
		logger.info("EquipmentDaoImpl-getEquipmentList");
		return getSqlSession().selectList("getEquipmentList", equipmentIdList);
	}


}
