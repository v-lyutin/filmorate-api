package com.filmorate.filmorateapi.media.content.usecase;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.EpisodeContentResponse;
import java.util.List;

public interface EpisodeContentUseCase {
    EpisodeContentResponse createContent(Long episodeId, ContentRequest request, ContentType contentType);

    EpisodeContentResponse updateContent(Long contentId, ContentUpdateRequest request);

    List<EpisodeContentResponse> getContentByEpisode(Long episodeId, ContentType contentType);

    EpisodeContentResponse getContentById(Long contentId);

    void removeAllContentByEpisode(Long episodeId);

    void removeContentById(Long contentId);
}
