package jp.co.forrentsystem.util;

import java.io.File;

public class CsvUtil {
	public static boolean checkFile(File file) {
		if (!file.exists()) {
			// ファイル存在しない場合
			return false;
		} else if (!file.isFile()) {
			// ファイルとして扱えない場合
			return false;
		} else if (!file.canRead()) {
			// ファイルが読み込めない場合
			return false;
		} else if (!file.getPath().endsWith(".CSV")) {
			// CSVファイルではない場合
			return false;
		} else if (12 != file.getName().length()) {
			// ファイル名文字数が異なる場合
			return false;
		}
		return true;
	}
}
