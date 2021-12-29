package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.MoviePersonRoles;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.repository.FilmRepository;
import com.pf7.smdb.repository.MoviePersonRolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MoviePersonRolesImpl extends BaseServiceImpl<MoviePersonRoles> implements MoviePersonRolesService {
    private final MoviePersonRolesRepository moviePersonRolesRepository;


    @Override
    public JpaRepository<MoviePersonRoles, Long> getRepository() {
        return moviePersonRolesRepository;
    }
}
