package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.dao.FloorDao;
import jp.co.forrentsystem.dto.FloorDto;
import jp.co.forrentsystem.service.FloorService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 階数サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class FloorServiceImpl implements FloorService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FloorServiceImpl.class);

	@Autowired
	private FloorDao floorDao;

	@Override
	public List<FloorDto> getFloorList() {
		logger.info("FloorServiceImpl-getFloorList");
		// 階数情報を取得
		return floorDao.getFloorList();
	}

	@Override
	public FloorDto geFloorName(Integer floorClassId) {
		logger.info("FloorServiceImpl-geFloorName");
		// 階数区分IDをキーに階数情報を取得
		return floorDao.getFloorByFloorClassId(floorClassId);
	}
}
