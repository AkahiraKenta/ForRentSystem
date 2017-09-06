package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 処理ステータスの共通定数クラス
 * @author webridge
 *
 */
public enum ProcessStatus {

	/** 列挙定数の定義 */
	LEFT_UNATTENDED("未処理", 1),
	PROCESSED("処理済", 2),
	RESPOND("対応中", 3);

	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    ProcessStatus(String name, int value) {
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
     * 処理ステータス名称を取得
     *
     * @param value 処理ステータス値
     *
     * @return 処理ステータス名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (ProcessStatus processStatus : ProcessStatus.values()) {
            if (processStatus.getValue() == value) {
                name = processStatus.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 処理ステータス選択項目リストの設定
     *
     * @return 処理ステータス選択項目リスト
     */
    public static List<MasterDto> getProcessStatusList() {
    	List<MasterDto> processStatusList = new ArrayList<MasterDto>();
    	for (ProcessStatus processStatus : ProcessStatus.values()) {
    		MasterDto processStatusDto = new MasterDto();
    		processStatusDto.setId(processStatus.getValue() );
    		processStatusDto.setName(processStatus.getName());
    		processStatusList.add(processStatusDto);
    	}
    	return processStatusList;
    }
}
