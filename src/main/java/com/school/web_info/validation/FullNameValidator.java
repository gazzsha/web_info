package com.school.web_info.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class FullNameValidator implements ConstraintValidator<FullName, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(s) || s.isEmpty()) return false;
        String[] tokensFullName = s.split(" ");
        return tokensFullName.length == 2;
    }
}
