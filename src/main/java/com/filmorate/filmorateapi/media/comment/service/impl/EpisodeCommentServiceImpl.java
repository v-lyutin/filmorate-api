package com.filmorate.filmorateapi.media.comment.service.impl;

import com.filmorate.filmorateapi.media.comment.model.EpisodeComment;
import com.filmorate.filmorateapi.media.comment.repository.EpisodeCommentRepository;
import com.filmorate.filmorateapi.media.comment.service.EpisodeCommentService;
import com.filmorate.filmorateapi.media.series.model.Episode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EpisodeCommentServiceImpl implements EpisodeCommentService {
    private final EpisodeCommentRepository episodeCommentRepository;

    @Override
    public Page<EpisodeComment> getCommentsByEpisode(Episode episode, Pageable pageable) {
        return episodeCommentRepository.findAllByEpisode(episode, pageable);
    }

    @Override
    public void createEpisodeComment(EpisodeComment episodeComment) {
        episodeCommentRepository.save(episodeComment);
    }

    @Override
    public void removeAllCommentsByEpisode(Episode episode) {
        episodeCommentRepository.removeAllByEpisode(episode);
    }
}
