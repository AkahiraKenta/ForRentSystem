package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 徒歩分の共通定数クラス
 * @author webridge
 *
 */
public enum FMinutesWalkClass {

	/** 列挙定数の定義 */
	MINUTES2("2分以内", 2),
	MINUTES5("5分以内", 5),
	MINUTES10("10分以内", 10);

	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    FMinutesWalkClass(String name, int value) {
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
     * 徒歩分名称を取得
     *
     * @param value 徒歩分値
     *
     * @return 徒歩分名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (FMinutesWalkClass fMinutesWalkClass : FMinutesWalkClass.values()) {
            if (fMinutesWalkClass.getValue() == value) {
                name = fMinutesWalkClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 徒歩分選択リストの設定
     *
     * @return 徒歩分選択項目リスト
     */
    public static List<MasterDto> getFMinutesWalkList() {
    	List<MasterDto> fMinutesWalkClassList = new ArrayList<MasterDto>();
    	for (FMinutesWalkClass fMinutesWalkClass : FMinutesWalkClass.values()) {
    		MasterDto fMinutesWalkClassDto = new MasterDto();
    		fMinutesWalkClassDto.setId(fMinutesWalkClass.getValue() );
    		fMinutesWalkClassDto.setName(fMinutesWalkClass.getName());
    		fMinutesWalkClassList.add(fMinutesWalkClassDto);
    	}
    	return fMinutesWalkClassList;
    }
}
