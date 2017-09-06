package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.NewsDao;
import jp.co.forrentsystem.dto.NewsDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * ニュースDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class NewsDaoImpl extends SqlSessionDaoSupport implements NewsDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(NewsDaoImpl.class);

	@Override
	public List<NewsDto> getListNews() {
		logger.info("NewsDaoImpl-getListNews");
		return getSqlSession().selectList("getListNews");
	}

	@Override
	public void registNews(NewsDto newsDto) {
		logger.info("NewsDaoImpl-registNews");
		getSqlSession().insert("registNews", newsDto);
	}

	@Override
	public NewsDto getNewsByNewsId(Integer newsId) {
		logger.info("NewsDaoImpl-getNewsByNewsId");
		return getSqlSession().selectOne("getNewsByNewsId", newsId);
	}

	@Override
	public void updateNews(NewsDto newsDto) {
		logger.info("NewsDaoImpl-updateNews");
		getSqlSession().update("updateNews", newsDto);
	}

	@Override
	public void deleteNews(Integer newsId) {
		logger.info("NewsDaoImpl-deleteNews");
		getSqlSession().delete("deleteNews", newsId);

	}

	@Override
	public List<NewsDto> getListNewsByViewNumber(int newsViewNumber) {
		logger.info("NewsDaoImpl-getListNewsByViewNumber");
		return getSqlSession().selectList("getListNewsByViewNumber", newsViewNumber);
	}

	@Override
	public int getMaxNewsId() {
		logger.info("NewsDaoImpl-getMaxNewsId");
		return getSqlSession().selectOne("getMaxNewsId");
	}


}
