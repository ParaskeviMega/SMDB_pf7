package com.pf7.smdb.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @ManyToMany
    @JoinTable(name = "tv_shows_played", joinColumns = {@JoinColumn(name = "person_id")/*,@JoinColumn(name = "name"), @JoinColumn(name = "name"),@JoinColumn(name = "surname")*/},
            inverseJoinColumns = @JoinColumn(name = "tv_show_id"))
    private Set<Person> peoplePlayedTVShows;
}
