package jp.co.forrentsystem.dto;

/**
 * 沿線DTO
 * @author k.akahira
 *
 */
public class RouteDto {
	/** 沿線ID */
	private Integer routeId;
	/** 沿線名称 */
	private String routeName;

	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
}
