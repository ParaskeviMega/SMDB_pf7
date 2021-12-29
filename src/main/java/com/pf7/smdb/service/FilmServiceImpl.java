package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.MoviePersonRoles;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.repository.FilmRepository;
import com.pf7.smdb.repository.MoviePersonRolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {
    private final FilmRepository filmRepository;
    private final MoviePersonRolesRepository moviePersonRolesRepository;

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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void UpdateFilmsAndContributions(Set<Film> films, Set<MoviePersonRoles> moviePersonRoles) {
        filmRepository.saveAll(films);
        moviePersonRolesRepository.saveAll(moviePersonRoles);
    }
}
