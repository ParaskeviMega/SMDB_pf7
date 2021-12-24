package com.pf7.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity()
//@SequenceGenerator(name = "idGenerator", sequenceName = "FILMS_SEQ", allocationSize = 1)
public class Film extends BaseModel {

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride( name = "title", column = @Column(name = "MovieTitle")),
            @AttributeOverride( name = "description", column = @Column(name = "MovieDescription")),
            @AttributeOverride( name = "year", column = @Column(name = "MovieYear")),
            @AttributeOverride( name = "rating", column = @Column(name = "MovieRating")),
            @AttributeOverride( name = "genre", column = @Column(name = "Genre")),
            @AttributeOverride( name = "personId", column = @Column(name = "PersonID"))
    })
    private Movie movie;

//    @NotNull
//    @OneToMany
//    private Set<Person> peoplePlayedFilms;

    @OneToMany(mappedBy = "film")
    private Set<Contribution> associations1;
}


