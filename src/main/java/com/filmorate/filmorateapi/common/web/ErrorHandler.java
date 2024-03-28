package com.filmorate.filmorateapi.common.web;

import com.filmorate.filmorateapi.media.actor.exception.MovieActorServiceException;
import com.filmorate.filmorateapi.media.career.exception.CareerServiceException;
import com.filmorate.filmorateapi.media.content.exception.ContentServiceException;
import com.filmorate.filmorateapi.media.fact.exception.FactServiceException;
import com.filmorate.filmorateapi.media.genre.exception.GenreServiceException;
import com.filmorate.filmorateapi.media.movie.exception.MovieServiceException;
import com.filmorate.filmorateapi.media.person.exception.PersonServiceException;
import com.filmorate.filmorateapi.security.exception.IdentityApiServiceException;
import com.filmorate.filmorateapi.security.exception.JwtAccessTokenServiceException;
import com.filmorate.filmorateapi.security.exception.UserAccountServiceException;
import com.filmorate.filmorateapi.security.exception.UserRoleServiceException;
import com.filmorate.filmorateapi.user.api.exception.CurrentUserProfileApiServiceException;
import com.filmorate.filmorateapi.user.exception.UserProfileServiceException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(MovieActorServiceException.class)
    public ProblemDetail handleMovieActorServiceException(MovieActorServiceException exception) {
        return ProblemDetail.forStatusAndDetail(exception.getHttpStatus(), exception.getMessage());
    }

    @ExceptionHandler(ContentServiceException.class)
    public ProblemDetail handleContentServiceException(ContentServiceException exception) {
        return ProblemDetail.forStatusAndDetail(exception.getHttpStatus(), exception.getMessage());
    }

    @ExceptionHandler(MovieServiceException.class)
    public ProblemDetail handleMovieServiceException(MovieServiceException exception) {
        return ProblemDetail.forStatusAndDetail(exception.getHttpStatus(), exception.getMessage());
    }

    @ExceptionHandler(FactServiceException.class)
    public ProblemDetail handleFactServiceException(FactServiceException exception) {
        return ProblemDetail.forStatusAndDetail(exception.getHttpStatus(), exception.getMessage());
    }

    @ExceptionHandler(CurrentUserProfileApiServiceException.class)
    public ProblemDetail handleCurrentUserProfileApiServiceException(CurrentUserProfileApiServiceException exception) {
        return ProblemDetail.forStatusAndDetail(exception.getHttpStatus(), exception.getMessage());
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ProblemDetail handleTypeMismatchException(TypeMismatchException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(PersonServiceException.class)
    public ProblemDetail handlePersonServiceException(PersonServiceException exception) {
        return ProblemDetail.forStatusAndDetail(exception.getHttpStatus(), exception.getMessage());
    }

    @ExceptionHandler(CareerServiceException.class)
    public ProblemDetail handleCareerServiceException(CareerServiceException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail handleAccessDeniedException(AccessDeniedException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, exception.getMessage());
    }

    @ExceptionHandler(GenreServiceException.class)
    public ProblemDetail handleGenreServiceException(GenreServiceException exception) {
        return ProblemDetail.forStatusAndDetail(exception.getHttpStatus(), exception.getMessage());
    }

    @ExceptionHandler(JwtAccessTokenServiceException.class)
    public ProblemDetail handleJwtAccessTokenServiceException(JwtAccessTokenServiceException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    @ExceptionHandler(IdentityApiServiceException.class)
    public ProblemDetail handleIdentityApiServiceException(IdentityApiServiceException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, exception.getMessage());
    }

    @ExceptionHandler(UserProfileServiceException.class)
    public ProblemDetail handleUserProfileServiceException(UserProfileServiceException exception) {
        return ProblemDetail.forStatusAndDetail(exception.getHttpStatus(), exception.getMessage());
    }

    @ExceptionHandler(UserAccountServiceException.class)
    public ProblemDetail handleUserAccountServiceException(UserAccountServiceException exception) {
        return ProblemDetail.forStatusAndDetail(exception.getHttpStatus(), exception.getMessage());
    }

    @ExceptionHandler(UserRoleServiceException.class)
    public ProblemDetail handleUserRoleServiceException(UserRoleServiceException exception) {
        return ProblemDetail.forStatusAndDetail(exception.getHttpStatus(), exception.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ProblemDetail handleUsernameNotFoundException(UsernameNotFoundException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        FieldError fieldError = exception.getBindingResult().getAllErrors().stream()
                .filter(FieldError.class::isInstance)
                .map(FieldError.class::cast)
                .findFirst()
                .orElseThrow();
        String errorMessage = String.format("%s: %s", fieldError.getField(), fieldError.getDefaultMessage());
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, errorMessage);
    }

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleRuntimeException(RuntimeException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}
