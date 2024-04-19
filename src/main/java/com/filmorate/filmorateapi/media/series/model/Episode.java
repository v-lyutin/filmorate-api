package com.filmorate.filmorateapi.media.series.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    protected String previewUrl;

    @Column(nullable = false)
    protected String title;

    @Column(nullable = false)
    protected String originalTitle;

    @Column(nullable = false)
    protected String description;

    @Column(nullable = false)
    private Integer episodeNumber;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @ManyToOne(optional = false)
    private Season season;
}
