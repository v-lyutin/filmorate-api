package com.filmorate.filmorateapi.media.content.util;

import com.filmorate.filmorateapi.media.content.exception.ContentServiceException;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import org.springframework.http.HttpStatus;
import java.beans.PropertyEditorSupport;

public class ContentTypeEditor extends PropertyEditorSupport {
    public void setAsText(String value) {
        try {
            setValue(ContentType.valueOf(value.toUpperCase()));
        } catch (Exception exception) {
            throw new ContentServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Type with value '%s' not exists", value));
        }
    }
}
