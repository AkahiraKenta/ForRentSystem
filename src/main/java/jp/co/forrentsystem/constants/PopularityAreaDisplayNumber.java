package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 人気エリア表示件数の共通定数クラス
 * @author webridge
 *
 */
public enum PopularityAreaDisplayNumber {

	/** 列挙定数の定義 */
	FIVE("5", 5),
	TEN("10", 10),
	FIFTEEN("15", 15),
	TWENTY("20", 20);


	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    PopularityAreaDisplayNumber(String name, int value) {
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
     * 人気エリア表示件数の名称を取得
     *
     * @param value 人気エリア表示件数値
     *
     * @return 人気エリア表示件数名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (PopularityAreaDisplayNumber popularityArea : PopularityAreaDisplayNumber.values()) {
            if (popularityArea.getValue() == value) {
                name = popularityArea.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 人気エリア表示件数のIDを取得
     *
     * @param name 人気エリア表示件数名称
     *
     * @return 人気エリア表示件数値
     */
    public static Integer getTargetId(String name) {
    	int value = 0;
    	for (PopularityAreaDisplayNumber popularityAreaDisplayNumber : PopularityAreaDisplayNumber.values()) {
            if (StringUtils.equals(popularityAreaDisplayNumber.getName(), name)) {
            	value = popularityAreaDisplayNumber.getValue();
                break;
            }
        }
    	return value;
    }

    /**
     * 人気エリア表示件数の選択項目リストの設定
     *
     * @return 人気エリア表示件数の選択項目リスト
     */
    public static List<MasterDto> getPopularityAreaList() {
    	List<MasterDto> systemSettingList = new ArrayList<MasterDto>();
    	for (PopularityAreaDisplayNumber popularityArea : PopularityAreaDisplayNumber.values()) {
    		MasterDto systemSettingDto = new MasterDto();
    		systemSettingDto.setId(popularityArea.getValue() );
    		systemSettingDto.setName(popularityArea.getName());
    		systemSettingList.add(systemSettingDto);
    	}
    	return systemSettingList;
    }
}
