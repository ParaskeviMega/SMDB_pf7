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

//        List<Person> people = List.of(Person.builder().name("Manos").surname("Fragkiadakis").born("1993").build(),
//                Person.builder().name("Dimitris").surname("Linarakis").born("1998").build(),
//                Person.builder().name("Stathis").surname("Zaragkas").born("1998").build(),
//                Person.builder().name("Vivi").surname("Mega").born("1995").build());
//
//        personService.createAll(people);
//
//
//        //Films Insert
//        List<Film> filmList = List.of(Film.builder()
//                        .movie(Movie.builder().title("Resident Evil 10")
//                                .year(2004)
//                                .genre(Set.of(GenreEnum.ROMANCE, GenreEnum.COMEDY))
//                                .rating(4.5f).build())
//                        .filmPersonRoles(Set.of(new FilmPersonRoles(people.get(3),PersonRoleEnum.ACTOR),new FilmPersonRoles(people.get(2),PersonRoleEnum.ACTOR)))
//                        .build(),
//                Film.builder()
//                        .movie(Movie.builder().title("Spiderman : NoWay Home")
//                                .year(2022)
//                                .genre(Set.of(GenreEnum.FANTASY, GenreEnum.ACTION))
//                                .rating(2.5f).build())
//                        .filmPersonRoles(Set.of(new FilmPersonRoles(people.get(1),PersonRoleEnum.ACTOR),new FilmPersonRoles(people.get(2),PersonRoleEnum.ACTOR)))
//                        .build(),
//                Film.builder()
//                        .movie(Movie.builder().title("Lord Of The Rings")
//                                .year(2004)
//                                .genre(Set.of(GenreEnum.HORROR, GenreEnum.ACTION))
//                                .rating(4.5f).build())
//                        .filmPersonRoles(Set.of(new FilmPersonRoles(people.get(1),PersonRoleEnum.ACTOR),new FilmPersonRoles(people.get(2),PersonRoleEnum.ACTOR)))
//                        .build(),
//                Film.builder()
//                        .movie(Movie.builder().title("Harry Poter")
//                                .year(2004)
//                                .genre(Set.of(GenreEnum.HORROR, GenreEnum.ACTION))
//                                .rating(4.5f).build())
//                        .filmPersonRoles(Set.of(new FilmPersonRoles(people.get(3),PersonRoleEnum.ACTOR),new FilmPersonRoles(people.get(2),PersonRoleEnum.ACTOR)))
//                        .build()
//        );
//
//        filmService.createAll(filmList);
//
//
//        //TVShow Insert
//        List<TVShow> tvShowList = List.of(TVShow.builder()
//                        .movie(Movie.builder().title("Friends")
//                                .year(2004)
//                                .genre(Set.of(GenreEnum.ROMANCE, GenreEnum.COMEDY))
//                                .rating(4.5f).build())
//                        .episodes(Set.of(new Episode("Friends Episode 1",1),new Episode("Friends Episode 2",2)))
//                        .tvShowPersonRoles(Set.of(new TvShowPersonRoles(people.get(3),PersonRoleEnum.MANAGER),new TvShowPersonRoles(people.get(1),PersonRoleEnum.PRODUCER)))
//                        .build(),
//                TVShow.builder()
//                        .movie(Movie.builder().title("Titans")
//                                .year(2022)
//                                .genre(Set.of(GenreEnum.FANTASY, GenreEnum.ACTION))
//                                .rating(2.5f).build())
//                        .episodes(Set.of(new Episode("Titans Episode 1",1),new Episode("Titans Episode 2",2)))
//                        .tvShowPersonRoles(Set.of(new TvShowPersonRoles(people.get(2),PersonRoleEnum.MANAGER),new TvShowPersonRoles(people.get(3),PersonRoleEnum.PRODUCER)))
//                        .build(),
//                TVShow.builder()
//                        .movie(Movie.builder().title("Punisher")
//                                .year(2004)
//                                .genre(Set.of(GenreEnum.HORROR, GenreEnum.ACTION))
//                                .rating(4.5f).build())
//                        .episodes(Set.of(new Episode("Punisher Episode 1",1),new Episode("Punisher Episode 2",2)))
//                        .tvShowPersonRoles(Set.of(new TvShowPersonRoles(people.get(2),PersonRoleEnum.ACTOR),new TvShowPersonRoles(people.get(1),PersonRoleEnum.WRITER)))
//                        .build(),
//                TVShow.builder()
//                        .movie(Movie.builder().title("Flash")
//                                .year(2004)
//                                .genre(Set.of(GenreEnum.HORROR, GenreEnum.ACTION))
//                                .rating(4.5f).build())
//                        .episodes(Set.of(new Episode("Flash Episode 1",1),new Episode("Flash Episode 2",2)))
//                        .tvShowPersonRoles(Set.of(new TvShowPersonRoles(people.get(0),PersonRoleEnum.WRITER)))
//                        .build()
//        );
//
//        tvShowService.createAll(tvShowList);
//
//
//        filmList.forEach(film -> film.getFilmPersonRoles().forEach(filmPersonRoles ->
//                logger.info("Film : {} , Person : {}, Role : {}",film.getMovie().getTitle(),
//                        filmPersonRoles.getPerson().getSurname(),
//                        filmPersonRoles.getPersonRoleEnum().toString())));
//
//
//        tvShowList.forEach(tvShow -> tvShow.getTvShowPersonRoles().forEach(tvShowPersonRoles ->
//                logger.info("TvShow : {} , Person : {}, Role : {}",tvShow.getMovie().getTitle(),
//                        tvShowPersonRoles.getPerson().getSurname(),
//                        tvShowPersonRoles.getPersonRoleEnum().toString())));

    }
}

