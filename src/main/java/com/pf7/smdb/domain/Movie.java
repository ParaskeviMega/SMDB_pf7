package com.pf7.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

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

    @NotNull(message = "Title cannot be null.")
    @Column(length = 50, nullable = false)
    private String title;

    @NotNull(message = "Description cannot be null.")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "Year cannot be null.")
    @Column(length = 4, nullable = false)
    private Integer year;

    @NotNull(message = "Genre cannot be null.")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Genre genre;

    @NotNull(message = "Rating cannot be null.")
    @Column(precision = 1, scale = 1, nullable = false)
    @Min(1)
    @Max(5)
    private Float rating;
//
//    @NotNull
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
//    private Set<Person> peopleSet;
}
