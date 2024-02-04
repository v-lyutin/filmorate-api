package com.filmorate.filmorateapi.media.genre.usecase;

import com.filmorate.filmorateapi.media.genre.web.dto.GenreCreationRequest;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreResponse;
import java.util.Collection;

public interface GenreUseCase {
    Collection<GenreResponse> getAllGenres();

    void createGenre(GenreCreationRequest genreCreationRequest);

    void updateGenre(Long genreId, GenreCreationRequest genreCreationRequest);

    void deleteGenre(Long genreId);
}
