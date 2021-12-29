package com.pf7.smdb.bootstrap;

import com.pf7.smdb.base.AbstractLogComponent;
import com.pf7.smdb.domain.*;
import com.pf7.smdb.helper.GenreEnum;
import com.pf7.smdb.helper.PersonPersonRoles;
import com.pf7.smdb.helper.PersonRoleEnum;
import com.pf7.smdb.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
//@Profile("base-content-creator")
@RequiredArgsConstructor
public class BaseContentCreatorRunner extends AbstractLogComponent implements CommandLineRunner {
    private final PersonService personService;
    private final FilmService filmService;
    private final TVShowService tvShowService;

    @Override
    public void run(String... args) {
        //@formatter:off


        List<Person> people = List.of(Person.builder().name("Manos").surname("Fragkiadakis").born("1993").generalRoles(Set.of(PersonRoleEnum.MANAGER)).build(),
                Person.builder().name("Dimitris").surname("Linarakis").born("1998").generalRoles(Set.of(PersonRoleEnum.PRODUCER)).build(),
                Person.builder().name("Stathis").surname("Zaragkas").born("1998").generalRoles(Set.of(PersonRoleEnum.ACTOR)).build(),
                Person.builder().name("Vivi").surname("Mega").born("1995").generalRoles(Set.of(PersonRoleEnum.MANAGER)).build());

        personService.createAll(people);


        List<PersonPersonRoles> personRolesList = List.of(
                PersonPersonRoles.builder().person(filmService.findPersonBySurname("Fragkiadakis")).personRoleList(Set.of(PersonRoleEnum.MANAGER, PersonRoleEnum.ACTOR)).build(),
                PersonPersonRoles.builder().person(filmService.findPersonBySurname("Linarakis")).personRoleList(Set.of(PersonRoleEnum.MANAGER, PersonRoleEnum.ACTOR)).build(),
                PersonPersonRoles.builder().person(filmService.findPersonBySurname("Zaragkas")).personRoleList(Set.of(PersonRoleEnum.MANAGER, PersonRoleEnum.ACTOR)).build());

        List<PersonPersonRoles> personRolesList2 = List.of(
                PersonPersonRoles.builder().person(filmService.findPersonBySurname("Fragkiadakis")).personRoleList(Set.of(PersonRoleEnum.MANAGER, PersonRoleEnum.ACTOR)).build(),
                PersonPersonRoles.builder().person(filmService.findPersonBySurname("Linarakis")).personRoleList(Set.of(PersonRoleEnum.MANAGER, PersonRoleEnum.ACTOR)).build());

        List<PersonPersonRoles> personRolesList3 = List.of(
                PersonPersonRoles.builder().person(filmService.findPersonBySurname("Linarakis")).personRoleList(Set.of(PersonRoleEnum.MANAGER, PersonRoleEnum.ACTOR)).build(),
                PersonPersonRoles.builder().person(filmService.findPersonBySurname("Zaragkas")).personRoleList(Set.of(PersonRoleEnum.MANAGER, PersonRoleEnum.ACTOR)).build());

        List<PersonPersonRoles> personRolesList4 = List.of(
                PersonPersonRoles.builder().person(filmService.findPersonBySurname("Zaragkas")).personRoleList(Set.of(PersonRoleEnum.MANAGER, PersonRoleEnum.ACTOR)).build(),
                PersonPersonRoles.builder().person(filmService.findPersonBySurname("Mega")).personRoleList(Set.of(PersonRoleEnum.PRODUCER, PersonRoleEnum.ACTOR)).build());


        List<Film> filmsList = List.of(Film.builder()
                        .movie(Movie.builder().title("Resident Evil 10")
                                .year(2004)
                                .genre(Set.of(GenreEnum.ROMANCE, GenreEnum.COMEDY))
                                .people(filmService.overridePersonRoles(personRolesList))
                                .rating(4.5f).build())
                        .build(),
                Film.builder()
                        .movie(Movie.builder().title("Spiderman : NoWay Home")
                                .year(2022)
                                .genre(Set.of(GenreEnum.FANTASY, GenreEnum.ACTION))
                                .people(filmService.overridePersonRoles(personRolesList2))
                                .rating(2.5f).build())
                        .build(),
                Film.builder()
                        .movie(Movie.builder().title("Lord Of The Rings")
                                .year(2004)
                                .genre(Set.of(GenreEnum.HORROR, GenreEnum.ACTION))
                                .people(filmService.overridePersonRoles(personRolesList3))
                                .rating(4.5f).build())
                        .build(),
                Film.builder()
                        .movie(Movie.builder().title("Harry Poter")
                                .year(2004)
                                .genre(Set.of(GenreEnum.HORROR, GenreEnum.ACTION))
                                .people(filmService.overridePersonRoles(personRolesList4))
                                .rating(4.5f).build())
                        .build()
        );
        filmService.createAll(filmsList);


        filmService.findFilmByMovieTitle("Harry Poter").getMovie().getPeople().forEach(person -> logger.info("{}",person.getGeneralRoles()));
        logger.info("\n Test \n");
        filmService.findFilmByMovieTitle("Harry Poter").getMovie().getPeople().forEach(person -> logger.info("{}",person.getMovieRoles()));

        logger.info("TESTTTTTTTTTTTTT : {}",filmService.findFilmByMovieTitle("Harry Poter"));
    }
}
