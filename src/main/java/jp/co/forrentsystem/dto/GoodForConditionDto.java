package jp.co.forrentsystem.dto;

import java.util.Date;

/**
 * こだわり条件DTO
 * @author k.akahira
 *
 */
public class GoodForConditionDto {
	/** こだわり条件ID */
	private Integer conditionId;
	/** こだわり条件名称 */
	private String conditionName;
	/** 表示順 */
	private Integer displayNumber;
	/** 登録日時 */
	private Date created;
	/** 更新日時 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;

	public Integer getConditionId() {
		return conditionId;
	}
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}
	public String getConditionName() {
		return conditionName;
	}
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	public Integer getDisplayNumber() {
		return displayNumber;
	}
	public void setDisplayNumber(Integer displayNumber) {
		this.displayNumber = displayNumber;
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
