package jp.co.forrentsystem.form.backend;

import jp.co.forrentsystem.util.PagerForm;


/**
 * 建物一覧用Formクラス
 * @author k.akahira
 *
 */
public class ListBuildingForm extends PagerForm {

	/** 建物ID */
	private Integer buildingId;
	/** 建物コード */
	private String buildingCode;
	/** 建物名称 */
	private String buildingName;
	/** 建物種別 */
	private Integer buildingType;
	/** 建物種別（名称) */
	private String buildingTypeName;
	/** 沿線 */
	private Integer route;
	/** 沿線名称 */
	private String routeName;
	/** 駅 */
	private Integer station;
	/** 駅名称 */
	private String stationName;
	/** 最寄駅1(徒歩分) */
	private Integer minutesWalk;
	/** 郵便番号 */
	private String zipCode;
	/** 都道府県 */
	private String province;
	/** 市区町村コード */
	private String CityName;
	/** 市区町村 */
	private String city;
	/** 築年数（年） */
	private Integer builtYear;
	/** 画面遷移元
	 *  0:メニュー＞建物一覧
	 *  1:建物検索＞建物一覧
	 */
	private Integer buildingListFlag;

	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingCode() {
		return buildingCode;
	}
	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public Integer getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(Integer buildingType) {
		this.buildingType = buildingType;
	}
	public String getBuildingTypeName() {
		return buildingTypeName;
	}
	public void setBuildingTypeName(String buildingTypeName) {
		this.buildingTypeName = buildingTypeName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String CityName) {
		this.CityName = CityName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getRoute() {
		return route;
	}
	public void setRoute1(Integer route) {
		this.route = route;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public Integer getStation() {
		return station;
	}
	public void setStation(Integer station) {
		this.station = station;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
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
	public Integer getBuildingListFlag() {
		return buildingListFlag;
	}
	public void setBuildingListFlag(Integer buildingListFlag) {
		this.buildingListFlag = buildingListFlag;
	}
}