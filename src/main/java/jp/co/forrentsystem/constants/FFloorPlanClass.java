package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 間取りの共通定数クラス
 * @author webridge
 *
 */
public enum FFloorPlanClass {

	/** 列挙定数の定義 */
	R1("1R", 1),
	K1("1K/1DK", 2),
	LDK1("1LDK/2k", 3),
	DK2("2DK/3LDK/3K", 4),
	LDK3("3DK/3LDK/4K", 5);

	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    FFloorPlanClass(String name, int value) {
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
     * 間取り名称を取得
     *
     * @param value 間取り値
     *
     * @return 間取り名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (FFloorPlanClass fFloorPlanClass : FFloorPlanClass.values()) {
            if (fFloorPlanClass.getValue() == value) {
                name = fFloorPlanClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 間取り選択リストの設定
     *
     * @return 間取り選択項目リスト
     */
    public static List<MasterDto> getFloorPlanClassList() {
    	List<MasterDto> floorPlanClassList = new ArrayList<MasterDto>();
    	for (FFloorPlanClass fFloorPlanClass : FFloorPlanClass.values()) {
    		MasterDto fFloorPlanClassDto = new MasterDto();
    		fFloorPlanClassDto.setId(fFloorPlanClass.getValue() );
    		fFloorPlanClassDto.setName(fFloorPlanClass.getName());
    		floorPlanClassList.add(fFloorPlanClassDto);
    	}
    	return floorPlanClassList;
    }
}
