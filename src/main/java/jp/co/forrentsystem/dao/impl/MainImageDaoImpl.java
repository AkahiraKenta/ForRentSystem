package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.MainImageDao;
import jp.co.forrentsystem.dto.MainImageDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * メイン画像マスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class MainImageDaoImpl extends SqlSessionDaoSupport implements MainImageDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(MainImageDaoImpl.class);

	@Override
	public List<MainImageDto> getMainImageList() {
		logger.info("MainImageDaoImpl-getMainImageList");

		return getSqlSession().selectList("getMainImageList");
	}

	@Override
	public List<MainImageDto> getMainImageViewList() {
		logger.info("MainImageDaoImpl-getMainImageList");

		return getSqlSession().selectList("getMainImageViewList");
	}


}
