package com.filmorate.filmorateapi.media.comment.model;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "movie_comments")
public class MovieComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Movie movie;

    @ManyToOne(optional = false)
    private Comment comment;
}
