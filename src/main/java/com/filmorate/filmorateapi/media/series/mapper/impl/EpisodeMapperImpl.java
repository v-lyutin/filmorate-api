package com.filmorate.filmorateapi.media.series.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.series.mapper.EpisodeMapper;
import com.filmorate.filmorateapi.media.series.model.Episode;
import com.filmorate.filmorateapi.media.series.model.Season;
import com.filmorate.filmorateapi.media.series.web.dto.request.EpisodeCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.EpisodeUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.EpisodePreviewResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.EpisodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class EpisodeMapperImpl implements EpisodeMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    @Transactional
    public Episode map(Season season, EpisodeCreationRequest request) {
        return Episode.builder()
                .previewUrl(request.previewUrl())
                .title(request.title())
                .originalTitle(request.originalTitle())
                .description(request.description())
                .episodeNumber(request.episodeNumber())
                .duration(request.duration())
                .releaseDate(request.releaseDate())
                .season(season)
                .build();
    }

    @Override
    public EpisodeResponse map(Episode episode) {
        return new EpisodeResponse(
                episode.getId(),
                episode.getPreviewUrl(),
                episode.getTitle(),
                episode.getOriginalTitle(),
                episode.getEpisodeNumber(),
                episode.getDescription(),
                episode.getDuration(),
                episode.getReleaseDate()
        );
    }


    @Override
    public void update(Episode episode, EpisodeUpdateRequest request) {
        if (request == null) {
            return;
        }
        if (jsonNullableMapper.isPresent(request.episodeNumber())) {
            episode.setEpisodeNumber(jsonNullableMapper.unwrap(request.episodeNumber()));
        }
        if (jsonNullableMapper.isPresent(request.description())) {
            episode.setDescription(jsonNullableMapper.unwrap(request.description()));
        }
        if (jsonNullableMapper.isPresent(request.duration())) {
            episode.setDuration(jsonNullableMapper.unwrap(request.duration()));
        }
        if (jsonNullableMapper.isPresent(request.originalTitle())) {
            episode.setOriginalTitle(jsonNullableMapper.unwrap(request.originalTitle()));
        }
        if (jsonNullableMapper.isPresent(request.releaseDate())) {
            episode.setReleaseDate(jsonNullableMapper.unwrap(request.releaseDate()));
        }
        if (jsonNullableMapper.isPresent(request.previewUrl())) {
            episode.setPreviewUrl(jsonNullableMapper.unwrap(request.previewUrl()));
        }
        if (jsonNullableMapper.isPresent(request.title())) {
            episode.setTitle(jsonNullableMapper.unwrap(request.title()));
        }
    }

    @Override
    public EpisodePreviewResponse toPreview(Episode episode, Season season) {
        return new EpisodePreviewResponse(
                episode.getId(),
                episode.getPreviewUrl(),
                episode.getTitle(),
                episode.getOriginalTitle(),
                season.getSeasonNumber(),
                episode.getEpisodeNumber());
    }
}
