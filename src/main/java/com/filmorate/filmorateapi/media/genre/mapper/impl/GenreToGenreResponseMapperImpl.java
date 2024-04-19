package com.filmorate.filmorateapi.media.genre.mapper.impl;

import com.filmorate.filmorateapi.media.genre.mapper.GenreToGenreResponseMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreResponse;
import org.springframework.stereotype.Component;

@Component
public class GenreToGenreResponseMapperImpl implements GenreToGenreResponseMapper {
    @Override
    public GenreResponse map(Genre genre) {
        return new GenreResponse(genre.getName());
    }
}
