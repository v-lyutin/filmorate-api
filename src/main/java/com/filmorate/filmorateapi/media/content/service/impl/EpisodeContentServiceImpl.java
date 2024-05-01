package com.filmorate.filmorateapi.media.content.service.impl;

import com.filmorate.filmorateapi.media.content.exception.ContentServiceException;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.EpisodeContent;
import com.filmorate.filmorateapi.media.content.repository.EpisodeContentRepository;
import com.filmorate.filmorateapi.media.content.service.EpisodeContentService;
import com.filmorate.filmorateapi.media.series.model.Episode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeContentServiceImpl implements EpisodeContentService {
    private final EpisodeContentRepository episodeContentRepository;

    @Override
    public EpisodeContent createContent(EpisodeContent content) {
        return episodeContentRepository.save(content);
    }

    @Override
    public List<EpisodeContent> getContentByEpisode(Episode episode) {
        return episodeContentRepository.findAllByEpisode(episode);
    }

    @Override
    public List<EpisodeContent> getContentByEpisodeAndContentType(Episode episode, ContentType contentType) {
        return episodeContentRepository.findAllByEpisodeAndContentType(episode, contentType);
    }

    @Override
    public EpisodeContent updateContent(EpisodeContent content) {
        return episodeContentRepository.save(content);
    }

    @Override
    public EpisodeContent getContentById(Long contentId) {
        return episodeContentRepository.findById(contentId)
                .orElseThrow(() -> new ContentServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Content with ID = '%d' not found", contentId)));
    }

    @Override
    public void removeContentById(Long contentId) {
        episodeContentRepository.deleteById(contentId);
    }

    @Override
    public void removeAllContentByEpisode(Episode episode) {
        episodeContentRepository.removeAllByEpisode(episode);
    }
}
