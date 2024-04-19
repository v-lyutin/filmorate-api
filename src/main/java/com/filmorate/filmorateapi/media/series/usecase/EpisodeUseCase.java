package com.filmorate.filmorateapi.media.series.usecase;

import com.filmorate.filmorateapi.media.series.web.dto.request.EpisodeCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.EpisodeUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.EpisodePreviewResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.EpisodeResponse;
import java.util.List;

public interface EpisodeUseCase {
    EpisodeResponse createEpisode(Long seasonId, EpisodeCreationRequest request);

    EpisodeResponse updateEpisode(Long episodeId, EpisodeUpdateRequest request);

    EpisodeResponse getEpisodeById(Long episodeId);

    List<EpisodePreviewResponse> getEpisodesBySeason(Long seasonId);

    void removeEpisodeById(Long episodeId);
}
