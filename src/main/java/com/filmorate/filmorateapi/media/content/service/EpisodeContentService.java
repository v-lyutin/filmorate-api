package com.filmorate.filmorateapi.media.content.service;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.EpisodeContent;
import com.filmorate.filmorateapi.media.series.model.Episode;
import java.util.List;

public interface EpisodeContentService {
    EpisodeContent createContent(EpisodeContent content);

    List<EpisodeContent> getContentByEpisode(Episode episode);

    List<EpisodeContent> getContentByEpisodeAndContentType(Episode episode, ContentType contentType);

    EpisodeContent updateContent(EpisodeContent content);

    EpisodeContent getContentById(Long contentId);

    void removeContentById(Long contentId);

    void removeAllContentByEpisode(Episode episode);
}
