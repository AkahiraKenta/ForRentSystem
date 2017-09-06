package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 募集ステータス共通定数クラス
 * @author webridge
 *
 */
public enum RecruitmentStatus {
    /** 列挙定数の定義 */
	VACANCY("空き", 1),
    RESERVE_VACANCY("解約予定", 2),
    UNDER_CONTRACT("契約中", 3);

    /** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    RecruitmentStatus(String name, int value) {
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
     * 対象の募集ステータス名称を取得
     *
     * @param value 募集ステータス値
     *
     * @return 募集ステータス名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (RecruitmentStatus recruitmentStatus : RecruitmentStatus.values()) {
            if (recruitmentStatus.getValue() == value) {
                name = recruitmentStatus.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 募集ステータス選択項目リストの設定
     *
     * @return 募集ステータス選択項目リスト
     */
    public static List<MasterDto> getRecruitmentStatusList() {
    	List<MasterDto> recruitmentStatusList = new ArrayList<MasterDto>();
    	for (RecruitmentStatus recruitmentStatus : RecruitmentStatus.values()) {
    		MasterDto recruitmentStatusDto = new MasterDto();
    		recruitmentStatusDto.setId(recruitmentStatus.getValue() );
    		recruitmentStatusDto.setName(recruitmentStatus.getName());
    		recruitmentStatusList.add(recruitmentStatusDto);
    	}
    	return recruitmentStatusList;
    }
}