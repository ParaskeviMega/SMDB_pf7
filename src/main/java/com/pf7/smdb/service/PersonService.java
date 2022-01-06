package com.pf7.smdb.service;

import com.pf7.smdb.domain.Person;

import java.util.List;

public interface PersonService extends BaseService<Person, Long> {

    Boolean existsPersonByPersonNameContains(String name);

    Person findPersonByPersonNameContains(String name);

    List<Person> findPeopleByPersonNameContains(String name);

    Person findPersonById(Long id);

    List<Person> findPeopleByPersonBorn(Integer born);
}

