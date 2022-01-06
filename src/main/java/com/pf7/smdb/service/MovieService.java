package com.pf7.smdb.service;

import com.pf7.smdb.domain.Movie;

public interface MovieService extends BaseService<Movie, Long> {


//    void parseAndCreateFilmsFromTmdbApi();
//
//    Boolean existsFilmByMovieTitle(String title);
//
//    @Query(value = "SELECT * FROM Film f WHERE f.movie.title LIKE CONCAT('%',:movieTitle,'%')",nativeQuery = true)
//    Film findFilmByTitleLike(@Param("movieTitle") String title);
//
//    Boolean existsPersonByName(String name);
//
//    List<Film> findFilmsByPersonNameLike (String name);
//
//    //@Query("select Film from Film inner join FilmPersonRoles.Film.")
//    List<Film> findFilmsByPersonNameAndRole(String name,String role);
}
