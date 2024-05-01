package com.filmorate.filmorateapi.media.content.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.content.mapper.SeriesContentMapper;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.SeriesContent;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.SeriesContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SeriesContentMapperImpl implements SeriesContentMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public SeriesContent map(ContentRequest request, ContentType contentType) {
        SeriesContent content = SeriesContent.builder()
                .contentType(contentType)
                .contentUrl(request.url())
                .build();
        if (jsonNullableMapper.isPresent(request.title())) {
            content.setTitle(jsonNullableMapper.unwrap(request.title()));
        }
        return content;
    }

    @Override
    public SeriesContent map(SeriesContent content, ContentUpdateRequest request) {
        if (jsonNullableMapper.isPresent(request.title())) {
            content.setTitle(jsonNullableMapper.unwrap(request.title()));
        } else {
            content.setTitle(null);
        }
        content.setContentUrl(request.url());
        return content;
    }

    @Override
    public SeriesContentResponse map(SeriesContent content) {
        return new SeriesContentResponse(
                content.getId(),
                content.getTitle() == null ? null : content.getTitle(),
                content.getContentUrl(),
                content.getContentType(),
                content.getSeries().getId()
        );
    }

    @Override
    public List<SeriesContentResponse> map(List<SeriesContent> content) {
        return content.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
