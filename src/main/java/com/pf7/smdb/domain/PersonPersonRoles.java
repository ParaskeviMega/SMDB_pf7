package com.pf7.smdb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class PersonPersonRoles {

    public PersonPersonRoles(Person person, PersonRole... personRoleList) {
        this.person = person;
        this.personRoleList = List.of(personRoleList);
    }

    private Person person;
    private List<PersonRole> personRoleList;
}
