package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dao.GoodForConditionDao;
import jp.co.forrentsystem.dto.GoodForConditionDto;
import jp.co.forrentsystem.service.GoodForConditionService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * こだわり条件サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class GoodForConditionServiceImpl implements GoodForConditionService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(GoodForConditionServiceImpl.class);

	@Autowired
	private GoodForConditionDao goodForConditionDao;

	@Override
	public List<MasterDto> getGoodForConditionList() {
		logger.info("GoodForConditionServiceImpl-getGoodForConditionList");
		// こだわり条件情報を取得
		return goodForConditionDao.getGoodForConditionList();
	}

	@Override
	public List<MasterDto> getGoodForConditionNameList(List<Integer> conditionNameIdList) {
		logger.info("GoodForConditionServiceImpl-getGoodForConditionNameList");
		// こだわり条件名称を取得
		return goodForConditionDao.getGoodForConditionNameList(conditionNameIdList);
	}

	@Override
	public List<GoodForConditionDto> getGoodForConditionListOrderByDisplayNumber() {
		logger.info("GoodForConditionServiceImpl-getGoodForConditionListOrderByDisplayNumber");
		// 表示順にこだわり条件を取得
		return goodForConditionDao.getGoodForConditionListOrderByDisplayNumber();
	}

	@Override
	public GoodForConditionDto registGoodForCondition() {
		logger.info("GoodForConditionServiceImpl-registGoodForCondition");
		// こだわり条件の表示順の最大値+1を取得する
		int maxDisplayNumber = goodForConditionDao.getGoodForConditionMaxDisplayNumber();

		// こだわり条件情報をDTOに設定する
		GoodForConditionDto goodForConditionDto = new GoodForConditionDto();
		goodForConditionDto.setConditionName("");
		goodForConditionDto.setDisplayNumber(maxDisplayNumber);
		goodForConditionDto.setDeleteFlag(0);

		// こだわり条件を登録する
		goodForConditionDao.registGoodForCondition(goodForConditionDto);

		return goodForConditionDto;
	}

	@Override
	public void deleteGoodForCondition(Integer conditionId) {
		logger.info("GoodForConditionServiceImpl-deleteGoodForCondition");

		// こだわり条件を削除
		goodForConditionDao.deleteGoodForCondition(conditionId);

		// 現在のこだわり条件マスタ情報を取得
		List<GoodForConditionDto> goodForConditionist = goodForConditionDao.getGoodForConditionListOrderByDisplayNumber();

		// こだわり条件リストから削除対象こだわり条件を取り除く
		for (GoodForConditionDto goodForConditionDto : goodForConditionist) {
			if (goodForConditionDto.getConditionId() == conditionId) {
				goodForConditionist.remove(goodForConditionDto);
				break;
			}
		}

		// こだわり条件に順位を振り直し、更新
		for (int i = 0; i < goodForConditionist.size(); i++) {
			// 人気駅の順位をupdate
			goodForConditionist.get(i).setDisplayNumber(i+1);
			goodForConditionDao.updateGoodForConditionDisplayNumber(goodForConditionist.get(i));
		}
	}

	@Override
	public void updateGoodForCondition(Integer conditionId, String conditionName) {
		logger.info("GoodForConditionServiceImpl-updateGoodForCondition");
		// こだわり条件情報をDTOに設定する
		GoodForConditionDto goodForConditionDto = new GoodForConditionDto();
		goodForConditionDto.setConditionId(conditionId);
		goodForConditionDto.setConditionName(conditionName);

		// こだわり条件を更新する
		goodForConditionDao.updateGoodForCondition(goodForConditionDto);
	}

	@Override
	public void updateGoodForConditionDisplayNumber(String[] conditionId) {
		logger.info("GoodForConditionServiceImpl-updateGoodForConditionDisplayNumber");

		for(int i = 0; i < conditionId.length; i++) {
			// こだわり条件情報をDTOに設定する
			GoodForConditionDto goodForConditionDto = new GoodForConditionDto();
			goodForConditionDto.setConditionId(Integer.parseInt(conditionId[i]));
			goodForConditionDto.setDisplayNumber(i+1);

			// こだわり条件の表示順を更新する
			goodForConditionDao.updateGoodForConditionDisplayNumber(goodForConditionDto);
		}
	}
}
