package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 賃料選択上限項目の共通定数クラス
 * @author webridge
 *
 */
public enum FRentToClass {

	/** 列挙定数の定義 */
	RENT0("上限なし", 0),
	RENT1("3万円以下", 30000),
	RENT2("3.5万円以下", 35000),
	RENT3("4万円以下", 40000),
	RENT4("4.5万円以下", 45000),
	RENT5("5万円以下", 50000),
	RENT6("5.5万円以下", 55000),
	RENT7("6万円以下", 60000),
	RENT8("6.5万円以下", 65000),
	RENT9("7万円以下", 70000),
	RENT10("7.5万円以下", 75000),
	RENT11("8万円以下", 80000),
	RENT12("8.5万円以下", 85000),
	RENT13("9万円以下", 90000),
	RENT14("9.5万円以下", 95000),
	RENT15("10万円以下", 100000),
	RENT16("10.5万円以下", 105000),
	RENT17("11万円以下", 110000),
	RENT18("11.5万円以下", 115000),
	RENT19("12万円以下", 120000),
	RENT20("13万円以下", 130000),
	RENT21("14万円以下", 140000),
	RENT22("15万円以下", 150000),
	RENT23("16万円以下", 160000),
	RENT24("17万円以下", 170000),
	RENT25("18万円以下", 180000),
	RENT26("19万円以下", 190000),
	RENT27("20万円以下", 200000),
	RENT28("30万円以下", 300000),
	RENT29("40万円以下", 400000),
	RENT30("50万円以下", 500000);

	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    FRentToClass(String name, int value) {
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
     * 賃料上限選択名称からのIDを取得
     *
     * @param name 賃料上限名称
     *
     * @return 賃料上限選択値
     */
    public static Integer getTargetId(String name) {
    	int value = 0;
    	for (FRentToClass rentToClass : FRentToClass.values()) {
            if (StringUtils.equals(rentToClass.getName(), name)) {
            	value = rentToClass.getValue();
                break;
            }
        }
    	return value;
    }

    /**
     * 賃料上限選択値から名称を取得
     *
     * @param value 賃料上限選択値
     *
     * @return 賃料上限選択名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (FRentToClass rentToClass : FRentToClass.values()) {
            if (rentToClass.getValue() == value) {
                name = rentToClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 賃料上限の選択項目リストの設定
     *
     * @return 賃料上限の選択項目リスト
     */
    public static List<MasterDto> getRentToClassList() {
    	List<MasterDto> rentToClassList = new ArrayList<MasterDto>();
    	for (FRentToClass rentToClass : FRentToClass.values()) {
    		MasterDto rentFormClassDto= new MasterDto();
    		rentFormClassDto.setId(rentToClass.getValue() );
    		rentFormClassDto.setName(rentToClass.getName());
    		rentToClassList.add(rentFormClassDto);
    	}
    	return rentToClassList;
    }
}
