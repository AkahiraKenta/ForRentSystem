package jp.co.forrentsystem.form.backend;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * 建物登録用Formクラス
 * @author k.akahira
 */
public class RegistBuildingForm {

	/** 建物ID */
	private Integer buildingId;
	@NotEmpty
	/** 建物コード */
	private String buildingCode;
	@NotEmpty
	/** 建物名称 */
	private String buildingName;
	/** 建物種別 */
	private Integer buildingType;
	/** 建物種別（名称) */
	private String buildingTypeName;
	/** 建物種別（値） */
	private Integer buildingTypeValue;
	/** 郵便番号 */
	private String zipCode;
	/** 都道府県 */
	private String province;
	/** 市区町村コード */
	private String CityName;
	/** 市区町村 */
	private String city;
	/** 町域コード */
	private String townAreaName;
	/** 町域 */
	private String townArea;
	/** 町域以下 */
	private String townAreaBelow;
	/** 最寄駅1(沿線） */
	private Integer nearestRoute1;
	/** 最寄駅1(沿線）名称 */
	private String nearestRouteName1;
	/** 最寄駅1(駅) */
	private Integer nearestStation1;
	/** 最寄駅1(駅)名称 */
	private String nearestStationName1;
	/** 最寄駅1(徒歩分) */
	@Min(1)
	@Max(999)
	private Integer minutesWalk1;
	/** 最寄駅1表示順 */
	private Integer displayNumber1;
	/** 最寄駅2(沿線） */
	private Integer nearestRoute2;
	/** 最寄駅2(沿線）名称 */
	private String nearestRouteName2;
	/** 最寄駅2(駅） */
	private Integer nearestStation2;
	/** 最寄駅2(駅）名称 */
	private String nearestStationName2;
	/** 最寄駅2(徒歩分) */
	@Min(1)
	@Max(999)
	private Integer minutesWalk2;
	/** 最寄駅2表示順 */
	private Integer displayNumber2;
	/** 最寄駅3(沿線） */
	private Integer nearestRoute3;
	/** 最寄駅3(沿線）名称 */
	private String nearestRouteName3;
	/** 最寄駅3(駅） */
	private Integer nearestStation3;
	/** 最寄駅3(駅）名称 */
	private String nearestStationName3;
	/** 最寄駅3(徒歩分) */
	@Min(1)
	@Max(999)
	private Integer minutesWalk3;
	/** 最寄駅3表示順 */
	private Integer displayNumber3;
	/** GEOコード */
	private Double geoCode;
	/** 緯度 */
	private Double latitude;
	/** 経度 */
	private Double longitude;
	/** 築年数（年） */
	@Min(1900)
	@Max(9999)
	private Integer builtYear;
	/** 築年数（月） */
	@Min(1)
	@Max(12)
	private Integer builtMonth;
	/** 階建 */
	private Integer numberOfStoreys;
	/** 構造 */
	private Integer structureId;
	/** 構造（名称) */
	private String structureName;
	/** 建物PRタイトル */
	@NotEmpty
	private String prTitle;
	/** 建物PR詳細 */
	private String prDetail;

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
	public Integer getBuildingTypeValue() {
		return buildingTypeValue;
	}
	public void setBuildingTypeValue(Integer buildingTypeValue) {
		this.buildingTypeValue = buildingTypeValue;
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
	public String getTownAreaName() {
		return townAreaName;
	}
	public void setTownAreaName(String townAreaName) {
		this.townAreaName = townAreaName;
	}
	public String getTownArea() {
		return townArea;
	}
	public void setTownArea(String townArea) {
		this.townArea = townArea;
	}
	public String getTownAreaBelow() {
		return townAreaBelow;
	}
	public void setTownAreaBelow(String townAreaBelow) {
		this.townAreaBelow = townAreaBelow;
	}
	public Integer getNearestRoute1() {
		return nearestRoute1;
	}
	public void setNearestRoute1(Integer nearestRoute1) {
		this.nearestRoute1 = nearestRoute1;
	}
	public String getNearestRouteName1() {
		return nearestRouteName1;
	}
	public void setNearestRouteName1(String nearestRouteName1) {
		this.nearestRouteName1 = nearestRouteName1;
	}
	public Integer getNearestStation1() {
		return nearestStation1;
	}
	public void setNearestStation1(Integer nearestStation1) {
		this.nearestStation1 = nearestStation1;
	}
	public String getNearestStationName1() {
		return nearestStationName1;
	}
	public void setNearestStationName1(String nearestStationName1) {
		this.nearestStationName1 = nearestStationName1;
	}
	public Integer getMinutesWalk1() {
		return minutesWalk1;
	}
	public void setMinutesWalk1(Integer minutesWalk1) {
		this.minutesWalk1 = minutesWalk1;
	}
	public Integer getDisplayNumber1() {
		return displayNumber1;
	}
	public void setDisplayNumber1(Integer displayNumber1) {
		this.displayNumber1 = displayNumber1;
	}
	public Integer getNearestRoute2() {
		return nearestRoute2;
	}
	public void setNearestRoute2(Integer nearestRoute2) {
		this.nearestRoute2 = nearestRoute2;
	}
	public String getNearestRouteName2() {
		return nearestRouteName2;
	}
	public void setNearestRouteName2(String nearestRouteName2) {
		this.nearestRouteName2 = nearestRouteName2;
	}
	public Integer getNearestStation2() {
		return nearestStation2;
	}
	public void setNearestStation2(Integer nearestStation2) {
		this.nearestStation2 = nearestStation2;
	}
	public String getNearestStationName2() {
		return nearestStationName2;
	}
	public void setNearestStationName2(String nearestStationName2) {
		this.nearestStationName2 = nearestStationName2;
	}
	public Integer getMinutesWalk2() {
		return minutesWalk2;
	}
	public void setMinutesWalk2(Integer minutesWalk2) {
		this.minutesWalk2 = minutesWalk2;
	}
	public Integer getDisplayNumber2() {
		return displayNumber2;
	}
	public void setDisplayNumber2(Integer displayNumber2) {
		this.displayNumber2 = displayNumber2;
	}
	public Integer getNearestRoute3() {
		return nearestRoute3;
	}
	public void setNearestRoute3(Integer nearestRoute3) {
		this.nearestRoute3 = nearestRoute3;
	}
	public String getNearestRouteName3() {
		return nearestRouteName3;
	}
	public void setNearestRouteName3(String nearestRouteName3) {
		this.nearestRouteName3 = nearestRouteName3;
	}
	public Integer getNearestStation3() {
		return nearestStation3;
	}
	public void setNearestStation3(Integer nearestStation3) {
		this.nearestStation3 = nearestStation3;
	}
	public String getNearestStationName3() {
		return nearestStationName3;
	}
	public void setNearestStationName3(String nearestStationName3) {
		this.nearestStationName3 = nearestStationName3;
	}
	public Integer getMinutesWalk3() {
		return minutesWalk3;
	}
	public Integer getDisplayNumber3() {
		return displayNumber3;
	}
	public void setDisplayNumber3(Integer displayNumber3) {
		this.displayNumber3 = displayNumber3;
	}
	public void setMinutesWalk3(Integer minutesWalk3) {
		this.minutesWalk3 = minutesWalk3;
	}
	public Double getGeoCode() {
		return geoCode;
	}
	public void setGeoCode(Double geoCode) {
		this.geoCode = geoCode;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
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
	public Integer getNumberOfStoreys() {
		return numberOfStoreys;
	}
	public void setNumberOfStoreys(Integer numberOfStoreys) {
		this.numberOfStoreys = numberOfStoreys;
	}
	public Integer getStructureId() {
		return structureId;
	}
	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
	}
	public String getStructureName() {
		return structureName;
	}
	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}
	public String getPrTitle() {
		return prTitle;
	}
	public void setPrTitle(String prTitle) {
		this.prTitle = prTitle;
	}
	public String getPrDetail() {
		return prDetail;
	}
	public void setPrDetail(String prDetail) {
		this.prDetail = prDetail;
	}
}
