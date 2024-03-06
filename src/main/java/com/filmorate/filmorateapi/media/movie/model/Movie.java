package com.filmorate.filmorateapi.media.movie.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "movies")
@EntityListeners(AuditingEntityListener.class)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String posterUrl;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String enName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String enDescription;

    @Column(nullable = false)
    private Integer releaseYear;

    @Column(nullable = false)
    private Integer duration;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant editedAt;
}
