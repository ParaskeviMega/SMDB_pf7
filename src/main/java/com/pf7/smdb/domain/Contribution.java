package com.pf7.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Embeddable
@SequenceGenerator(name = "idGenerator", sequenceName = "CONTRIBUTIONS_SEQ", allocationSize = 1)
public class Contribution extends BaseModel{

    @ManyToOne
    private Person person;

    @ManyToOne
    private Film film;

    @ManyToOne
    private TVShow tvShow;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<PersonRole> personRole;
}