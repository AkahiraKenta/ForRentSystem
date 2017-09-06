package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * おすすめ物件表示件数の共通定数クラス
 * @author webridge
 *
 */
public enum RecommendedRoomDisplayNumber {

	/** 列挙定数の定義 */
	FIVE("5", 5),
	TEN("10", 10),
	FIFTEEN("15", 15),
	TWENTY("20", 20);


	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    RecommendedRoomDisplayNumber(String name, int value) {
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
     * おすすめ物件表示件数のIDを取得
     *
     * @param name おすすめ物件表示件数名称
     *
     * @return おすすめ物件表示件数値
     */
    public static Integer getTargetId(String name) {
    	int value = 0;
    	for (RecommendedRoomDisplayNumber recommendedRoomDisplayNumber : RecommendedRoomDisplayNumber.values()) {
            if (StringUtils.equals(recommendedRoomDisplayNumber.getName(), name)) {
            	value = recommendedRoomDisplayNumber.getValue();
                break;
            }
        }
    	return value;
    }

    /**
     * おすすめ物件表示件数の名称を取得
     *
     * @param value おすすめ物件表示件数値
     *
     * @return おすすめ物件表示件数名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (RecommendedRoomDisplayNumber recommendedRoom : RecommendedRoomDisplayNumber.values()) {
            if (recommendedRoom.getValue() == value) {
                name = recommendedRoom.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * おすすめ物件表示件数の選択項目リストの設定
     *
     * @return おすすめ物件表示件数の選択項目リスト
     */
    public static List<MasterDto> getRecommendedRoomList() {
    	List<MasterDto> systemSettingList = new ArrayList<MasterDto>();
    	for (RecommendedRoomDisplayNumber recommendedRoom : RecommendedRoomDisplayNumber.values()) {
    		MasterDto systemSettingDto = new MasterDto();
    		systemSettingDto.setId(recommendedRoom.getValue() );
    		systemSettingDto.setName(recommendedRoom.getName());
    		systemSettingList.add(systemSettingDto);
    	}
    	return systemSettingList;
    }
}
