package com.pf7.smdb.service;

import com.pf7.smdb.domain.Contribution;
import com.pf7.smdb.domain.Film;

import java.util.List;

public interface FilmService extends BaseService<Film, Long>{
    Film findFilmByMovieTitle(String title);

}
