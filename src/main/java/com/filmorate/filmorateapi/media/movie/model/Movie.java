package com.filmorate.filmorateapi.media.movie.model;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.person.model.Person;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "movie")
@EntityListeners(AuditingEntityListener.class)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String enTitle;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String enDescription;

    @Column(nullable = false)
    private Integer releaseYear;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private String posterUrl;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            schema = "filmorate",
            name = "movie_genres",
            joinColumns = { @JoinColumn(name = "movie_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id", referencedColumnName = "id") }
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne
    private Person director;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;
}
