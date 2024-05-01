package com.filmorate.filmorateapi.media.content.model;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "filmorate", name = "movie_content")
public class MovieContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(nullable = false)
    private String contentUrl;

    @Enumerated(EnumType.STRING)
    ContentType contentType;

    @ManyToOne(optional = false)
    private Movie movie;
}
