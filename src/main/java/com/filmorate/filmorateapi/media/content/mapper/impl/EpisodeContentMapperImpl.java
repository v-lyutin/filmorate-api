package com.filmorate.filmorateapi.media.content.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.content.mapper.EpisodeContentMapper;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.EpisodeContent;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.EpisodeContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EpisodeContentMapperImpl implements EpisodeContentMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public EpisodeContent map(ContentRequest request, ContentType contentType) {
        EpisodeContent content = EpisodeContent.builder()
                .contentType(contentType)
                .contentUrl(request.url())
                .build();
        if (jsonNullableMapper.isPresent(request.title())) {
            content.setTitle(jsonNullableMapper.unwrap(request.title()));
        }
        return content;
    }

    @Override
    public EpisodeContent map(EpisodeContent content, ContentUpdateRequest request) {
        if (jsonNullableMapper.isPresent(request.title())) {
            content.setTitle(jsonNullableMapper.unwrap(request.title()));
        } else {
            content.setTitle(null);
        }
        content.setContentUrl(request.url());
        return content;
    }

    @Override
    public EpisodeContentResponse map(EpisodeContent content) {
        return new EpisodeContentResponse(
                content.getId(),
                content.getTitle() == null ? null : content.getTitle(),
                content.getContentUrl(),
                content.getContentType(),
                content.getEpisode().getId()
        );
    }

    @Override
    public List<EpisodeContentResponse> map(List<EpisodeContent> content) {
        return content.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
