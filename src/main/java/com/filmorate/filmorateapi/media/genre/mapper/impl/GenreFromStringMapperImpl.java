package com.filmorate.filmorateapi.media.genre.mapper.impl;

import com.filmorate.filmorateapi.media.genre.mapper.GenreFromStringMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenreFromStringMapperImpl implements GenreFromStringMapper {
    private final GenreService genreService;

    @Override
    public Genre map(String source) {
        return genreService.getGenreByName(source);
    }
}
