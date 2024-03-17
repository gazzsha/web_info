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
@Constraint(validatedBy = BirthdayValidator.class)
@Documented
public @interface Birthday {
    String message() default "Возраст 18+";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}