package com.pf7.smdb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmPersonRolesKey implements Serializable {

    @Column(name = "film_Id")
    Long filmId;

    @Column(name = "person_id")
    Long personId;

    @Override
    public boolean equals(Object o) {
        if (o instanceof FilmPersonRolesKey) {
            FilmPersonRolesKey otherId = (FilmPersonRolesKey) o;
            return (otherId.filmId == this.filmId) && (otherId.personId == this.personId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int)(filmId + personId);
    }
}
