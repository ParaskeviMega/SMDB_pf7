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
@Table
@SequenceGenerator(name = "idGenerator", sequenceName = "SHOWS_SEQ", allocationSize = 1)
public class Show extends BaseModel{

    @NotNull(message = "Title cannot be null.")
    @Column(nullable = false)
    private String showTitle;

    @Lob
    @Column(length = 20000)
    private String showDescription;

    @Column(length = 4)
    private Integer showYear;

    @NotNull(message = "Genre cannot be null.")
    @Column(length = 50,nullable = false)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> showGenre;

    @Column(length = 4)
    private String showRating;

    private Integer showEpisodes;

    private Integer showSeasons;

    @OneToMany(targetEntity = PersonRole.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private final Set<PersonRole> showPersonRoles = new HashSet<>();

}
