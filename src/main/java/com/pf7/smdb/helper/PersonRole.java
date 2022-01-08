package com.pf7.smdb.helper;

import com.pf7.smdb.domain.BaseModel;
import com.pf7.smdb.domain.Person;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIEPERSONROLES_SEQ", allocationSize = 1)
public class PersonRole extends BaseModel {

    @ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "moviePersonId",referencedColumnName = "id")
    private Person personRolesPerson;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "personRole_persons",
//            joinColumns = @JoinColumn(name = "personRoleId",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "personId",referencedColumnName = "id")
//    )
//    private Set<Person> PersonRolesPerson;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> personRoles;

}
