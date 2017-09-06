package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 築年数の共通定数クラス
 * @author webridge
 *
 */
public enum FBuiltClass {

	/** 列挙定数の定義 */
	BUILT1("新築/1年以内", 1),
	BUILT5("5年以内", 5),
	BUILT10("10年以内", 10),
	BUILT20("20年以内", 20);

	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    FBuiltClass(String name, int value) {
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
     * 築年数名称を取得
     *
     * @param value 築年数値
     *
     * @return 築年数名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (FBuiltClass fMinutesWalk : FBuiltClass.values()) {
            if (fMinutesWalk.getValue() == value) {
                name = fMinutesWalk.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 築年数選択リストの設定
     *
     * @return 築年数選択項目リスト
     */
    public static List<MasterDto> getBuiltList() {
    	List<MasterDto> fMinutesWalkList = new ArrayList<MasterDto>();
    	for (FBuiltClass fMinutesWalk : FBuiltClass.values()) {
    		MasterDto fMinutesWalkDto = new MasterDto();
    		fMinutesWalkDto.setId(fMinutesWalk.getValue() );
    		fMinutesWalkDto.setName(fMinutesWalk.getName());
    		fMinutesWalkList.add(fMinutesWalkDto);
    	}
    	return fMinutesWalkList;
    }
}
