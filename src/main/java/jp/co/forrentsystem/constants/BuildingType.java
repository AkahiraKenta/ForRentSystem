package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 建物種別の共通定数クラス
 * @author webridge
 *
 */
public enum BuildingType {

	/** 列挙定数の定義 */
	MANSION("マンション", 1),
	APART("アパート", 2),
	DEPACHED("戸建_テラスハウス", 3),
	STORE("店舗_事務所", 4),
	PARKING("駐車場", 5);

	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    BuildingType(String name, int value) {
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
     * 建物種別名称を取得
     *
     * @param value 建物種別値
     *
     * @return 建物種別名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (BuildingType buildingType : BuildingType.values()) {
            if (buildingType.getValue() == value) {
                name = buildingType.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 建物種別選択項目リストの設定
     *
     * @return 建物種別選択項目リスト
     */
    public static List<MasterDto> getBuildingTypeList() {
    	List<MasterDto> buildingTypeList = new ArrayList<MasterDto>();
    	for (BuildingType buildingType : BuildingType.values()) {
    		MasterDto buildingTypeDto = new MasterDto();
    		buildingTypeDto.setId(buildingType.getValue() );
    		buildingTypeDto.setName(buildingType.getName());
    		buildingTypeList.add(buildingTypeDto);
    	}
    	return buildingTypeList;
    }

    /**
     * 建物種別選択項目リストの設定(空行あり)
     *
     * @return 建物種別選択項目リスト
     */
    public static List<MasterDto> getBuildingTypeAndBlankList() {
    	int value = 0;
    	String name = "";

    	List<MasterDto> buildingTypeList = new ArrayList<MasterDto>();
    	//空行設定
    	MasterDto buildingTypeBlankDto = new MasterDto();
    	buildingTypeBlankDto.setId(value);
    	buildingTypeBlankDto.setName(name);
    	buildingTypeList.add(buildingTypeBlankDto);
    	for (BuildingType buildingType : BuildingType.values()) {
    		MasterDto buildingTypeDto = new MasterDto();
    		buildingTypeDto.setId(buildingType.getValue() );
    		buildingTypeDto.setName(buildingType.getName());
    		buildingTypeList.add(buildingTypeDto);
    	}
    	return buildingTypeList;
    }
}
