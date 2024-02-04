package com.filmorate.filmorateapi.media.genre.service;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import java.util.Collection;

public interface GenreService {
    Collection<Genre> getAllGenres();

    void createGenre(Genre genre);

    void updateGenre(Long genreId, String genreName);

    void deleteGenre(Long genreId);
}
