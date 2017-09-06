package jp.co.forrentsystem.dto;

import java.util.List;

import jp.co.forrentsystem.util.PagerDto;


/**
 * 検索条件DTO
 * @author k.akahira
 *
 */
public class SearchConditionDto extends PagerDto{

	/** 沿線IDリスト */
	private List<Integer> routeIdList;
	/** 駅IDリスト */
	private List<Integer> stationIdList;
	/** 都道府県リスト */
	private List<String> provinceList;
	/** 市区町村リスト */
	private List<String> cityList;
	/** 町域リスト */
	private List<String> townAreaList;
	/** 建物種別リスト */
	private List<Integer> buildingTypeList;
	/** 設備リスト */
	private List<Integer> equipmentList;
	/** 賃料From */
	private Integer rentFrom;
	/** 賃料To */
	private Integer rentTo;
	/** 間取り */
	private List<Integer> floorPlanIdList;
	/** 駅徒歩分 */
	private Integer minutesWalk;
	/** 築年数(年) */
	private Integer builtYear;
	/** 築年数(月) */
	private Integer builtMonth;
	/** こだわり条件 */
	private List<Integer> goodForConditionList;
	/** ソート順ID */
	private Integer sortArticleId;

	public List<Integer> getRouteIdList() {
		return routeIdList;
	}
	public void setRouteIdList(List<Integer> routeIdList) {
		this.routeIdList = routeIdList;
	}
	public List<Integer> getStationIdList() {
		return stationIdList;
	}
	public void setStationIdList(List<Integer> stationIdList) {
		this.stationIdList = stationIdList;
	}
	public List<String> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<String> provinceList) {
		this.provinceList = provinceList;
	}
	public List<String> getCityList() {
		return cityList;
	}
	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}
	public List<String> getTownAreaList() {
		return townAreaList;
	}
	public void setTownAreaList(List<String> townAreaList) {
		this.townAreaList = townAreaList;
	}
	public List<Integer> getBuildingTypeList() {
		return buildingTypeList;
	}
	public void setBuildingTypeList(List<Integer> buildingTypeList) {
		this.buildingTypeList = buildingTypeList;
	}
	public List<Integer> getEquipmentList() {
		return equipmentList;
	}
	public void setEquipmentList(List<Integer> equipmentList) {
		this.equipmentList = equipmentList;
	}
	public Integer getRentFrom() {
		return rentFrom;
	}
	public void setRentFrom(Integer rentFrom) {
		this.rentFrom = rentFrom;
	}
	public Integer getRentTo() {
		return rentTo;
	}
	public void setRentTo(Integer rentTo) {
		this.rentTo = rentTo;
	}
	public List<Integer> getFloorPlanIdList() {
		return floorPlanIdList;
	}
	public void setFloorPlanIdList(List<Integer> floorPlanIdList) {
		this.floorPlanIdList = floorPlanIdList;
	}
	public Integer getMinutesWalk() {
		return minutesWalk;
	}
	public void setMinutesWalk(Integer minutesWalk) {
		this.minutesWalk = minutesWalk;
	}
	public Integer getBuiltYear() {
		return builtYear;
	}
	public void setBuiltYear(Integer builtYear) {
		this.builtYear = builtYear;
	}
	public Integer getBuiltMonth() {
		return builtMonth;
	}
	public void setBuiltMonth(Integer builtMonth) {
		this.builtMonth = builtMonth;
	}
	public List<Integer> getGoodForConditionList() {
		return goodForConditionList;
	}
	public void setGoodForConditionList(List<Integer> goodForConditionList) {
		this.goodForConditionList = goodForConditionList;
	}
	public Integer getSortArticleId() {
		return sortArticleId;
	}
	public void setSortArticleId(Integer sortArticleId) {
		this.sortArticleId = sortArticleId;
	}
}
