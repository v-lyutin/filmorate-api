package com.filmorate.filmorateapi.media.genre.usecase;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreCreationRequest;
import java.util.Collection;

public interface GenreUseCase {
    Collection<Genre> getAllGenres();

    Genre getGenreById(Long genreId);

    Genre createGenre(GenreCreationRequest genreCreationRequest);

    Genre updateGenre(Long genreId, GenreCreationRequest genreCreationRequest);

    void deleteGenre(Long genreId);
}
