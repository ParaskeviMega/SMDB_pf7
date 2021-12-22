package com.pf7.smdb.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity()
public class TVShow extends BaseModel{

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride( name = "title", column = @Column(name = "MovieTitle")),
            @AttributeOverride( name = "description", column = @Column(name = "MovieDescription")),
            @AttributeOverride( name = "year", column = @Column(name = "MovieYear")),
            @AttributeOverride( name = "rating", column = @Column(name = "MovieRating"))
    })
    private Movie movie;

    @NotNull(message = "Season cannot be null.")
    @Column(nullable = false)
    private Integer season;

    @NotNull(message = "Episodes cannot be null.")
    @Column(nullable = false)
    private Integer episodes;

    @OneToMany(mappedBy = "tvShow")
    private Set<Association> associations1;
}
