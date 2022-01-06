package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController extends AbstractController<Movie> {
    private final MovieService movieService;

    @Override
    protected BaseService<Movie, Long> getBaseService() {
        return movieService;
    }

//    @GetMapping(path = "/movie", params = {"title"})
//    public Movie getByFilmTitle(@RequestParam("title") String title) {
//        return movieService.findFilmByTitleLike(title);
//    }

//    @GetMapping(path = "/findFilms", params = {"actor","role"})
//    public List<Film> getByActor(@RequestParam("actor") String actor, @RequestParam("role") String role) {
//        return filmService.findFilmsByPersonNameAndRole(actor,role);
//    }
}
