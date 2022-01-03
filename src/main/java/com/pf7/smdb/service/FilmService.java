package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.Person;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmService extends BaseService<Film, Long> {
//    List<String> findAllFilmsByActorName();

    Film findFilmByMovieTitle(String title);

    Person findPersonById(Long id);

    void parseAndCreateFilmsFromTmdbApi();

    Boolean existsFilmByMovieTitle(String title);

    @Query(value = "SELECT * FROM Movie WHERE Rating LIKE '?1'", nativeQuery = true)
    Film findFilmByTitleLike(String title);

    Boolean existsPersonByName(String name);
}
