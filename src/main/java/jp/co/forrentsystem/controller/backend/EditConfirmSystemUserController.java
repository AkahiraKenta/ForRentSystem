package jp.co.forrentsystem.controller.backend;

import jp.co.forrentsystem.form.backend.SystemUserForm;
import jp.co.forrentsystem.service.SystemUserService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * システムユーザー登録・編集確認画面用コントローラークラス
 * @author d.kitajima
 *
 */
@Controller
public class EditConfirmSystemUserController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(EditConfirmSystemUserController.class);

	@Autowired
	private SystemUserService systemUserService;

	/**
	 * システムユーザー登録・編集確認画面 初期表示処理
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/back/editConfirmSystemUser", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		logger.info("EditConfirmSystemUserController-init");

		ModelAndView mav = new ModelAndView();
		mav.addObject("systemUserForm", model.get("systemUserForm"));
		mav.setViewName("./back/editConfirmSystemUser");

		return mav;
	}

	/**
	 * 戻るボタン押下時の処理
	 * @return
	 */
	@RequestMapping(value = "/back/callEditCompleteSystemUser", params = "back", method = RequestMethod.POST)
	public String backRegistSystemUser(SystemUserForm systemUserForm, RedirectAttributes attributes) {
		logger.info("EditConfirmSystemUserController-backRegistSystemUser");

		attributes.addFlashAttribute("systemUserForm", systemUserForm);

		return "redirect:initRegistSystemUser";
	}

	/**
	 * 保存ボタン押下時の処理
	 * @return
	 */
	@RequestMapping(value = "/back/callEditCompleteSystemUser", params = "save", method = RequestMethod.POST)
	public String execute(SystemUserForm systemUserForm) {

		logger.info("EditConfirmSystemUserController-execute");

		if (systemUserForm.getSystemUserId() > 0) {
			// 更新
			systemUserService.updateSystemUser(systemUserForm);
		} else {
			// 登録
			systemUserService.registSystemUser(systemUserForm);
		}


		return "back/editCompleteSystemUser";

	}
}
