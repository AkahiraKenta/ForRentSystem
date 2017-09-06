package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 人気駅表示件数の共通定数クラス
 * @author webridge
 *
 */
public enum PopularityStationDisplayNumber {

	/** 列挙定数の定義 */
	FIVE("5", 5),
	TEN("10", 10),
	FIFTEEN("15", 15),
	TWENTY("20", 20);


	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    PopularityStationDisplayNumber(String name, int value) {
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
     * 人気駅表示件数のIDを取得
     *
     * @param name 人気駅表示件数名称
     *
     * @return 人気駅表示件数値
     */
    public static Integer getTargetId(String name) {
    	int value = 0;
    	for (PopularityStationDisplayNumber popularityStationDisplayNumber : PopularityStationDisplayNumber.values()) {
            if (StringUtils.equals(popularityStationDisplayNumber.getName(), name)) {
            	value = popularityStationDisplayNumber.getValue();
                break;
            }
        }
    	return value;
    }

    /**
     * 人気駅表示件数の名称を取得
     *
     * @param value 人気駅表示件数値
     *
     * @return 人気駅表示件数名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (PopularityStationDisplayNumber popularityStation : PopularityStationDisplayNumber.values()) {
            if (popularityStation.getValue() == value) {
                name = popularityStation.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 人気駅表示件数の選択項目リストの設定
     *
     * @return 人気駅表示件数の選択項目リスト
     */
    public static List<MasterDto> getPopularityStationList() {
    	List<MasterDto> systemSettingList = new ArrayList<MasterDto>();
    	for (PopularityStationDisplayNumber popularityStation : PopularityStationDisplayNumber.values()) {
    		MasterDto systemSettingDto = new MasterDto();
    		systemSettingDto.setId(popularityStation.getValue() );
    		systemSettingDto.setName(popularityStation.getName());
    		systemSettingList.add(systemSettingDto);
    	}
    	return systemSettingList;
    }
}
