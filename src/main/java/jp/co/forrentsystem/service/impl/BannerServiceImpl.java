package jp.co.forrentsystem.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jp.co.forrentsystem.constants.Constants;
import jp.co.forrentsystem.dao.BannerDao;
import jp.co.forrentsystem.dto.BannerDto;
import jp.co.forrentsystem.form.backend.BannerForm;
import jp.co.forrentsystem.service.BannerService;
import jp.co.forrentsystem.service.SystemSettingService;
import jp.co.forrentsystem.util.FileUtil;

/**
 * バナーサービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class BannerServiceImpl implements BannerService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(BannerServiceImpl.class);

	@Autowired
	private BannerDao bannerDao;
	@Autowired
	private SystemSettingService systemSettingService;

	@Override
	public List<BannerDto> getBannerList() {
		logger.info("BannerServiceImpl-getBannerList");

		return bannerDao.getBannerList();
	}

	@Override
	public void registBanner(BannerForm bannerForm) throws IOException {
		logger.info("BannerServiceImpl-registBanner");
		// 表示順の最大値+1を取得
		int displayNumber = bannerDao.getMaxDisplayNumber();

		BannerDto bannerDto = getBannerDto(bannerForm);
		bannerDto.setDisplayNumber(displayNumber);

		bannerDao.registBanner(bannerDto);
	}

	@Override
	public BannerDto getBannerByBannerId(Integer bannerId) {
		logger.info("BannerServiceImpl-getBannerByBannerId");

		return bannerDao.getBannerByBannerId(bannerId);
	}

	@Override
	public BannerForm getBannerInfo(BannerDto bannerDto) {
		logger.info("BannerServiceImpl-getBannerInfo");
		// バナー情報をFormに設定
		BannerForm bannerForm = new BannerForm();
		bannerForm.setBannerId(bannerDto.getBannerId());
		bannerForm.setFileName(bannerDto.getFileName());
		bannerForm.setFilePath(bannerDto.getFilePath());
		bannerForm.setDisplayNumber(bannerDto.getDisplayNumber());
		bannerForm.setTransitionUrl(bannerDto.getTransitionUrl());
		bannerForm.setTransitionFlag(bannerDto.getTransitionFlag());
		bannerForm.setPublicationFlag(bannerDto.getPublicationFlag());
		return bannerForm;
	}

	@Override
	public void updateBanner(BannerForm bannerForm) {
		logger.info("BannerServiceImpl-updateBanner");

		BannerDto bannerDto = getBannerDto(bannerForm);

		bannerDao.updateBanner(bannerDto);
	}

	@Override
	public void deleteBanner(Integer bannerId) {
		logger.info("BannerServiceImpl-deleteBanner");

		bannerDao.deleteBanner(bannerId);
	}

	private BannerDto getBannerDto(BannerForm bannerForm) {
		// バナー画面入力値情報をDTOに設定
		BannerDto bannerDto = new BannerDto();
		bannerDto.setBannerId(bannerForm.getBannerId());
		bannerDto.setDisplayNumber(bannerForm.getDisplayNumber());
		bannerDto.setFileName(bannerForm.getFileName());
		bannerDto.setFilePath(FileUtil.getFileRelativePath()+FileUtil.getBannerPath());
		bannerDto.setTransitionUrl(bannerForm.getTransitionUrl());
		bannerDto.setTransitionFlag(bannerForm.getTransitionFlag());
		bannerDto.setPublicationFlag(bannerForm.getPublicationFlag());
		bannerDto.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
		return bannerDto;
	}

	@Override
	public void updateBannerDisplayNumber(String[] bannerId) {
		logger.info("BannerServiceImpl-updateBannerDisplayNumber");

		for(int i = 0; i < bannerId.length; i++) {
			// 表示順を設定し、バナー情報を更新
			BannerDto bannerDto = new BannerDto();
			bannerDto.setBannerId(Integer.parseInt(bannerId[i]));
			bannerDto.setDisplayNumber(i+1);
			bannerDao.updateBannerDisplayNumber(bannerDto);
		}
	}

	@Override
	public List<BannerDto> getBannerListByViewNumber() {
		logger.info("BannerServiceImpl-getBannerListByViewNumber");

		// バナー表示件数を取得
		int bannerViewNumber = systemSettingService.getSystemSettingForBanner();
		return bannerDao.getBannerListByViewNumber(bannerViewNumber);
	}

	@Override
	public ModelMap reloadModel(ModelMap model, HttpSession session) {
		if (model.isEmpty() == false) {
			session.setAttribute("model", model);
		} else {
			model = (ModelMap)session.getAttribute("model");
		}
		return model;
	}
}
