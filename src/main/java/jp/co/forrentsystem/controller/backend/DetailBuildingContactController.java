package jp.co.forrentsystem.controller.backend;

import java.util.List;

import javax.servlet.http.HttpSession;

import jp.co.forrentsystem.constants.ProcessClass;
import jp.co.forrentsystem.constants.ProcessStatus;
import jp.co.forrentsystem.constants.ResidentsHopeTimeClass;
import jp.co.forrentsystem.dto.BuildingContactDto;
import jp.co.forrentsystem.form.backend.BuildingContactForm;
import jp.co.forrentsystem.service.BuildingContactService;

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
 * 物件お問合せ詳細情報コントローラ
 * @author k.akahira
 */
@Controller
public class DetailBuildingContactController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(DetailBuildingContactController.class);

	@Autowired
	private BuildingContactService buildingContactService;



	/**
	 * 物件お問合せ画面初期表示
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/initDetailBuildingContact", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		logger.info("DetailBuildingContactController-init");

		int buildingContactId = (int)model.get("buildingContactId");

		// 物件お問合せ情報取得
		List<BuildingContactDto> buildingContactList = buildingContactService.getBuildingContactByContactId(buildingContactId);

		ModelAndView mav = new ModelAndView();
		mav.addObject("buildingContactForm", new BuildingContactForm());
		mav.addObject("buildingContactList", buildingContactList);
		mav.addObject("processStatusList", ProcessStatus.getProcessStatusList());
		mav.addObject("processClassList", ProcessClass.getProcessClassList());
		mav.addObject("residentsHopeTimeClassList", ResidentsHopeTimeClass.getResidentsHopeTimeClassList());

		mav.setViewName("./back/detailBuildingContact");

		return mav;
	}

	/**
	 * 処理ステータス更新処理
	 *
	 * @param session セッション情報
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/callUpdateBuildingContact", method = RequestMethod.GET)
	public String updateBuildingContact(@Param(value="buildingContactId") Integer buildingContactId, @Param(value="processStatus") Integer processStatus, HttpSession session) {
		logger.info("DetailBuildingContactController-updateBuildingContact");

		// 検索条件をSESSIONから削除
		session.removeAttribute("searchProcessStatus");
		// 物件お問合せIDをSESSIONから削除
		session.removeAttribute("buildingContactId");

		// 処理ステータス更新
		buildingContactService.updateBuildingContactForProcessStatus(buildingContactId, processStatus);
		return "redirect:/back/listBuildingContact";
	}

	/**
	 * 部屋詳細ボタン押下時、物件お問合せ詳細から部屋詳細画面へ遷移
	 *
	 * @param buildingId 建物ID
	 * @param roomId 部屋ID
	 * @param session セッション
	 *
	 * @return 画面遷移
	 */
	@RequestMapping(value = "/back/callDetailRoomFromBuildingContact", method = RequestMethod.GET)
	public String callDetailRoomFromBuildingContact(@Param(value="buildingContactId") Integer buildingContactId, @Param(value="buildingId") Integer buildingId, @Param(value="roomId") Integer roomId,
			HttpSession session, RedirectAttributes attributes) {
		logger.info("DetailBuildingContactController-callDetailRoomFromBuildingContact");

		// 物件お問合せ情報をSESSIONに格納
		session.setAttribute("buildingContactId", buildingContactId);
		// 建物ID,部屋IDをattributeに格納
		attributes.addFlashAttribute("buildingId", buildingId);
		attributes.addFlashAttribute("roomId", roomId);
		attributes.addFlashAttribute("transactionFlag", 1);

		return "redirect:/back/detailRoom";
	}

}
