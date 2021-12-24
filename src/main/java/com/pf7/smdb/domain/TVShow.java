package com.pf7.smdb.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity()
public class TVShow extends BaseModel{

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

    //@NotNull(message = "Season cannot be null.")
    @Column(nullable = false)
    private Integer season;

    //@NotNull(message = "Episodes cannot be null.")
    @Column(nullable = false)
    private Integer episodes;

    @OneToMany(mappedBy = "tvShow")
    private Set<Contribution> associations1;
}
