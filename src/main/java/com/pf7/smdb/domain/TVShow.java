package com.pf7.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "TVSHOWS_SEQ", allocationSize = 1)
public class TVShow extends BaseModel {

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "title", column = @Column(name = "MovieTitle")),
            @AttributeOverride(name = "description", column = @Column(name = "MovieDescription")),
            @AttributeOverride(name = "year", column = @Column(name = "MovieYear")),
            @AttributeOverride(name = "rating", column = @Column(name = "MovieRating")),
            @AttributeOverride(name = "genre", column = @Column(name = "Genre"))
    })
    private Movie movie;

    @ManyToMany
    private Set<Episode> episodes;
//
//    @OneToMany(mappedBy = "tvShow",fetch = FetchType.EAGER)
//    private Set<Contribution> contributions;
}
