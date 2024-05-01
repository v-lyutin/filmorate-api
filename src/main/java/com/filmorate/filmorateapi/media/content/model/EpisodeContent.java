package com.filmorate.filmorateapi.media.content.model;

import com.filmorate.filmorateapi.media.series.model.Episode;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "filmorate", name = "episodes_content")
public class EpisodeContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(nullable = false)
    private String contentUrl;

    @Enumerated(EnumType.STRING)
    ContentType contentType;

    @ManyToOne(optional = false)
    private Episode episode;
}
