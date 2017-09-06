package jp.co.forrentsystem.util;

public class PagerDto {

	// 取得件数From
	private Integer fromNumber;
	// 表示件数
	private Integer viewNumber;

	public Integer getFromNumber() {
		return fromNumber;
	}
	public void setFromNumber(Integer fromNumber) {
		this.fromNumber = fromNumber;
	}
	public Integer getViewNumber() {
		return viewNumber;
	}
	public void setViewNumber(Integer viewNumber) {
		this.viewNumber = viewNumber;
	}

}
