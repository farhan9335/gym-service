package com.example.mypack.utility;


import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileNumberValidator implements ConstraintValidator<MobileNumber, String> {

    private static final Pattern MOBILE_NUMBER_PATTERN = Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$");

    @Override
    public void initialize(MobileNumber constraintAnnotation) {
        // No initialization needed
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && MOBILE_NUMBER_PATTERN.matcher(value).matches();
    }
}

