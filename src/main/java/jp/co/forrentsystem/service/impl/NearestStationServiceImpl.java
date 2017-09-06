package jp.co.forrentsystem.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.co.forrentsystem.dao.NearestStationDao;
import jp.co.forrentsystem.dao.StationDao;
import jp.co.forrentsystem.dto.NearestStationDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.dto.SearchConditionDto;
import jp.co.forrentsystem.form.backend.EditBuildingForm;
import jp.co.forrentsystem.form.backend.RegistBuildingForm;
import jp.co.forrentsystem.form.frontend.FSearchConditionForm;
import jp.co.forrentsystem.service.NearestStationService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 最寄駅マスタサービス実装クラス
 * @author k.akahira
 *
 */
@Service
public class NearestStationServiceImpl implements NearestStationService{

	private Logger logger = org.slf4j.LoggerFactory.getLogger(NearestStationServiceImpl.class);

	@Autowired
	private NearestStationDao nearestStationDao;
	@Autowired
	private StationDao stationDao;

	@Override
	public List<NearestStationDto> getNearestStationDtoList(
			RegistBuildingForm registConfirmBuildingForm, Integer buildingId) {
		List<NearestStationDto> nearestStationDtoList = new ArrayList<NearestStationDto>();
		if (registConfirmBuildingForm.getNearestRoute1() != null &&
				registConfirmBuildingForm.getNearestRoute1() != 999) {
			nearestStationDtoList.add(addNearestStationDto(buildingId, registConfirmBuildingForm.getNearestRoute1(),
					registConfirmBuildingForm.getNearestStation1(), registConfirmBuildingForm.getMinutesWalk1(), registConfirmBuildingForm.getDisplayNumber1()));
		}
		if (registConfirmBuildingForm.getNearestRoute2() != null &&
				registConfirmBuildingForm.getNearestRoute2() != 999) {
			nearestStationDtoList.add(addNearestStationDto(buildingId, registConfirmBuildingForm.getNearestRoute2(),
					registConfirmBuildingForm.getNearestStation2(), registConfirmBuildingForm.getMinutesWalk2(), registConfirmBuildingForm.getDisplayNumber2()));
		}
		if (registConfirmBuildingForm.getNearestRoute3() != null &&
				registConfirmBuildingForm.getNearestRoute3() != 999) {
			nearestStationDtoList.add(addNearestStationDto(buildingId, registConfirmBuildingForm.getNearestRoute3(),
					registConfirmBuildingForm.getNearestStation3(), registConfirmBuildingForm.getMinutesWalk3(), registConfirmBuildingForm.getDisplayNumber3()));
		}

		return nearestStationDtoList;
	}

	@Override
	public List<NearestStationDto> getNearestStationDtoList(
			EditBuildingForm editConfirmBuildingForm, Integer buildingId) {
		List<NearestStationDto> nearestStationDtoList = new ArrayList<NearestStationDto>();
		if (editConfirmBuildingForm.getNearestRoute1() != null &&
				editConfirmBuildingForm.getNearestRoute1() != 999) {
			nearestStationDtoList.add(addNearestStationDto(buildingId, editConfirmBuildingForm.getNearestRoute1(),
					editConfirmBuildingForm.getNearestStation1(), editConfirmBuildingForm.getMinutesWalk1(), editConfirmBuildingForm.getDisplayNumber1()));
		}
		if (editConfirmBuildingForm.getNearestRoute2() != null &&
				editConfirmBuildingForm.getNearestRoute2() != 999) {
			nearestStationDtoList.add(addNearestStationDto(buildingId, editConfirmBuildingForm.getNearestRoute2(),
					editConfirmBuildingForm.getNearestStation2(), editConfirmBuildingForm.getMinutesWalk2(), editConfirmBuildingForm.getDisplayNumber2()));
		}
		if (editConfirmBuildingForm.getNearestRoute3() != null &&
				editConfirmBuildingForm.getNearestRoute3() != 999) {
			nearestStationDtoList.add(addNearestStationDto(buildingId, editConfirmBuildingForm.getNearestRoute3(),
					editConfirmBuildingForm.getNearestStation3(), editConfirmBuildingForm.getMinutesWalk3(), editConfirmBuildingForm.getDisplayNumber3()));
		}

		return nearestStationDtoList;
	}

	@Override
	public void registNearestStation(List<NearestStationDto> nearestStationDtoList) {
		logger.info("NearestStationServiceImpl-registNearestStation");
		for (NearestStationDto nearestStationDto : nearestStationDtoList) {
			// 最寄駅情報を登録
			nearestStationDao.registNearestStation(nearestStationDto);
		}
	}

	private NearestStationDto addNearestStationDto(
			Integer buildingId, Integer routeId, Integer stationId, Integer minutesWalk, Integer displayNumber) {
		// 最寄駅情報をDTOに設定
		NearestStationDto nearestStationDto = new NearestStationDto();
		nearestStationDto.setBuildingId(buildingId);
		nearestStationDto.setRouteId(routeId);
		nearestStationDto.setStationId(stationId);
		nearestStationDto.setMinutesWalk(minutesWalk);
		nearestStationDto.setDisplayNumber(displayNumber);
		nearestStationDto.setDeleteFlag(0);

		return nearestStationDto;
	}

	@Override
	public List<NearestStationNameDto> getNearestStationNameList(
			Integer buildingId) {
		logger.info("NearestStationServiceImpl-getNearestStationNameList");

		// 建物IDをキーに最寄駅情報を取得
		return nearestStationDao.getNearestStationNameList(buildingId);
	}

	@Override
	public void updateNearestStation(
			List<NearestStationDto> nearestStationDtoList, Integer buildingId) {
		logger.info("NearestStationServiceImpl-updateNearestStation");

		// 現在登録されている最寄駅情報が存在するかチェックする
		Integer count = nearestStationDao.countNearestStationByBuildingId(buildingId);
		if (count != 0) {
			// 現在登録済みの最寄駅情報を削除
			nearestStationDao.deleteNearestStationByBuildingId(buildingId);
		}
		for (NearestStationDto nearestStationDto : nearestStationDtoList) {
			// 変更された最寄駅徐湯ほうを登録(更新)
			nearestStationDao.registNearestStation(nearestStationDto);
		}
	}

	@Override
	public Map<Integer, List<NearestStationNameDto>> getNearestStationNameListMap() {
		logger.info("NearestStationServiceImpl-getNearestStationNameListMap");

		// 沿線駅情報を取得
		List<NearestStationNameDto> nearestStationList = nearestStationDao.getRouteAndStationList();

		// 取得した沿線駅情報を沿線単位にMAPに格納する
		Map<Integer, List<NearestStationNameDto>> nearestStationListMap = new LinkedHashMap<Integer, List<NearestStationNameDto>>();

		// 比較用沿線IDを格納する変数
		int beforeRouteId = 0;

		// マップに格納する沿線駅情報リスト
		List<NearestStationNameDto> nearestStationNameList = new LinkedList<NearestStationNameDto>();

		for(NearestStationNameDto nearestStationNameDto : nearestStationList) {
			// 沿線駅情報リストを沿線単位にまとめる処理
			if(beforeRouteId != nearestStationNameDto.getRouteId()) {
				if (beforeRouteId != 0) {
					// 変数値が初期値ではない場合、沿線単位にまとめたリストをマップに格納
					nearestStationListMap.put(beforeRouteId, nearestStationNameList);

					// 新しくリストを作成
					nearestStationNameList = new LinkedList<NearestStationNameDto>();
				}
				// 変数値とDTOの沿線IDが異なる場合、変数値に沿線IDを設定する
				beforeRouteId = nearestStationNameDto.getRouteId();

			}
			nearestStationNameList.add(nearestStationNameDto);
		}
		// 最後の沿線駅情報をマップに格納
		nearestStationListMap.put(nearestStationNameList.get(0).getRouteId(), nearestStationNameList);



		return nearestStationListMap;
	}

	@Override
	public List<NearestStationNameDto> getRouteAndStationNameList(
			FSearchConditionForm fSearchConditionForm) {
		logger.info("NearestStationServiceImpl-getRouteAndStationNameList");

		List<NearestStationNameDto> resultList = new ArrayList<NearestStationNameDto>();

		if (fSearchConditionForm.getSelectedStationId() != null
			&& fSearchConditionForm.getSelectedStationId().length != 0) {
			SearchConditionDto searchConditionDto = new SearchConditionDto();
			// TODO:沿線も表示する際は、コメントアウトを外す。
			// 沿線IDリスト格納用
//			List<Integer> routeIdList = new LinkedList<Integer>();

			// 駅IDリスト格納用
			List<Integer> stationIdList = new LinkedList<Integer>();

			// 沿線は、検索条件に含めないこと。（山手線新宿駅、総武線新宿駅の区別は行わない。）
			// 沿線と駅が選択情報が存在する場合、沿線IDリストと駅IDリストを作成する
			for (String routeAndStationId : fSearchConditionForm.getSelectedStationId()) {
//				String routeId = null;
				String stationId = null;
				if (routeAndStationId.matches(".*_.*")) {
//					routeId = routeAndStationId.split("_")[0];
					stationId = routeAndStationId.split("_")[1];
//					routeIdList.add(Integer.parseInt(routeId));
					stationIdList.add(Integer.parseInt(stationId));
				} else {
					stationIdList.add(Integer.parseInt(routeAndStationId));
				}
			}
			// 重複除く
			Set<Integer> stationSet = new HashSet<Integer>();
			stationSet.addAll(stationIdList);

			List<Integer> stationList = new ArrayList<Integer>();
			stationList.addAll(stationSet);

			// TODO:沿線も表示する際は、routeIdListを設定すること。
			searchConditionDto.setRouteIdList(new ArrayList<Integer>());
			searchConditionDto.setStationIdList(stationList);
			if (!StringUtils.equals(fSearchConditionForm.getSelectedStationId()[0], "999")) {
				resultList = nearestStationDao.getRouteAndStationNameList(searchConditionDto);
			}
		}

		return resultList;
	}
}
