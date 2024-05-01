package com.filmorate.filmorateapi.media.content.service;

import com.filmorate.filmorateapi.media.content.model.MovieContent;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import java.util.List;

public interface MovieContentService {
    MovieContent createContent(MovieContent content);

    List<MovieContent> getContentByMovie(Movie movie);

    List<MovieContent> getContentByMovieAndContentType(Movie movie, ContentType contentType);

    MovieContent updateContent(MovieContent content);

    MovieContent getContentById(Long contentId);

    void removeContentById(Long contentId);

    void deleteAllContentByMovie(Movie movie);
}
