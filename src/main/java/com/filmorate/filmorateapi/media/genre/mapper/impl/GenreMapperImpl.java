package com.filmorate.filmorateapi.media.genre.mapper.impl;

import com.filmorate.filmorateapi.media.genre.mapper.GenreMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GenreMapperImpl implements GenreMapper {
    private final GenreService genreService;

    @Override
    public Set<Genre> toGenres(Set<String> genreNames) {
        return genreNames.stream()
                .map(genreService::getGenreByName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> toGenreNamesSet(Set<Genre> genres) {
        return genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toSet());
    }
}
