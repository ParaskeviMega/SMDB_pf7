package com.pf7.smdb.domain;

import com.pf7.smdb.helper.GenreEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Embeddable
public class Movie {

    //@NotNull(message = "Title cannot be null.")
    @Column(length = 50, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    //@NotNull(message = "Year cannot be null.")
    @Column(length = 4, nullable = false)
    private Integer year;

    //@NotNull(message = "Genre cannot be null.")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<GenreEnum> genre;

    //@NotNull(message = "PersonID cannot be null.")
    @ManyToMany(targetEntity = Person.class, fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    private Set<Person> people;

    //@NotNull(message = "Rating cannot be null.")
    @Column(precision = 1, scale = 1, nullable = false)
    @Min(1)
    @Max(5)
    private Float rating;

}
