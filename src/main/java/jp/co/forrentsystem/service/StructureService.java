package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.StructureDto;

/**
 * 構造処理サービス
 * @author k.akhaira
 *
 */
public interface StructureService {

	/**
	 * 建物構造リストを取得する処理
	 *
	 * @return 建物構造リスト
	 */
	public abstract List<StructureDto> getStructureList();

	/**
	 * 対象構造名称を取得する処理
	 *
	 * @param structureId 対象構造ID
	 *
	 * @return 対象構造名称
	 */
	public abstract StructureDto getStructureName(Integer structureId);

	/**
	 * 構造マスタを登録
	 *
	 * @return 構造マスタDTO
	 */
	public abstract StructureDto registStructure();

	/**
	 * 構造マスタを削除
	 *
	 * @param structureId 構造ID
	 *
	 * @return 構造ID
	 */
	public abstract int deleteStructure(Integer structureId);

	/**
	 * 構造マスタを更新
	 *
	 * @param structureId 構造ID
	 * @param structureName 構造名称
	 *
	 * @return 構造マスタDTO
	 */
	public abstract StructureDto updateStructure(Integer structureId,
			String structureName);
}
