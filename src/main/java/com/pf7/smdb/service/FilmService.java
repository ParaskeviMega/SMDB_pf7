package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.helper.GenreEnum;
import com.pf7.smdb.helper.PersonRoleEnum;

import java.util.Set;

public interface FilmService extends BaseService<Film, Long> {
    Film findFilmByMovieTitle(String title);

    Person findPersonById(Long id);

    void parseAndCreateFilmsFromTmdbApi();

    Boolean existsFilmByMovieTitle(String title);
}
