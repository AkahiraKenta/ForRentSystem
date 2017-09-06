package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 建物画像区分の共通定数クラス
 * @author webridge
 *
 */
public enum BuildingImageClass {
    /** 列挙定数の定義 */
	BUILDING_IMAGE_CLASS_APPEARANCE("外観", 1),
	BUILDING_IMAGE_CLASS_ENTRANCE("エントランス", 2),
	BUILDING_IMAGE_CLASS_CAR_PARK("駐車場", 3),
	BUILDING_IMAGE_CLASS_OTHER("その他", 4);

    /** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    BuildingImageClass(String name, int value) {
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
     * 建物画像区分名称の取得
     *
     * @param value 建物画像区分値
     *
     * @return 建物画像区分名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (BuildingImageClass buildingImageClass : BuildingImageClass.values()) {
            if (buildingImageClass.getValue() == value) {
                name = buildingImageClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 建物画像区分選択項目リストの設定
     *
     * @return 建物画像選択項目リスト
     */
    public static List<MasterDto> getBuildingImageClassList() {
    	List<MasterDto> buildingImageClassList = new ArrayList<MasterDto>();
    	for (BuildingImageClass buildingImageClass : BuildingImageClass.values()) {
    		MasterDto buildingImageClassDto = new MasterDto();
    		buildingImageClassDto.setId(buildingImageClass.getValue() );
    		buildingImageClassDto.setName(buildingImageClass.getName());
    		buildingImageClassList.add(buildingImageClassDto);
    	}
    	return buildingImageClassList;
    }
}