package jp.co.forrentsystem.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.dto.StructureDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.form.backend.EditBuildingForm;
import jp.co.forrentsystem.form.backend.ListBuildingForm;
import jp.co.forrentsystem.form.backend.RegistBuildingForm;
import jp.co.forrentsystem.form.backend.SearchBuildingForm;
import jp.co.forrentsystem.form.frontend.FSearchConditionForm;

/**
 * 建物情報処理サービス
 * @author k.akhaira
 *
 */
public interface BuildingService {

	/**
	 * 建物情報を登録する処理
	 *
	 * @param registBuildingForm 建物情報Form
	 */
	public abstract BuildingDto insertBuilding(RegistBuildingForm registBuildingForm);
	/**
	 * 建物情報を更新する処理
	 *
	 * @param editBuildingForm 建物情報Form
	 */
	public abstract void updateBuilding(EditBuildingForm editBuildingForm);

	/**
	 * 建物検索結果情報を取得
	 *
	 * @param listBuildingForm 建物一覧Form
	 * @param searchBuildingForm 検索条件Form
	 *
	 * @return 建物情報DTOリスト
	 */
	public abstract List<BuildingDto> searchBuildingList(ListBuildingForm listBuildingForm, SearchBuildingForm searchBuildingForm);

	/**
	 * 建物IDをキーに建物情報を取得
	 *
	 * @param buildingId 建物ID
	 *
	 * @return 建物情報DTO
	 */
	public abstract BuildingDto getBuildingDtoByBuildingId(Integer buildingId);

	/**
	 * 建物詳細情報を取得
	 *
	 * @param buildingDto 建物情報DTO
	 * @param nearestStationNameDtoList 最寄駅情報リスト
	 * @param structureDto
	 * @param buildingTypeName
	 *
	 * @return 建物詳細画面情報
	 */
	public abstract DetailBuildingForm getDetailBuildingForm(
			BuildingDto buildingDto,
			List<NearestStationNameDto> nearestStationNameDtoList, String buildingTypeName, StructureDto structureDto);

	/**
	 * 新着建物情報を取得
	 *
	 * @return 建物情報DTOリスト
	 */
	public abstract List<BuildingDto> searchNewBuildingList();

	/**
	 * 建物情報の住所を取得(都道府県単位)
	 *
	 * @return  建物情報の住所マップ
	 */
	public abstract Map<String, Map<String, List<BuildingDto>>> getBuildingAddressListMap();

	/**
	 * 検索条件として指定された住所を取得
	 *
	 * @param fSearchConditionForm 検索条件Form
	 *
	 * @return 住所リスト
	 */
	public abstract List<BuildingDto> getAddressList(FSearchConditionForm fSearchConditionForm);

	/**
	 * 建物情報の対象件数を取得
	 *
	 * @param listBuildingForm 建物一覧Form
	 * @param searchBuildingForm 検索条件Form
	 * @return 建物一覧Form
	 */
	public abstract ListBuildingForm getPagerForSearchBuilding(
			ListBuildingForm listBuildingForm, SearchBuildingForm searchBuildingForm);

	/**
	 * 建物情報含め、紐付く情報を削除
	 *
	 * @param buildingId 建物ID
	 */
	public abstract void deleteBuilding(Integer buildingId);

	/**
	 * 建物情報DTOを建物情報FORMに設定する
	 *
	 * @param buildingDto 建物情報DTO
	 *
	 * @return 建物情報登録Form
	 */
	public abstract RegistBuildingForm getRegistBuildingForm(BuildingDto buildingDto);

	/**
	 * 建物登録から建物詳細へ建物情報を設定する。
	 *
	 * @param buildingDto 建物DTO
	 *
	 * @return 建物詳細情報
	 */
	public abstract DetailBuildingForm getBuildingDtoForDetailBuildingForm(
			BuildingDto buildingDto);

	/**
	 * パラメータ情報のリロード処理
	 * パラメータがnullの場合、sessionから取得する
	 *
	 * @param model パラメータ
	 * @param session セッション
	 */
	public abstract ModelMap reloadModel(ModelMap model, HttpSession session);
}
