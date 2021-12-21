package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    //@Query(value = "select * from FILMS o, people c where o.people_id = c.id", nativeQuery = true)
    //Person findPersonById(Long id);
}
