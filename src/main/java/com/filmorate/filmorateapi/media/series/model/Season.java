package com.filmorate.filmorateapi.media.series.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String posterUrl;

    @Column(nullable = false)
    private Integer seasonNumber;

    @ManyToOne(optional = false)
    private Series series;
}
