package com.pf7.smdb.service;

import com.pf7.smdb.domain.TVShow;

import org.springframework.data.jpa.repository.Query;

public interface TVShowService extends BaseService<TVShow, Long> {

    void parseAndCreateTvShowFromTmdbApi();

    Boolean existsTVShowByMovieTitle(String title);

    @Query(value = "SELECT * FROM Movie WHERE Rating LIKE '?1'", nativeQuery = true)
    TVShow findTvShowByTitleLike(String title);

    Boolean existsPersonByName(String name);
}
