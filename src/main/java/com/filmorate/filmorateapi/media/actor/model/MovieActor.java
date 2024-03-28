package com.filmorate.filmorateapi.media.actor.model;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.person.model.Person;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "movie_actors")
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private Boolean isMainRole;

    @ManyToOne(optional = false)
    private Person person;

    @ManyToOne(optional = false)
    private Movie movie;
}
