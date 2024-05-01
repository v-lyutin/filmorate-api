package com.filmorate.filmorateapi.media.content.service;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.EpisodeContent;
import com.filmorate.filmorateapi.media.content.model.SeriesContent;
import com.filmorate.filmorateapi.media.series.model.Episode;
import com.filmorate.filmorateapi.media.series.model.Series;

import java.util.List;

public interface SeriesContentService {
    SeriesContent createContent(SeriesContent content);

    List<SeriesContent> getContentBySeries(Series series);

    List<SeriesContent> getContentBySeriesAndContentType(Series series, ContentType contentType);

    SeriesContent updateContent(SeriesContent content);

    SeriesContent getContentById(Long contentId);

    void removeContentById(Long contentId);

    void removeAllContentBySeries(Series series);
}
