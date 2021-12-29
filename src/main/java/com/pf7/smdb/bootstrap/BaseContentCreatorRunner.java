package com.pf7.smdb.bootstrap;

import com.pf7.smdb.base.AbstractLogComponent;
import com.pf7.smdb.domain.*;
import com.pf7.smdb.helper.GenreEnum;
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


        List<Person> people = List.of(Person.builder().name("Manos").surname("Fragkiadakis").born("1993").generalRoles(Set.of(PersonRoleEnum.ACTOR,PersonRoleEnum.PRODUCER)).build(),
                Person.builder().name("Dimitris").surname("Linarakis").born("1998").generalRoles(Set.of(PersonRoleEnum.DIRECTOR,PersonRoleEnum.PRODUCER)).build(),
                Person.builder().name("Stathis").surname("Zaragkas").born("1998").generalRoles(Set.of(PersonRoleEnum.MANAGER,PersonRoleEnum.WRITER)).build(),
                Person.builder().name("Vivi").surname("Mega").born("1995").generalRoles(Set.of(PersonRoleEnum.WRITER,PersonRoleEnum.ACTOR)).build());

        personService.createAll(people);


        //Films Insert
        List<Film> filmList = List.of(Film.builder()
                        .movie(Movie.builder().title("Resident Evil 10")
                                .year(2004)
                                .genre(Set.of(GenreEnum.ROMANCE, GenreEnum.COMEDY))
                                .people(Set.of(personService.findPersonById(4L),personService.findPersonById(2L)))
                                .rating(4.5f).build())
                        .build(),
                Film.builder()
                        .movie(Movie.builder().title("Spiderman : NoWay Home")
                                .year(2022)
                                .genre(Set.of(GenreEnum.FANTASY, GenreEnum.ACTION))
                                .people(Set.of(personService.findPersonById(3L),personService.findPersonById(1L)))
                                .rating(2.5f).build())
                        .build(),
                Film.builder()
                        .movie(Movie.builder().title("Lord Of The Rings")
                                .year(2004)
                                .genre(Set.of(GenreEnum.HORROR, GenreEnum.ACTION))
                                .people(Set.of(personService.findPersonById(2L),personService.findPersonById(4L)))
                                .rating(4.5f).build())
                        .build(),
                Film.builder()
                        .movie(Movie.builder().title("Harry Poter")
                                .year(2004)
                                .genre(Set.of(GenreEnum.HORROR, GenreEnum.ACTION))
                                .people(Set.of(personService.findPersonById(3L),personService.findPersonById(1L)))
                                .rating(4.5f).build())
                        .build()
        );

        Set<MoviePersonRoles> moviePersonRoles = Set.of(
                MoviePersonRoles.builder().film(filmList.get(0)).person(people.get((0))).personRoleEnum(PersonRoleEnum.ACTOR).build(),
                MoviePersonRoles.builder().film(filmList.get(0)).person(people.get((1))).personRoleEnum(PersonRoleEnum.MANAGER).build(),
                MoviePersonRoles.builder().film(filmList.get(0)).person(people.get((2))).personRoleEnum(PersonRoleEnum.PRODUCER).build(),
                MoviePersonRoles.builder().film(filmList.get(0)).person(people.get((3))).personRoleEnum(PersonRoleEnum.WRITER).build(),
                MoviePersonRoles.builder().film(filmList.get(1)).person(people.get((3))).personRoleEnum(PersonRoleEnum.MANAGER).build(),
                MoviePersonRoles.builder().film(filmList.get(1)).person(people.get((3))).personRoleEnum(PersonRoleEnum.DIRECTOR).build(),
                MoviePersonRoles.builder().film(filmList.get(2)).person(people.get((1))).personRoleEnum(PersonRoleEnum.MANAGER).build(),
                MoviePersonRoles.builder().film(filmList.get(3)).person(people.get((2))).personRoleEnum(PersonRoleEnum.MANAGER).build(),
                MoviePersonRoles.builder().film(filmList.get(3)).person(people.get((0))).personRoleEnum(PersonRoleEnum.ACTOR).build(),
                MoviePersonRoles.builder().film(filmList.get(3)).person(people.get((3))).personRoleEnum(PersonRoleEnum.WRITER).build(),
                MoviePersonRoles.builder().film(filmList.get(3)).person(people.get((2))).personRoleEnum(PersonRoleEnum.DIRECTOR).build(),
                MoviePersonRoles.builder().film(filmList.get(3)).person(people.get((2))).personRoleEnum(PersonRoleEnum.PRODUCER).build());

        filmService.UpdateFilmsAndContributions(new HashSet<>(filmList),moviePersonRoles);


        //TVShow Insert
        List<TVShow> tvShowList = List.of(TVShow.builder()
                        .movie(Movie.builder().title("Friends")
                                .year(2004)
                                .genre(Set.of(GenreEnum.ROMANCE, GenreEnum.COMEDY))
                                .people(Set.of(personService.findPersonById(4L),personService.findPersonById(2L)))
                                .rating(4.5f).build())
                        .episodes(Set.of(new Episode("Friends Episode 1",1),new Episode("Friends Episode 2",2)))
                        .tvShowPersonRoles(Set.of(new TvShowPersonRoles(people.get(0),PersonRoleEnum.ACTOR)))
                        .build(),
                TVShow.builder()
                        .movie(Movie.builder().title("Titans")
                                .year(2022)
                                .genre(Set.of(GenreEnum.FANTASY, GenreEnum.ACTION))
                                .people(Set.of(personService.findPersonById(3L),personService.findPersonById(1L)))
                                .rating(2.5f).build())
                        .episodes(Set.of(new Episode("Titans Episode 1",1),new Episode("Titans Episode 2",2)))
                        .tvShowPersonRoles(Set.of(new TvShowPersonRoles(people.get(1),PersonRoleEnum.MANAGER),new TvShowPersonRoles(people.get(1),PersonRoleEnum.PRODUCER)))
                        .build(),
                TVShow.builder()
                        .movie(Movie.builder().title("Punisher")
                                .year(2004)
                                .genre(Set.of(GenreEnum.HORROR, GenreEnum.ACTION))
                                .people(Set.of(personService.findPersonById(2L),personService.findPersonById(4L)))
                                .rating(4.5f).build())
                        .episodes(Set.of(new Episode("Punisher Episode 1",1),new Episode("Punisher Episode 2",2)))
                        .tvShowPersonRoles(Set.of(new TvShowPersonRoles(people.get(2),PersonRoleEnum.ACTOR),new TvShowPersonRoles(people.get(2),PersonRoleEnum.WRITER)))
                        .build(),
                TVShow.builder()
                        .movie(Movie.builder().title("Flash")
                                .year(2004)
                                .genre(Set.of(GenreEnum.HORROR, GenreEnum.ACTION))
                                .people(Set.of(personService.findPersonById(3L),personService.findPersonById(1L)))
                                .rating(4.5f).build())
                        .episodes(Set.of(new Episode("Flash Episode 1",1),new Episode("Flash Episode 2",2)))
                        .tvShowPersonRoles(Set.of(new TvShowPersonRoles(people.get(3),PersonRoleEnum.WRITER)))
                        .build()
        );

        tvShowService.createAll(tvShowList);
        tvShowService.delete(tvShowList.get(3));

//        Set<MoviePersonRoles> moviePersonRoles1 = Set.of(
//                MoviePersonRoles.builder().tvShow(tvShowList.get(0)).person(people.get((0))).personRoleEnum(PersonRoleEnum.ACTOR).build(),
//                MoviePersonRoles.builder().tvShow(tvShowList.get(0)).person(people.get((1))).personRoleEnum(PersonRoleEnum.MANAGER).build(),
//                MoviePersonRoles.builder().tvShow(tvShowList.get(0)).person(people.get((2))).personRoleEnum(PersonRoleEnum.PRODUCER).build(),
//                MoviePersonRoles.builder().tvShow(tvShowList.get(0)).person(people.get((3))).personRoleEnum(PersonRoleEnum.WRITER).build(),
//                MoviePersonRoles.builder().tvShow(tvShowList.get(1)).person(people.get((2))).personRoleEnum(PersonRoleEnum.MANAGER).build(),
//                MoviePersonRoles.builder().tvShow(tvShowList.get(1)).person(people.get((3))).personRoleEnum(PersonRoleEnum.DIRECTOR).build(),
//                MoviePersonRoles.builder().tvShow(tvShowList.get(2)).person(people.get((1))).personRoleEnum(PersonRoleEnum.MANAGER).build(),
//                MoviePersonRoles.builder().tvShow(tvShowList.get(2)).person(people.get((2))).personRoleEnum(PersonRoleEnum.MANAGER).build(),
//                MoviePersonRoles.builder().tvShow(tvShowList.get(3)).person(people.get((0))).personRoleEnum(PersonRoleEnum.ACTOR).build(),
//                MoviePersonRoles.builder().tvShow(tvShowList.get(3)).person(people.get((3))).personRoleEnum(PersonRoleEnum.WRITER).build(),
//                MoviePersonRoles.builder().tvShow(tvShowList.get(3)).person(people.get((2))).personRoleEnum(PersonRoleEnum.DIRECTOR).build(),
//                MoviePersonRoles.builder().tvShow(tvShowList.get(3)).person(people.get((2))).personRoleEnum(PersonRoleEnum.PRODUCER).build());

        //tvShowService.UpdateFilmsAndContributions(new HashSet<>(tvShowList),moviePersonRoles1);
        //tvShowService.delete(tvShowList.get(3));
    }
}
