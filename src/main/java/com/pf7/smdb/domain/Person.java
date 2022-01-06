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
@Entity
@Table(name = "PEOPLE")
@SequenceGenerator(name = "idGenerator", sequenceName = "PEOPLE_SEQ", allocationSize = 1)
public class Person extends BaseModel {

    //NotNull(message = "Person Name cannot be null.")
    @Column(name = "personName",length = 100)
    private String personName;

    @Column(length = 4)
    private Integer personBorn;

}

