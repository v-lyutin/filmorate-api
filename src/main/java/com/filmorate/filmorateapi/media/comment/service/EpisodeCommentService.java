package com.filmorate.filmorateapi.media.comment.service;

import com.filmorate.filmorateapi.media.comment.model.EpisodeComment;
import com.filmorate.filmorateapi.media.series.model.Episode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EpisodeCommentService {
    Page<EpisodeComment> getCommentsByEpisode(Episode Episode, Pageable pageable);

    void createEpisodeComment(EpisodeComment episodeComment);

    void removeAllCommentsByEpisode(Episode episode);
}
