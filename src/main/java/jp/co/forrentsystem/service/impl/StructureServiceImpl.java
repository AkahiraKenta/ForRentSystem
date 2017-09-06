package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.dao.StructureDao;
import jp.co.forrentsystem.dto.StructureDto;
import jp.co.forrentsystem.service.StructureService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 構造サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class StructureServiceImpl implements StructureService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(StructureServiceImpl.class);

	@Autowired
	private StructureDao structureDao;

	@Override
	public List<StructureDto> getStructureList() {
		logger.info("StructureServiceImpl-getBuildingStructureList");

		// 構造情報を取得
		return structureDao.getStructure();
	}

	@Override
	public StructureDto getStructureName(Integer structureId) {
		logger.info("StructureServiceImpl-getStructureName");

		// 構造IDをキーに構造情報を取得
		return structureDao.getStructureByStructureId(structureId);
	}

	@Override
	public StructureDto registStructure() {
		logger.info("StructureServiceImpl-registStructure");

		StructureDto structureDto = new StructureDto();
		structureDto.setDeleteFlag(0);

		// 構造マスタ情報を登録
		structureDao.registStructure(structureDto);

		return structureDao.getStructureByMaxStructureId();
	}

	@Override
	public int deleteStructure(Integer structureId) {
		logger.info("StructureServiceImpl-deleteStructure");

		// 構造マスタ情報を削除
		structureDao.deleteStructure(structureId);
		return structureId;
	}

	@Override
	public StructureDto updateStructure(Integer structureId,
			String structureName) {
		logger.info("StructureServiceImpl-updateStructure");

		StructureDto structureDto = new StructureDto();
		structureDto.setStructureId(structureId);
		structureDto.setStructureName(structureName);
		structureDto.setDeleteFlag(0);

		// 構造マスタを更新
		structureDao.updateStructure(structureDto);

		return structureDto;
	}
}
