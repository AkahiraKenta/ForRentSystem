package jp.co.forrentsystem.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jp.co.forrentsystem.constants.Constants;
import jp.co.forrentsystem.dao.NewsDao;
import jp.co.forrentsystem.dto.NewsDto;
import jp.co.forrentsystem.form.backend.NewsForm;
import jp.co.forrentsystem.service.NewsService;
import jp.co.forrentsystem.service.SystemSettingService;

/**
 * ニュースサービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class NewsServiceImpl implements NewsService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(NewsServiceImpl.class);

	@Autowired
	private NewsDao newsDao;
	@Autowired
	private SystemSettingService systemSettingService;

	@Override
	public List<NewsDto> getListNews() {
		logger.info("NewsServiceImpl-getListNews");

		// ニュース情報を取得
		return newsDao.getListNews();
	}

	@Override
	public void registNews(NewsForm newsForm) {
		logger.info("NewsServiceImpl-registNews");
		// ニュース情報をDTOに設定
		NewsDto newsDto = getNewsDto(newsForm);
		// ニュース登録
		newsDao.registNews(newsDto);
	}

	@Override
	public NewsForm getNewsByNewsId(Integer newsId) {
		logger.info("NewsServiceImpl-getNewsByNewsId");
		// ニュース情報取得
		NewsDto newsDto = newsDao.getNewsByNewsId(newsId);

		// 取得したニュース情報をFormに設定する
		NewsForm newsForm = new NewsForm();
		newsForm.setNewsId(newsDto.getNewsId());
		newsForm.setNewsTitle(newsDto.getNewsTitle());
		newsForm.setNewsContent(newsDto.getNewsContent());
		newsForm.setPostedDate(newsDto.getPostedDate());
		newsForm.setLinkUmuFlag(newsDto.getLinkUmuFlag());
		newsForm.setLinkClass(newsDto.getLinkClass());
		newsForm.setLinkUrl(newsDto.getLinkUrl());

		return newsForm;
	}

	@Override
	public void updateNews(NewsForm newsForm) {
		logger.info("NewsServiceImpl-updateNews");
		// ニュース情報をDTOに設定
		NewsDto newsDto = getNewsDto(newsForm);
		// ニュース更新
		newsDao.updateNews(newsDto);

	}

	/**
	 * フォーム情報をニュースDTOに設定し取得する
	 * @param newsForm ニュースForm
	 * @return ニュースDTO
	 */
	private NewsDto getNewsDto(NewsForm newsForm) {
		// ニュース情報をDTOに設定
		NewsDto newsDto = new NewsDto();
		if (newsForm.getNewsId() != null) {
			newsDto.setNewsId(newsForm.getNewsId());
		}
		newsDto.setNewsTitle(newsForm.getNewsTitle());
		newsDto.setNewsContent(newsForm.getNewsContent());
		newsDto.setPostedDate(newsForm.getPostedDate());
		newsDto.setLinkUmuFlag(newsForm.getLinkUmuFlag());
		newsDto.setLinkClass(newsForm.getLinkClass());
		newsDto.setLinkUrl(newsForm.getLinkUrl());
		newsDto.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
		return newsDto;
	}

	@Override
	public void deleteNews(Integer newsId) {
		logger.info("NewsServiceImpl-deleteNews");

		// ニュース情報を削除
		newsDao.deleteNews(newsId);

	}

	@Override
	public List<NewsDto> getListNewsByViewNumber() {
		logger.info("NewsServiceImpl-getNewsListByViewNumber");

		// ニュース表示件数取得
		int newsViewNumber = systemSettingService.getSystemSettingForNewsViewNumber();

		// ニュース表示件数分のニュース情報を返却
		return newsDao.getListNewsByViewNumber(newsViewNumber);
	}

	@Override
	public int getMaxNewsId() {
		logger.info("NewsServiceImpl-getMaxNewsId");

		int newsId = newsDao.getMaxNewsId();
		return newsId;
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
