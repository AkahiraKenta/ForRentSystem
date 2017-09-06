package jp.co.forrentsystem.util;

/**
 * ページング情報Form
 * @author webridge
 *
 */
public class PagerForm {

	// 全件数
	private Integer totalNumber;
	// 現在のページ
	private Integer currentPage;
	// 表示件数
	private Integer viewNumber;
	// 全ページ数
	private Integer pageTotalNumber;

	public Integer getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getViewNumber() {
		return viewNumber;
	}
	public void setViewNumber(Integer viewNumber) {
		this.viewNumber = viewNumber;
	}
	public Integer getPageTotalNumber() {
		return pageTotalNumber;
	}
	public void setPageTotalNumber(Integer pageTotalNumber) {
		this.pageTotalNumber = pageTotalNumber;
	}
}
