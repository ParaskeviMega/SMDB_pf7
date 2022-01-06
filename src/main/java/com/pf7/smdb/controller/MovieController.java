package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController extends AbstractController<Movie> {
    private final MovieService movieService;

    @Override
    protected BaseService<Movie, Long> getBaseService() {
        return movieService;
    }

    @GetMapping(params = {"title"})
    public Movie getByMovieTitle(@RequestParam("title") String title) {
        return movieService.findMovieByMovieTitle(title);
    }

    @GetMapping(params = {"year"})
    public List<Movie> getMoviesByYear(@RequestParam("year") Integer year) {
        return movieService.findMoviesByMovieYear(year);
    }

    @GetMapping(params = {"genre"})
    public List<Movie> getMoviesByGenre(@RequestParam("genre") String genre) {
        return movieService.findMoviesByMovieGenreEquals(genre);
    }

    @GetMapping(params = {"rating"})
    public List<Movie> getMoviesByRating(@RequestParam("rating") String rating) {
        return movieService.findMoviesByMovieRatingStartsWith(rating);
    }
}
