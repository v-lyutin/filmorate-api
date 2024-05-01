package com.filmorate.filmorateapi.media.content.usecase.impl;

import com.filmorate.filmorateapi.media.content.mapper.MovieContentMapper;
import com.filmorate.filmorateapi.media.content.model.MovieContent;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.service.MovieContentService;
import com.filmorate.filmorateapi.media.content.usecase.MovieContentUseCase;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.MovieContentResponse;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieContentUseCaseFacade implements MovieContentUseCase {
    private final MovieService movieService;
    private final MovieContentService movieContentService;
    private final MovieContentMapper movieContentMapper;

    @Override
    public MovieContentResponse createContent(Long movieId, ContentRequest request, ContentType contentType) {
        Movie movie = movieService.getMovieById(movieId);
        MovieContent content = movieContentMapper.map(request, contentType);
        content.setMovie(movie);
        return movieContentMapper.map(movieContentService.createContent(content));
    }

    @Override
    public MovieContentResponse updateContent(Long contentId, ContentUpdateRequest request) {
        MovieContent content = movieContentService.getContentById(contentId);
        MovieContent updatedContent = movieContentMapper.map(content, request);
        return movieContentMapper.map(movieContentService.updateContent(updatedContent));
    }

    @Override
    public List<MovieContentResponse> getContentByMovie(Long movieId, ContentType contentType) {
        Movie movie = movieService.getMovieById(movieId);
        if (contentType == ContentType.ALL) {
            return movieContentMapper.map(movieContentService.getContentByMovie(movie));
        }
        return movieContentMapper.map(movieContentService.getContentByMovieAndContentType(movie, contentType));
    }

    @Override
    public MovieContentResponse getContentById(Long contentId) {
        return movieContentMapper.map(movieContentService.getContentById(contentId));
    }

    @Override
    public void removeAllContentByMovie(Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        movieContentService.deleteAllContentByMovie(movie);
    }

    @Override
    public void removeContentById(Long contentId) {
        movieContentService.removeContentById(contentId);
    }
}
