package jp.co.forrentsystem.controller.backend;

import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.service.BuildingService;

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
 * 建物情報登録完了コントローラ
 * @author k.akahira
 */
@Controller
public class EditCompleteBuildingController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditCompleteBuildingController.class);

	@Autowired
	private BuildingService buildingService;

	/**
	 * 初期表示
	 *
	 * @param model
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/editCompleteBuilding", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		logger.info("EditCompleteBuildingController-init");

		ModelAndView mav = new ModelAndView();
		mav.addObject("buildingId", model.get("buildingId"));
		mav.setViewName("./back/editCompleteBuilding");
		return mav;
	}

	/**
	 * 管理画面へ戻る
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backEditCompleteBuildingToManageTop", method = RequestMethod.GET)
	public String backToManageTop() {
		logger.info("EditCompleteBuildingController-backEditCompleteBuildingToManageTop");

		// リダイレクト（管理TOP画面）
		return "redirect:/back/manageTop";
	}

	/**
	 * 建物詳細画面へ戻る
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backEditCompleteBuildingToDetailBuilding", method = RequestMethod.GET)
	public String backToDetailBuilding(@Param(value="buildingId") Integer buildingId, RedirectAttributes attribute) {
		logger.info("EditCompleteBuildingController-backEditCompleteBuildingToDetailBuilding");

		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);

		DetailBuildingForm detailBuildingForm = buildingService.getBuildingDtoForDetailBuildingForm(buildingDto);
		attribute.addFlashAttribute("detailBuildingForm", detailBuildingForm);

		// リダイレクト（建物詳細画面）
		return "redirect:/back/detailBuilding";
	}

	/**
	 * 部屋登録画面へ
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backEditCompleteBuildingToRegistRoomBuilding", method = RequestMethod.GET)
	public String backToRegistRoomBuilding(@Param(value="buildingId") Integer buildingId, RedirectAttributes attribute) {
		logger.info("EditCompleteBuildingController-backEditCompleteBuildingToRegistRoomBuilding");

		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);

		DetailBuildingForm detailBuildingForm = buildingService.getBuildingDtoForDetailBuildingForm(buildingDto);
		attribute.addFlashAttribute("detailBuildingForm", detailBuildingForm);

		// リダイレクト（建物詳細画面）
		return "redirect:/back/registRoom";
	}

}
