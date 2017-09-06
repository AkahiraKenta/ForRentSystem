package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * ニュース表示件数の共通定数クラス
 * @author webridge
 *
 */
public enum NewsDisplayNumber {

	/** 列挙定数の定義 */
	FIVE("5", 5),
	TEN("10", 10),
	FIFTEEN("15", 15),
	TWENTY("20", 20);


	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    NewsDisplayNumber(String name, int value) {
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
     * ニュース表示件数のIDを取得
     *
     * @param name ニュース表示件数名称
     *
     * @return ニュース表示件数値
     */
    public static Integer getTargetId(String name) {
    	int value = 0;
    	for (NewsDisplayNumber newsDisplayNumber : NewsDisplayNumber.values()) {
            if (StringUtils.equals(newsDisplayNumber.getName(), name)) {
            	value = newsDisplayNumber.getValue();
                break;
            }
        }
    	return value;
    }

    /**
     * ニュース表示件数の名称を取得
     *
     * @param value ニュース表示件数値
     *
     * @return ニュース表示件数名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (NewsDisplayNumber news : NewsDisplayNumber.values()) {
            if (news.getValue() == value) {
                name = news.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * ニュース表示件数の選択項目リストの設定
     *
     * @return ニュース表示件数の選択項目リスト
     */
    public static List<MasterDto> getNewsList() {
    	List<MasterDto> systemSettingList = new ArrayList<MasterDto>();
    	for (NewsDisplayNumber news : NewsDisplayNumber.values()) {
    		MasterDto systemSettingDto = new MasterDto();
    		systemSettingDto.setId(news.getValue() );
    		systemSettingDto.setName(news.getName());
    		systemSettingList.add(systemSettingDto);
    	}
    	return systemSettingList;
    }
}
