package com.pf7.smdb.bootstrap;

import com.pf7.smdb.base.AbstractLogComponent;
import com.pf7.smdb.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//@Profile("base-content-creator")
@RequiredArgsConstructor
public class BaseContentCreatorRunner extends AbstractLogComponent implements CommandLineRunner {
    private final FilmService filmService;
    private final TVShowService tvShowService;

    @Override
    public void run(String... args) {
        //@formatter:off

        //Parsing Films From Tmdb
        filmService.parseAndCreateFilmsFromTmdbApi();
        tvShowService.parseAndCreateTvShowFromTmdbApi();
    }
}

