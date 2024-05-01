package com.filmorate.filmorateapi.media.content.repository;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.EpisodeContent;
import com.filmorate.filmorateapi.media.series.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EpisodeContentRepository extends JpaRepository<EpisodeContent, Long> {
    List<EpisodeContent> findAllByEpisode(Episode episode);

    List<EpisodeContent> findAllByEpisodeAndContentType(Episode episode, ContentType contentType);

    void removeAllByEpisode(Episode episode);
}
