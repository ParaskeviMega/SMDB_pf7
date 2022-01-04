package com.pf7.smdb.helper;


import com.pf7.smdb.domain.BaseModel;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.helper.PersonRoleEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "FILM_PERSONROLES_SEQ", allocationSize = 1)
public class FilmPersonRoles extends BaseModel {

    public FilmPersonRoles(Person person, PersonRoleEnum personRoleEnum) {
        this.person = person;
        this.personRoleEnum = personRoleEnum;
    }

    @ManyToOne(targetEntity = Person.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Person person;

    @Enumerated(EnumType.STRING)
    private PersonRoleEnum personRoleEnum;
}