package com.filmorate.filmorateapi.media.comment.repository;

import com.filmorate.filmorateapi.media.comment.model.EpisodeComment;
import com.filmorate.filmorateapi.media.series.model.Episode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeCommentRepository extends CrudRepository<EpisodeComment, Long> {
    Page<EpisodeComment> findAllByEpisode(Episode episode, Pageable pageable);

    void removeAllByEpisode(Episode episode);
}
