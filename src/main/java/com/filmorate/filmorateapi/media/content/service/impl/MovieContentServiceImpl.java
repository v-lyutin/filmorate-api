package com.filmorate.filmorateapi.media.content.service.impl;

import com.filmorate.filmorateapi.media.content.exception.ContentServiceException;
import com.filmorate.filmorateapi.media.content.model.MovieContent;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.repository.MovieContentRepository;
import com.filmorate.filmorateapi.media.content.service.MovieContentService;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class MovieContentServiceImpl implements MovieContentService {
    private final MovieContentRepository contentRepository;

    @Override
    public MovieContent createContent(MovieContent content) {
        return contentRepository.save(content);
    }

    @Override
    public List<MovieContent> getContentByMovie(Movie movie) {
        if (movie == null) {
            throw new ContentServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "The 'movie' variable is null");
        }
        return contentRepository.findAllByMovie(movie);
    }

    @Override
    public List<MovieContent> getContentByMovieAndContentType(Movie movie, ContentType contentType) {
        return contentRepository.findAllByMovieAndContentType(movie, contentType);
    }

    @Override
    public MovieContent updateContent(MovieContent content) {
        return contentRepository.save(content);
    }

    @Override
    public MovieContent getContentById(Long contentId) {
        return contentRepository.findById(contentId)
                .orElseThrow(() -> new ContentServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Content with ID = '%d' not found", contentId)));
    }

    @Override
    public void removeContentById(Long contentId) {
        contentRepository.deleteById(contentId);
    }

    @Override
    public void deleteAllContentByMovie(Movie movie) {
        contentRepository.removeAllByMovie(movie);
    }
}
