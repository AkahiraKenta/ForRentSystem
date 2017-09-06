package jp.co.forrentsystem.controller.backend;

import static jp.co.forrentsystem.constants.Constants.*;
import jp.co.forrentsystem.constants.SystemUserClass;
import jp.co.forrentsystem.form.backend.SystemUserForm;
import jp.co.forrentsystem.form.backend.SystemUserForm.RegistCheck;
import jp.co.forrentsystem.form.backend.SystemUserForm.UpdateCheck;
import jp.co.forrentsystem.service.SystemUserService;
import jp.co.forrentsystem.util.UtilService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * システムユーザー登録画面用コントローラークラス
 * @author d.kitajima
 *
 */
@Controller
public class RegistSystemUserController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RegistSystemUserController.class);

	@Autowired
	private SystemUserService systemUserService;


	/**
	 * システムユーザー登録画面 初期表示処理
	 * @return
	 */
	@RequestMapping(value = "/back/initRegistSystemUser", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		logger.info("RegistSystemUserController-init");

		ModelAndView mav = new ModelAndView();

		// Form設定
		SystemUserForm systemUserForm = null;
		if (model.get("systemUserForm") == null) {
			systemUserForm = new SystemUserForm();
			systemUserForm.setSystemUserId(-1);
		} else {
			systemUserForm = (SystemUserForm)model.get("systemUserForm");
		}

		// IDの設定値で処理を切り分ける
		int systemUserId = systemUserForm.getSystemUserId();
		if (systemUserId != -1) {
			// 更新
			//対象のユーザー情報を取得する
			systemUserForm = systemUserService.getTargetSystemUser(systemUserId);
		}

		mav.addObject("systemUserForm", systemUserForm);

		// システムユーザー区分
		mav.addObject("systemUserClassList", SystemUserClass.getSystemUserClassList());
		mav.addObject("flagList", UtilService.getMasterDtoListForFlag(SORT_DESC));
		mav.setViewName("./back/registSystemUser");

		return mav;
	}

	/**
	 * 登録ボタン押下時の処理
	 * @param systemUserForm
	 * @param result
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/back/callRegistConfirmSystemUser", params = "regist", method = RequestMethod.POST)
	public ModelAndView moveConfirmForRegist(@Validated(RegistCheck.class)SystemUserForm systemUserForm, BindingResult result, RedirectAttributes attributes) {

		logger.info("RegistSystemUserController-moveConfirm-regist");

		ModelAndView mav = new ModelAndView();

		// バリデーションチェック・相関チェック
		if (result.hasErrors() || correlationCheck(systemUserForm) == false) {

			// バリデーションチェックエラーの場合は、自画面遷移
			mav.addObject("systemUserForm", systemUserForm);
			mav.addObject("systemUserClassList", SystemUserClass.getSystemUserClassList());
			mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
			mav.setViewName("./back/registSystemUser");

			return mav;
		}

		// エラー発生せず確認画面に遷移する場合は、Formをフラッシュに設定する
		attributes.addFlashAttribute("systemUserForm", systemUserForm);
		mav.setViewName("redirect:/back/editConfirmSystemUser");

		return mav;

	}

	/**
	 * 更新ボタン押下時
	 * @param systemUserForm
	 * @param result
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/back/callRegistConfirmSystemUser", params = "update", method = RequestMethod.POST)
	public ModelAndView moveConfirmForUpdate(@Validated(UpdateCheck.class)SystemUserForm systemUserForm, BindingResult result, RedirectAttributes attributes) {

		logger.info("RegistSystemUserController-moveConfirm-update");

		ModelAndView mav = new ModelAndView();

		// バリデーションチェック
		if (result.hasErrors()) {

			// バリデーションチェックエラーの場合は、自画面遷移
			mav.addObject("systemUserForm", systemUserForm);
			mav.addObject("systemUserClassList", SystemUserClass.getSystemUserClassList());
			mav.addObject("flagList", UtilService.getMasterDtoListForFlag());
			mav.setViewName("./back/registSystemUser");

			return mav;
		}

		// エラー発生せず確認画面に遷移する場合は、Formをフラッシュに設定する
		attributes.addFlashAttribute("systemUserForm", systemUserForm);
		mav.setViewName("redirect:/back/editConfirmSystemUser");

		return mav;
	}

	/**
	 * 戻るボタン押下時の処理
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/back/backSystemUserList", method = RequestMethod.GET)
	public String backSystemUserList() {

		return "redirect:/back/listSystemUser";
	}

	/**
	 * 相関チェック
	 * @return
	 */
	private boolean correlationCheck(SystemUserForm systemUserForm) {

		boolean correlationCheckResultFlag = true;


		// ①パスワード一致チェック
		if (!StringUtils.equals(systemUserForm.getSystemUserPassword(), systemUserForm.getSystemUserPasswordConfirm())) {
			correlationCheckResultFlag = false;
		}

		// ②ログインID重複チェック
		if (!systemUserService.checkAvailableLoginId(systemUserForm.getSystemUserLoginId())) {
			correlationCheckResultFlag = false;
		}


		return correlationCheckResultFlag;
	}

}
