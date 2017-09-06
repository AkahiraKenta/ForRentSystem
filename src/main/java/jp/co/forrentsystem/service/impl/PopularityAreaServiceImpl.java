package jp.co.forrentsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import jp.co.forrentsystem.constants.Constants;
import jp.co.forrentsystem.dao.AddressDao;
import jp.co.forrentsystem.dao.PopularityAreaDao;
import jp.co.forrentsystem.dao.impl.AddressImportHistoryDao;
import jp.co.forrentsystem.dto.AddressDto;
import jp.co.forrentsystem.dto.PopularityAreaDto;
import jp.co.forrentsystem.service.PopularityAreaService;
import jp.co.forrentsystem.service.SystemSettingService;
import jp.co.forrentsystem.util.FileUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 人気エリアサービス実装クラス
 * @author k.akhaira
 *
 */
@Service
 public class PopularityAreaServiceImpl implements PopularityAreaService {

	@Autowired
	private AddressDao addressDao;
	@Autowired
	private AddressImportHistoryDao addressImportHistoryDao;
	@Autowired
	private PopularityAreaDao popularityAreaDao;
	@Autowired
	private SystemSettingService systemSettingService;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(PopularityAreaServiceImpl.class);

	@Override
	public List<AddressDto> getProvinceListForPopularityArea() {
		logger.info("AddressServiceImpl-getProvinceListForPopularityArea");
		return addressDao.getProvinceListForPopularityArea();
	}

	@Override
	public List<PopularityAreaDto> getPopularityAreaList() {
		logger.info("AddressServiceImpl-getPopularityAreaList");
		return popularityAreaDao.getPopularityAreaList();
	}

	@Override
	public List<AddressDto> getAddressListForPopularityAreaByProvince(
			String province) {
		logger.info("AddressServiceImpl-getAddressListForPopularityAreaByProvince");
		return addressDao.getAddressListForPopularityAreaByProvince(province);
	}

	@Override
	public PopularityAreaDto registPopularityArea(String province, String city, String townArea) {
		logger.info("AddressServiceImpl-registPopularityArea");
		// 人気駅順位の設定最大値取得
		Integer maxRankConfig = FileUtil.getMaxRank();
		// 人気エリアの順位最大値を取得
		Integer rank = popularityAreaDao.getRank();
		// 返却用
		PopularityAreaDto resultPolularityAreaDto = new PopularityAreaDto();
		if (rank == null || rank <= maxRankConfig) {
			// パラメータ用
			PopularityAreaDto popularityAreaDto = new PopularityAreaDto();
			// 人気エリアDTOに値を設定する
			popularityAreaDto.setProvince(province);
			popularityAreaDto.setCity(city);
			popularityAreaDto.setTownArea(townArea);
			popularityAreaDto.setRank(rank == null ? 1 : rank);
			popularityAreaDto.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
			popularityAreaDao.registPopularityArea(popularityAreaDto);

			// 登録したデータを取得
			resultPolularityAreaDto = popularityAreaDao.getPopularityAreaByDto(popularityAreaDto);
		} else {
			// パラメータ用
			PopularityAreaDto popularityAreaDto = new PopularityAreaDto();
			// 人気エリアDTOに値を設定する
			popularityAreaDto.setProvince(province);
			popularityAreaDto.setCity(city);
			popularityAreaDto.setTownArea(townArea);
			resultPolularityAreaDto = popularityAreaDao.getPopularityAreaByDto(popularityAreaDto);
		}

		return resultPolularityAreaDto;
	}

	@Override
	public PopularityAreaDto deletePopularityArea(Integer popularityAreaId) {
		logger.info("AddressServiceImpl-deletePopularityArea");
		// 削除対象の人気エリア情報を取得
		PopularityAreaDto popularityAreaDto = popularityAreaDao.getPopularityAreaByPopularitAreaId(popularityAreaId);
		// 人気エリアを削除
		popularityAreaDao.deletePopularityArea(popularityAreaId);
		// 現在の人気エリアを取得
		List<PopularityAreaDto> popularityAreaDtoList = popularityAreaDao.getPopularityAreaList();

		// 人気エリアリストから削除対象人気エリアを取り除く
		for (PopularityAreaDto deleteDto : popularityAreaDtoList) {
			if (deleteDto.getPopularityAreaId() == popularityAreaDto.getPopularityAreaId()) {
				popularityAreaDtoList.remove(deleteDto);
				break;
			}
		}

		// 人気エリアに順位を振り直し、更新
		for (int i = 0; i < popularityAreaDtoList.size(); i++) {
			// 人気エリアの順位をupdate
			popularityAreaDtoList.get(i).setRank(i+1);
			popularityAreaDao.updateAreaRank(popularityAreaDtoList.get(i));
		}
		return popularityAreaDto;
	}

	@Override
	public List<PopularityAreaDto> updatePopularityArea(
			String[] popularityAreaIdArray) {
		logger.info("AddressServiceImpl-updatePopularityArea");

		List<PopularityAreaDto> popularityAreaDtoList = new ArrayList<PopularityAreaDto>();
		for(int i = 0; i < popularityAreaIdArray.length; i++) {
			// 人気駅IDをループ、DTOに駅IDと順位を格納
			PopularityAreaDto popularityAreaDto = new PopularityAreaDto();
			popularityAreaDto.setPopularityAreaId(Integer.parseInt(popularityAreaIdArray[i]));
			popularityAreaDto.setRank(i+1);
			// DTOに格納した人気駅情報で更新
			popularityAreaDao.updateAreaRank(popularityAreaDto);
			popularityAreaDtoList.add(popularityAreaDto);
		}

		return popularityAreaDtoList;
	}

	@Override
	public List<PopularityAreaDto> getPopularityAreaListByViewNumber() {
		logger.info("AddressServiceImpl-getPopularityAreaListByViewNumber");

		// 人気エリア表示件数取得
		int popularityAreaViewNumber = systemSettingService.getSystemSettingForPopularityArea();

		// 人気エリア表示件数分の人気エリア情報取得
		return popularityAreaDao.getPopularityAreaListByViewNumber(popularityAreaViewNumber);
	}
}
