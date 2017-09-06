package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 保証金区分の共通定数クラス
 * @author webridge
 *
 */
public enum SecurityMoneyClass {
    /** 列挙定数の定義 */
	SECURITY_MONEY_CLASS_NON("なし", 0),
	SECURITY_MONEY_CLASS_AMOUNT_SPECIFIED("金額指定", 1),
	SECURITY_MONEY_CLASS_RENT_MONTH("賃料の1ヵ月", 2),
	SECURITY_MONEY_CLASS_RENT_TWO_MONTH("賃料の2ヵ月", 3),
	SECURITY_MONEY_CLASS_RENT_THREE_MONTH("賃料の3ヵ月", 4),
	SECURITY_MONEY_CLASS_RENT_FOUR_MONTH("賃料の4ヵ月", 5),
	SECURITY_MONEY_CLASS_RENT_FIVE_MONTH("賃料の5ヵ月", 6),
	SECURITY_MONEY_CLASS_RENT_SIX_MONTH("賃料の6ヵ月", 7),
	SECURITY_MONEY_CLASS_RENT_SEVEN_MONTH("賃料の7ヵ月", 8),
	SECURITY_MONEY_CLASS_RENT_EIGHT_MONTH("賃料の8ヵ月", 9),
	SECURITY_MONEY_CLASS_RENT_NINE_MONTH("賃料の9ヵ月", 10),
	SECURITY_MONEY_CLASS_RENT_TEN_MONTH("賃料の10ヵ月", 11),
	SECURITY_MONEY_CLASS_RENT_ELEVEN_MONTH("賃料の11ヵ月", 12),
	SECURITY_MONEY_CLASS_RENT_TWELVE_MONTH("賃料の12ヵ月", 13);


    /** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    SecurityMoneyClass(String name, int value) {
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
     * 保証金区分名称の取得
     *
     * @param value 保証金区分値
     *
     * @return 保証金区分名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (SecurityMoneyClass securityMoneyClass : SecurityMoneyClass.values()) {
            if (securityMoneyClass.getValue() == value) {
                name = securityMoneyClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 保証金区分選択項目リストの設定
     *
     * @return 保証金区分選択項目リスト
     */
    public static List<MasterDto> getSecurityMoneyClassList() {
    	List<MasterDto> securyMoneyClassList = new ArrayList<MasterDto>();
    	for (SecurityMoneyClass securytMoneyClass : SecurityMoneyClass.values()) {
    		MasterDto securityMoneyClassDto = new MasterDto();
    		securityMoneyClassDto.setId(securytMoneyClass.getValue() );
    		securityMoneyClassDto.setName(securytMoneyClass.getName());
    		securyMoneyClassList.add(securityMoneyClassDto);
    	}
    	return securyMoneyClassList;
    }
}