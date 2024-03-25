package com.filmorate.filmorateapi.media.content.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.content.mapper.ContentMapper;
import com.filmorate.filmorateapi.media.content.mapper.ContentTypeMapper;
import com.filmorate.filmorateapi.media.content.model.Content;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.ContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContentMapperImpl implements ContentMapper {
    private final JsonNullableMapper jsonNullableMapper;
    private final ContentTypeMapper contentTypeMapper;

    @Override
    public Content map(ContentRequest request) {
        Content content = Content.builder()
                .contentType(contentTypeMapper.map(request.contentType()))
                .contentUrl(request.url())
                .build();
        if (jsonNullableMapper.isPresent(request.title())) {
            content.setTitle(jsonNullableMapper.unwrap(request.title()));
        }
        return content;
    }

    @Override
    public ContentResponse map(Content content) {
        return new ContentResponse(
                content.getId(),
                content.getTitle() == null ? null : content.getTitle(),
                content.getContentUrl(),
                contentTypeMapper.map(content.getContentType()),
                content.getMovie().getId()
        );
    }
}
