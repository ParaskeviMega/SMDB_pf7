package com.pf7.smdb.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Movie{

    //@NotNull(message = "Title cannot be null.")
    @Column(length = 50, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    //@NotNull(message = "Year cannot be null.")
    @Column(length = 4, nullable = false)
    private Integer year;

    //@NotNull(message = "Genre cannot be null.")
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Genre> genre;

    //@NotNull(message = "PersonID cannot be null.")
    @ElementCollection
    private Set<Long> personId;

    //@NotNull(message = "Rating cannot be null.")
    @Column(precision = 1, scale = 1, nullable = false)
    @Min(1)
    @Max(5)
    private Float rating;
}
