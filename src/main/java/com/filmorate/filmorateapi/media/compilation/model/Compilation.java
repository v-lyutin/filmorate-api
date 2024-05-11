package com.filmorate.filmorateapi.media.compilation.model;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.user.model.UserProfile;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "compilations")
public class Compilation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @ManyToOne(optional = false)
    private UserProfile userProfile;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            schema = "filmorate",
            name = "genre_compilations",
            joinColumns = { @JoinColumn(name = "compilation_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id", referencedColumnName = "id") }
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "filmorate",
            name = "movie_compilations",
            joinColumns = {
                    @JoinColumn(name = "compilation_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "movie_id", referencedColumnName = "id")
            }
    )
    private Set<Movie> movies = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "filmorate",
            name = "series_compilations",
            joinColumns = {
                    @JoinColumn(name = "compilation_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "series_id", referencedColumnName = "id")
            }
    )
    private Set<Series> series = new HashSet<>();

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "filmorate",
            name = "compilation_likes",
            joinColumns = { @JoinColumn(name = "compilation_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "user_profile_id", referencedColumnName = "id") }
    )
    private Set<UserProfile> likedByUsers = new HashSet<>();
}
