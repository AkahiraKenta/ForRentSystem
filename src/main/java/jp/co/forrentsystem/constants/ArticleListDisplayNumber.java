package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 *物件一覧表示件数の共通定数クラス
 * @author webridge
 *
 */
public enum ArticleListDisplayNumber {

	/** 列挙定数の定義 */
	FIVE("5", 5),
	TEN("10", 10),
	FIFTEEN("15", 15),
	TWENTY("20", 20);


	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    ArticleListDisplayNumber(String name, int value) {
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
     *物件一覧表示件数のIDを取得
     *
     * @param name物件一覧表示件数名称
     *
     * @return物件一覧表示件数値
     */
    public static Integer getTargetId(String name) {
    	int value = 0;
    	for (ArticleListDisplayNumber articleListDisplayNumber : ArticleListDisplayNumber.values()) {
            if (StringUtils.equals(articleListDisplayNumber.getName(), name)) {
            	value = articleListDisplayNumber.getValue();
                break;
            }
        }
    	return value;
    }

    /**
     *物件一覧表示件数の名称を取得
     *
     * @param value物件一覧表示件数値
     *
     * @return物件一覧表示件数名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (ArticleListDisplayNumber articleListDisplayNumber : ArticleListDisplayNumber.values()) {
            if (articleListDisplayNumber.getValue() == value) {
                name = articleListDisplayNumber.getName();
                break;
            }
        }
    	return name;
    }

    /**
     *物件一覧表示件数の選択項目リストの設定
     *
     * @return物件一覧表示件数の選択項目リスト
     */
    public static List<MasterDto> getArticleList() {
    	List<MasterDto> systemSettingList = new ArrayList<MasterDto>();
    	for (ArticleListDisplayNumber articleListDisplayNumber : ArticleListDisplayNumber.values()) {
    		MasterDto systemSettingDto = new MasterDto();
    		systemSettingDto.setId(articleListDisplayNumber.getValue() );
    		systemSettingDto.setName(articleListDisplayNumber.getName());
    		systemSettingList.add(systemSettingDto);
    	}
    	return systemSettingList;
    }
}
