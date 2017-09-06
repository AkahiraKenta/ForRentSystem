package jp.co.forrentsystem.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jp.co.forrentsystem.annotation.validator.CheckDateFormatValidator;

/**
 * 文字列の日付形式チェック ※独自アノテーション定義
 * @author d.kitajima
 *
 */
@Target({FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CheckDateFormatValidator.class)
@Documented
public @interface CheckDateFormat {

	String message() default "{wrider.annotation.CheckDateFormat.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
