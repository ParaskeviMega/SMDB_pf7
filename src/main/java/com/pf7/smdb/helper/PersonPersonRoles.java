package com.pf7.smdb.helper;

import com.pf7.smdb.domain.Person;
import com.pf7.smdb.domain.PersonRole;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PersonPersonRoles {

    private Person person;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<PersonRole> personRoleList;

}
