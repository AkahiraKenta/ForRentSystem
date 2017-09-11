package jp.co.forrentsystem.controller.backend;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.forrentsystem.dto.RoomsImageDto;
import jp.co.forrentsystem.form.backend.EditRoomsForm;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.EquipmentService;
import jp.co.forrentsystem.service.GoodForConditionService;
import jp.co.forrentsystem.service.RoomEquipmentService;
import jp.co.forrentsystem.service.RoomGoodForConditionService;
import jp.co.forrentsystem.service.RoomsService;
import jp.co.forrentsystem.util.FileUtil;

/**
 * 部屋編集確認コントローラ
 * @author k.akahira
 */
@Controller
public class EditConfirmRoomController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditConfirmRoomController.class);

	@Autowired
	private RoomsService roomsService;
	@Autowired
	private RoomEquipmentService roomEquipmentService;
	@Autowired
	private RoomGoodForConditionService roomGoodForConditionService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private GoodForConditionService goodForConditionService;
	@Autowired
	private BuildingService buildingService;

	/**
	 * 初期表示
	 *
	 * @param model
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/editConfirmRoom", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		logger.info("EditConfirmRoomController-init");

		EditRoomsForm editRoomsForm = (EditRoomsForm)roomsService.reloadModel(model, session).get("editRoomsForm");

		// 部屋画像リスト
		List<RoomsImageDto> roomImageDtoList = roomsService.getRoomImageList(editRoomsForm.getBuildingId(), editRoomsForm.getRoomId());

		ModelAndView mav = new ModelAndView();
		mav.addObject("editConfirmRoomForm", editRoomsForm);
		// 部屋設備取得
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件取得
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		mav.addObject("equipmentArray", editRoomsForm.getEquipmentArray());
		mav.addObject("goodForConditionArray", editRoomsForm.getGoodForConditionArray());
		mav.addObject("roomImageList", roomImageDtoList);
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.setViewName("./back/editConfirmRoom");

		return mav;
	}

	/**
	 * 部屋編集完了画面へ遷移
	 *
	 * @param editConfirmRoomForm 部屋編集確認Form
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callEditCompleteRoom", method = RequestMethod.POST)
	public ModelAndView callEditCompleteRoom(@Valid EditRoomsForm editConfirmRoomForm, RedirectAttributes attribute) {
		logger.info("EditConfirmRoomController-callEditCompleteRoom");

		// 部屋情報更新処理
		roomsService.updateRooms(editConfirmRoomForm);

		ModelAndView mav = new ModelAndView();

		mav.addObject("buildingId", editConfirmRoomForm.getBuildingId());
		mav.addObject("roomId", editConfirmRoomForm.getRoomId());
		mav.setViewName("./back/editCompleteRoom");

		// リダイレクト（部屋編集完了画面）
		return mav;
	}

	/**
	 * 部屋編集画面へ戻る
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callEditCompleteRoom", params="back", method = RequestMethod.POST)
	public String back(@Valid EditRoomsForm editConfirmRoomForm, RedirectAttributes attribute) {
		logger.info("EditConfirmRoomController-back");

		attribute.addFlashAttribute("editRoomsForm", editConfirmRoomForm);

		// リダイレクト(部屋編集画面)
		return "redirect:/back/backForEditRoomConfirm";
	}
}
