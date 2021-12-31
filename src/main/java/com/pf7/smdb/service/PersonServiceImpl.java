package com.pf7.smdb.service;

import com.pf7.smdb.domain.Person;
import com.pf7.smdb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }


    @Override
    public Person findPersonById(Long id) {
        return personRepository.findPersonById(id);
    }

    @Override
    public Boolean existsPersonByName(String name) {
        return personRepository.existsPersonByName(name);
    }

}
