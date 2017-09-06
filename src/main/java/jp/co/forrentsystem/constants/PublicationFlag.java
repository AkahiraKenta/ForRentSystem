package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 公開フラグの共通定数クラス
 * @author webridge
 *
 */
public enum PublicationFlag {
    /** 列挙定数の定義 */
	PUBLICATION_FLAG__OFF("非公開", 0),
	PUBLICATION_FLAG__ON("公開", 1);

    /** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    PublicationFlag(String name, int value) {
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
     * 公開フラグ名称の取得
     *
     * @param value 公開フラグ値
     *
     * @return 公開フラグ名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (PublicationFlag publicationFlag : PublicationFlag.values()) {
            if (publicationFlag.getValue() == value) {
                name = publicationFlag.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 公開フラグ選択項目リストの設定
     *
     * @return 公開フラグ選択項目リスト
     */
    public static List<MasterDto> getPublicationFlagList() {
    	List<MasterDto> publicationFlagList = new ArrayList<MasterDto>();
    	for (PublicationFlag publicationFlag : PublicationFlag.values()) {
    		MasterDto publicationFlagDto = new MasterDto();
    		publicationFlagDto.setId(publicationFlag.getValue());
    		publicationFlagDto.setName(publicationFlag.getName());
    		publicationFlagList.add(publicationFlagDto);
    	}
    	return publicationFlagList;
    }
}