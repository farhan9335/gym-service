package com.example.mypack.utility;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileNumberValidator.class)
@Documented
public @interface MobileNumber {

	String message() default "Invalid mobile phone number";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
