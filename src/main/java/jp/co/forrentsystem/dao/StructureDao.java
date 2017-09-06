package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.StructureDto;

public interface StructureDao {

	/**
	 * 構造情報を全て取得
	 *
	 * @return 構造リスト
	 */
	public abstract List<StructureDto> getStructure();

	/**
	 * 対象構造情報を取得
	 *
	 * @param structureId 対象構造ID
	 *
	 * @return 対象構造名称
	 */
	public abstract StructureDto getStructureByStructureId(Integer structureId);

	/**
	 * 構造マスタを登録
	 *
	 * @param structureDto 構造マスタDTO
	 */
	public abstract void registStructure(StructureDto structureDto);

	/**
	 * 登録した構造マスタ情報を取得
	 *
	 * @return 構造マスタ情報
	 */
	public abstract StructureDto getStructureByMaxStructureId();

	/**
	 * 構造マスタを削除
	 *
	 * @param structureId 構造マスタID
	 */
	public abstract void deleteStructure(Integer structureId);

	/**
	 * 構造マスタを更新
	 *
	 * @param structureDto 構造マスタDTO
	 */
	public abstract void updateStructure(StructureDto structureDto);
}
