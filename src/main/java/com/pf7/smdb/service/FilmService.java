package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;

public interface FilmService extends BaseService<Film, Long>{
    Film findByTitle(String Title);
}
