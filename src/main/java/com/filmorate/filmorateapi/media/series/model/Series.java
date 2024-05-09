package com.filmorate.filmorateapi.media.series.model;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.rating.model.MPAARating;
import com.filmorate.filmorateapi.media.rating.model.RARSRating;
import com.filmorate.filmorateapi.user.model.UserProfile;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String posterUrl;

    @Column(nullable = false)
    protected String title;

    @Column(nullable = false)
    protected String originalTitle;

    @Column(nullable = false)
    protected String description;

    @Column(nullable = false)
    protected Integer releaseYear;

    @Column(nullable = false)
    protected String country;

    @Column(nullable = false)
    private boolean isFinished;

    @ManyToOne(optional = false)
    private MPAARating mpaaRating;

    @ManyToOne(optional = false)
    private RARSRating rarsRating;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            schema = "filmorate",
            name = "series_genres",
            joinColumns = { @JoinColumn(name = "series_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id", referencedColumnName = "id") }
    )
    protected Set<Genre> genres = new HashSet<>();

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "filmorate",
            name = "series_likes",
            joinColumns = { @JoinColumn(name = "series_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "user_profile_id", referencedColumnName = "id") }
    )
    private Set<UserProfile> likedByUsers = new HashSet<>();
}
