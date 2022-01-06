package com.pf7.smdb.helper;

import com.pf7.smdb.domain.BaseModel;
import com.pf7.smdb.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIEPERSONROLES_SEQ", allocationSize = 1)
public class PersonRole extends BaseModel {

    @ManyToOne(optional = false,cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinColumn(name = "moviePersonId",referencedColumnName = "id")
    private Person PersonRolesPerson;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "personRole_persons",
//            joinColumns = @JoinColumn(name = "personRoleId",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "personId",referencedColumnName = "id")
//    )
//    private Set<Person> PersonRolesPerson;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> PersonRoles;

}
