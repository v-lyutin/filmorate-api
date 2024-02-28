package com.filmorate.filmorateapi.user.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = NicknameConstraintValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@NotBlank
public @interface Nickname {
    String message() default "Incorrect nickname";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
