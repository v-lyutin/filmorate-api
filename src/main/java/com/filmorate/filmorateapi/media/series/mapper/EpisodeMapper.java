package com.filmorate.filmorateapi.media.series.mapper;

import com.filmorate.filmorateapi.media.series.model.Episode;
import com.filmorate.filmorateapi.media.series.model.Season;
import com.filmorate.filmorateapi.media.series.web.dto.request.EpisodeCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.EpisodeUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.EpisodePreviewResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.EpisodeResponse;

public interface EpisodeMapper {
    Episode map(Season season, EpisodeCreationRequest request);

    EpisodeResponse map(Episode episode);

    EpisodePreviewResponse toPreview(Episode episode, Season season);

    void update(Episode episode, EpisodeUpdateRequest request);
}
