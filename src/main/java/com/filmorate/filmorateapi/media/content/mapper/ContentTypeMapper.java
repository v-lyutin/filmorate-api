package com.filmorate.filmorateapi.media.content.mapper;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentTypeRequest;

public interface ContentTypeMapper {
    ContentType map(String contentTypeName);

    String map(ContentType contentType);

    ContentType map(ContentTypeRequest request);
}
