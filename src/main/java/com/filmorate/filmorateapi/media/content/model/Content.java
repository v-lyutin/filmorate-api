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
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(nullable = false)
    private String contentUrl;

    @ManyToOne
    private ContentType contentType;

    @ManyToOne(optional = false)
    private Movie movie;
}
