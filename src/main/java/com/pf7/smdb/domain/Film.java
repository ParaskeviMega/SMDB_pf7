package com.pf7.smdb.domain;

import com.pf7.smdb.helper.FilmPersonRoles;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FILMS")
@SequenceGenerator(name = "idGenerator", sequenceName = "FILMS_SEQ", allocationSize = 1)
public class Film extends BaseModel {

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride( name = "title", column = @Column(name = "MovieTitle")),
            @AttributeOverride( name = "description", column = @Column(name = "MovieDescription")),
            @AttributeOverride( name = "year", column = @Column(name = "MovieYear")),
            @AttributeOverride( name = "rating", column = @Column(name = "MovieRating")),
            @AttributeOverride( name = "genre", column = @Column(name = "Genre"))
    })
    private Movie movie;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FilmPersonRoles> filmPersonRoles;
}


