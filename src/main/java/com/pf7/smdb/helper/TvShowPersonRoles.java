package com.pf7.smdb.helper;


import com.pf7.smdb.domain.BaseModel;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.helper.PersonRoleEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "TVSHOW_PERSONROLES_SEQ", allocationSize = 1)
public class TvShowPersonRoles extends BaseModel {

    public TvShowPersonRoles(Person person, PersonRoleEnum personRoleEnum) {
        this.person = person;
        this.personRoleEnum = personRoleEnum;
    }

    @ManyToOne(targetEntity = Person.class,cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Person person;

    @Enumerated(EnumType.STRING)
    private PersonRoleEnum personRoleEnum;
}
