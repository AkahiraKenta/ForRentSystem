package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.BannerDao;
import jp.co.forrentsystem.dto.BannerDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * バナーマスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class BannerDaoImpl extends SqlSessionDaoSupport implements BannerDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(BannerDaoImpl.class);

	@Override
	public List<BannerDto> getBannerList() {
		logger.info("BannerDaoImpl-getBannerList");
		return getSqlSession().selectList("getBannerList");
	}

	@Override
	public void registBanner(BannerDto bannerDto) {
		logger.info("BannerDaoImpl-registBanner");
		getSqlSession().insert("registBanner", bannerDto);
	}

	@Override
	public int getMaxDisplayNumber() {
		logger.info("BannerDaoImpl-getMaxDisplayNumber");
		return getSqlSession().selectOne("getMaxDisplayNumber");
	}

	@Override
	public BannerDto getBannerByBannerId(Integer bannerId) {
		logger.info("BannerDaoImpl-getBannerByBannerId");
		return getSqlSession().selectOne("getBannerByBannerId", bannerId);
	}

	@Override
	public void updateBanner(BannerDto bannerDto) {
		logger.info("BannerDaoImpl-updateBanner");
		getSqlSession().update("updateBanner", bannerDto);
	}

	@Override
	public void deleteBanner(Integer bannerId) {
		logger.info("BannerDaoImpl-deleteBanner");
		getSqlSession().delete("deleteBanner", bannerId);
	}

	@Override
	public void updateBannerDisplayNumber(BannerDto bannerDto) {
		logger.info("BannerDaoImpl-updateBannerDisplayNumber");
		getSqlSession().update("updateBannerDisplayNumber", bannerDto);
	}

	@Override
	public List<BannerDto> getBannerListByViewNumber(int bannerViewNumber) {
		logger.info("BannerDaoImpl-updateBannerDisplayNumber");
		return getSqlSession().selectList("getBannerListByViewNumber", bannerViewNumber);
	}
}
