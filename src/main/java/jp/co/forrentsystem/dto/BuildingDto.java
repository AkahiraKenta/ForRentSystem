package jp.co.forrentsystem.dto;

import java.util.Date;

import jp.co.forrentsystem.util.PagerDto;

/**
 * 建物マスタDTO
 * @author k.akahira
 *
 */
public class BuildingDto extends PagerDto {
	/** 建物ID */
	private Integer buildingId;
	/** 建物コード */
	private String buildingCode;
	/** 建物名称 */
	private String buildingName;
	/** 建物種別 */
	private Integer buildingType;
	/** 郵便番号 */
	private String zipCode;
	/** 都道府県 */
	private String province;
	/** 市区町村 */
	private String city;
	/** 町域 */
	private String townArea;
	/** 町域以下 */
	private String townAreaBelow;
//	// GEOコード
//	private BigDecimal geoCode;
//	// 緯度
//	private BigDecimal latitude;
//	// 経度
//	private BigDecimal longitude;
	/** GEOコード */
	private String geoCode;
	/** 緯度 */
	private Double latitude;
	/** 経度 */
	private Double longitude;
	/** 築年数（年） */
	private Integer builtYear;
	/** 築年数（月） */
	private Integer builtMonth;
	/** 階建 */
	private Integer numberOfStoreys;
	/** 構造 */
	private Integer structureId;
	/** 建物PRタイトル */
	private String prTitle;
	/** 建物PR詳細 */
	private String prDetail;
	/** 登録日時 */
	private Date created;
	/** 更新日時 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;
	/** 件数 */
	private Integer count;
	/** 沿線ID */
	private Integer routeId;
	/** 駅ID */
	private Integer stationId;

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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
//	public BigDecimal getGeoCode() {
//		return geoCode;
//	}
//	public void setGeoCode(BigDecimal geoCode) {
//		this.geoCode = geoCode;
//	}
//	public BigDecimal getLatitude() {
//		return latitude;
//	}
//	public void setLatitude(BigDecimal latitude) {
//		this.latitude = latitude;
//	}
//	public BigDecimal getLongitude() {
//		return longitude;
//	}
//	public void setLongitude(BigDecimal longitude) {
//		this.longitude = longitude;
//	}
	public String getGeoCode() {
		return geoCode;
	}
	public void setGeoCode(String geoCode) {
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
}
