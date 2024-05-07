package com.filmorate.filmorateapi.media.movie.model;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.user.model.UserProfile;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
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
    private String posterUrl;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String originalTitle;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer releaseYear;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Integer duration;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            schema = "filmorate",
            name = "movie_genres",
            joinColumns = { @JoinColumn(name = "movie_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id", referencedColumnName = "id") }
    )
    private Set<Genre> genres = new HashSet<>();
}
