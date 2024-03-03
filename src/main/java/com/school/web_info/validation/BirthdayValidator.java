package com.school.web_info.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

public class BirthdayValidator implements ConstraintValidator<Birthday, Date> {

    private static final Integer FULL_AGE = 18;
    @Override
    public boolean isValid(Date time, ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime dateTimeFullAge = LocalDateTime.now().minusYears(FULL_AGE);
        if (Objects.isNull(time)) return false;
        return time.before(Date.valueOf(dateTimeFullAge.toLocalDate()));
    }

}
