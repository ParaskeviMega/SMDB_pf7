package com.pf7.smdb.domain;
import com.pf7.smdb.helper.PersonRoleEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "PEOPLE")
@SequenceGenerator(name = "idGenerator", sequenceName = "PEOPLE_SEQ", allocationSize = 1)
public class Person extends BaseModel {

    //@NotNull(message = "First Name cannot be null.")
    @Column(length = 100)
    private String name;

    //@NotNull(message = "Born cannot be null.")
    @Column(length = 4)
    private Integer born;
}

