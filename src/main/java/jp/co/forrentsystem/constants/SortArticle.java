package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 物件検索のソートの共通定数クラス
 * @author webridge
 *
 */
public enum SortArticle {

	/** 列挙定数の定義 */
	RENT("家賃が安い順", 1),
	BUILT("築年が新しい順", 2),
	SPACE("面積が広い順", 3);

	/** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    SortArticle(String name, int value) {
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
     * ソート名称を取得
     *
     * @param value ソート値
     *
     * @return ソート名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (SortArticle sortArticle : SortArticle.values()) {
            if (sortArticle.getValue() == value) {
                name = sortArticle.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * ソート選択項目リストの設定
     *
     * @return sortArticle選択項目リスト
     */
    public static List<MasterDto> getSortArticleList() {
    	List<MasterDto> sortArticleList = new ArrayList<MasterDto>();
    	for (SortArticle sortArticle : SortArticle.values()) {
    		MasterDto sortArticleDto = new MasterDto();
    		sortArticleDto.setId(sortArticle.getValue() );
    		sortArticleDto.setName(sortArticle.getName());
    		sortArticleList.add(sortArticleDto);
    	}
    	return sortArticleList;
    }
}
