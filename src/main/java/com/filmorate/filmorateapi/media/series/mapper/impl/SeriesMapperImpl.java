package com.filmorate.filmorateapi.media.series.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.genre.mapper.GenreFromStringMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.series.mapper.SeriesMapper;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.service.SeasonService;
import com.filmorate.filmorateapi.media.series.service.SeriesService;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPageResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPreviewResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SeriesMapperImpl implements SeriesMapper {
    private final SeasonService seasonService;
    private final GenreFromStringMapper genreFromStringMapper;
    private final JsonNullableMapper jsonNullableMapper;
    private final SeriesService seriesService;

    @Override
    public Series map(SeriesCreationRequest request) {
        return Series.builder()
                .posterUrl(request.posterUrl())
                .title(request.title())
                .originalTitle(request.originalTitle())
                .genres(parseGenres(request.genres()))
                .description(request.description())
                .releaseYear(request.releaseYear())
                .country(request.country())
                .isFinished(request.isFinished())
                .build();
    }

    @Override
    public SeriesResponse map(Series series) {
        return new SeriesResponse(
                series.getId(),
                series.getPosterUrl(),
                series.getTitle(),
                series.getOriginalTitle(),
                genresToGenreResponses(series.getGenres()),
                series.getDescription(),
                series.getReleaseYear(),
                series.getCountry(),
                seasonService.countSeasonsBySeries(series),
                series.isFinished()
        );
    }

    @Override
    public void update(SeriesUpdateRequest request, Series series) {
        if (request == null) {
            return;
        }
        if (jsonNullableMapper.isPresent(request.title())) {
            series.setTitle(jsonNullableMapper.unwrap(request.title()));
        }
        if (jsonNullableMapper.isPresent(request.originalTitle())) {
            series.setOriginalTitle(jsonNullableMapper.unwrap(request.originalTitle()));
        }
        if (jsonNullableMapper.isPresent(request.genres())) {
            Set<String> genres = jsonNullableMapper.unwrap(request.genres());
            series.setGenres(parseGenres(genres));
        }
        if (jsonNullableMapper.isPresent(request.description())) {
            series.setDescription(jsonNullableMapper.unwrap(request.description()));
        }
        if (jsonNullableMapper.isPresent(request.releaseYear())) {
            series.setReleaseYear(jsonNullableMapper.unwrap(request.releaseYear()));
        }
        if (jsonNullableMapper.isPresent(request.country())) {
            series.setCountry(jsonNullableMapper.unwrap(request.country()));
        }
        if (jsonNullableMapper.isPresent(request.isFinished())) {
            series.setFinished(jsonNullableMapper.unwrap(request.isFinished()));
        }
    }

    @Override
    public SeriesPageResponse toSeriesPageResponse(Page<Series> series) {
        List<SeriesPreviewResponse> seriesPreviewResponses = series.getContent().stream()
                .map(this::toSeriesPreviewResponse)
                .toList();
        return new SeriesPageResponse(
                series.getTotalPages(),
                series.isFirst(),
                series.isLast(),
                series.getTotalElements(),
                seriesPreviewResponses
        );
    }

    private SeriesPreviewResponse toSeriesPreviewResponse(Series series) {
        return new SeriesPreviewResponse(
                series.getId(),
                series.getPosterUrl(),
                series.getTitle(),
                series.getOriginalTitle(),
                genresToGenreResponses(series.getGenres()),
                seriesService.getSeriesLikeCount(series.getId())
        );
    }

    private Set<Genre> parseGenres(Set<String> genres) {
        return genres.stream()
                .map(genreFromStringMapper::map)
                .collect(Collectors.toSet());
    }

    private List<String> genresToGenreResponses(Set<Genre> genres) {
        if (genres == null) {
            return null;
        }
        return genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toList());
    }
}
