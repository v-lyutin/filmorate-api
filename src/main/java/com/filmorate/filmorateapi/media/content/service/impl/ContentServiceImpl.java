package com.filmorate.filmorateapi.media.content.service.impl;

import com.filmorate.filmorateapi.media.content.exception.ContentServiceException;
import com.filmorate.filmorateapi.media.content.model.Content;
import com.filmorate.filmorateapi.media.content.repository.ContentRepository;
import com.filmorate.filmorateapi.media.content.service.ContentService;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;

    @Override
    public Content createContent(Content content) {
        if (content == null) {
            throw new ContentServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "The 'content' variable is null");
        }
        return contentRepository.save(content);
    }

    @Override
    public List<Content> getContentByMovie(Movie movie) {
        if (movie == null) {
            throw new ContentServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "The 'movie' variable is null");
        }
        return contentRepository.findAllByMovie(movie);
    }

    @Override
    public Content updateContent(Content content) {
        if (content == null) {
            throw new ContentServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "The 'content' variable is null");
        }
        return contentRepository.save(content);
    }

    @Override
    public Content getContentById(Long contentId) {
        return contentRepository.findById(contentId)
                .orElseThrow(() -> new ContentServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Content with ID = '%d' not found", contentId)));
    }

    @Override
    public void deleteContent(Movie movie, Long contentId) {
        if (movie == null) {
            throw new ContentServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "The 'movie' variable is null");
        }
        List<Content> movieContent = getContentByMovie(movie);
        if (movieContent == null || movieContent.isEmpty()) {
            return;
        }
        Long requiredContentId = movieContent.stream()
                .map(Content::getId)
                .filter(id -> id.equals(contentId))
                .findFirst()
                .orElseThrow(() -> new ContentServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Content with ID = '%d' for movie with ID = '%d' not found", contentId, movie.getId())
                ));
        contentRepository.deleteById(requiredContentId);
    }

    @Override
    public void deleteAllContentByMovie(Movie movie) {
        if (movie == null) {
            throw new ContentServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "The 'movie' variable is null");
        }
        contentRepository.removeAllByMovie(movie);
    }
}
