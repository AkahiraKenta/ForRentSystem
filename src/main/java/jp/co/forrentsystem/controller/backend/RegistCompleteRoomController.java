package jp.co.forrentsystem.controller.backend;

import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.dto.RoomsDetailDto;
import jp.co.forrentsystem.dto.RoomsDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.form.backend.RegistRoomsForm;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.RoomsService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 部屋登録完了コントローラ
 * @author k.akahira
 */
@Controller
public class RegistCompleteRoomController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistCompleteRoomController.class);

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private RoomsService roomsService;

	/**
	 * 初期表示
	 *
	 * @param model
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registCompleteRoom", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		logger.info("RegistCompleteRoomController-init");

		ModelAndView mav = new ModelAndView();
		mav.addObject("buildingId", model.get("buildingId"));
		mav.addObject("roomId", model.get("roomId"));
		mav.setViewName("./back/registCompleteRoom");
		return mav;
	}

	/**
	 * 部屋登録画面へ遷移
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/continueRegistRoom", method = RequestMethod.GET)
	public String contineRegistRoom(@Param(value="buildingId") Integer buildingId, @Param(value="roomId") Integer roomId, RedirectAttributes attribute) {
		logger.info("RegistCompleteRoomController-contineRegistRoom");

		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);
		RoomsDto roomsDto = roomsService.getParamRoomsDto(buildingId, roomId);
		RoomsDetailDto roomsDetailDto = roomsService.getRoomsDtoByBuildingIdAndRoomId(roomsDto);
		RegistRoomsForm registRoomsForm = roomsService.getRegistForm(roomsDetailDto, buildingDto);

		attribute.addFlashAttribute("backRegistRoomForm", registRoomsForm);

		// リダイレクト（部屋登録画面）
		return "redirect:/back/backRegistRoomFromConfirm";
	}

	/**
	 * 管理画面へ戻る
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backRegistCompleteRoomToManageTop", method = RequestMethod.GET)
	public String backRegistCompleteRoomToManageTop() {
		logger.info("RegistCompleteRoomController-backRegistCompleteRoomToManageTop");

		// リダイレクト（管理TOP画面）
		return "redirect:/back/manageTop";
	}

	/**
	 * 建物詳細画面へ遷移
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backRegistCompleteRoomToDetailBuilding", method = RequestMethod.GET)
	public String backRegistCompleteRoomToDetailBuilding(@Param(value="buildingId") Integer buildingId, RedirectAttributes attribute) {
		logger.info("RegistCompleteRoomController-backRegistCompleteRoomToDetailBuilding");

		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);

		// 建物情報を建物詳細Formに設定する
		DetailBuildingForm detailBuildingForm = buildingService.getBuildingDtoForDetailBuildingForm(buildingDto);

		//建物情報を建物詳細Formをattributeに保存
		attribute.addFlashAttribute("detailBuildingForm", detailBuildingForm);

		// リダイレクト（建物詳細画面）
		return "redirect:/back/detailBuilding";
	}
}
