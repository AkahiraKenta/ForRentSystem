package jp.co.forrentsystem.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jp.co.forrentsystem.constants.MasterDto;

public class ViewUtil {

	/**
	 * セレクトボックス表示用項目をマップでもらい、DTOのLIST型で返却する。
	 *
	 * @param masterMap マスタ情報マップ
	 *
	 * @return マスタ情報DTOリスト
	 */
	public static List<MasterDto> getMasterDtoList(Map<Integer,String> masterMap) {
		List<MasterDto> masterDtoUtilList = new ArrayList<MasterDto>();
		for(Entry<Integer, String> entry : masterMap.entrySet()) {
			MasterDto masterDtoUtil = new MasterDto();
			masterDtoUtil.setId(entry.getKey());
			masterDtoUtil.setName(entry.getValue());
			masterDtoUtilList.add(masterDtoUtil);
		}

		return masterDtoUtilList;
	}
}
