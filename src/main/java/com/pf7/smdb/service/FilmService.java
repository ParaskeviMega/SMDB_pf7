package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmService extends BaseService<Film, Long> {


    void parseAndCreateFilmsFromTmdbApi();

    Boolean existsFilmByMovieTitle(String title);

    @Query(value = "SELECT * FROM Film f WHERE f.movie.title LIKE CONCAT('%',:movieTitle,'%')",nativeQuery = true)
    Film findFilmByTitleLike(@Param("movieTitle") String title);

    Boolean existsPersonByName(String name);

    List<Film> findFilmsByPersonNameLike (String name);

    //@Query("select Film from Film inner join FilmPersonRoles.Film.")
    List<Film> findFilmsByPersonNameAndRole(String name,String role);
}
