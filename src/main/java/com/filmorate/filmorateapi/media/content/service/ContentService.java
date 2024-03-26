package com.filmorate.filmorateapi.media.content.service;

import com.filmorate.filmorateapi.media.content.model.Content;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import java.util.List;

public interface ContentService {
    Content createContent(Content content);

    List<Content> getContentByMovie(Movie movie);

    List<Content> getContentByMovieAndContentType(Movie movie, ContentType contentType);

    Content updateContent(Content content);

    Content getContentById(Long contentId);

    void removeContentById(Long contentId);

    void deleteAllContentByMovie(Movie movie);
}
