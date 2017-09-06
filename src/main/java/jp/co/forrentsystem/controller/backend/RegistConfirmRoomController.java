package jp.co.forrentsystem.controller.backend;

import javax.validation.Valid;

import jp.co.forrentsystem.dto.RoomsDto;
import jp.co.forrentsystem.form.backend.RegistRoomsForm;
import jp.co.forrentsystem.service.EquipmentService;
import jp.co.forrentsystem.service.GoodForConditionService;
import jp.co.forrentsystem.service.RoomEquipmentService;
import jp.co.forrentsystem.service.RoomGoodForConditionService;
import jp.co.forrentsystem.service.RoomsService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 部屋情報登録確認コントローラ
 * @author k.akhaira
 */
@Controller
public class RegistConfirmRoomController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistConfirmRoomController.class);

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

	/**
	 * 初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registConfirmRoom", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		logger.info("RegistConfirmRoomController-execute");

		RegistRoomsForm registRoomsForm = (RegistRoomsForm)model.get("registConfirmRoomForm");


		ModelAndView mav = new ModelAndView();
		mav.addObject("registConfirmRoomForm", registRoomsForm);
		// 部屋設備取得
		mav.addObject("equipmentList", equipmentService.getEquipmentList());
		// こだわり条件取得
		mav.addObject("goodForConditionList", goodForConditionService.getGoodForConditionList());
		mav.addObject("equipmentArray", registRoomsForm.getEquipmentArray());
		mav.addObject("goodForConditionArray", registRoomsForm.getGoodForConditionArray());
		mav.setViewName("./back/registConfirmRoom");

		return mav;
	}

	/**
	 * 部屋登録完了画面へ遷移
	 *
	 * @param registConfirmRoomForm 部屋登録確認Form
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callRegistCompleteRoom", method = RequestMethod.POST)
	public String callRegistCompleteRoom(@Valid RegistRoomsForm registConfirmRoomForm, RedirectAttributes attribute) {
		logger.info("RegistConfirmRoomController-callRegistCompleteRoom");

		// 部屋情報登録処理
		RoomsDto roomsDto = roomsService.registRooms(registConfirmRoomForm);

		// 建物IDと部屋IDをattributeへ設定
		attribute.addFlashAttribute("buildingId", registConfirmRoomForm.getBuildingId());
		attribute.addFlashAttribute("roomId", roomsDto.getRoomId());

		// リダイレクト（部屋登録完了画面）
		return "redirect:/back/registCompleteRoom";
	}

	/**
	 * 部屋登録画面へ遷移
	 *
	 * @param registConfirmRoomForm 部屋登録確認Form
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callRegistCompleteRoom", params="back", method = RequestMethod.POST)
	public String back(@Valid RegistRoomsForm registRoomsForm, RedirectAttributes attribute) {
		logger.info("RegistConfirmRoomController-back");

		attribute.addFlashAttribute("backRegistRoomForm", registRoomsForm);
		// リダイレクト（部屋登録画面）
		return "redirect:/back/backRegistRoomFromConfirm";
	}
}
