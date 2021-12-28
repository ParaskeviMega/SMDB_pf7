package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.helper.PersonPersonRoles;

import java.util.List;
import java.util.Set;

public interface FilmService extends BaseService<Film, Long>{
    Film findFilmByMovieTitle(String title);

    Person findPersonById(Long id);

    Person findPersonBySurname(String surname);

    Set<Person> overridePersonRoles(List<PersonPersonRoles>  personPersonRoles);
}
