package jp.co.forrentsystem.controller.backend;

import javax.servlet.http.HttpSession;

import jp.co.forrentsystem.dto.BuildingDto;
import jp.co.forrentsystem.form.backend.DetailBuildingForm;
import jp.co.forrentsystem.form.backend.RegistBuildingForm;
import jp.co.forrentsystem.service.BuildingService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 建物情報登録コントローラ
 * @author k.akahira
 */
@Controller
public class RegistCompleteBuildingController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistCompleteBuildingController.class);

	@Autowired
	private BuildingService buildingService;

	/**
	 * 建物登録完了画面初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/registCompleteBuilding", method = RequestMethod.GET)
	public ModelAndView init(@Param(value="buildingId") Integer buildingId) {
		logger.info("RegistCompleteBuildingController-init");

		ModelAndView mav = new ModelAndView();
		mav.addObject("buildingId", buildingId);
		mav.setViewName("./back/registCompleteBuilding");

		return mav;
	}

	/**
	 * 建物登録完了画面から建物登録画面遷移（続けて建物登録）
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/continueRegistBuilding", method = RequestMethod.GET)
	public String continueRegistBuilding(@Param(value="buildingId") Integer buildingId, RedirectAttributes attribute) {
		logger.info("RegistCompleteBuildingController-continueRegistBuilding");

		// 先ほど登録した建物情報を取得
		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);
		RegistBuildingForm registBuildingForm = buildingService.getRegistBuildingForm(buildingDto);

		// 建物コードだけは、初期化する
		buildingDto.setBuildingCode(null);

		attribute.addFlashAttribute("registBuildingForm", registBuildingForm);

		// リダイレクト（建物登録画面）
		return "redirect:/back/registBuilding";
	}

	/**
	 * 建物登録完了画面からTOP画面遷移
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backRegistCompleteBuildingToManageTop", method = RequestMethod.GET)
	public ModelAndView backTop(HttpSession session) {
		logger.info("RegistCompleteBuildingController-backTop");
		// 建物検索SESSION削除
		session.removeAttribute("searchBuildingForm");
		// 建物情報SESSION削除
		session.removeAttribute("registBuildingForm");

		ModelAndView mav = new ModelAndView();
		// リダイレクト（管理TOP画面）
		mav.setViewName("redirect:/back/manageTop");

		return mav;
	}

	/**
	 * 建物登録完了画面から建物詳細画面へ遷移
	 *
	 * @param buildingId 建物ID
	 * @param attribute
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backRegistCompleteBuildingToDetailBuilding", method = RequestMethod.GET)
	public String backDetail(@Param(value="buildingId") Integer buildingId, RedirectAttributes attribute) {
		logger.info("RegistCompleteBuildingController-backDetail");

		// 先ほど登録した建物情報を取得
		BuildingDto buildingDto = buildingService.getBuildingDtoByBuildingId(buildingId);

		// 建物情報を建物詳細Formに設定する
		DetailBuildingForm detailBuildingForm = buildingService.getBuildingDtoForDetailBuildingForm(buildingDto);

		//建物情報を建物詳細Formをattributeに保存
		attribute.addFlashAttribute("detailBuildingForm", detailBuildingForm);

		// リダイレクト（建物検索画面）
		return "redirect:/back/detailBuilding";
	}

	/**
	 * 建物登録完了画面から建物一覧画面へ遷移
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/backRegistCompleteBuildingToListBuilding", method = RequestMethod.GET)
	public String backList() {
		logger.info("RegistCompleteBuildingController-backList");

		// リダイレクト（建物一覧画面）
		return "redirect:/back/listBuilding";
	}
}
