package com.pf7.smdb.domain;

import com.pf7.smdb.helper.GenreEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Embeddable
public class Movie {

    //@NotNull(message = "Title cannot be null.")
    @Column(length = 255)
    private String title;

    @Lob
    @Column(length = 20000)
    private String description;

    //@NotNull(message = "Year cannot be null.")
    @Column(length = 4)
    private Integer year;

    //@NotNull(message = "Genre cannot be null.")
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<GenreEnum> genre = new HashSet<>();

//    //@NotNull(message = "PersonID cannot be null.")
//    @ManyToMany(targetEntity = Person.class, fetch = FetchType.EAGER)
//    private Set<Person> people = new HashSet<>();

    //@NotNull(message = "Rating cannot be null.")
    @Column(precision = 1, scale = 1)
    @Min(1)
    @Max(10)
    private Double rating;

}
