package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 更新料区分の共通定数クラス
 * @author webridge
 *
 */
public enum RenewalFeeClass {
    /** 列挙定数の定義 */
	RENAWAL_FEE_CLASS_NON("なし", 0),
	RENAWAL_FEE_CLASS_AMOUNT_SPECIFIED("金額指定", 1),
	RENAWAL_FEE_CLASS_NEW_RENT_MONTH("新賃料の1ヵ月", 2),
	RENAWAL_FEE_CLASS_NEW_RENT_TWO_MONTH("新賃料の2ヵ月", 3);

    /** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    RenewalFeeClass(String name, int value) {
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
     * 更新料区分名称の取得
     *
     * @param value 敷金区分値
     *
     * @return 敷金区分名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (RenewalFeeClass renewalFeeClass : RenewalFeeClass.values()) {
            if (renewalFeeClass.getValue() == value) {
                name = renewalFeeClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 更新料区分選択項目リストの設定
     *
     * @return 更新料区分選択項目リスト
     */
    public static List<MasterDto> getRenewalFeeClassList() {
    	List<MasterDto> renawalFeeClassList = new ArrayList<MasterDto>();
    	for (RenewalFeeClass renawalFeeClass : RenewalFeeClass.values()) {
    		MasterDto renawalFeeClassDto = new MasterDto();
    		renawalFeeClassDto.setId(renawalFeeClass.getValue() );
    		renawalFeeClassDto.setName(renawalFeeClass.getName());
    		renawalFeeClassList.add(renawalFeeClassDto);
    	}
    	return renawalFeeClassList;
    }
}