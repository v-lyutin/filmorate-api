package com.filmorate.filmorateapi.media.movie.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.movie.mapper.MovieFilterMapper;
import com.filmorate.filmorateapi.media.movie.web.dto.filter.MovieFilter;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieFindRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieFilterMapperImpl implements MovieFilterMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public MovieFilter map(MovieFindRequest request) {
        MovieFilter movieFilter = MovieFilter.builder().build();
        if (request == null) {
            return movieFilter;
        }
        if (jsonNullableMapper.isPresent(request.title())) {
            movieFilter.setTitle(jsonNullableMapper.unwrap(request.title()));
        }
        if (jsonNullableMapper.isPresent(request.originalTitle())) {
            movieFilter.setOriginalTitle(jsonNullableMapper.unwrap(request.originalTitle()));
        }
        if (jsonNullableMapper.isPresent(request.releaseYear())) {
            movieFilter.setReleaseYear(jsonNullableMapper.unwrap(request.releaseYear()).toString());
        }
        if (jsonNullableMapper.isPresent(request.country())) {
            movieFilter.setCountry(jsonNullableMapper.unwrap(request.country()));
        }
        if (jsonNullableMapper.isPresent(request.duration())) {
            movieFilter.setDuration(jsonNullableMapper.unwrap(request.duration()).toString());
        }
        if (jsonNullableMapper.isPresent(request.mpaaRating())) {
            movieFilter.setMpaaRatingName(jsonNullableMapper.unwrap(request.mpaaRating()));
        }
        if (jsonNullableMapper.isPresent(request.rarsRating())) {
            movieFilter.setRarsRatingName(jsonNullableMapper.unwrap(request.rarsRating()));
        }
        if (jsonNullableMapper.isPresent(request.genres())) {
            movieFilter.setGenres(jsonNullableMapper.unwrap(request.genres()));
        }
        return movieFilter;
    }
}
