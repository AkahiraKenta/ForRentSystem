package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.PopularityAreaDto;


/**
 * 人気エリアDAO
 * @author k.akahira
 *
 */
public interface PopularityAreaDao {

	/**
	 * 人気エリアを取得
	 *
	 * @return 人気エリアDTOリスト
	 */
	public abstract List<PopularityAreaDto> getPopularityAreaList();

	/**
	 * 順位の最大値を取得
	 *
	 * @return 順位の最大値
	 */
	public abstract Integer getRank();

	/**
	 * 人気エリア登録
	 *
	 * @param popularityAreaDto 人気エリア情報
	 */
	public abstract void registPopularityArea(
			PopularityAreaDto popularityAreaDto);

	/**
	 * 人気エリア情報を画面選択値を元に取得
	 *
	 * @param popularityAreaDto 人気エリアDTO
	 *
	 * @return 人気エリアDTO
	 */
	public abstract PopularityAreaDto getPopularityAreaByDto(
			PopularityAreaDto popularityAreaDto);

	/**
	 * 人気エリアを削除
	 *
	 * @param popularityAreaId 人気エリアID
	 */
	public abstract void deletePopularityArea(Integer popularityAreaId);

	/**
	 * 人気エリアIDをキーに人気エリア情報を取得
	 *
	 * @param popularityAreaId 人気エリアID
	 *
	 * @return 人気エリアDTO
	 */
	public abstract PopularityAreaDto getPopularityAreaByPopularitAreaId(
			Integer popularityAreaId);

	/**
	 * 人気エリアの順位を更新
	 *
	 * @param popularityAreaDto 人気エリアDTO
	 */
	public abstract void updateAreaRank(PopularityAreaDto popularityAreaDto);

	/**
	 * 人気エリア表示件数分の人気エリア情報を取得
	 *
	 * @param popularityAreaViewNumber 人気エリア表示件数
	 *
	 * @return 人気エリア情報DTOリスト
	 */
	public abstract List<PopularityAreaDto> getPopularityAreaListByViewNumber(Integer popularityAreaViewNumber);
}
