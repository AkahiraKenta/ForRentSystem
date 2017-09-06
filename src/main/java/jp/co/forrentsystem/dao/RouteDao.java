package jp.co.forrentsystem.dao;

import java.util.List;

import jp.co.forrentsystem.dto.RouteDto;


/**
 * 沿線マスタDAO
 * @author k.akahira
 *
 */
public interface RouteDao {

	/**
	 * 全沿線を取得
	 *
	 * @return 沿線DTOリスト
	 */
	public abstract List<RouteDto> getAllRouteList();

	/**
	 * 沿線名称を取得
	 *
	 * @param nearestRoute1 沿線ID
	 *
	 * @return 沿線DTO
	 */
	public abstract RouteDto getRouteName(Integer nearestRoute1);

	/**
	 * 建物に紐付く沿線を取得
	 *
	 * @return 沿線DTOリスト
	 */
	public abstract List<RouteDto> getAllExistRouteList();

	/**
	 * 人気駅設定可能な沿線リストを取得
	 *
	 * @return 沿線DTOリスト
	 */
	public abstract List<RouteDto> getPopularityRouteList();


}
