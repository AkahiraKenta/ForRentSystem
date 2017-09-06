package jp.co.forrentsystem.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.co.forrentsystem.constants.Constants;
import jp.co.forrentsystem.constants.MasterDto;

public class UtilService {

	/**
	 * 有効/無効のリスト取得処理
	 *
	 * @return 選択項目の表示内容(有効/無効)
	 */
	public static List<MasterDto> getMasterDtoListForFlag() {
		return getMasterDtoListForFlag(0);
	}

	/**
	 * 有効/無効の表示用リスト作成処理
	 * @param sort 0：無効→有効　1:有効→無効
	 * @return
	 */
	public static List<MasterDto> getMasterDtoListForFlag(int sort) {
		Map<Integer, String> flagMap = new LinkedHashMap<Integer, String>();
		if (sort == 0) {
			flagMap.put(Constants.FALSE_VALUE, Constants.FALSE_NAME);
			flagMap.put(Constants.TRUE_VALUE, Constants.TRUE_NAME);
		} else {
			flagMap.put(Constants.TRUE_VALUE, Constants.TRUE_NAME);
			flagMap.put(Constants.FALSE_VALUE, Constants.FALSE_NAME);
		}

		return ViewUtil.getMasterDtoList(flagMap);
	}

	/**
	 * 有効/無効の名称取得処理
	 *
	 * @return 有効無効項目値名称
	 */
	public static String getNameForFlag(Integer value) {
		String name = null;
		if (Constants.FALSE_VALUE == value) {
			name = Constants.FALSE_NAME;
		} else {
			name = Constants.TRUE_NAME;
		}
		return name;
	}

	/**
	 * 表示/非表示の表示用リスト作成処理
	 *
	 * @return 選択項目の表示内容(表示/非表示)
	 */
	public static List<MasterDto> getMasterDtoListForViewFlag() {
		Map<Integer, String> flagMap = new HashMap<Integer, String>();
		flagMap.put(Constants.NOT_VIEW_VALUE, Constants.NOT_VIEW_NAME);
		flagMap.put(Constants.VIEW_VALUE, Constants.VIEW_NAME);
		return ViewUtil.getMasterDtoList(flagMap);
	}
	/**
	 * 表示/非表示の名称取得処理
	 *
	 * @return 有効無効項目値名称
	 */
	public static String getNameForViewFlag(Integer value) {
		String name = null;
		if (Constants.NOT_VIEW_VALUE == value) {
			name = Constants.NOT_VIEW_NAME;
		} else {
			name = Constants.VIEW_NAME;
		}
		return name;
	}

	/**
	 * 公開/非公開の表示用リスト作成処理
	 *
	 * @return 選択項目の表示内容(公開/非公開)
	 */
	public static List<MasterDto> getMasterDtoListForPublicationFlag() {
		Map<Integer, String> flagMap = new HashMap<Integer, String>();
		flagMap.put(Constants.NOT_PUBLICATION_VALUE, Constants.NOT_PUBLICATION_NAME);
		flagMap.put(Constants.PUBLICATION_VALUE, Constants.PUBLICATION_NAME);
		return ViewUtil.getMasterDtoList(flagMap);
	}
	/**
	 * 公開/非公開の名称取得処理
	 *
	 * @return 公開/非公開項目値名称
	 */
	public static String getNameForPublicationFlag(Integer value) {
		String name = null;
		if (Constants.NOT_PUBLICATION_VALUE == value) {
			name = Constants.NOT_PUBLICATION_NAME;
		} else {
			name = Constants.PUBLICATION_NAME;
		}
		return name;
	}


	/**
	 * 配列をリストに変換(文字列用）
	 *
	 * @param array 配列
	 *
	 * @return List<String>
	 *
	 */
	public static List<String> changeListString(String[] array) {
		List<String> arrayList = new ArrayList<String>();
		if (array != null && array.length != 0) {
			for (String str : array) {
				arrayList.add(str);
			}
		}

		return arrayList;
	}

	/**
	 * 配列をリストに変換(数値用）
	 *
	 * @param array 配列
	 *
	 * @return List<Integer>
	 *
	 */
	public static List<Integer> changeListInteger(String[] array) {
		List<Integer> arrayList = new ArrayList<Integer>();
		if (array != null && array.length != 0) {
			for (String str : array) {
				arrayList.add(Integer.parseInt(str));
			}
		}

		return arrayList;
	}


	/**
	 * リストを配列に変換
	 *
	 * @param array 配列
	 *
	 * @return List<Integer>
	 *
	 */
	public static String[] changeArray(List<Integer> paramList) {
		String[] array = new String[paramList.size()];
		for (int i=0; i < paramList.size(); i++) {
			array[i] = String.valueOf(paramList.get(i));
		}

		return array;
	}
}


