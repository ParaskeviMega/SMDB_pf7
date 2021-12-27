package com.pf7.smdb.bootstrap;

import com.pf7.smdb.base.AbstractLogComponent;
import com.pf7.smdb.domain.*;
import com.pf7.smdb.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
//@Profile("base-content-creator")
@RequiredArgsConstructor
public class BaseContentCreatorRunner extends AbstractLogComponent implements CommandLineRunner {
    private final PersonService personService;
    private final FilmService filmService;
    private final TVShowService tvShowService;
    private final ContributionService contributionService;

    @Override
    public void run(String... args) {
        //@formatter:off



        List<Person> people = List.of(Person.builder().name("Manos").surname("Fragkiadakis").born("1993").build(),
                Person.builder().name("Dimitris").surname("Linarakis").born("1998").build(),
                Person.builder().name("Stathis").surname("Zaragkas").born("1998").build(),
                Person.builder().name("Vivi").surname("Mega").born("1994").build());

        personService.createAll(people);

        List<Film> filmsList = List.of(Film.builder()
                        .movie(Movie.builder().title("Resident Evil 10")
                                .year(2004)
                                .genre(Set.of(Genre.ROMANCE,Genre.COMEDY))
                                .people(personService.findPeopleByNameInAndSurnameIn(List.of("Manos"), List.of("Fragkiadakis")))
                                .rating(4.5f).build())
                        .build(),
                Film.builder()
                        .movie(Movie.builder().title("Spiderman : NoWay Home")
                                .year(2022)
                                .genre(Set.of(Genre.FANTASY,Genre.ACTION))
                                .people(personService.findPeopleByNameInAndSurnameIn(List.of("Vivi", "Dimitris"), List.of("Mega,Linarakis")))
                                .rating(2.5f).build())
                        .build(),
                Film.builder()
                        .movie(Movie.builder().title("Lord Of The Rings")
                                .year(2004)
                                .genre(Set.of(Genre.HORROR,Genre.ACTION))
                                .people(personService.findPeopleByNameInAndSurnameIn(List.of("Stathis"), List.of("Zaragkas")))
                                .rating(4.5f).build())
                        .build(),
                Film.builder()
                        .movie(Movie.builder().title("Harry Poter")
                                .year(2004)
                                .genre(Set.of(Genre.HORROR,Genre.ACTION))
                                .people(personService.findPeopleByNameInAndSurnameIn(List.of("Stathis"), List.of("Zaragkas")))
                                .rating(4.5f).build())
                        .build()
        );
        filmService.createAll(filmsList);

        List<Contribution> contributions = List.of(Contribution.builder()
                        .film(filmService.findFilmByMovieTitle("Resident Evil 10"))
                        .person(personService.findPersonById(1L))
                        .personRole(Set.of(PersonRole.ACTOR,PersonRole.WRITER)).build(),
                Contribution.builder()
                        .film(filmService.findFilmByMovieTitle("Resident Evil 10"))
                        .person(personService.findPersonById(2L))
                        .personRole(Set.of(PersonRole.DIRECTOR,PersonRole.WRITER)).build(),
                Contribution.builder()
                        .film(filmService.findFilmByMovieTitle("Spiderman : NoWay Home"))
                        .person(personService.findPersonById(3L))
                        .personRole(Set.of(PersonRole.ACTOR,PersonRole.DIRECTOR)).build(),
                Contribution.builder()
                        .film(filmService.findFilmByMovieTitle("Spiderman : NoWay Home"))
                        .person(personService.findPersonById(2L))
                        .personRole(Set.of(PersonRole.PRODUCER,PersonRole.WRITER)).build(),
                Contribution.builder()
                        .film(filmService.findFilmByMovieTitle("Lord Of The Rings"))
                        .person(personService.findPersonById(4L))
                        .personRole(Set.of(PersonRole.MANAGER,PersonRole.WRITER)).build(),
                Contribution.builder()
                        .film(filmService.findFilmByMovieTitle("Harry Poter"))
                        .person(personService.findPersonById(4L))
                        .personRole(Set.of(PersonRole.ACTOR,PersonRole.WRITER)).build()
                );


        contributionService.createAll(contributions);

//        genreService.findAll().forEach(genre -> logger.info("Everything {}", genre));
//        logger.info("\n");
//        actorService.findAll().forEach(actor -> logger.info("Everything {}", actor));
//        logger.info("\n");
//        movieService.findAll().forEach(movie -> logger.info("Everything {}", movie));
//        logger.info("\n");
//        logger.info("\n");
//        movieService.findAll().forEach(movie -> movie.getGenre()
//                .forEach(genre -> logger.info("Genre : {}", genre.getGenreEnum().toString())));

    }
}
