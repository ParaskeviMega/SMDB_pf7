package com.pf7.smdb.service;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.domain.Show;

import java.util.List;

public interface PersonService extends BaseService<Person, Long> {

    Boolean existsPersonByPersonNameContains(String name);

    Person findPersonByPersonNameContains(String name);

    List<Person> findPeopleByPersonNameContains(String name);

    Person findPersonById(Long id);

    List<Person> findPeopleByPersonBorn(Integer born);

    List<Movie> findMoviesByPersonName(String name);

    List<Show> findShowsByPersonName(String name);
}

