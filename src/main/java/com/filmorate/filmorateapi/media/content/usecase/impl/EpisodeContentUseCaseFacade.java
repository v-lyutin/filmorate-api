package com.filmorate.filmorateapi.media.content.usecase.impl;

import com.filmorate.filmorateapi.media.content.mapper.EpisodeContentMapper;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.EpisodeContent;
import com.filmorate.filmorateapi.media.content.service.EpisodeContentService;
import com.filmorate.filmorateapi.media.content.usecase.EpisodeContentUseCase;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.EpisodeContentResponse;
import com.filmorate.filmorateapi.media.series.model.Episode;
import com.filmorate.filmorateapi.media.series.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EpisodeContentUseCaseFacade implements EpisodeContentUseCase {
    private final EpisodeService episodeService;
    private final EpisodeContentService episodeContentService;
    private final EpisodeContentMapper episodeContentMapper;

    @Override
    public EpisodeContentResponse createContent(Long episodeId, ContentRequest request, ContentType contentType) {
        Episode episode = episodeService.getEpisodeById(episodeId);
        EpisodeContent episodeContent = episodeContentMapper.map(request, contentType);
        episodeContent.setEpisode(episode);
        return episodeContentMapper.map(episodeContentService.createContent(episodeContent));
    }

    @Override
    public EpisodeContentResponse updateContent(Long contentId, ContentUpdateRequest request) {
        EpisodeContent content = episodeContentService.getContentById(contentId);
        EpisodeContent updatedContent = episodeContentMapper.map(content, request);
        return episodeContentMapper.map(episodeContentService.updateContent(updatedContent));
    }

    @Override
    public List<EpisodeContentResponse> getContentByEpisode(Long episodeId, ContentType contentType) {
        Episode episode = episodeService.getEpisodeById(episodeId);
        if (contentType == ContentType.ALL) {
            return episodeContentMapper.map(episodeContentService.getContentByEpisode(episode));
        }
        return episodeContentMapper.map(episodeContentService.getContentByEpisodeAndContentType(episode, contentType));
    }

    @Override
    public EpisodeContentResponse getContentById(Long contentId) {
        return episodeContentMapper.map(episodeContentService.getContentById(contentId));
    }

    @Override
    public void removeAllContentByEpisode(Long episodeId) {
        Episode episode = episodeService.getEpisodeById(episodeId);
        episodeContentService.removeAllContentByEpisode(episode);
    }

    @Override
    public void removeContentById(Long contentId) {
        episodeContentService.removeContentById(contentId);
    }
}
