package com.filmorate.filmorateapi.media.genre.service.impl;

import com.filmorate.filmorateapi.media.genre.exception.GenreServiceException;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.repository.GenreRepository;
import com.filmorate.filmorateapi.media.genre.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public Collection<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(Long genreId) {
        return genreRepository.findById(genreId)
                .orElseThrow(() -> new GenreServiceException(String.format("Жанра с ID = {%d} не существует", genreId)));
    }

    @Override
    public void createGenre(Genre genre) {
        if (genreRepository.existsByName(genre.getName())) {
            throw new GenreServiceException("Жанр с таким названием уже существует");
        }
        genreRepository.save(genre);
    }

    @Override
    public void updateGenre(Long genreId, String genreName) {
        if (genreRepository.existsByName(genreName)) {
            throw new GenreServiceException("Жанр с таким названием уже существует");
        }
        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new GenreServiceException(String.format("Жанра с ID = {%d} не существует", genreId)));
        genre.setName(genreName);
        genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Long genreId) {
        genreRepository.deleteById(genreId);
    }
}
