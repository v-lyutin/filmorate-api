package com.filmorate.filmorateapi.media.comment.model;

import com.filmorate.filmorateapi.media.series.model.Episode;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "episodes_comments")
public class EpisodeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Episode episode;

    @ManyToOne(optional = false)
    private Comment comment;
}
