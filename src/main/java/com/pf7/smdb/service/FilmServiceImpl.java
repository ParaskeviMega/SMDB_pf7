package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.helper.PersonPersonRoles;
import com.pf7.smdb.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public Set<Person> overridePersonRoles(List<PersonPersonRoles>  personPersonRoles) {
        Set<Person> personSet = new HashSet<>();

        personPersonRoles.forEach(personPersonRoles1 -> personPersonRoles1.getPerson().setPersonRoles(Set.copyOf(personPersonRoles1.getPersonRoleList())));
        personPersonRoles.forEach(personPersonRoles1 -> personSet.add(personPersonRoles1.getPerson()));

        return personSet;
    }
}
