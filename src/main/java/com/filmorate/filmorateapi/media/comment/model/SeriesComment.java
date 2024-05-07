package com.filmorate.filmorateapi.media.comment.model;

import com.filmorate.filmorateapi.media.series.model.Series;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "series_comments")
public class SeriesComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Series series;

    @ManyToOne(optional = false)
    private Comment comment;
}
