package com.filmorate.filmorateapi.media.genre.usecase.impl;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.service.GenreService;
import com.filmorate.filmorateapi.media.genre.usecase.GenreUseCase;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class GenreUseCaseFacade implements GenreUseCase {
    private final GenreService genreService;

    @Override
    public Collection<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @Override
    public Genre getGenreById(Long genreId) {
        return genreService.getGenreById(genreId);
    }

    @Override
    public Genre createGenre(GenreCreationRequest genreCreationRequest) {
        Genre genre = new Genre();
        genre.setName(genreCreationRequest.name());
        return genreService.createGenre(genre);
    }

    @Override
    public Genre updateGenre(Long genreId, GenreCreationRequest genreCreationRequest) {
        return genreService.updateGenre(genreId, genreCreationRequest.name());
    }

    @Override
    public void deleteGenre(Long genreId) {
        genreService.deleteGenre(genreId);
    }
}
