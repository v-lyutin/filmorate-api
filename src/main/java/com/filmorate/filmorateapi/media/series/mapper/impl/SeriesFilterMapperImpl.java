package com.filmorate.filmorateapi.media.series.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.series.mapper.SeriesFilterMapper;
import com.filmorate.filmorateapi.media.series.web.dto.filter.SeriesFilter;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesFindRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeriesFilterMapperImpl implements SeriesFilterMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public SeriesFilter map(SeriesFindRequest request) {
        SeriesFilter seriesFilter = SeriesFilter.builder().build();
        if (request == null) {
            return seriesFilter;
        }
        if (jsonNullableMapper.isPresent(request.title())) {
            seriesFilter.setTitle(jsonNullableMapper.unwrap(request.title()));
        }
        if (jsonNullableMapper.isPresent(request.originalTitle())) {
            seriesFilter.setOriginalTitle(jsonNullableMapper.unwrap(request.originalTitle()));
        }
        if (jsonNullableMapper.isPresent(request.releaseYear())) {
            seriesFilter.setReleaseYear(jsonNullableMapper.unwrap(request.releaseYear()).toString());
        }
        if (jsonNullableMapper.isPresent(request.country())) {
            seriesFilter.setCountry(jsonNullableMapper.unwrap(request.country()));
        }
        if (jsonNullableMapper.isPresent(request.isFinished())) {
            seriesFilter.setIsFinished(jsonNullableMapper.unwrap(request.isFinished()));
        }
        if (jsonNullableMapper.isPresent(request.mpaaRating())) {
            seriesFilter.setMpaaRatingName(jsonNullableMapper.unwrap(request.mpaaRating()));
        }
        if (jsonNullableMapper.isPresent(request.rarsRating())) {
            seriesFilter.setRarsRatingName(jsonNullableMapper.unwrap(request.rarsRating()));
        }
        if (jsonNullableMapper.isPresent(request.genres())) {
            seriesFilter.setGenres(jsonNullableMapper.unwrap(request.genres()));
        }
        return seriesFilter;
    }
}
