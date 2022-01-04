package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmController extends AbstractController<Film> {
    private final FilmService filmService;

    @Override
    protected BaseService<Film, Long> getBaseService() {
        return filmService;
    }

    @GetMapping(path = "/movie", params = {"title"})
    public Film getByFilmTitle(@RequestParam("title") String title) {
        return filmService.findFilmByTitleLike(title);
    }

//    @GetMapping(path = "/findFilms", params = {"actor","role"})
//    public List<Film> getByActor(@RequestParam("actor") String actor, @RequestParam("role") String role) {
//        return filmService.findFilmsByPersonNameAndRole(actor,role);
//    }
}
