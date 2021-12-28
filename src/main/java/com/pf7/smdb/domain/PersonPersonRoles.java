package com.pf7.smdb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class PersonPersonRoles {

    private Person person;
    private List<PersonRole> personRoleList;

    public PersonPersonRoles(Person person, List<PersonRole> personRoleList) {
        this.person = person;
        this.personRoleList = personRoleList;
    }

}
