package com.filmorate.filmorateapi.media.genre.mapper;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import java.util.Set;

public interface GenreMapper {
    Set<Genre> toGenres(Set<String> genreNames);

    Set<String> toGenreNamesSet(Set<Genre> genres);
}
