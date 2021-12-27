package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person getPersonByNameAndAndSurname(String name, String surname);

    Set<Person> findPeopleByNameInAndSurnameIn(List<String> name,List<String> surname);

    Person findPersonById(Long id);
}
