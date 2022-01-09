package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Boolean existsPersonByPersonNameContains(String name);

    Person findPersonByPersonNameContains(String name);

    List<Person> findPeopleByPersonNameContains(String name);

    List<Person> findPeopleByPersonBorn(Integer born);
}
