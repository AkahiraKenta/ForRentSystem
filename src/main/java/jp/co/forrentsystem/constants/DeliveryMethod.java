package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 引渡方法の共通定数クラス
 * @author webridge
 *
 */
public enum DeliveryMethod {
    /** 列挙定数の定義 */
	CONTRACT_FORM_NON("", 0),
	CONTRACT_FORM_BASIC("現状引渡", 1),
	CONTRACT_FORM_REGULAR("スケルトン", 2),
	CONTRACT_FORM_CONSULTATION("要相談", 3);

    /** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    DeliveryMethod(String name, int value) {
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
     * 引渡方法名称の取得
     *
     * @param value 引渡方法値
     *
     * @return 引渡方法名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (DeliveryMethod deliveryMethod : DeliveryMethod.values()) {
            if (deliveryMethod.getValue() == value) {
                name = deliveryMethod.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 契約形態選択項目リストの設定
     *
     * @return 契約形態選択項目リスト
     */
    public static List<MasterDto> getDeliveryMethodList() {
    	List<MasterDto> DeliveryMethodList = new ArrayList<MasterDto>();
    	for (DeliveryMethod DeliveryMethod : DeliveryMethod.values()) {
    		MasterDto DeliveryMethodDto = new MasterDto();
    		DeliveryMethodDto.setId(DeliveryMethod.getValue() );
    		DeliveryMethodDto.setName(DeliveryMethod.getName());
    		DeliveryMethodList.add(DeliveryMethodDto);
    	}
    	return DeliveryMethodList;
    }
}