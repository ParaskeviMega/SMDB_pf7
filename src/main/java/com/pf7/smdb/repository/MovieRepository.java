package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findMovieByMovieTitle(String title);

    List<Movie> findMoviesByMovieYear(Integer year);

    List<Movie> findMoviesByMovieGenreEquals(String genre);

    List<Movie> findMoviesByMovieRatingStartsWith(String rating);

    Boolean existsMovieByMovieTitleContains(String title);
}
