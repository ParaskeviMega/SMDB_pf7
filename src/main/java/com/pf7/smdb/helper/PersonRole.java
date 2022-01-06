package com.pf7.smdb.helper;

import com.pf7.smdb.domain.BaseModel;
import com.pf7.smdb.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIEPERSONROLES_SEQ", allocationSize = 1)
public class PersonRole extends BaseModel {

    @ManyToOne(optional = false,cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "moviePersonId",referencedColumnName = "id")
    private Person PersonRolesPerson;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> PersonRoles;

}
