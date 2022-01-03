package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.Person;

import java.util.List;
import java.util.Set;

public interface PersonService extends BaseService<Person, Long> {

    Person findPersonById(Long id);

    Boolean existsPersonByName(String name);

    Person findPersonByName(String name);

    List<Film> findFilmsByPersonName(String name);
}
