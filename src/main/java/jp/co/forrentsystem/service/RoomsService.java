package jp.co.forrentsystem.service;

import java.util.List;

import jp.co.forrentsystem.dto.ArticleDto;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.RoomsDetailDto;
import jp.co.forrentsystem.dto.RoomsDto;
import jp.co.forrentsystem.dto.RoomsImageDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.form.backend.DetailRoomForm;
import jp.co.forrentsystem.form.backend.EditRoomsForm;
import jp.co.forrentsystem.form.backend.ListRoomsForm;
import jp.co.forrentsystem.form.backend.RegistRoomsForm;
import jp.co.forrentsystem.form.frontend.FSearchConditionForm;


/**
 * 部屋情報処理サービス
 * @author k.akhaira
 *
 */
public interface RoomsService {

	/**
	 * 部屋情報FORMに建物情報を設定
	 *
	 * @param buildingDto 建物情報DTO
	 * @param nearestStationNameDtoList 最寄駅情報リスト
	 * @param structureDto 構造DTO
	 * @param buildingTypeName 建物種別名称
	 *
	 * @return 建物詳細画面情報
	 */
	public abstract RegistRoomsForm getBuildingInfoForRoom(
			DetailBuildingForm detailBuildingForm);

	/**
	 * 部屋編集情報をDTOへ設定
	 *
	 * @param editRoomForm 部屋編集情報
	 *
	 * @return 部屋情報DTO
	 */
	public abstract RoomsDto getRoomsDto(EditRoomsForm editRoomForm);

	/**
	 * 部屋情報登録処理
	 *
	 * @param roomsDto 部屋情報DTO
	 */
	public abstract RoomsDto registRooms(RegistRoomsForm registRoomsForm);

	/**
	 * 対象建物の部屋情報一覧を取得
	 *
	 * @param buildingId 建物ID
	 *
	 * @return 部屋情報DTOリスト
	 */
	public abstract List<ListRoomsForm> getRoomsListByBuildingId(Integer buildingId);

	/**
	 * 建物IDと部屋IDをキーに部屋情報を取得
	 *
	 * @param roomsDto 部屋情報DTO
	 *
	 * @return 部屋詳細情報DTO
	 */
	public abstract RoomsDetailDto getRoomsDtoByBuildingIdAndRoomId(
			RoomsDto roomsDto);

	/**
	 * 部屋情報のキー項目をDTOに設定する
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 *
	 * @return 部屋情報DTO
	 */
	public abstract RoomsDto getParamRoomsDto(Integer buildingId, Integer roomId);

	/**
	 * 部屋Formに部屋情報を設定する
	 *
	 * @param roomsDetailDto 部屋詳細情報DTO
	 * @param buildingDto 建物詳細DTO
	 *
	 * @return 部屋情報Form
	 */
	public abstract DetailRoomForm getDetailRoomForm(RoomsDetailDto roomsDetailDto, BuildingDto buildingDto);

	/**
	 * 部屋情報更新処理
	 *
	 * @param editRoomForm 部屋情報Form
	 */
	public abstract void updateRooms(EditRoomsForm editRoomForm);

	/**
	 * 部屋画像を取得
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 *
	 * @return 部屋画像DTOリスト
	 */
	public abstract List<RoomsImageDto> getRoomImageList(
			Integer buildingId, Integer roomId);

	/**
	 * 部屋画像を登録
	 *
	 * @param targetBuildingId 建物ID
	 * @param targetRoomId 部屋ID
	 * @param roomImageClass 部屋画像区分
	 * @param fileName ファイル名
	 * @param imageCaption 画像見出し
	 * @param publicationFlag 公開フラグ
	 *
	 * @return 部屋画像DTO
	 */
	public abstract RoomsImageDto registRoomImage(Integer targetBuildingId,
			Integer targetRoomId,Integer roomImageClass, String fileName,
			String imageCaption, Integer publicationFlag);

	/**
	 * 部屋画像を削除
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 * @param imageId 画像ID
	 * @param fileName ファイル名
	 *
	 * @return 部屋画像DTO
	 */
	public abstract RoomsImageDto deleteRoomImage(Integer buildingId,
			Integer roomId, Integer imageId, String fileName);

	/**
	 * 物件情報を取得する
	 *
	 * @param fSearchConditionForm 検索条件
	 * @return 物件情報リスト
	 */
	public abstract List<ArticleDto> getArticleList(
			FSearchConditionForm fSearchConditionForm);

	/**
	 * 物件件数を取得
	 *
	 * @param fSearchConditionForm 検索条件
	 *
	 * @return 物件件数
	 */
	public abstract int countArticleList(
			FSearchConditionForm fSearchConditionForm);

	/**
	 * 物件詳細情報を取得
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 *
	 * @return 物件詳細情報
	 */
	public abstract ArticleDto getDetailArticle(
			Integer buildingId, Integer roomId);

	/**
	 * 建物IDをキーに空き状態の部屋一覧を取得
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 *
	 * @return 部屋情報リスト
	 */
	public abstract List<RoomsDto> getRoomsListForVacancy(
			Integer buildingId, Integer roomId);

	/**
	 * 部屋情報削除（紐付く情報も含む）
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 */
	public abstract void deleteRoom(Integer buildingId, Integer roomId);

	/**
	 * 物件情報DTOから部屋登録情報Formに設定
	 *
	 * @param roomsDetailDto 部屋情報DTO
	 * @param buildingDto 建物情報DTO
	 *
	 * @return 部屋登録情報Form
	 */
	public abstract RegistRoomsForm getRegistForm(RoomsDetailDto roomsDetailDto, BuildingDto buildingDto);


}
