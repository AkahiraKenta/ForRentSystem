package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dao.GoodForConditionDao;
import jp.co.forrentsystem.dto.GoodForConditionDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class GoodForConditionDaoImpl extends SqlSessionDaoSupport implements GoodForConditionDao {

	@Override
	public List<MasterDto> getGoodForConditionList() {
		logger.info("GoodConditionDaoImpl-getGoodForConditionList");
		return getSqlSession().selectList("getStructure");
	}

	@Override
	public List<MasterDto> getGoodForConditionNameList(List<Integer> conditionNameIdList) {
		logger.info("GoodConditionDaoImpl-getGoodForConditionNameList");
		return getSqlSession().selectOne("getStructureByStructureId", conditionNameIdList);
	}

	@Override
	public List<GoodForConditionDto> getGoodForConditionListOrderByDisplayNumber() {
		logger.info("GoodConditionDaoImpl-getGoodForConditionListOrderByDisplayNumber");
		return getSqlSession().selectList("getGoodForConditionListOrderByDisplayNumber");
	}

	@Override
	public int getGoodForConditionMaxDisplayNumber() {
		logger.info("GoodConditionDaoImpl-getGoodForConditionMaxDisplayNumber");
		return getSqlSession().selectOne("getGoodForConditionMaxDisplayNumber");
	}

	@Override
	public void registGoodForCondition(GoodForConditionDto goodForConditionDto) {
		logger.info("GoodConditionDaoImpl-registGoodForCondition");
		getSqlSession().insert("registGoodForCondition", goodForConditionDto);
	}

	@Override
	public void deleteGoodForCondition(Integer conditionId) {
		logger.info("GoodConditionDaoImpl-deleteGoodForCondition");
		getSqlSession().insert("deleteGoodForCondition", conditionId);

	}

	@Override
	public void updateGoodForCondition(GoodForConditionDto goodForConditionDto) {
		logger.info("GoodConditionDaoImpl-updateGoodForCondition");
		getSqlSession().update("updateGoodForCondition", goodForConditionDto);
	}

	@Override
	public void updateGoodForConditionDisplayNumber(
			GoodForConditionDto goodForConditionDto) {
		logger.info("GoodConditionDaoImpl-updateGoodForConditionDisplayNumber");
		getSqlSession().update("updateGoodForConditionDisplayNumber", goodForConditionDto);
	}
}
