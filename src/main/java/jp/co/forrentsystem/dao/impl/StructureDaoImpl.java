package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.StructureDao;
import jp.co.forrentsystem.dto.StructureDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class StructureDaoImpl extends SqlSessionDaoSupport implements StructureDao {

	@Override
	public List<StructureDto> getStructure() {
		logger.info("StructureDaoImpl-getStructure");
		return getSqlSession().selectList("getStructure");
	}

	@Override
	public StructureDto getStructureByStructureId(Integer structureId) {
		logger.info("StructureDaoImpl-getStructureByStructureId");
		return getSqlSession().selectOne("getStructureByStructureId", structureId);
	}

	@Override
	public void registStructure(StructureDto structureDto) {
		logger.info("StructureDaoImpl-registStructure");
		getSqlSession().insert("registStructure", structureDto);
	}

	@Override
	public StructureDto getStructureByMaxStructureId() {
		logger.info("StructureDaoImpl-getStructureByMaxStructureId");
		return getSqlSession().selectOne("getStructureByMaxStructureId");
	}
	@Override
	public void deleteStructure(Integer structureId) {
		logger.info("StructureDaoImpl-deleteStructure");
		getSqlSession().delete("deleteStructure", structureId);
	}

	@Override
	public void updateStructure(StructureDto structureDto) {
		logger.info("StructureDaoImpl-updateStructure");
		 getSqlSession().update("updateStructure", structureDto);
	}
}
