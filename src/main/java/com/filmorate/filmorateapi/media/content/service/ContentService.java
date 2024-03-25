package com.filmorate.filmorateapi.media.content.service;

import com.filmorate.filmorateapi.media.content.model.Content;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import java.util.List;

public interface ContentService {
    Content createContent(Content content);

    List<Content> getContentByMovie(Movie movie);

    Content updateContent(Content content);

    Content getContentById(Long contentId);

    void deleteContent(Movie movie, Long contentId);

    void deleteAllContentByMovie(Movie movie);
}
