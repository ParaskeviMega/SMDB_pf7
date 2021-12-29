package com.pf7.smdb.service;

import com.pf7.smdb.domain.Person;

import java.util.List;
import java.util.Set;

public interface PersonService extends BaseService<Person, Long> {
    Person getPersonByNameAndAndSurname(String name, String surname);

    Set<Person> findPeopleByNameInAndSurnameIn(List<String> name, List<String> surname);

    Person findPersonById(Long id);
}
