package com.filmorate.filmorateapi.user.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NicknameConstraintValidator implements ConstraintValidator<Nickname, String> {
    private static final String NICKNAME_REGEX = "^[a-z0-9_.]{5,30}$";

    @Override
    public boolean isValid(String nickname, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(NICKNAME_REGEX);
        Matcher matcher = pattern.matcher(nickname);
        return matcher.matches();
    }
}
