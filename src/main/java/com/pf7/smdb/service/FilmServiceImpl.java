package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
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
    public Film findByTitle(String title) {
        //filmRepository.findBy()
        return filmRepository.findAll().stream().filter(m -> m.getTitle().equals(title)).findAny().orElse(null);
    }
}