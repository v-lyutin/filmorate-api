package com.filmorate.filmorateapi.media.rating.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "rating_mpaa")
public class MPAA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
