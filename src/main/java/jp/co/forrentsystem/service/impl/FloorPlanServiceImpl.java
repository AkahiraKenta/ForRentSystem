package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.dao.FloorPlanDao;
import jp.co.forrentsystem.dto.FloorPlanDto;
import jp.co.forrentsystem.service.FloorPlanService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 間取りサービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class FloorPlanServiceImpl implements FloorPlanService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FloorPlanServiceImpl.class);

	@Autowired
	private FloorPlanDao floorPlanDao;

	@Override
	public List<FloorPlanDto> getFloorPlanList() {
		logger.info("FloorPlanServiceImpl-getFloorPlanList");
		// 間取り情報を取得
		return floorPlanDao.getFloorPlanList();
	}

	@Override
	public FloorPlanDto geFloorPlanName(Integer floorPlanId) {
		logger.info("FloorPlanServiceImpl-geFloorPlanName");
		// 間取りIDをキーに間取り情報を取得
		return floorPlanDao.getFloorPlanByFloorPlanId(floorPlanId);
	}

	@Override
	public FloorPlanDto registFloorPlan() {
		logger.info("FloorPlanServiceImpl-registFloorPlan");
		FloorPlanDto floorPlanDto = new FloorPlanDto();

		// 間取り情報を登録
		floorPlanDao.registFloorPlan(floorPlanDto);

		// 登録した間取り情報を返却
		return  floorPlanDao.getFloorPlanByMaxFloorPlanId();
	}

	@Override
	public Integer deleteFloorPlan(Integer floorPlanId) {
		logger.info("FloorPlanServiceImpl-deleteFloorPlan");
		// 間取り情報を削除
		floorPlanDao.deleteFloorPlan(floorPlanId);

		// 削除した間取りIDを返却
		return floorPlanId;
	}

	@Override
	public FloorPlanDto updateFloorPlan(Integer floorPlanId, String floorPlanName) {
		logger.info("FloorPlanServiceImpl-updateFloorPlan");

		// 間取り情報をDTOに設定
		FloorPlanDto floorPlanDto = new FloorPlanDto();
		floorPlanDto.setFloorPlanId(floorPlanId);
		floorPlanDto.setFloorPlanName(floorPlanName);

		// 間取り情報を更新
		floorPlanDao.updateFloorPlan(floorPlanDto);

		// 更新した間取り情報を返却
		return floorPlanDao.getFloorPlanByFloorPlanId(floorPlanId);
	}
}
