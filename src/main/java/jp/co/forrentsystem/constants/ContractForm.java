package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 契約形態の共通定数クラス
 * @author webridge
 *
 */
public enum ContractForm {
    /** 列挙定数の定義 */
	DELIVARY_METHOD_NON("", 0),
	DELIVARY_METHOD_STATE("普通借家", 1),
	DELIVARY_METHOD_SKELETON("定期借家", 2);

    /** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    ContractForm(String name, int value) {
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
     * 契約形態名称を取得
     *
     * @param value 契約形態値
     *
     * @return 契約形態名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (ContractForm contractForm : ContractForm.values()) {
            if (contractForm.getValue() == value) {
                name = contractForm.getName();
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
    public static List<MasterDto> getContractFormList() {
    	List<MasterDto> ContractFormList = new ArrayList<MasterDto>();
    	for (ContractForm ContractForm : ContractForm.values()) {
    		MasterDto ContractFormDto = new MasterDto();
    		ContractFormDto.setId(ContractForm.getValue() );
    		ContractFormDto.setName(ContractForm.getName());
    		ContractFormList.add(ContractFormDto);
    	}
    	return ContractFormList;
    }
}