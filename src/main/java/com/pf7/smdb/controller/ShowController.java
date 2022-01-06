package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Show;
import com.pf7.smdb.domain.Show;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/show")
public class ShowController extends AbstractController<Show>{
    private  final ShowService showService;

    @Override
    protected BaseService<Show, Long> getBaseService() {
        return showService;
    }

    @GetMapping(params = {"title"})
    public Show getByShowTitle(@RequestParam("title") String title) {
        return showService.findShowByShowTitle(title);
    }

    @GetMapping(params = {"year"})
    public List<Show> getShowsByYear(@RequestParam("year") Integer year) {
        return showService.findShowsByShowYear(year);
    }

    @GetMapping(params = {"genre"})
    public List<Show> getShowsByGenre(@RequestParam("genre") String genre) {
        return showService.findShowsByShowGenreEquals(genre);
    }

    @GetMapping(params = {"rating"})
    public List<Show> getShowsByRating(@RequestParam("rating") String rating) {
        return showService.findShowsByShowRatingStartsWith(rating);
    }

    @GetMapping(params = {"numberOfEpisodes"})
    public List<Show> getShowsByNumberOfEpisodes(@RequestParam("numberOfEpisodes") Integer episodes) {
        return showService.findShowByShowEpisodesEquals(episodes);
    }

    @GetMapping(params = {"numberOfSeasons"})
    public List<Show> getShowsByNumberOfSeasons(@RequestParam("numberOfSeasons") Integer seasons) {
        return showService.findShowByShowSeasonsEquals(seasons);
    }
}
