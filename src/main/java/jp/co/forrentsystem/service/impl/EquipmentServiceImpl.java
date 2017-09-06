package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dao.EquipmentDao;
import jp.co.forrentsystem.service.EquipmentService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 設備サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EquipmentServiceImpl.class);

	@Autowired
	private EquipmentDao equipmentDao;

	@Override
	public List<MasterDto> getEquipmentList() {
		logger.info("EquipmentServiceImpl-getEquipmentList");

		// 設備情報取得
		return equipmentDao.getEquipmentList();
	}
}
