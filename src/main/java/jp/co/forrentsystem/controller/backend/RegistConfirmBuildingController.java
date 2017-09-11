package jp.co.forrentsystem.controller.backend;

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

import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.form.backend.RegistBuildingForm;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.NearestStationService;

/**
 * 建物情報登録確認コントローラ
 * @author k.akahira
 */
@Controller
public class RegistConfirmBuildingController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistConfirmBuildingController.class);

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private NearestStationService nearestStationService;

	/**
	 * 初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registConfirmBuilding", method = RequestMethod.GET, produces="text/plain;charset=utf-8")
	public ModelAndView init(ModelMap model, HttpSession session) {
		logger.info("RegistConfirmBuildingController-execute");

		RegistBuildingForm registConfirmBuildingForm = (RegistBuildingForm)buildingService.reloadModel(model, session).get("registBuildingForm");

		ModelAndView mav = new ModelAndView();
		mav.addObject("registConfirmBuildingForm", registConfirmBuildingForm);
		mav.setViewName("./back/registConfirmBuilding");

		return mav;
	}

	/**
	 * 建物登録完了画面へ遷移
	 *
	 * @param registConfirmBuildingForm 建物登録確認情報FORM
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callRegistCompleteBuilding", method = RequestMethod.POST, produces="text/plain;charset=utf-8")
	public ModelAndView callRegistCompleteBuilding(@Valid RegistBuildingForm registConfirmBuildingForm, RedirectAttributes attribute) {
		logger.info("RegistConfirmBuildingController-callRegistCompleteBuilding");

		BuildingDto buildingDto = buildingService.insertBuilding(registConfirmBuildingForm);

		// 建物情報Formをリダイレクト内容に含める
		attribute.addFlashAttribute("registBuildingForm", registConfirmBuildingForm);

		ModelAndView mav = new ModelAndView();
		// リダイレクト（建物登録完了画面）
		mav.addObject("buildingId", buildingDto.getBuildingId());
		mav.setViewName("redirect:/back/registCompleteBuilding");

		return mav;
	}

	/**
	 * 建物登録画面へ遷移
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callRegistCompleteBuilding", params = "back", method = RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String back(@Valid RegistBuildingForm registConfirmBuildingForm, RedirectAttributes attribute) {
		logger.info("RegistConfirmBuildingController-back");

		// 建物登録確認Formをattributeに設定
		attribute.addFlashAttribute("registBuildingForm", registConfirmBuildingForm);

		// リダイレクト（建物登録画面）
		return "redirect:/back/registBuilding";
	}
}
