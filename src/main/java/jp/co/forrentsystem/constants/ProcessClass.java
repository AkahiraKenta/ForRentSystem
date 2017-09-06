package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * お問合わせ種類の共通定数クラス
 * @author webridge
 *
 */
public enum ProcessClass {

	/** 列挙定数の定義 */
	MANSION("物件詳細を知りたい", 1),
	APART("空室確認", 2),
	DEPACHED("内覧希望", 3),
	STORE("その他", 4);

	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    ProcessClass(String name, int value) {
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
     * お問合わせ種類名称を取得
     *
     * @param value お問合わせ種類値
     *
     * @return お問合わせ種類名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (ProcessClass processClass : ProcessClass.values()) {
            if (processClass.getValue() == value) {
                name = processClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * お問合わせ種類選択項目リストの設定
     *
     * @return お問合わせ種類選択項目リスト
     */
    public static List<MasterDto> getProcessClassList() {
    	List<MasterDto> processClassList = new ArrayList<MasterDto>();
    	for (ProcessClass processClass : ProcessClass.values()) {
    		MasterDto processClassDto = new MasterDto();
    		processClassDto.setId(processClass.getValue() );
    		processClassDto.setName(processClass.getName());
    		processClassList.add(processClassDto);
    	}
    	return processClassList;
    }

    /**
     * お問合わせ種類選択項目リストの設定(空行あり)
     *
     * @return お問合わせ種類選択項目リスト
     */
    public static List<MasterDto> getProcessClassAndBlankList() {
    	int value = 0;
    	String name = "";

    	List<MasterDto> processClassList = new ArrayList<MasterDto>();
    	//空行設定
    	MasterDto processClassBlankDto = new MasterDto();
    	processClassBlankDto.setId(value);
    	processClassBlankDto.setName(name);
    	processClassList.add(processClassBlankDto);
    	for (ProcessClass processClass : ProcessClass.values()) {
    		MasterDto processClassDto = new MasterDto();
    		processClassDto.setId(processClass.getValue() );
    		processClassDto.setName(processClass.getName());
    		processClassList.add(processClassDto);
    	}
    	return processClassList;
    }
}
