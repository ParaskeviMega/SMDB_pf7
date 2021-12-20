package com.pf7.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "People",indexes = {@Index(columnList = "personRoles")})
@SequenceGenerator(name = "idGenerator", sequenceName = "PEOPLE_SEQ", initialValue = 1, allocationSize = 1)
public class Person extends BaseModel{

    @NotNull(message = "First Name cannot be null.")
    @Column(length = 20,nullable = false)
    private String name;

    @NotNull(message = "Surname cannot be null.")
    @Column(length = 20,nullable = false)
    private String surname;

    @Column
    private String bio;

    @NotNull(message = "Born cannot be null.")
    @Column(length = 50,nullable = false)
    private String born;

    @NotNull
    @ElementCollection
    private Set<PersonRole> personRoles;
}

