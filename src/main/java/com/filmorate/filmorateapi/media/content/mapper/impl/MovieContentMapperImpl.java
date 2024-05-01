package com.filmorate.filmorateapi.media.content.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.content.mapper.MovieContentMapper;
import com.filmorate.filmorateapi.media.content.model.MovieContent;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.MovieContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieContentMapperImpl implements MovieContentMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public MovieContent map(ContentRequest request, ContentType contentType) {
        MovieContent content = MovieContent.builder()
                .contentType(contentType)
                .contentUrl(request.url())
                .build();
        if (jsonNullableMapper.isPresent(request.title())) {
            content.setTitle(jsonNullableMapper.unwrap(request.title()));
        }
        return content;
    }

    @Override
    public MovieContent map(MovieContent content, ContentUpdateRequest request) {
        if (jsonNullableMapper.isPresent(request.title())) {
            content.setTitle(jsonNullableMapper.unwrap(request.title()));
        } else {
            content.setTitle(null);
        }
        content.setContentUrl(request.url());
        return content;
    }

    @Override
    public MovieContentResponse map(MovieContent content) {
        return new MovieContentResponse(
                content.getId(),
                content.getTitle() == null ? null : content.getTitle(),
                content.getContentUrl(),
                content.getContentType(),
                content.getMovie().getId()
        );
    }

    @Override
    public List<MovieContentResponse> map(List<MovieContent> content) {
        return content.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
