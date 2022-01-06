package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search/person/by/")
public class PersonController extends AbstractController<Person> {
    private final PersonService personService;

    @Override
    protected BaseService<Person, Long> getBaseService() {
        return personService;
    }


    @GetMapping(params = {"id"})
    public Person getPersonById(@RequestParam("id") Long id) {
        return personService.findPersonById(id);
    }

    @GetMapping(params = {"name"})
    public Person getPersonByName(@RequestParam("year") String name) {
        return personService.findPersonByPersonNameContains(name);
    }

    @GetMapping(params = {"born"})
    public List<Person> getPeopleByBorn(@RequestParam("year") Integer born) {
        return personService.findPeopleByPersonBorn(born);
    }

}

