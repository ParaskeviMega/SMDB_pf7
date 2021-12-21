package com.pf7.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity()
@SequenceGenerator(name = "idGenerator", sequenceName = "PEOPLE_SEQ", allocationSize = 1)
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

    @NotNull(message = "Role cannot be null.")
    @Column(length = 50,nullable = false)
    private String personRole;   //Set Collection ??????
}

