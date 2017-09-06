package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * リンク区分の共通定数クラス
 * @author webridge
 *
 */
public enum LinkClass {

	/** 列挙定数の定義 */
	TARGET_BLANK("ターゲットブランク", 1),
	OTHER("その他", 2);

	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    LinkClass(String name, int value) {
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
     * リンク区分名称を取得
     *
     * @param value リンク区分値
     *
     * @return リンク区分名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (LinkClass linkClass : LinkClass.values()) {
            if (linkClass.getValue() == value) {
                name = linkClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * リンク区分選択項目リストの設定
     *
     * @return リンク区分選択項目リスト
     */
    public static List<MasterDto> getLinkClassList() {
    	List<MasterDto> LinkClassList = new ArrayList<MasterDto>();
    	for (LinkClass linkClass : LinkClass.values()) {
    		MasterDto LinkClassDto = new MasterDto();
    		LinkClassDto.setId(linkClass.getValue() );
    		LinkClassDto.setName(linkClass.getName());
    		LinkClassList.add(LinkClassDto);
    	}
    	return LinkClassList;
    }
}
