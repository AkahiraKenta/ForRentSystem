package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 礼金区分の共通定数クラス
 * @author webridge
 *
 */
public enum KeyMoneyClass {
    /** 列挙定数の定義 */
	SECURITY_DEPOSIT_CLASS_NON("なし", 0),
	SECURITY_DEPOSIT_CLASS_AMOUNT_SPECIFIED("金額指定", 1),
	SECURITY_DEPOSIT_CLASS_RENT_MONTH("賃料の1ヵ月", 2),
	SECURITY_DEPOSIT_CLASS_RENT_TWO_MONTH("賃料の2ヵ月", 3);

    /** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    KeyMoneyClass(String name, int value) {
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
     * 礼金区分名称の取得
     *
     * @param value 礼金区分値
     *
     * @return 礼金区分名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (KeyMoneyClass keyMoneyClass : KeyMoneyClass.values()) {
            if (keyMoneyClass.getValue() == value) {
                name = keyMoneyClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 礼金区分選択項目リストの設定
     *
     * @return 礼金区分選択項目リスト
     */
    public static List<MasterDto> getKeyMoneyClassList() {
    	List<MasterDto> keyMoneyClassList = new ArrayList<MasterDto>();
    	for (KeyMoneyClass keyMoneyClass : KeyMoneyClass.values()) {
    		MasterDto keyMoneyClassDto = new MasterDto();
    		keyMoneyClassDto.setId(keyMoneyClass.getValue() );
    		keyMoneyClassDto.setName(keyMoneyClass.getName());
    		keyMoneyClassList.add(keyMoneyClassDto);
    	}
    	return keyMoneyClassList;
    }
}