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
    public Person getPersonByNameAndAndSurname(String name, String surname) {
        return personRepository.getPersonByNameAndAndSurname(name, surname);
    }

    @Override
    public Set<Person> findPeopleByNameInAndSurnameIn(List<String> name, List<String> surname) {
        return personRepository.findPeopleByNameInAndSurnameIn(name, surname);
    }

    @Override
    public Person findPersonById(Long id) {
        return personRepository.findPersonById(id);
    }

}
