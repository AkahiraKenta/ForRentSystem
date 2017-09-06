package jp.co.forrentsystem.controller.backend;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import jp.co.forrentsystem.dto.SystemUserDto;
import jp.co.forrentsystem.form.backend.SystemUserForm;
import jp.co.forrentsystem.service.SystemUserService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * システムユーザー管理画面用コントローラークラス
 * @author d.kitajima
 *
 */
@Controller
public class ListSystemUserController {
	private Logger logger = org.slf4j.LoggerFactory.getLogger(ListSystemUserController.class);

	@Autowired
	private SystemUserService systemUserService;

	/**
	 * システムユーザー管理画面　初期表示処理
	 * @return
	 */
	@RequestMapping(value = "/back/listSystemUser", method = RequestMethod.GET)
	public ModelAndView init() {
		logger.info("ListSystemUserController-init");

		List<SystemUserDto> systemUserDtoList = systemUserService.getSystemUserList();

		ModelAndView mav = new ModelAndView();
		mav.addObject("systemUserForm", new SystemUserForm());
		mav.addObject("systemUserDtoList", systemUserDtoList);
		mav.setViewName("./back/systemUser");

		return mav;
	}

	/**
	 * システムユーザー管理画面　システムユーザー新規追加リンク
	 * @return
	 */
	@RequestMapping(value = "/back/registSystemUser", method = RequestMethod.GET)
	public String callRegistSystemUser(RedirectAttributes attributes) {
		logger.info("ListSystemUserController-callRegistSystemUser");

		SystemUserForm systemUserForm = new SystemUserForm();
		systemUserForm.setSystemUserId(-1);
		attributes.addFlashAttribute("systemUserForm",systemUserForm);

		return "redirect:/back/initRegistSystemUser";
	}

	/**
	 * 編集ボタン押下時の処理
	 * @param systemUserId
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/back/callEditSystemUser", method=RequestMethod.GET)
	public String callEditSystemUser(@RequestParam("systemUserId")int systemUserId, RedirectAttributes attributes) {
		logger.info("ListSystemUserController-callEditSystemUser");

		// 該当のシステムユーザー情報を取得する
		SystemUserForm systemUserForm = systemUserService.getTargetSystemUser(systemUserId);

		attributes.addFlashAttribute("systemUserForm", systemUserForm);
		return "redirect:/back/initRegistSystemUser";
	}

	/**
	 * 削除ボタン押下時の処理
	 * @param systemUserId
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/back/callDeleteSystemUser", method=RequestMethod.GET)
	public ModelAndView callDeleteSystemUser(@RequestParam("systemUserId")int systemUserId, RedirectAttributes attributes) {
		logger.info("ListSystemUserController-callDeleteSystemUser");

		// システムユーザ情報を削除する
		systemUserService.deleteTargetSystemUser(systemUserId);
		List<SystemUserDto> systemUserDtoList = systemUserService.getSystemUserList();

		ResourceBundle bundle = ResourceBundle.getBundle("Message_ja");

		ModelAndView mav = new ModelAndView();
		mav.addObject("systemUserForm", new SystemUserForm());
		mav.addObject("systemUserDtoList", systemUserDtoList);
		mav.addObject("message", bundle.getString("delete.systemuser"));
		mav.setViewName("./back/systemUser");

		return mav;
	}


	/**
	 * パスワード変更
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/back/changePassword", method=RequestMethod.POST)
	public boolean changePassword(SystemUserForm systemUserForm, @Param(value="systemUserId") Integer systemUserId, HttpSession session) {
		logger.info("ListSystemUserController-changePassword");

		// システムユーザIDをフォームに設定
		systemUserForm.setSystemUserId(systemUserId);

		// 現在のパスワードが一致するか確認
		boolean passwordFlag = systemUserService.checkSystemUserPassword(systemUserForm);
		if (passwordFlag) {
			// パスワードを更新
			systemUserService.updateSystemUserForPassword(systemUserForm);
		}
		return passwordFlag;
	}
}
