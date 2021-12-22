package com.pf7.smdb.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
//@SequenceGenerator(name = "idGenerator", sequenceName = "FILMS_SEQ", allocationSize = 1)
public class Film extends BaseModel {

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride( name = "title", column = @Column(name = "MovieTitle")),
            @AttributeOverride( name = "description", column = @Column(name = "MovieDescription")),
            @AttributeOverride( name = "year", column = @Column(name = "MovieYear")),
            @AttributeOverride( name = "rating", column = @Column(name = "MovieRating"))
    })
    private Movie movie;

//    @NotNull
//    @OneToMany
//    private Set<Person> peoplePlayedFilms;

    @OneToMany(mappedBy = "film")
    private Set<Association> associations1;
}


