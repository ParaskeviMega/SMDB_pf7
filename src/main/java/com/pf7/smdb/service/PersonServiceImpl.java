package com.pf7.smdb.service;

import com.pf7.smdb.domain.Person;
import com.pf7.smdb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    @Override
    public Boolean existsPersonByPersonNameContains(String name) {
        return personRepository.existsPersonByPersonNameContains(name);
    }

    @Override
    public Person findPersonByPersonNameContains(String name) {
        return personRepository.findPersonByPersonNameContains(name);
    }

    @Override
    public List<Person> findPeopleByPersonNameContains(String name) {
        return personRepository.findPeopleByPersonNameContains(name);
    }

    @Override
    public Person findPersonById(Long id) {
        return personRepository.findPersonById(id);
    }

    @Override
    public List<Person> findPeopleByPersonBorn(Integer born) {
        return personRepository.findPeopleByPersonBorn(born);
    }
}
