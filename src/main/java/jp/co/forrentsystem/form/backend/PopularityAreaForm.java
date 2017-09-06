package jp.co.forrentsystem.form.backend;

import java.util.Date;

/**
 * 人気エリアForm
 * @author k.akahira
 *
 */
public class PopularityAreaForm {

	/** 人気エリアID */
	private Integer popularityAreaId;
	/** 都道府県名 */
	private String province;
	/** 市区町村名 */
	private String city;
	/** 町域名 */
	private String townArea;
	/** 順位 */
	private Integer rank;
	/** 登録日時 */
	private Date created;
	/** 更新日時 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;
	/** 検索用都道府県 */
	private String searchProvince;

	public Integer getPopularityAreaId() {
		return popularityAreaId;
	}
	public void setPopularityAreaId(Integer popularityAreaId) {
		this.popularityAreaId = popularityAreaId;
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
	public String getSearchProvince() {
		return searchProvince;
	}
	public void setSearchProvince(String searchProvince) {
		this.searchProvince = searchProvince;
	}
}
