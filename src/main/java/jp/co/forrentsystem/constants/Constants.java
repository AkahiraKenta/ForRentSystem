package jp.co.forrentsystem.constants;

public final class Constants {

	private Constants(){};

	/** 削除フラグ：未削除 */
	public static final Integer DELETE_FLAG_FALSE = 0;

	/** フラグ値：0(無効) */
	public static final Integer FALSE_VALUE = 0;
	/** フラグ値：1(有効) */
	public static final Integer TRUE_VALUE = 1;
	/** フラグ名称：無効 */
	public static final String FALSE_NAME = "無効";
	/** フラグ名称：有効 */
	public static final String TRUE_NAME = "有効";

	/** 有効・無効 ソート順 無効→有効 */
	public static final int SORT_ASC = 0;
	/** 有効・無効 ソート順 有効→無効 */
	public static final int SORT_DESC = 1;

	/** フラグ値：0(非表示) */
	public static final Integer NOT_VIEW_VALUE = 0;
	/** フラグ値：1(表示) */
	public static final Integer VIEW_VALUE = 1;
	/** フラグ名称：非表示 */
	public static final String NOT_VIEW_NAME = "非表示";
	/** フラグ名称：表示 */
	public static final String VIEW_NAME = "表示";

	/** フラグ値：0(非公開) */
	public static final Integer NOT_PUBLICATION_VALUE = 0;
	/** フラグ値：1(公開) */
	public static final Integer PUBLICATION_VALUE = 1;
	/** フラグ名称：非公開 */
	public static final String NOT_PUBLICATION_NAME = "非公開";
	/** フラグ名称：公開 */
	public static final String PUBLICATION_NAME = "公開";

}
