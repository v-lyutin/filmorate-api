package com.filmorate.filmorateapi.media.genre.service.impl;

import com.filmorate.filmorateapi.media.genre.exception.GenreServiceException;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.repository.GenreRepository;
import com.filmorate.filmorateapi.media.genre.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
                .orElseThrow(() -> new GenreServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Genre with ID = '%d' not found", genreId)));
    }

    @Override
    public Genre getGenreByName(String name) {
        return genreRepository.findByName(name)
                .orElseThrow(() -> new GenreServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Genre with name '%s' not found", name)));
    }

    @Override
    public Genre createGenre(Genre genre) {
        if (genreRepository.existsByName(genre.getName())) {
            throw new GenreServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Genre with name '%s' is already exists", genre.getName()));
        }
        return genreRepository.save(genre);
    }

    @Override
    public Genre updateGenre(Long genreId, String genreName) {
        if (genreRepository.existsByName(genreName)) {
            throw new GenreServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Genre with name '%s' is already exists", genreName));
        }
        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new GenreServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Genre with ID = '%d' not found", genreId)));
        genre.setName(genreName);
        return genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Long genreId) {
        genreRepository.deleteById(genreId);
    }
}
