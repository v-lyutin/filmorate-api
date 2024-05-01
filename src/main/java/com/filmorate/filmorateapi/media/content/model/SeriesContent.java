package com.filmorate.filmorateapi.media.content.model;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.series.model.Series;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "filmorate", name = "series_content")
public class SeriesContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(nullable = false)
    private String contentUrl;

    @Enumerated(EnumType.STRING)
    ContentType contentType;

    @ManyToOne(optional = false)
    private Series series;
}
