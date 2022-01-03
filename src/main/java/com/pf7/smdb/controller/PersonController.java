package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Person;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.FilmService;
import com.pf7.smdb.service.PersonService;
import com.pf7.smdb.service.TVShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class PersonController extends AbstractController<Person> {
    private final PersonService personService;
    private final TVShowService tvShowService;
    private final FilmService filmService;

    @Override
    protected BaseService<Person, Long> getBaseService() {
        return personService;
    }

    @GetMapping(path = "/person", params = {"id"})
    public Person getPersonById(@RequestParam("id") Long id) {
        return personService.findPersonById(id);
    }

    @GetMapping(path = "/person", params = {"name"})
    public Person getPersonByName(@RequestParam("name") String name) {
        return personService.findPersonByName(name);
    }

//    @GetMapping(path = "/person", params = {"name"})
//    public Person getFilmsAndTvShowByName(@RequestParam("name") String name) {
//        return null;
//    }

//    @GetMapping(path = "films_version",headers = "action=findAllFilmsByActorName")
//    public ResponseEntity<ApiResponse<String, List<Film>>> findAllFilmsByActorName() {
//        return ResponseEntity.ok(ApiResponse.<List<String, Film>>builder()
//                .data(filmService.findAllFilmsByActorName())
//                .build());
//    }
//
//    @GetMapping(path = "tvshows_version",headers = "action=findAllTvShowsByActorName")
//    public ResponseEntity<ApiResponse<List<KeyValue<String, TVShow>>>> findAllTvShowsByActorName() {
//        return ResponseEntity.ok(ApiResponse.<List<String, TVShow>>builder()
//                .data(tvShowService.findAllTvShowsByActorName())
//                .build());
}

