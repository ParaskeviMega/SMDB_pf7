package com.pf7.smdb.service;

import com.pf7.smdb.domain.Show;
import com.pf7.smdb.helper.CustomObject;

import java.util.List;

public interface ShowService extends BaseService<Show, Long> {

    void parseAndCreateShowFromTmdbApi();

    Boolean existsShowByShowTitleContains(String title);

    List<Show> findShowsByShowTitleContains(String title);

    Show findShowByShowTitle(String title);

    Show findShowById(Long id);

    List<Show> findShowsByShowYear(Integer year);

    List<Show> findShowsByShowGenreEquals(String genre);

    List<Show> findShowsByShowRatingStartsWith(String rating);

    List<Show> findShowByShowEpisodesEquals(Integer episodes);

    List<Show> findShowByShowSeasonsEquals(Integer seasons);

    List<Show> findShowsByShowYearAndShowRatingStartsWith(Integer year, String rating);

    List<Show> findXTopRatedShows(Integer x);

    List<CustomObject.GenreOccurrence> findNumberOfShowsPerGenre();

    List<CustomObject.GenreYearOccurence> findNumberOfShowsPerYearPerGenre();
}
