package jp.co.forrentsystem.form.backend;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * ログイン用Formクラス
 * @author k.akahira
 *
 */
public class LoginForm {

	/** システムユーザログインID */
	@NotEmpty
	private String systemUserLoginId;
	/** システムユーザパスワード */
	@NotEmpty
	private String systemUserPassword;

	public String getSystemUserLoginId() {
		return systemUserLoginId;
	}
	public void setSystemUserLoginId(String systemUserLoginId) {
		this.systemUserLoginId = systemUserLoginId;
	}
	public String getSystemUserPassword() {
		return systemUserPassword;
	}
	public void setSystemUserPassword(String systemUserPassword) {
		this.systemUserPassword = systemUserPassword;
	}


}
