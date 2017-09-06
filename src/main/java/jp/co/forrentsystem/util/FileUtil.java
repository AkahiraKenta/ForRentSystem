package jp.co.forrentsystem.util;

import java.util.ResourceBundle;

public class FileUtil {

	private static ResourceBundle bundle;

	static {
		// 外部ファイルからパスを取得する
		bundle = ResourceBundle.getBundle("app_setting");
	}

	/**
	 * プロパティファイルで定義された、ディレクトパスを取得
	 *
	 * @return ディレクトリパス
	 */
	public static String getFileBaseDirectory() {

		// 外部ファイルからパスを取得する
		String basePath = bundle.getString("fileupload.path");
		String directory = basePath;

		return directory;
	}

	/**
	 * ディレクトリ区切り文字取得処理
	 *
	 * @return 区切り文字
	 */
	public static String getDirectoryDelimiter() {
		return bundle.getString("directory.delimiter");
	}

	/**
	 * ファイル相対パス取得処理
	 *
	 * @return 相対パス
	 */
	public static String getFileRelativePath() {
		return bundle.getString("file.relative.path");
	}

	/**
	 * 人気エリア、人気駅、お勧め物件の最大設定値
	 *
	 * @return 表示件数
	 */
	public static Integer getMaxRank() {
		return Integer.parseInt(bundle.getString("maxrank.config"));
	}

	/**
	 * 物件検索の1ページに対する表示件数
	 *
	 * @return 表示件数
	 */
	public static Integer getArticleViewNumber() {
		return Integer.parseInt(bundle.getString("article.view.number"));
	}

	/**
	 * 物件お問合せ検索の1ページに対する表示件数
	 *
	 * @return 表示件数
	 */
	public static Integer getContactViewNumber() {
		return Integer.parseInt(bundle.getString("contact.view.number"));
	}

	/**
	 * ヘッダーパス
	 *
	 * @return ヘッダー画像格納パス
	 */
	public static String getHeaderPath() {
		return bundle.getString("file.header.path");
	}

	/**
	 * フッターパス
	 *
	 * @return フッター画像格納パス
	 */
	public static String getFooterPath() {
		return bundle.getString("file.footer.path");
	}

	/**
	 * メイン画像パス
	 *
	 * @return メイン画像格納パス
	 */
	public static String getMainPath() {
		return bundle.getString("file.main.path");
	}

	/**
	 * バナーパス
	 *
	 * @return バナー画像格納パス
	 */
	public static String getBannerPath() {
		return bundle.getString("file.banner.path");
	}

	/**
	 * アップロードファイル最大サイズ
	 *
	 * @return アップロードファイル最大サイズ
	 */
	public static Long getFileUploadMaxSize() {
		return Long.parseLong(bundle.getString("fileupload.max.size"));
	}
}
