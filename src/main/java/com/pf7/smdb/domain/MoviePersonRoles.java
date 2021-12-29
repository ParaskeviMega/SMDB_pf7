package com.pf7.smdb.domain;

import com.pf7.smdb.domain.BaseModel;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.helper.PersonRoleEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIE_PERSON_ROLES_SEQ", allocationSize = 1)
public class MoviePersonRoles extends BaseModel{

    @ManyToOne(targetEntity = TVShow.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private TVShow tvShow;

    @ManyToOne(targetEntity = Film.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Film film;

    @ManyToOne(targetEntity = Person.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Person person;

    @Enumerated(EnumType.STRING)
    private PersonRoleEnum personRoleEnum;
}
