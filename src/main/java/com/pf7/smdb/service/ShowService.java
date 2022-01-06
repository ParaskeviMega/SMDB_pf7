package com.pf7.smdb.service;

import com.pf7.smdb.domain.Show;

public interface ShowService extends BaseService<Show, Long> {

    void parseAndCreateShowFromTmdbApi();

//
//    Boolean existsTVShowByMovieTitle(String title);
//
//    @Query(value = "SELECT * FROM Movie WHERE Rating LIKE '?1'", nativeQuery = true)
//    TVShow findTvShowByTitleLike(String title);
//
//    Boolean existsPersonByName(String name);
//
////    List<KeyValue<String, TVShow>> findAllTvShowsByActorName();
}
