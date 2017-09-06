package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.constants.BannerDisplayNumber;
import jp.co.forrentsystem.constants.Constants;
import jp.co.forrentsystem.constants.NewArticleDisplayNumber;
import jp.co.forrentsystem.constants.NewsDisplayNumber;
import jp.co.forrentsystem.constants.PopularityAreaDisplayNumber;
import jp.co.forrentsystem.constants.PopularityStationDisplayNumber;
import jp.co.forrentsystem.constants.RecommendedRoomDisplayNumber;
import jp.co.forrentsystem.dao.SystemSettingDao;
import jp.co.forrentsystem.dto.SystemSettingDto;
import jp.co.forrentsystem.service.SystemSettingService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * システム設定サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class SystemSettingServiceImpl implements SystemSettingService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(SystemSettingServiceImpl.class);

	@Autowired
	private SystemSettingDao systemSettingDao;

	@Override
	public List<SystemSettingDto> getSystemSettingList() {
		logger.info("SystemSettingServiceImpl-getSystemSettingList");

		// システム設定情報を取得
		return systemSettingDao.getSystemSettingList();
	}

	@Override
	public void updateDisplayNumber(Integer systemSettingId,
			Integer displayNumberId) {
		logger.info("SystemSettingServiceImpl-updateDisplayNumber");

		// 表示順を取得
		String displayNumberStr = getDisplayNumber(systemSettingId,displayNumberId);

		if (!StringUtils.isEmpty(displayNumberStr)) {
			SystemSettingDto systemSettingDto = new SystemSettingDto();
			systemSettingDto.setSystemSettingId(systemSettingId);
			systemSettingDto.setDisplayNumber(Integer.parseInt(displayNumberStr));
			systemSettingDto.setDeleteFlag(Constants.DELETE_FLAG_FALSE);

			// システム設定を更新
			systemSettingDao.updateDisplayNumber(systemSettingDto);
		}

	}

	/**
	 * システム設定IDをキーに表示件数を取得
	 * @param systemSettingId システム設定ID
	 * @param displayNumberId 表示件数ID
	 * @return 表示件数
	 */
	private String getDisplayNumber(Integer systemSettingId,
			Integer displayNumberId) {
		String displayNumber = null;
		switch (systemSettingId) {
		case 1:
			// 新着物件表示件数
			displayNumber = NewArticleDisplayNumber.getTargetName(displayNumberId);
			break;
		case 2:
			// 人気駅表示件数
			displayNumber = PopularityStationDisplayNumber.getTargetName(displayNumberId);
			break;
		case 3:
			// 人気エリア表示件数
			displayNumber = PopularityAreaDisplayNumber.getTargetName(displayNumberId);
			break;
		case 4:
			// ニュース一覧表示件数
			displayNumber = NewsDisplayNumber.getTargetName(displayNumberId);
			break;
		case 5:
			// バナー表示件数
			displayNumber = BannerDisplayNumber.getTargetName(displayNumberId);
			break;
		case 6:
			// おすすめ物件表示件数
			displayNumber = RecommendedRoomDisplayNumber.getTargetName(displayNumberId);
			break;
		case 7:
			// 物件一覧表示件数
			displayNumber = RecommendedRoomDisplayNumber.getTargetName(displayNumberId);
			break;
		default:
			break;
		}

		return displayNumber;
	}

	@Override
	public Integer getSystemSettingForNewArticle() {
		logger.info("SystemSettingServiceImpl-getSystemSettingForNewArticle");

		// 新着物件表示件数を取得
		List<SystemSettingDto> systemSettingList = systemSettingDao.getSystemSettingList();

		// 新着物件の表示件数を返却
		return systemSettingList.get(0).getDisplayNumber();
	}

	@Override
	public int getSystemSettingForPopularityStation() {
		logger.info("SystemSettingServiceImpl-getSystemSettingForPopularityStation");

		// 人気駅表示件数を取得
		List<SystemSettingDto> systemSettingList = systemSettingDao.getSystemSettingList();

		// 人気駅表示件数を返却
		return systemSettingList.get(1).getDisplayNumber();
	}

	@Override
	public int getSystemSettingForPopularityArea() {
		logger.info("SystemSettingServiceImpl-getSystemSettingForPopularityArea");

		// 人気エリア表示件数を取得
		List<SystemSettingDto> systemSettingList = systemSettingDao.getSystemSettingList();

		// 人気エリア表示件数を返却
		return systemSettingList.get(2).getDisplayNumber();
	}

	@Override
	public int getSystemSettingForNewsViewNumber() {
		logger.info("SystemSettingServiceImpl-getSystemSettingForNewsViewNumber");

		// ニュース表示件数を取得
		List<SystemSettingDto> systemSettingList = systemSettingDao.getSystemSettingList();

		// ニュース表示件数を返却
		return systemSettingList.get(4).getDisplayNumber();
	}

	@Override
	public int getSystemSettingForRecommendedRoom() {
		logger.info("SystemSettingServiceImpl-getSystemSettingForRecommendedRoom");

		// おすすめ物件表示件数を取得
		List<SystemSettingDto> systemSettingList = systemSettingDao.getSystemSettingList();

		// おすすめ物件表示件数を返却
		return systemSettingList.get(5).getDisplayNumber();
	}

	@Override
	public int getSystemSettingForBanner() {
		logger.info("SystemSettingServiceImpl-getSystemSettingForBanner");

		// バナー表示件数を取得
		List<SystemSettingDto> systemSettingList = systemSettingDao.getSystemSettingList();

		// バナー表示件数を返却
		return systemSettingList.get(3).getDisplayNumber();
	}

	@Override
	public int getSystemSettingForArticleList() {
		logger.info("SystemSettingServiceImpl-getSystemSettingForBanner");

		// 物件一覧表示件数を取得
		List<SystemSettingDto> systemSettingList = systemSettingDao.getSystemSettingList();

		// 物件一覧表示件数を返却
		return systemSettingList.get(6).getDisplayNumber();
	}


}
