package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
    public Person findPersonBySurname(String surname) {
        Person person = filmRepository.findPersonBySurname(surname);
        return person;
    }

}
