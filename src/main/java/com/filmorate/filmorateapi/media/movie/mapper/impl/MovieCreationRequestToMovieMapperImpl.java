package com.filmorate.filmorateapi.media.movie.mapper.impl;

import com.filmorate.filmorateapi.media.movie.mapper.MovieCreationRequestToMovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import org.springframework.stereotype.Component;

@Component
public class MovieCreationRequestToMovieMapperImpl implements MovieCreationRequestToMovieMapper {
    @Override
    public Movie map(MovieCreationRequest request) {
        return Movie.builder()
                .url(request.url())
                .posterUrl(request.posterUrl())
                .name(request.name())
                .enName(request.enName())
                .description(request.description())
                .enDescription(request.enDescription())
                .releaseYear(request.releaseYear())
                .duration(request.duration())
                .build();
    }
}
