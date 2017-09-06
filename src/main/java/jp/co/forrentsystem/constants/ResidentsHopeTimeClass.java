package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 入居希望時期の共通定数クラス
 * @author webridge
 *
 */
public enum ResidentsHopeTimeClass {

	/** 列挙定数の定義 */
	MANSION("すぐにでも", 1),
	APART("３ヵ月以内", 2),
	DEPACHED("半年以内", 3),
	STORE("良い物件があったら", 4);

	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    ResidentsHopeTimeClass(String name, int value) {
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
     * 入居希望時期名称を取得
     *
     * @param value 入居希望時期値
     *
     * @return 入居希望時期名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (ResidentsHopeTimeClass residentsHopeTimeClass : ResidentsHopeTimeClass.values()) {
            if (residentsHopeTimeClass.getValue() == value) {
                name = residentsHopeTimeClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 入居希望時期選択項目リストの設定
     *
     * @return 入居希望時期選択項目リスト
     */
    public static List<MasterDto> getResidentsHopeTimeClassList() {
    	List<MasterDto> residentsHopeTimeClassList = new ArrayList<MasterDto>();
    	for (ResidentsHopeTimeClass residentsHopeTimeClass : ResidentsHopeTimeClass.values()) {
    		MasterDto residentsHopeTimeClassDto = new MasterDto();
    		residentsHopeTimeClassDto.setId(residentsHopeTimeClass.getValue() );
    		residentsHopeTimeClassDto.setName(residentsHopeTimeClass.getName());
    		residentsHopeTimeClassList.add(residentsHopeTimeClassDto);
    	}
    	return residentsHopeTimeClassList;
    }

    /**
     * 入居希望時期選択項目リストの設定(空行あり)
     *
     * @return 入居希望時期選択項目リスト
     */
    public static List<MasterDto> getResidentsHopeTimeClassAndBlankList() {
    	int value = 0;
    	String name = "";

    	List<MasterDto> residentsHopeTimeClassList = new ArrayList<MasterDto>();
    	//空行設定
    	MasterDto residentsHopeTimeBlankDto = new MasterDto();
    	residentsHopeTimeBlankDto.setId(value);
    	residentsHopeTimeBlankDto.setName(name);
    	residentsHopeTimeClassList.add(residentsHopeTimeBlankDto);
    	for (ResidentsHopeTimeClass residentsHopeTimeClass : ResidentsHopeTimeClass.values()) {
    		MasterDto processClassDto = new MasterDto();
    		processClassDto.setId(residentsHopeTimeClass.getValue() );
    		processClassDto.setName(residentsHopeTimeClass.getName());
    		residentsHopeTimeClassList.add(processClassDto);
    	}
    	return residentsHopeTimeClassList;
    }
}
