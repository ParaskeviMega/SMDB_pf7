package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findPersonById(Long id);

    Boolean existsPersonByName(String name);

    Person findPersonByName(String name);

    //Person findPersonByNameAndBorn();
}
