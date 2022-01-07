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
@RequestMapping("/search/person")
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

//    @GetMapping(params = {"name"})
//    public Person getPersonByName(@RequestParam("name") String name) {
//        return personService.findPersonByPersonNameContains(name);
//    }

    @GetMapping(params = {"name"})
    public List<Person> getPeopleByName(@RequestParam("name") String name) {
        return personService.findPeopleByPersonNameContains(name);
    }

    @GetMapping(params = {"born"})
    public List<Person> getPeopleByBorn(@RequestParam("born") Integer born) {
        return personService.findPeopleByPersonBorn(born);
    }

}

