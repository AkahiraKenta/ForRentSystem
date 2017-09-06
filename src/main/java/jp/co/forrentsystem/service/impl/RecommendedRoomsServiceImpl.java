package jp.co.forrentsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import jp.co.forrentsystem.constants.Constants;
import jp.co.forrentsystem.dao.RecommendedRoomDao;
import jp.co.forrentsystem.dao.RoomsDao;
import jp.co.forrentsystem.dao.RoomsImageDao;
import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.dto.RecommendedRoomDto;
import jp.co.forrentsystem.dto.RecommendedRoomImageDto;
import jp.co.forrentsystem.form.backend.SearchRecommendedRoomForm;
import jp.co.forrentsystem.service.RecommendedRoomsService;
import jp.co.forrentsystem.service.SystemSettingService;
import jp.co.forrentsystem.util.FileUtil;
import jp.co.forrentsystem.util.PagerUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * こだわり条件サービス実装クラス
 * @author webridge
 *
 */
@Service
public class RecommendedRoomsServiceImpl implements RecommendedRoomsService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RecommendedRoomsServiceImpl.class);

	@Autowired
	private RoomsDao roomsDao;
	@Autowired
	private RoomsImageDao roomsImageDao;
	@Autowired
	private RecommendedRoomDao recommendedRoomDao;
	@Autowired
	private SystemSettingService systemSettingService;

	@Override
	public List<ArticleDto> getArticleForRecommendedRoom(SearchRecommendedRoomForm searchRecommendedRoomForm) {
		logger.info("RoomsServiceImpl-getArticleForRecommendedRoom");

		// おすすめ物件情報をDTOに設定
		ArticleDto articleDto = getArticleDto(searchRecommendedRoomForm);
		articleDto.setFromNumber(PagerUtil.getNumberFrom(searchRecommendedRoomForm.getCurrentPage(), searchRecommendedRoomForm.getViewNumber()));
		articleDto.setViewNumber(searchRecommendedRoomForm.getViewNumber());

		// おすすめ物件情報を取得
		return roomsDao.getArticleForRecommendedRoom(articleDto);
	}

	/**
	 * ページング情報取得（初期表示に使用する）
	 * @param articleDto 物件DTO
	 *
	 * @return おすすめ物件Form
	 */
	@Override
	public SearchRecommendedRoomForm getPagerForSearchRecommendedRoom(SearchRecommendedRoomForm searchRecommendedRoomForm) {
		logger.info("RoomsServiceImpl-getPagerInfo");

		// おすすめ物件情報をDTOに設定
		ArticleDto articleDto = getArticleDto(searchRecommendedRoomForm);
		// 対象件数
		int totalNumber = roomsDao.getCountTotalNumberForRecommenededRoom(articleDto);
		// 表示件数
		int viewNumber = FileUtil.getArticleViewNumber();
		// 全件数
		searchRecommendedRoomForm.setTotalNumber(totalNumber);
		// 表示件数
		searchRecommendedRoomForm.setViewNumber(viewNumber);
		// 現在のページ
		searchRecommendedRoomForm.setCurrentPage(searchRecommendedRoomForm.getCurrentPage());
		// 全ページ数
		searchRecommendedRoomForm.setPageTotalNumber(PagerUtil.getPageTotalNumber(totalNumber, viewNumber));

		return searchRecommendedRoomForm;
	}

	/**
	 * おすすめ物件DTO作成し取得
	 *
	 * @param searchRecommendedRoomForm おすすめ物件Form
	 * @return おすすめ物件DTO
	 */
	private ArticleDto getArticleDto(
			SearchRecommendedRoomForm searchRecommendedRoomForm) {

		// おすすめ物件情報をDTOに設定
		ArticleDto articleDto = new ArticleDto();
		articleDto.setBuildingCode(searchRecommendedRoomForm.getBuildingCode());
		articleDto.setBuildingName(searchRecommendedRoomForm.getBuildingName());
		articleDto.setRoomCode(searchRecommendedRoomForm.getRoomCode());
		articleDto.setRoomNumber(searchRecommendedRoomForm.getRoomNumber());
		articleDto.setBuildingType(searchRecommendedRoomForm.getBuildingType());
		articleDto.setNumberOfStoreysId(searchRecommendedRoomForm.getNumberOfStoreysId());
		articleDto.setSpaceFrom(searchRecommendedRoomForm.getSpaceFrom());
		articleDto.setSpaceTo(searchRecommendedRoomForm.getSpaceTo());
		articleDto.setRentFrom(searchRecommendedRoomForm.getRentFrom());
		articleDto.setRentTo(searchRecommendedRoomForm.getRentTo());

		return articleDto;
	}

	@Override
	public void registRecommendedRoom(Integer buildingId, Integer roomId) {
		logger.info("RoomsServiceImpl-registRecommendedRoom");
		// おすすめ物件の順位の最大値＋１を取得
		Integer rank = recommendedRoomDao.selectMaxRank();

		// おすすめ物件情報をDTOに設定
		RecommendedRoomDto recommendedRoomDto = new RecommendedRoomDto();
		recommendedRoomDto.setBuildingId(buildingId);
		recommendedRoomDto.setRoomId(roomId);
		recommendedRoomDto.setRank(rank==null? 1 : rank);
		recommendedRoomDto.setDeleteFlag(Constants.DELETE_FLAG_FALSE);

		// おすすめ物件情報を登録
		recommendedRoomDao.registRecommendedRoom(recommendedRoomDto);

	}

	@Override
	public List<ArticleDto> getRecoomendedRoom() {
		logger.info("RoomsServiceImpl-getRecoomendedRoom");

		// おすすめ物件情報を取得
		return recommendedRoomDao.getRecoomendedRoom();
	}

	@Override
	public Integer deleteRecommendRoom(Integer id) {
		// おすすめ物件を削除
		recommendedRoomDao.deleteRecommendRoom(id);
		// 現在のおすすめ物件を取得
		List<ArticleDto> articleDtoList = recommendedRoomDao.getRecoomendedRoom();

		// おすすめ物件リストから削除対象おすすめ物件を取り除く
		for (ArticleDto articleDto : articleDtoList) {
			if (articleDto.getId() == id) {
				articleDtoList.remove(articleDto);
				break;
			}
		}

		// おすすめ物件に順位を振り直し、更新
		for (int i = 0; i < articleDtoList.size(); i++) {
			// 人気駅の順位をupdate
			articleDtoList.get(i).setRank(i+1);
			recommendedRoomDao.updateRankForRecommendRoom(articleDtoList.get(i));
		}
		return id;
	}

	@Override
	public List<ArticleDto> updateRecommendRoom(String[] idArray) {
		logger.info("RoomsServiceImpl-updateRecommendRoom");

		List<ArticleDto> articleDtoList = new ArrayList<ArticleDto>();
		for(int i = 0; i < idArray.length; i++) {
			// おすすめ物件IDをループ、DTOにおすすめ物件IDと順位を格納
			ArticleDto articleDto = new ArticleDto();
			articleDto.setId(Integer.parseInt(idArray[i]));
			articleDto.setRank(i+1);
			// DTOに格納したおすすめ物件情報で更新
			recommendedRoomDao.updateRankForRecommendRoom(articleDto);
			articleDtoList.add(articleDto);
		}

		return articleDtoList;
	}

	@Override
	public List<RecommendedRoomImageDto> getRecoomendedRoomListByViewNumber() {
		logger.info("RoomsServiceImpl-getRecoomendedRoomListByViewNumber");

		// おすすめ物件表示件数を取得
		int recommendedRoomViewNumber = systemSettingService.getSystemSettingForRecommendedRoom();
		return recommendedRoomDao.getRecoomendedRoomListByViewNumber(recommendedRoomViewNumber);
	}
}
