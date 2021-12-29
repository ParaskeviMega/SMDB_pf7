package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.MoviePersonRoles;
import com.pf7.smdb.domain.TVShow;
import com.pf7.smdb.repository.MoviePersonRolesRepository;
import com.pf7.smdb.repository.TVShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TVShowServiceImpl extends BaseServiceImpl<TVShow> implements TVShowService {
    private final TVShowRepository tvShowRepository;
    private final MoviePersonRolesRepository moviePersonRolesRepository;

    @Override
    public JpaRepository<TVShow, Long> getRepository() {
        return tvShowRepository;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void UpdateFilmsAndContributions(Set<TVShow> tvShows, Set<MoviePersonRoles> moviePersonRoles) {
        tvShowRepository.saveAll(tvShows);
        moviePersonRolesRepository.saveAll(moviePersonRoles);
    }
}
