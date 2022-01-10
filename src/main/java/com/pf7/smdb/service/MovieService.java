package com.pf7.smdb.service;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.helper.CustomObject;

import java.util.List;

public interface MovieService extends BaseService<Movie, Long> {


    void parseAndCreateMovieFromTmdbApi();

    Movie findMovieByMovieTitle(String title);

    List<Movie> findMoviesByMovieYear(Integer year);

    List<Movie> findMoviesByMovieGenreContains(String genre);

    List<Movie> findMoviesByMovieRatingStartsWith(String rating);

    Boolean existsMovieByMovieTitleContains(String title);

    Movie findMovieById(Long id);

    List<Movie> findMoviesByMovieTitleContains(String title);

    List<Movie> findMoviesByMovieYearAndMovieRatingStartsWith(Integer year, String rating);

    List<Movie> findXTopRatedMovies(Integer x);

    List<CustomObject.GenreOccurrence> findNumberOfMoviesPerGenre();

    List<CustomObject.GenreYearOccurence> findNumberOfMoviesPerYearPerGenre();
}
