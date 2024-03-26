package com.school.web_info.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = FullNameValidator.class)
@Documented
public @interface FullName {
    String message() default "Поле должно содердать имя и фамилию";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
