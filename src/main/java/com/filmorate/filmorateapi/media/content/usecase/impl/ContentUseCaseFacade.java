package com.filmorate.filmorateapi.media.content.usecase.impl;

import com.filmorate.filmorateapi.media.content.mapper.ContentMapper;
import com.filmorate.filmorateapi.media.content.model.Content;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.service.ContentService;
import com.filmorate.filmorateapi.media.content.usecase.ContentUseCase;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.ContentResponse;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ContentUseCaseFacade implements ContentUseCase {
    private final MovieService movieService;
    private final ContentService contentService;
    private final ContentMapper contentMapper;

    @Override
    public ContentResponse createContent(Long movieId, ContentRequest request, ContentType contentType) {
        Movie movie = movieService.getMovieById(movieId);
        Content content = contentMapper.map(request, contentType);
        content.setMovie(movie);
        return contentMapper.map(contentService.createContent(content));
    }

    @Override
    public ContentResponse updateContent(Long contentId, ContentUpdateRequest request) {
        Content content = contentService.getContentById(contentId);
        Content updatedContent = contentMapper.map(content, request);
        return contentMapper.map(contentService.updateContent(updatedContent));
    }

    @Override
    public List<ContentResponse> getContentByMovie(Long movieId, ContentType contentType) {
        Movie movie = movieService.getMovieById(movieId);
        if (contentType == ContentType.ALL) {
            return contentMapper.map(contentService.getContentByMovie(movie));
        }
        return contentMapper.map(contentService.getContentByMovieAndContentType(movie, contentType));
    }

    @Override
    public ContentResponse getContentById(Long contentId) {
        return contentMapper.map(contentService.getContentById(contentId));
    }

    @Override
    public void removeAllContentByMovie(Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        contentService.deleteAllContentByMovie(movie);
    }

    @Override
    public void removeContentById(Long contentId) {
        contentService.removeContentById(contentId);
    }
}
