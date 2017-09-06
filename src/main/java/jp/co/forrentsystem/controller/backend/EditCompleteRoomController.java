package jp.co.forrentsystem.controller.backend;

import java.util.List;

import jp.co.forrentsystem.constants.BuildingType;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.NearestStationNameDto;
import jp.co.forrentsystem.dto.StructureDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.NearestStationService;
import jp.co.forrentsystem.service.StructureService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 建物情報登録コントローラ
 * @author k.akahira
 */
@Controller
public class EditCompleteRoomController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditCompleteRoomController.class);

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private NearestStationService nearestStationService;
	@Autowired
	private StructureService structureService;

	/**
	 * 初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/editCompleteRoom", method = RequestMethod.GET)
	public String init() {
		logger.info("EditCompleteRoomController-init");

		return "back/editCompleteRoom";
	}

	/**
	 * 管理画面TOPへ戻る
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backEditCompleteRoomToManageTop", method = RequestMethod.GET)
	public String backToManageTop() {
		logger.info("EditCompleteRoomController-backToManageTop");

		// リダイレクト（管理TOP画面）
		return "redirect:/back/manageTop";
	}

	/**
	 * 部屋詳細画面へ戻る
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backEditCompleteRoomToDetailRoom", method = RequestMethod.GET)
	public String backToDetailRoom(@Param(value="buildingId") Integer buildingId, @Param(value="roomId") Integer roomId,
			RedirectAttributes attribute) {
		logger.info("EditCompleteRoomController-backToDetailRoom");

		attribute.addFlashAttribute("buildingId", buildingId);
		attribute.addFlashAttribute("roomId", roomId);
		attribute.addFlashAttribute("transactionFlag", 1);

		// リダイレクト（部屋詳細画面）
		return "redirect:/back/detailRoom";
	}

	/**
	 * 建物詳細画面へ戻る
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backEditCompleteRoomToDetailBuilding", method = RequestMethod.GET)
	public String backToDetailBuilding(@Param(value="buildingId") Integer buildingId, RedirectAttributes attribute) {
		logger.info("EditCompleteRoomController-backToDetailBuilding");

		// 建物IDをキーに建物情報取得
		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);

		// 最寄駅名称取得
		List<NearestStationNameDto> nearestStationNameDtoList = nearestStationService.getNearestStationNameList(buildingId);

		// 建物種別名称取得
		String buildingTypeName = BuildingType.getTargetName(buildingDto.getBuildingType());

		// 建物構造名称取得
		StructureDto structureDto = structureService.getStructureName(buildingDto.getStructureId());

		DetailBuildingForm detailBuildingForm = buildingService.getDetailBuildingForm(buildingDto, nearestStationNameDtoList
				,buildingTypeName, structureDto);

		// 建物詳細FormをSESSIONに設定
		attribute.addFlashAttribute("detailBuildingForm", detailBuildingForm);

		// リダイレクト（建物詳細画面)
		return "redirect:/back/detailBuilding";
	}
}
