package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * バナー表示件数の共通定数クラス
 * @author webridge
 *
 */
public enum BannerDisplayNumber {

	/** 列挙定数の定義 */
	FIVE("5", 5),
	TEN("10", 10),
	FIFTEEN("15", 15),
	TWENTY("20", 20);


	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    BannerDisplayNumber(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /** 名称取得メソッド */
    public String getName() {
        return this.name;
    }

    /** 値取得メソッド */
    public int getValue() {
        return this.value;
    }

    /**
     * バナー表示件数のIDを取得
     *
     * @param name バナー表示件数名称
     *
     * @return バナー表示件数値
     */
    public static Integer getTargetId(String name) {
    	int value = 0;
    	for (BannerDisplayNumber bannerDisplayNumber : BannerDisplayNumber.values()) {
            if (StringUtils.equals(bannerDisplayNumber.getName(), name)) {
            	value = bannerDisplayNumber.getValue();
                break;
            }
        }
    	return value;
    }

    /**
     * バナー表示件数の名称を取得
     *
     * @param value バナー表示件数値
     *
     * @return バナー表示件数名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (BannerDisplayNumber banner : BannerDisplayNumber.values()) {
            if (banner.getValue() == value) {
                name = banner.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * バナー表示件数の選択項目リストの設定
     *
     * @return バナー表示件数の選択項目リスト
     */
    public static List<MasterDto> getBannerList() {
    	List<MasterDto> bannerList = new ArrayList<MasterDto>();
    	for (BannerDisplayNumber banner : BannerDisplayNumber.values()) {
    		MasterDto bannerDto = new MasterDto();
    		bannerDto.setId(banner.getValue() );
    		bannerDto.setName(banner.getName());
    		bannerList.add(bannerDto);
    	}
    	return bannerList;
    }
}
