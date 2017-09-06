package jp.co.forrentsystem.dto;

import java.util.Date;

/**
 * 人気エリアDTO
 * @author k.akahira
 *
 */
public class PopularityAreaDto {
	/** 人気エリアID */
	private Integer popularityAreaId;
	/** 郵便番号 */
	private String zipCode;
	/** 都道府県 */
	private String province;
	/** 市区町村 */
	private String city;
	/** 町域 */
	private String townArea;
	/** 順位 */
	private Integer rank;
	/** 登録日時 */
	private Date created;
	/** 更新日時 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;
	/** 人気エリア件数 */
	private Integer popularityAreaCount;

	public Integer getPopularityAreaId() {
		return popularityAreaId;
	}
	public void setPopularityAreaId(Integer popularityAreaId) {
		this.popularityAreaId = popularityAreaId;
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
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
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
	public Integer getPopularityAreaCount() {
		return popularityAreaCount;
	}
	public void setPopularityAreaCount(Integer popularityAreaCount) {
		this.popularityAreaCount = popularityAreaCount;
	}
}
