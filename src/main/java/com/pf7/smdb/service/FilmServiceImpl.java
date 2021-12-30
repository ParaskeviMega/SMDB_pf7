package com.pf7.smdb.service;

import com.pf7.smdb.domain.*;
import com.pf7.smdb.helper.*;
import com.pf7.smdb.repository.FilmRepository;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.PersonCast;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.pf7.smdb.helper.HelperFunctions.*;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {
    private final FilmRepository filmRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return filmRepository;
    }

    @Override
    public Film findFilmByMovieTitle(String title) {
        return filmRepository.findFilmByMovieTitle(title);
    }

    @Override
    public Person findPersonById(Long id) {
        return filmRepository.findPersonById(id);
    }

    @Override
    public void parseAndCreateFilmsFromTmdbApi() {

        TmdbMovies movies = new TmdbApi("690004238e130a8abc787e0ddb18a5d3").getMovies();

        //var a = movies.getPopularMovies("en-US",1).getTotalPages();

        Set<Film> generalFilmlist = new HashSet<>();

        for (int i = 0; i < 1; i++) {
            for (MovieDb movie : movies.getPopularMovies("en", i)) {

                int year = 0;
                if (movie.getReleaseDate() != null) {
                    if (movie.getReleaseDate().length() >= 4) {
                        year = Integer.parseInt(movie.getReleaseDate().substring(0, 4));
                    }
                }

                Film film = Film.builder()
                        .movie(Movie.builder().title(movie.getOriginalTitle())
                                .genre(Set.of(randomGenre()))
                                .description(movie.getOverview())
                                .year(year)
                                .rating(round(movie.getVoteAverage(), 2)).build())
                        .build();

                if (existsFilmByMovieTitle(film.getMovie().getTitle())) {
                    continue;
                }

                boolean exists = false;
                if (generalFilmlist.size() > 0) {
                    for (Film films : generalFilmlist) {
                        if (films.getMovie().getTitle().equals(film.getMovie().getTitle())) {
                            exists = true;
                            break;
                        }
                    }
                }

                if (exists)
                    continue;

                Set<Person> personList = new HashSet<>();

                var castList = movies.getMovie(movie.getId(), "en", TmdbMovies.MovieMethod.credits);

                if (castList != null) {
                    for (PersonCast cast : castList.getCredits().getCast()) {

                        int r = (int) (Math.random() * (2010 - 1960)) + 1960;
                        Person person = new Person();
                        person.setName(cast.getName());
                        person.setBorn(r);
                        personList.add(person);
                    }
                }

                Set<FilmPersonRoles> filmPersonRoles = new HashSet<>();

                if (personList.size() > 0) {
                    for (Person person : personList) {
                        FilmPersonRoles filmPersonRoles1 = new FilmPersonRoles();
                        filmPersonRoles1.setPerson(person);
                        filmPersonRoles1.setPersonRoleEnum(randomRole());

                        filmPersonRoles.add(filmPersonRoles1);
                    }
                }

                film.setFilmPersonRoles(filmPersonRoles);
                generalFilmlist.add(film);
            }
        }
        createAll(List.copyOf(generalFilmlist));
    }

    @Override
    public Boolean existsFilmByMovieTitle(String title) {
        return filmRepository.existsFilmByMovieTitle(title);
    }
}

