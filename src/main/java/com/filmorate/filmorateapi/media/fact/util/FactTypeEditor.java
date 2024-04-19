package com.filmorate.filmorateapi.media.fact.util;

import com.filmorate.filmorateapi.media.fact.exception.FactServiceException;
import com.filmorate.filmorateapi.media.fact.model.FactType;
import org.springframework.http.HttpStatus;
import java.beans.PropertyEditorSupport;

public class FactTypeEditor extends PropertyEditorSupport {
    public void setAsText(String value) {
        try {
            setValue(FactType.valueOf(value.toUpperCase()));
        } catch (Exception exception) {
            throw new FactServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Type with value '%s' not exists", value));
        }
    }
}
