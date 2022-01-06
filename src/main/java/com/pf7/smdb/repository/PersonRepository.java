package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


    Boolean existsPersonByPersonNameContains(String name);

    Person findPersonByPersonNameContains(String name);


//    Person findPersonById(Long id);
//
//    Boolean existsPersonByName(String name);
//
//    Person findPersonByName(String name);

    //Person findPersonByNameAndBorn();
}
