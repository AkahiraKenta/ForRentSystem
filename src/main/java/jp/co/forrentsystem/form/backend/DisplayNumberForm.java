package jp.co.forrentsystem.form.backend;


/**
 * 表示件数用Formクラス
 * @author k.akahira
 *
 */
public class DisplayNumberForm {

	/** システム設定ID */
	private Integer systemSettingId;
	/** システム設定名称 */
	private String systemSettingName;
	/** 新着物件表示件数ID */
	private Integer newArticleDisplayNumberId;
	/** 人気駅表示件数ID */
	private Integer popularityStationDisplayNumberId;
	/** 人気エリア表示件数ID */
	private Integer popularityAreaDisplayNumberId;
	/** ニュース表示件数ID */
	private Integer newsDisplayNumberId;
	/** バナー表示件数ID */
	private Integer bannerDisplayNumberId;
	/** おすすめ物件表示件数ID */
	private Integer recommendedRoomDisplayNumberId;
	/** 物件一覧表示件数ID */
	private Integer articleListDisplayNumberId;

	public Integer getSystemSettingId() {
		return systemSettingId;
	}
	public void setSystemSettingId(Integer systemSettingId) {
		this.systemSettingId = systemSettingId;
	}
	public String getSystemSettingName() {
		return systemSettingName;
	}
	public void setSystemSettingName(String systemSettingName) {
		this.systemSettingName = systemSettingName;
	}
	public Integer getNewArticleDisplayNumberId() {
		return newArticleDisplayNumberId;
	}
	public void setNewArticleDisplayNumberId(Integer newArticleDisplayNumberId) {
		this.newArticleDisplayNumberId = newArticleDisplayNumberId;
	}
	public Integer getPopularityStationDisplayNumberId() {
		return popularityStationDisplayNumberId;
	}
	public void setPopularityStationDisplayNumberId(
			Integer popularityStationDisplayNumberId) {
		this.popularityStationDisplayNumberId = popularityStationDisplayNumberId;
	}
	public Integer getPopularityAreaDisplayNumberId() {
		return popularityAreaDisplayNumberId;
	}
	public void setPopularityAreaDisplayNumberId(
			Integer popularityAreaDisplayNumberId) {
		this.popularityAreaDisplayNumberId = popularityAreaDisplayNumberId;
	}
	public Integer getNewsDisplayNumberId() {
		return newsDisplayNumberId;
	}
	public void setNewsDisplayNumberId(Integer newsDisplayNumberId) {
		this.newsDisplayNumberId = newsDisplayNumberId;
	}
	public Integer getBannerDisplayNumberId() {
		return bannerDisplayNumberId;
	}
	public void setBannerDisplayNumberId(Integer bannerDisplayNumberId) {
		this.bannerDisplayNumberId = bannerDisplayNumberId;
	}
	public Integer getRecommendedRoomDisplayNumberId() {
		return recommendedRoomDisplayNumberId;
	}
	public void setRecommendedRoomDisplayNumberId(
			Integer recommendedRoomDisplayNumberId) {
		this.recommendedRoomDisplayNumberId = recommendedRoomDisplayNumberId;
	}
	public Integer getArticleListDisplayNumberId() {
		return articleListDisplayNumberId;
	}
	public void setArticleListDisplayNumberId(Integer articleListDisplayNumberId) {
		this.articleListDisplayNumberId = articleListDisplayNumberId;
	}

}
