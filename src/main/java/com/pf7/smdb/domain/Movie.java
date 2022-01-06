package com.pf7.smdb.domain;

import com.pf7.smdb.helper.PersonRole;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIES_SEQ", allocationSize = 1)
public class Movie extends BaseModel {

    @NotNull(message = "Title cannot be null.")
    @Column(nullable = false)
    private String movieTitle;

    @Lob
    @Column(length = 20000)
    private String movieDescription;

    @Column(length = 4)
    private Integer movieYear;

    @NotNull(message = "Genre cannot be null.")
    @Column(length = 50,nullable = false)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "movie_genres",joinColumns = @JoinColumn(name = "id"))
    private List<String> movieGenre;

    @Column(length = 4)
    private String movieRating;

    @OneToMany(targetEntity = PersonRole.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private final Set<PersonRole> moviePersonRoles = new HashSet<>();

}


