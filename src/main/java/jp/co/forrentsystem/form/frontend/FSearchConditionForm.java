package jp.co.forrentsystem.form.frontend;

import jp.co.forrentsystem.util.PagerForm;


/**
 * 検索条件Form
 * @author k.akahira
 *
 */
public class FSearchConditionForm  extends PagerForm {

	/** 沿線ID */
	private Integer routeId;
	/** 駅ID配列 */
	private String[] selectedStationId;
	/** 都道府県 */
	private String province;
	/** 市区町村 */
	private String city;
	/** 町域 */
	private String[] selectedTownArea;
	/** 建物種別 */
	private String[] selectedBuildingType;
	/** 設備 */
	private String[] selectedEquipment;
	/** 賃料FROM */
	private Integer rentFromClassId;
	/** 賃料TO */
	private Integer rentToClassId;
	/** 間取り */
	private String[] selectedFloorPlan;
	/** 駅徒歩 */
	private Integer selectedMinutesWalkClass;
	/** 築年数 */
	private Integer selectedBuiltClass;
	/** こだわり条件 */
	private String[] selectedGoodForCondition;
	/** ソート順 */
	private Integer sortArticleId;

	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public String[] getSelectedStationId() {
		return selectedStationId;
	}
	public void setSelectedStationId(String[] selectedStationId) {
		this.selectedStationId = selectedStationId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String[] getSelectedTownArea() {
		return selectedTownArea;
	}
	public void setSelectedTownArea(String[] selectedTownArea) {
		this.selectedTownArea = selectedTownArea;
	}
	public String[] getSelectedBuildingType() {
		return selectedBuildingType;
	}
	public void setSelectedBuildingType(String[] selectedBuildingType) {
		this.selectedBuildingType = selectedBuildingType;
	}
	public String[] getSelectedEquipment() {
		return selectedEquipment;
	}
	public void setSelectedEquipment(String[] selectedEquipment) {
		this.selectedEquipment = selectedEquipment;
	}
	public Integer getRentFromClassId() {
		return rentFromClassId;
	}
	public void setRentFromClassId(Integer rentFromClassId) {
		this.rentFromClassId = rentFromClassId;
	}
	public Integer getRentToClassId() {
		return rentToClassId;
	}
	public void setRentToClassId(Integer rentToClassId) {
		this.rentToClassId = rentToClassId;
	}
	public String[] getSelectedFloorPlan() {
		return selectedFloorPlan;
	}
	public void setSelectedFloorPlan(String[] selectedFloorPlan) {
		this.selectedFloorPlan = selectedFloorPlan;
	}
	public Integer getSelectedMinutesWalkClass() {
		return selectedMinutesWalkClass;
	}
	public void setSelectedMinutesWalkClass(Integer selectedMinutesWalkClass) {
		this.selectedMinutesWalkClass = selectedMinutesWalkClass;
	}
	public Integer getSelectedBuiltClass() {
		return selectedBuiltClass;
	}
	public void setSelectedBuiltClass(Integer selectedBuiltClass) {
		this.selectedBuiltClass = selectedBuiltClass;
	}

	public String[] getSelectedGoodForCondition() {
		return selectedGoodForCondition;
	}
	public void setSelectedGoodForCondition(String[] selectedGoodForCondition) {
		this.selectedGoodForCondition = selectedGoodForCondition;
	}
	public Integer getSortArticleId() {
		return sortArticleId;
	}
	public void setSortArticleId(Integer sortArticleId) {
		this.sortArticleId = sortArticleId;
	}
}
