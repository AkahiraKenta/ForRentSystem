package jp.co.forrentsystem.form.backend;

import java.util.Date;

import jp.co.forrentsystem.annotation.CheckDateFormat;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * ニュースForm
 * @author k.akahira
 *
 */
public class NewsForm {

	/** ニュースID */
	private Integer newsId;
	/** ニュースタイトル */
	@NotEmpty
	private String newsTitle;
	/** ニュース内容 */
	private String newsContent;
	/** 投稿日 */
	@NotEmpty
	@CheckDateFormat
	private String postedDate;
	/** リンク有無フラグ */
	private Integer linkUmuFlag;
	/** リンク有無フラグ名称 */
	private String linkUmuFlagName;
	/** リンク区分 */
	private Integer linkClass;
	/** リンク区分名称 */
	private String linkClassName;
	/** リンクURL */
	private String linkUrl;
	/** 登録日 */
	private Date created;
	/** 更新日 */
	private Date modified;
	/** 削除フラグ */
	private Integer deleteFlag;

	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
//	public String getPostedDateView() {
//		return postedDateView;
//	}
//	public void setPostedDateView(String postedDateView) {
//		this.postedDateView = postedDateView;
//	}
	public Integer getLinkUmuFlag() {
		return linkUmuFlag;
	}
	public void setLinkUmuFlag(Integer linkUmuFlag) {
		this.linkUmuFlag = linkUmuFlag;
	}
	public String getLinkUmuFlagName() {
		return linkUmuFlagName;
	}
	public void setLinkUmuFlagName(String linkUmuFlagName) {
		this.linkUmuFlagName = linkUmuFlagName;
	}
	public Integer getLinkClass() {
		return linkClass;
	}
	public void setLinkClass(Integer linkClass) {
		this.linkClass = linkClass;
	}
	public String getLinkClassName() {
		return linkClassName;
	}
	public void setLinkClassName(String linkClassName) {
		this.linkClassName = linkClassName;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
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
