package jp.co.forrentsystem.dto;

import java.util.Date;

/**
 * 間取りマスタDTO
 * @author k.akahira
 *
 */
public class FloorPlanDto {
	/** 間取りID */
	private Integer floorPlanId;
	/** 間取り名称 */
	private String floorPlanName;
	/** 登録日 */
	private Date created;
	/** 更新日 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;

	public Integer getFloorPlanId() {
		return floorPlanId;
	}
	public void setFloorPlanId(Integer floorPlanId) {
		this.floorPlanId = floorPlanId;
	}
	public String getFloorPlanName() {
		return floorPlanName;
	}
	public void setFloorPlanName(String floorPlanName) {
		this.floorPlanName = floorPlanName;
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
