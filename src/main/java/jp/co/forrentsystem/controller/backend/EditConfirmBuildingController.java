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

import jp.co.forrentsystem.dto.BuildingImageDto;
import jp.co.forrentsystem.form.backend.EditBuildingForm;
import jp.co.forrentsystem.service.BuildingImageService;
import jp.co.forrentsystem.service.BuildingService;
import jp.co.forrentsystem.service.NearestStationService;
import jp.co.forrentsystem.util.FileUtil;

/**
 * 建物情報編集確認コントローラ
 * @author k.akahira
 */
@Controller
public class EditConfirmBuildingController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditConfirmBuildingController.class);

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private NearestStationService nearestStationService;
	@Autowired
	private BuildingImageService buildingImageService;

	/**
	 * 初期表示
	 *
	 * @param model
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/editConfirmBuilding", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model, HttpSession session) {
		logger.info("EditConfirmBuildingController-init");

		// 建物編集確認FormをSESSIONから取得
		EditBuildingForm editConfirmBuildingForm = (EditBuildingForm)buildingService.reloadModel(model, session).get("editConfirmBuildingForm");

		// 建物画像
		BuildingImageDto buildingImage = buildingImageService.getBuildingImage(editConfirmBuildingForm.getBuildingId());

		ModelAndView mav = new ModelAndView();
		mav.addObject("editConfirmBuildingForm", editConfirmBuildingForm);
		mav.addObject("buildingImage", buildingImage);
		// 建物画像ファイルパスを設定
		mav.addObject("filePath", FileUtil.getFileRelativePath());
		mav.setViewName("./back/editConfirmBuilding");

		return mav;
	}

	/**
	 * 建物編集完了画面へ遷移
	 *
	 * @param editConfirmBuildingForm 建物編集確認Form
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callEditConfirmBuilding", method = RequestMethod.POST)
	public String callCompleteBuilding(@Valid EditBuildingForm editConfirmBuildingForm, RedirectAttributes attribute) {
		logger.info("EditConfirmBuildingController-callCompleteBuilding");

		// 建物情報更新
		buildingService.updateBuilding(editConfirmBuildingForm);

		attribute.addFlashAttribute("buildingId", editConfirmBuildingForm.getBuildingId());

		// リダイレクト（建物完了画面）
		return "redirect:/back/editCompleteBuilding";
	}

	/**
	 * 建物編集画面へ戻る
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callEditConfirmBuilding", params="back", method = RequestMethod.POST)
	public String backFromEditConfirmBuilding(@Valid EditBuildingForm editConfirmBuildingForm, RedirectAttributes attribute) {
		logger.info("EditConfirmBuildingController-back");

		attribute.addFlashAttribute("editConfirmBuildingForm", editConfirmBuildingForm);

		// リダイレクト（建物編集画面）
		return "redirect:/back/backFromEditConfirm";
	}
}
