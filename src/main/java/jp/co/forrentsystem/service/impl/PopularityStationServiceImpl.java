package jp.co.forrentsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import jp.co.forrentsystem.constants.Constants;
import jp.co.forrentsystem.dao.PopularityStationDao;
import jp.co.forrentsystem.dao.StationDao;
import jp.co.forrentsystem.dto.PopularityStationDto;
import jp.co.forrentsystem.dto.StationDto;
import jp.co.forrentsystem.service.PopularityStationService;
import jp.co.forrentsystem.service.SystemSettingService;
import jp.co.forrentsystem.util.FileUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 人気駅サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class PopularityStationServiceImpl implements PopularityStationService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(PopularityStationServiceImpl.class);

	@Autowired
	private StationDao stationDao;
	@Autowired
	private PopularityStationDao popularityStationDao;
	@Autowired
	private SystemSettingService systemSettingService;

	@Override
	public List<PopularityStationDto> getPopularityStationList() {
		logger.info("StationServiceImpl-getPopularityStationList");
		// 人気駅情報を全て取得
		return popularityStationDao.getPopularityStationList();
	}

	@Override
	public PopularityStationDto registPopularityStation(Integer stationId) {
		logger.info("StationServiceImpl-registPopularityStation");

		// 人気駅の順位最大値を取得
		Integer rank = popularityStationDao.getRank();

		// 人気駅順位の設定最大値取得
		Integer maxRankConfig = FileUtil.getMaxRank();
		PopularityStationDto popularityStationDto = new PopularityStationDto();
		if (rank == null || rank <= maxRankConfig) {
			// 人気駅が最大まで設定されていない場合、駅情報を人気駅DTOに設定
			// 駅名称を取得
			StationDto stationDto = stationDao.getStationByStationId(stationId);
			popularityStationDto.setStationId(stationId);
			popularityStationDto.setStationName(stationDto.getStationName());
			popularityStationDto.setRank(rank == null ? 1 : rank);
			popularityStationDto.setDeleteFlag(Constants.DELETE_FLAG_FALSE);

			// 人気駅登録
			popularityStationDao.registPopularityStation(popularityStationDto);
		}
		return popularityStationDto;
	}

	@Override
	public PopularityStationDto deletePopularityStation(Integer stationId) {
		logger.info("StationServiceImpl-deletePopularityStation");

		PopularityStationDto popularityStationDto = new PopularityStationDto();

		// 駅名称を取得
		StationDto stationDto = stationDao.getStationByStationId(stationId);
		popularityStationDto.setStationId(stationId);
		popularityStationDto.setStationName(stationDto.getStationName());

		// 対象人気駅を削除
		popularityStationDao.deletePopularityStation(popularityStationDto);

		// 現在の人気駅を取得
		List<PopularityStationDto> popularityStationDtoList = popularityStationDao.getPopularityStationList();

		// 人気駅リストから削除対象人気駅を取り除く
		for (PopularityStationDto deleteDto : popularityStationDtoList) {
			if (deleteDto.getStationId() == popularityStationDto.getStationId()) {
				popularityStationDtoList.remove(deleteDto);
				break;
			}
		}

		// 人気駅に順位を振り直し、更新
		for (int i = 0; i < popularityStationDtoList.size(); i++) {
			// 人気駅の順位をupdate
			popularityStationDtoList.get(i).setRank(i+1);
			popularityStationDao.updateRank(popularityStationDtoList.get(i));
		}
		return popularityStationDto;
	}

	@Override
	public List<PopularityStationDto> updatePopularityStation(String[] stationIdArray) {
		logger.info("StationServiceImpl-updatePopularityStation");

		List<PopularityStationDto> popularityStationDtoList = new ArrayList<PopularityStationDto>();
		for(int i = 0; i < stationIdArray.length; i++) {
			// 人気駅IDをループ、DTOに駅IDと順位を格納
			PopularityStationDto popularityStationDto = new PopularityStationDto();
			popularityStationDto.setStationId(Integer.parseInt(stationIdArray[i]));
			popularityStationDto.setRank(i+1);

			// DTOに格納した人気駅情報で更新
			popularityStationDao.updateRank(popularityStationDto);

			popularityStationDtoList.add(popularityStationDto);
		}

		return popularityStationDtoList;
	}

	@Override
	public List<StationDto> getStationListForPopularityStationByRouteId(
			Integer routeId) {
		logger.info("StationServiceImpl-getStationListForPopularityStationByRouteId");

		// 沿線IDをキーに人気駅に設定されていない駅情報を全て取得
		return stationDao.getStationListForPopularityStationByRouteId(routeId);
	}

	@Override
	public List<PopularityStationDto> getPopularityStationListByViewNumber() {
		logger.info("StationServiceImpl-getPopularityStationListByViewNumber");

		// 人気駅表示件数取得
		int popularityStationViewNumber = systemSettingService.getSystemSettingForPopularityStation();

		// 人気駅情報を取得
		return popularityStationDao.getPopularityStationListByViewNumber(popularityStationViewNumber);
	}
}
