package com.filmorate.filmorateapi.media.content.mapper.impl;

import com.filmorate.filmorateapi.media.content.mapper.ContentTypeMapper;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.service.ContentTypeService;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentTypeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContentTypeMapperImpl implements ContentTypeMapper {
    private final ContentTypeService contentTypeService;

    @Override
    public ContentType map(String contentTypeName) {
        return contentTypeService.getContentTypeByName(contentTypeName);
    }

    @Override
    public String map(ContentType contentType) {
        return contentType.getName();
    }

    @Override
    public ContentType map(ContentTypeRequest request) {
        ContentType contentType = new ContentType();
        contentType.setName(request.name());
        return contentType;
    }
}
