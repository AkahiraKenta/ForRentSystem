package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.RouteDto;

/**
 * 沿線処理サービス
 * @author k.akhaira
 *
 */
public interface RouteService {

	/**
	 * 全沿線を取得
	 *
	 * @return 沿線DTOリスト
	 */
	public abstract List<RouteDto> getAllRouteList();

	/**
	 * 対象沿線名称を取得
	 *
	 * @param nearestRoute1 最寄駅１（沿線）
	 *
	 * @return 沿線DTO
	 */
	public abstract RouteDto getRouteName(Integer nearestRoute1);

	/**
	 * 建物と紐付いている沿線を取得
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
