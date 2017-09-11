package jp.co.forrentsystem.controller.backend;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.forrentsystem.constants.ProcessStatus;
import jp.co.forrentsystem.dto.BuildingContactDto;
import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.service.BuildingContactService;
import jp.co.forrentsystem.service.BuildingService;

/**
 * 管理TOPコントローラ
 * @author k.akahira
 */
@Controller
public class ManageTopController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(ManageTopController.class);

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private BuildingContactService buildingContactService;

	/**
	 * 初期表示
	 *
	 * @param manageTopForm 管理TOP画面Form
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/manageTop", method = RequestMethod.GET)
	public ModelAndView init() {
		logger.info("ManageTopController-init");

		// 新着建物情報取得
		List<BuildingDto> buildingDtoList = buildingService.searchNewBuildingList();

		// 新着お問合わせ情報取得
		List<BuildingContactDto> buildingContactList = buildingContactService.getNewBuildingContact();

		ModelAndView mav = new ModelAndView();

		mav.addObject("buildingDtoList", buildingDtoList);
		mav.addObject("buildingContactList", buildingContactList);
		mav.addObject("processStatusList", ProcessStatus.getProcessStatusList());
		mav.setViewName("./back/manageTop");

		return mav;
	}

	/**
	 * 建物登録画面へ遷移
	 *
	 * @param detailBuildingForm 建物詳細Form
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/menuRegistBuilding", method = RequestMethod.GET)
	public String menuRegistBuilding() {
		logger.info("ManageTopController-menuRegistBuilding");

		// リダイレクト(建物詳細画面)
		return "redirect:/back/registBuilding";
	}

	/**
	 * 建物検索画面へ遷移
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/menuSearchBuilding", method = RequestMethod.GET)
	public ModelAndView menuSearchBuilding() {
		logger.info("ManageTopController-menuSearchBuilding");

		ModelAndView mav = new ModelAndView();

		// リダイレクト(建物検索画面)
		mav.setViewName("redirect:/back/searchBuilding");

		return mav;
	}

	/**
	 * お問合せ詳細画面へ遷移
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/menuDetailBuildingContact", method = RequestMethod.GET)
	public String menuDetailBuildingContact(@Param(value="buildingContactId") Integer buildingContactId, RedirectAttributes attribute) {
		logger.info("ManageTopController-menuSearchBuilding");

		attribute.addFlashAttribute("buildingContactId", buildingContactId);

		// リダイレクト(物件お問合せ詳細画面)
		return "redirect:/back/initDetailBuildingContact";

	}
}
