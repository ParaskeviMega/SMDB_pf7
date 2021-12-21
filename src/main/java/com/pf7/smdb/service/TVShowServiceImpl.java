package com.pf7.smdb.service;

import com.pf7.smdb.domain.TVShow;
import com.pf7.smdb.repository.TVShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TVShowServiceImpl extends BaseServiceImpl<TVShow> implements TVShowService {
    private final TVShowRepository tvShowRepository;

    @Override
    public JpaRepository<TVShow, Long> getRepository() {
        return tvShowRepository;
    }

//    @Override
//    public TVShow findByTitle(String title) {
//        return tvShowRepository.findByTitle(title);
//    }
}
