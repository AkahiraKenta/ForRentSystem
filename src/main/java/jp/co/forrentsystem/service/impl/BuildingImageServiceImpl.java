package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.constants.Constants;
import jp.co.forrentsystem.dao.BuildingDao;
import jp.co.forrentsystem.dao.BuildingImageDao;
import jp.co.forrentsystem.dao.StructureDao;
import jp.co.forrentsystem.dto.BuildingImageDto;
import jp.co.forrentsystem.dto.NewArticleDto;
import jp.co.forrentsystem.service.BuildingImageService;
import jp.co.forrentsystem.service.SystemSettingService;
import jp.co.forrentsystem.util.FileUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 建物画像サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class BuildingImageServiceImpl implements BuildingImageService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(BuildingImageServiceImpl.class);

	@Autowired
	private BuildingDao buildingDao;
	@Autowired
	private StructureDao structureDao;
	@Autowired
	private BuildingImageDao buildingImageDao;
	@Autowired
	private SystemSettingService systemSettingService;

	@Override
	public BuildingImageDto registBuildingImage(Integer targetBuildingId,
			Integer buildingImageClass, String fileName,
			String imageCaption, Integer publicationFlag) {
		logger.info("BuildingServiceImpl-registBuildingImage");

		// 建物画像入力情報をDTOへ設定する
		BuildingImageDto buildingImageDto = new BuildingImageDto();
		buildingImageDto.setBuildingId(targetBuildingId);
		buildingImageDto.setBuildingImageClass(buildingImageClass);
		buildingImageDto.setFileName(fileName);
		buildingImageDto.setImageCaption(imageCaption);
		buildingImageDto.setPublicationFlag(publicationFlag);
		// 建物画像ファイルパスを設定
		buildingImageDto.setFilePath(FileUtil.getFileRelativePath());
		buildingImageDto.setDeleteFlag(Constants.DELETE_FLAG_FALSE);

		// 登録済みか確認
		Integer count = buildingImageDao.countBuildingImage(buildingImageDto);
		if (count == 0) {
			// 未登録の場合
			// 建物画像情報を登録
			buildingImageDao.registBuildingImage(buildingImageDto);
		} else {
			// 登録済みの場合
			// 建物画像DTOをnullとする
			buildingImageDto = null;
		}
		return buildingImageDto;

	}

	@Override
	public BuildingImageDto getBuildingImage(Integer buildingId) {
		logger.info("BuildingServiceImpl-getBuildingImageDtoList");
		// 建物画像情報取得
		return buildingImageDao.getBuildingImage(buildingId);
	}

	@Override
	public BuildingImageDto deleteBuildingImage(Integer buildingId,
			Integer imageId, String fileName) {
		logger.info("BuildingServiceImpl-getBuildingImageDtoList");

		// 建物画像情報をDTOに設定する
		BuildingImageDto buildingImageDto = new BuildingImageDto();
		buildingImageDto.setBuildingId(buildingId);
		buildingImageDto.setImageId(imageId);
		buildingImageDto.setFileName(fileName);

		// 建物画像情報取得
		buildingImageDao.deleteBuildingImage(buildingImageDto);

		return buildingImageDto;
	}

	@Override
	public List<NewArticleDto> getBuildingImageByNewArticle() {
		logger.info("BuildingServiceImpl-getBuildingImageByNewArticle");

		// 新着物件表示件数取得
		int newArticleViewNumber = systemSettingService.getSystemSettingForNewArticle();

		// 新着物件の建物画像情報を取得
		return buildingImageDao.getBuildingImageByNewArticle(newArticleViewNumber);
	}
}
