package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 賃料選択項目下限の共通定数クラス
 * @author webridge
 *
 */
public enum FRentFromClass {

	/** 列挙定数の定義 */
	RENT0("下限なし", 0),
	RENT1("3万円以上", 30000),
	RENT2("3.5万円以上", 35000),
	RENT3("4万円以上", 40000),
	RENT4("4.5万円以上", 45000),
	RENT5("5万円以上", 50000),
	RENT6("5.5万円以上", 55000),
	RENT7("6万円以上", 60000),
	RENT8("6.5万円以上", 65000),
	RENT9("7万円以上", 70000),
	RENT10("7.5万円以上", 75000),
	RENT11("8万円以上", 80000),
	RENT12("8.5万円以上", 85000),
	RENT13("9万円以上", 90000),
	RENT14("9.5万円以上", 95000),
	RENT15("10万円以上", 100000),
	RENT16("10.5万円以上", 105000),
	RENT17("11万円以上", 110000),
	RENT18("11.5万円以上", 115000),
	RENT19("12万円以上", 120000),
	RENT20("13万円以上", 130000),
	RENT21("14万円以上", 140000),
	RENT22("15万円以上", 150000),
	RENT23("16万円以上", 160000),
	RENT24("17万円以上", 170000),
	RENT25("18万円以上", 180000),
	RENT26("19万円以上", 190000),
	RENT27("20万円以上", 200000),
	RENT28("30万円以上", 300000),
	RENT29("40万円以上", 400000),
	RENT30("50万円以上", 500000);

	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    FRentFromClass(String name, int value) {
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
     * 賃料下限選択名称からのIDを取得
     *
     * @param name 賃料下限名称
     *
     * @return 賃料下限選択値
     */
    public static Integer getTargetId(String name) {
    	int value = 0;
    	for (FRentFromClass rentFromClass : FRentFromClass.values()) {
            if (StringUtils.equals(rentFromClass.getName(), name)) {
            	value = rentFromClass.getValue();
                break;
            }
        }
    	return value;
    }

    /**
     * 賃料下限選択値から名称を取得
     *
     * @param value 賃料下限選択値
     *
     * @return 賃料下限選択名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (FRentFromClass rentFromClass : FRentFromClass.values()) {
            if (rentFromClass.getValue() == value) {
                name = rentFromClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 賃料下限の選択項目リストの設定
     *
     * @return 賃料下限の選択項目リスト
     */
    public static List<MasterDto> getRentFromClassList() {
    	List<MasterDto> rentFromClassList = new ArrayList<MasterDto>();
    	for (FRentFromClass rentFromClass : FRentFromClass.values()) {
    		MasterDto rentFormClassDto= new MasterDto();
    		rentFormClassDto.setId(rentFromClass.getValue() );
    		rentFormClassDto.setName(rentFromClass.getName());
    		rentFromClassList.add(rentFormClassDto);
    	}
    	return rentFromClassList;
    }
}
