package jp.co.forrentsystem.annotation.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.forrentsystem.annotation.CheckDateFormat;

/**
 * 文字列の日付形式チェック ※独自アノテーションクラス
 * @author d.kitajima
 *
 */
public class CheckDateFormatValidator implements ConstraintValidator<CheckDateFormat, String> {

	private static final String DATE_FORMAT = "yyyy/MM/dd";

	public void initialize(CheckDateFormat constraintAnnotation) {

	}

	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {

		if (object != null && "".equals(object) == false) {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);

			try {
				df.parse(object);
			} catch(Exception e) {
				return false;
			}
		}

		return true;

	}

}
