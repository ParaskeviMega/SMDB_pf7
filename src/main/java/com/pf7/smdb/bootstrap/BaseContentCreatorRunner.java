package com.pf7.smdb.bootstrap;

import com.pf7.smdb.base.AbstractLogComponent;
import com.pf7.smdb.domain.*;
import com.pf7.smdb.service.MovieService;
import com.pf7.smdb.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
//@Profile("base-content-creator")
@RequiredArgsConstructor
public class BaseContentCreatorRunner extends AbstractLogComponent implements CommandLineRunner {
    private final MovieService movieService;
    private final ShowService showService;

    @Override
    public void run(String... args) {
        //@formatter:off

        //Parsing Films From Tmdb
        movieService.parseAndCreateMovieFromTmdbApi();
        showService.parseAndCreateShowFromTmdbApi();
    }
}

