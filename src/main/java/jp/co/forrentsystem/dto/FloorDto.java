package jp.co.forrentsystem.dto;

import java.util.Date;

/**
 * 階数区分マスタDTO
 * @author k.akahira
 *
 */
public class FloorDto {
	/** 階数区分ID */
	private Integer floorClassId;
	/** 階数名称 */
	private String floorName;
	/** 登録日 */
	private Date created;
	/** 更新日 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;

	public Integer getFloorClassId() {
		return floorClassId;
	}
	public void setFloorClassId(Integer floorClassId) {
		this.floorClassId = floorClassId;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
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
}
