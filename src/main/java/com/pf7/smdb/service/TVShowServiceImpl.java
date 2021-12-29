package com.pf7.smdb.service;

import com.pf7.smdb.domain.TVShow;
import com.pf7.smdb.helper.GenreEnum;
import com.pf7.smdb.helper.PersonRoleEnum;
import com.pf7.smdb.repository.TVShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TVShowServiceImpl extends BaseServiceImpl<TVShow> implements TVShowService {
    private final TVShowRepository tvShowRepository;

    @Override
    public JpaRepository<TVShow, Long> getRepository() {
        return tvShowRepository;
    }

    @Override
    public GenreEnum randomGenre() {
        int pick = new Random().nextInt(GenreEnum.values().length);
        return GenreEnum.values()[pick];
    }

    @Override
    public PersonRoleEnum randomRole() {
        int pick = new Random().nextInt(PersonRoleEnum.values().length);
        return PersonRoleEnum.values()[pick];
    }

    @Override
    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
