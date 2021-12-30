package com.pf7.smdb.helper;

import com.pf7.smdb.domain.Person;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PersonPersonRoles {

    private Person person;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PersonRoleEnum> personRoleList = new HashSet<>();

}
