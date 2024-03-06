package com.filmorate.filmorateapi.media.movie.mapper.impl;

import com.filmorate.filmorateapi.media.movie.mapper.MovieToMovieCreationResponseMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import org.springframework.stereotype.Component;

@Component
public class MovieToMovieCreationResponseMapperImpl implements MovieToMovieCreationResponseMapper {
    @Override
    public MovieCreationResponse map(Movie movie) {
        return new MovieCreationResponse(
                movie.getId(),
                movie.getUrl(),
                movie.getPosterUrl(),
                movie.getName(),
                movie.getEnName(),
                movie.getDescription(),
                movie.getEnDescription(),
                movie.getReleaseYear(),
                movie.getDuration(),
                movie.getCreatedAt()
        );
    }
}
