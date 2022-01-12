package com.pf7.smdb.service;

import com.pf7.smdb.domain.*;
import com.pf7.smdb.helper.CustomObject;
import com.pf7.smdb.helper.PersonRole;
import com.pf7.smdb.repository.MovieRepository;
import com.pf7.smdb.repository.PersonRepository;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.PersonCast;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static com.pf7.smdb.helper.HelperFunctions.randomRole;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;

    @Override
    public JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
    public void parseAndCreateMovieFromTmdbApi() {

        TmdbMovies movies = new TmdbApi("690004238e130a8abc787e0ddb18a5d3").getMovies();

        for (int i = 0; i < 1; i++) {
            for (MovieDb movieTmdb : movies.getPopularMovies("en", i)) {

                int year = 0;
                if (movieTmdb.getReleaseDate() != null) {
                    if (movieTmdb.getReleaseDate().length() >= 4) {
                        year = Integer.parseInt(movieTmdb.getReleaseDate().substring(0, 4));
                    }
                }

                MovieDb tmdbMovies = movies.getMovie(movieTmdb.getId(), "en", TmdbMovies.MovieMethod.credits);

                List<String> genres = new ArrayList<>();

                tmdbMovies.getGenres().forEach(genre ->
                        genres.add(genre.getName().replace("&", "-")));

                Movie movie = Movie.builder()
                        .movieTitle(new String(movieTmdb.getOriginalTitle().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8))
                        .movieGenre(genres)
                        .movieDescription(movieTmdb.getOverview())
                        .movieYear(year)
                        .movieRating(String.valueOf(movieTmdb.getVoteAverage()))
                        .build();

                if (existsMovieByMovieTitleContains(movie.getMovieTitle())) {
                    continue;
                }

                Set<PersonRole> personRoleSet = new HashSet<>();

                if (tmdbMovies != null) {
                    for (PersonCast cast : tmdbMovies.getCredits().getCast()) {

                        var person2 = personRepository.findPeopleByPersonNameContains(cast.getName());

                        if (person2.size() > 0) {
                            continue;
                        }
                        Person person = new Person();

                        int r = (int) (Math.random() * (2010 - 1960)) + 1960;
                        person.setPersonName(cast.getName());
                        person.setPersonBorn(r);

                        PersonRole personRole = new PersonRole();

                        List<String> roles = new ArrayList<>();

                        int counter = 0;

                        while (counter != 3) {
                            String randomRole = randomRole();
                            if (!roles.contains(randomRole)) {
                                roles.add(randomRole);
                                counter++;
                            }
                        }

                        personRole.setPersonRoles(roles);
                        personRole.setPersonRolesPerson(person);
                        personRoleSet.add(personRole);
                    }
                }
                movie.getMoviePersonRoles().addAll(personRoleSet);
                try {
                    getRepository().save(movie);
                } catch (Exception e) {
                    logger.info("PROBLEM--------------> : {}", e.getMessage());
                }
            }
        }
    }

    @Override
    public Boolean existsMovieByMovieTitleContains(String title) {
        return movieRepository.existsMovieByMovieTitleContains(title);
    }

    @Override
    public List<Movie> findMoviesByMovieGenreContains(String genre) {
        List<Movie> movies = new ArrayList<>();
        boolean exists;
        for (Movie movie : getRepository().findAll()) {
            exists = false;
            for (String s : movie.getMovieGenre()) {
                if (exists) continue;
                if (StringUtils.containsIgnoreCase(s, genre)) {
                    movies.add(movie);
                    exists = true;
                }
            }
        }
        return movies;
    }

    @Override
    public List<Movie> findMoviesByMovieRatingStartsWith(String rating) {
        return movieRepository.findMoviesByMovieRatingStartsWith(rating);
    }

    @Override
    public Movie findMovieByMovieTitle(String title) {
        return movieRepository.findMovieByMovieTitle(title);
    }

    @Override
    public List<Movie> findMoviesByMovieYear(Integer year) {
        return movieRepository.findMoviesByMovieYear(year);
    }

    @Override
    public Movie findMovieById(Long id) {
        return movieRepository.findMovieById(id);
    }

    @Override
    public List<Movie> findMoviesByMovieTitleContains(String title) {
        List<Movie> movies = new ArrayList<>();

        for (Movie movie : getRepository().findAll()) {
            String s = movie.getMovieTitle();
            if (StringUtils.containsIgnoreCase(s, title)) {
                movies.add(movie);
            }
        }
        return movies;
    }

    @Override
    public List<Movie> findMoviesByMovieYearAndMovieRatingStartsWith(Integer year, String rating) {
        return movieRepository.findMoviesByMovieYearAndMovieRatingStartsWith(year, rating);
    }

    @Override
    public List<Movie> findXTopRatedMovies(Integer x) {
        return movieRepository.findXTopRatedMovies(x);
    }


    @Override
    public List<CustomObject.GenreOccurrence> findNumberOfMoviesPerGenre() {

        List<CustomObject.GenreOccurrence> shuffled = new ArrayList<>();

        for (Movie movie : movieRepository.findAll())
            for (String genre : movie.getMovieGenre())
                if (shuffled.stream().map(CustomObject.GenreOccurrence::getGenre).anyMatch(s -> s.contains(genre))) {
                    shuffled.stream().filter(obj -> obj.getGenre().contains(genre)).
                            forEach(stringIntegerKeyValueObj -> stringIntegerKeyValueObj.setOccurrences(stringIntegerKeyValueObj.getOccurrences() + 1));
                } else if (shuffled.stream().map(CustomObject.GenreOccurrence::getGenre).noneMatch(s -> s.contains(genre))) {
                    CustomObject.GenreOccurrence newObj = new CustomObject.GenreOccurrence();
                    newObj.setGenre(genre);
                    newObj.setOccurrences(1);
                    shuffled.add(newObj);
                }
        return shuffled;
    }

    @Override
    public List<CustomObject.GenreYearOccurence> findNumberOfMoviesPerYearPerGenre() {

        List<CustomObject.GenreYearOccurence> shuffled = new ArrayList<>();

        for (Movie movie : movieRepository.findAll()) {
            for (String genre : movie.getMovieGenre()) {

                if (shuffled.stream().anyMatch(obj -> obj.getGenre().contains(genre) && obj.getYear().contains(movie.getMovieYear().toString()))) {

                    shuffled.stream().filter(obj -> obj.getGenre().contains(genre) && obj.getYear().contains(movie.getMovieYear().toString())).
                            forEach(stringIntegerKeyValueObj -> stringIntegerKeyValueObj.setOccurrences(stringIntegerKeyValueObj.getOccurrences() + 1));
                } else {
                    CustomObject.GenreYearOccurence newObj = new CustomObject.GenreYearOccurence();
                    newObj.setGenre(genre);
                    newObj.setYear(movie.getMovieYear().toString());
                    newObj.setOccurrences(1);
                    shuffled.add(newObj);
                }
            }
        }

        return shuffled.stream()
                .sorted(Comparator.comparing(CustomObject.GenreYearOccurence::getGenre).thenComparing(CustomObject.GenreYearOccurence::getYear))
                .collect(Collectors.toList());
    }
}


