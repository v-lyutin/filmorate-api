package com.filmorate.filmorateapi.media.genre.service;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import java.util.Collection;

public interface GenreService {
    Collection<Genre> getAllGenres();

    Genre getGenreById(Long genreId);

    Genre getGenreByName(String name);

    Genre createGenre(Genre genre);

    Genre updateGenre(Long genreId, String genreName);

    void deleteGenre(Long genreId);
}
