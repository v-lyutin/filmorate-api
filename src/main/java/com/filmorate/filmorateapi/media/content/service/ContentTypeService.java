package com.filmorate.filmorateapi.media.content.service;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import java.util.List;

public interface ContentTypeService {
    ContentType createContentType(ContentType contentType);

    ContentType getContentTypeById(Long id);

    ContentType getContentTypeByName(String name);

    List<ContentType> getAllContentTypes();

    ContentType updateContentType(ContentType contentType);

    void removeContentTypeById(Long id);
}
