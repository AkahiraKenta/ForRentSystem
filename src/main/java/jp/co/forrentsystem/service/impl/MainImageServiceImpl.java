package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.dao.MainImageDao;
import jp.co.forrentsystem.dto.MainImageDto;
import jp.co.forrentsystem.service.MainImageService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * メイン画像サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class MainImageServiceImpl implements MainImageService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(MainImageServiceImpl.class);

	@Autowired
	private MainImageDao mainImageDao;

	@Override
	public List<MainImageDto> getMainImageList() {
		logger.info("MainImageServiceImpl-getMainImageList");

		// メイン画像情報を取得
		return mainImageDao.getMainImageList();
	}

	@Override
	public List<MainImageDto> getMainImageViewList() {
		logger.info("MainImageServiceImpl-getMainImageViewList");

		// 表示対象のメイン画像情報を取得
		return mainImageDao.getMainImageViewList();
	}


}
