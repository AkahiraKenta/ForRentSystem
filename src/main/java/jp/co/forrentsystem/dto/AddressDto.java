package jp.co.forrentsystem.dto;

/**
 * 住所DTO
 * @author k.akahira
 *
 */
public class AddressDto {
	/** 全国地方公共団体コード */
	private String jisCode;
	/** （旧）郵便番号（5桁）*/
	private String oldZipCode;
	/** 郵便番号（7桁）*/
	private String zipCode;
	/** 都道府県名(半角カタカナ) */
	private String provinceKana;
	/** 市区町村名(半角カタカナ) */
	private String cityKana;
	/** 町域名(半角カタカナ) */
	private String townKana;
	/** 都道府県名(漢字) */
	private String province;
	/** 市区町村名(漢字) */
	private String city;
	/** 町域名(漢字) */
	private String town;
	/** 一町域が二以上の郵便番号で表される場合の表示（「1」は該当、「0」は該当せず）*/
	private String flag1;
	/** 小字毎に番地が起番されている町域の表示（「1」は該当、「0」は該当せず）*/
	private String flag2;
	/** 丁目を有する町域の場合の表示（「1」は該当、「0」は該当せず）*/
	private String flag3;
	/** 一つの郵便番号で二以上の町域を表す場合の表示（「1」は該当、「0」は該当せず）*/
	private String flag4;
	/** 更新の表示（「0」は変更なし、「1」は変更あり、「2」廃止（廃止データのみ使用））*/
	private String flag5;
	/**
	 *  変更理由（「0」は変更なし、「1」市政・区政・町政・分区・政令指定都市施行、「2」住居表示の実施、「
	 *  3」区画整理、「4」郵便区調整等、「5」訂正、「6」廃止（廃止データのみ使用））
	 */
	private String changeReasonClass;

	public String getJisCode() {
		return jisCode;
	}
	public void setJisCode(String jisCode) {
		this.jisCode = jisCode;
	}
	public String getOldZipCode() {
		return oldZipCode;
	}
	public void setOldZipCode(String oldZipCode) {
		this.oldZipCode = oldZipCode;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getProvinceKana() {
		return provinceKana;
	}
	public void setProvinceKana(String provinceKana) {
		this.provinceKana = provinceKana;
	}
	public String getCityKana() {
		return cityKana;
	}
	public void setCityKana(String cityKana) {
		this.cityKana = cityKana;
	}
	public String getTownKana() {
		return townKana;
	}
	public void setTownKana(String townKana) {
		this.townKana = townKana;
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
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getFlag1() {
		return flag1;
	}
	public void setFlag1(String flag1) {
		this.flag1 = flag1;
	}
	public String getFlag2() {
		return flag2;
	}
	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}
	public String getFlag3() {
		return flag3;
	}
	public void setFlag3(String flag3) {
		this.flag3 = flag3;
	}
	public String getFlag4() {
		return flag4;
	}
	public void setFlag4(String flag4) {
		this.flag4 = flag4;
	}
	public String getFlag5() {
		return flag5;
	}
	public void setFlag5(String flag5) {
		this.flag5 = flag5;
	}
	public String getChangeReasonClass() {
		return changeReasonClass;
	}
	public void setChangeReasonClass(String changeReasonClass) {
		this.changeReasonClass = changeReasonClass;
	}
}
