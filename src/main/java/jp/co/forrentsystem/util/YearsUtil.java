package jp.co.forrentsystem.util;

import java.util.Calendar;

/**
 * 年数を取得ユーティル
 *
 * @author k.akahira
 *
 */
public class YearsUtil {

	/**
	 * 築年数を取得（現在年月-築年数）
	 *
	 * @param years 築年数
	 *
	 * @return 現在年月‐築年数
	 */
	public static Integer getBuiltYears(int years) {
		// 現在の年を取得
		int year = getBuiltYear(years);
		// 現在の月を取得
		int month = getBuiltMonth();

		String monthStr = null;
		if (month < 10) {
			monthStr = "0".concat(String.valueOf(month));
		} else {
			monthStr = String.valueOf(month);
		}

		String yearMonthStr = String.valueOf(year).concat(monthStr);

		return Integer.parseInt(yearMonthStr);
	}

	/**
	 * 築年数(年）を取得（現在年月-築年数）
	 *
	 * @param years 築年数
	 *
	 * @return 現在年月‐築年数
	 */
	public static Integer getBuiltYear(int years) {
		// 現在の年月を取得
		Calendar calendar = Calendar.getInstance();

		// 現在の年を取得
		int year = calendar.get(Calendar.YEAR) - years;

		return year;
	}

	/**
	 * 築年数(月）を取得
	 *
	 * @return 現在月
	 */
	public static Integer getBuiltMonth() {
		// 現在の年月を取得
		Calendar calendar = Calendar.getInstance();
		// 現在の月を取得
		int month = calendar.get(Calendar.MONTH) + 1;

		return month;
	}



}
