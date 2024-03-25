package com.filmorate.filmorateapi.media.content.usecase.impl;

import com.filmorate.filmorateapi.media.content.mapper.ContentMapper;
import com.filmorate.filmorateapi.media.content.model.Content;
import com.filmorate.filmorateapi.media.content.service.ContentService;
import com.filmorate.filmorateapi.media.content.usecase.ContentUseCase;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.ContentResponse;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContentUseCaseFacade implements ContentUseCase {
    private final MovieService movieService;
    private final ContentService contentService;
    private final ContentMapper contentMapper;

    @Override
    public ContentResponse createContent(Long movieId, ContentRequest request) {
        Movie movie = movieService.getMovieById(movieId);
        Content content = contentMapper.map(request);
        content.setMovie(movie);
        return contentMapper.map(contentService.createContent(content));
    }

    @Override
    public List<ContentResponse> getContentByMovie(Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        List<Content> movieContent = contentService.getContentByMovie(movie);
        return movieContent.stream()
                .map(contentMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public void removeAllContentByMovie(Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        contentService.deleteAllContentByMovie(movie);
    }

    @Override
    public void removeContentById(Long movieId, Long contentId) {
        Movie movie = movieService.getMovieById(movieId);
        contentService.deleteContent(movie, contentId);
    }
}
