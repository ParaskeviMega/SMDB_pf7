package com.pf7.smdb.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.EnumSet;
import java.util.Set;

@Data
@Entity
public class Association extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "tvshow_id")
    private TVShow tvShow;

    @Column(name="roles")
    @ElementCollection
    private Set<PersonRole> personRoles;
}