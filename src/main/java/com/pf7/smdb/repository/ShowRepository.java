package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.domain.Show;
import com.pf7.smdb.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {


    Boolean existsShowByShowTitleContains(String title);

    List<Show> findShowsByShowTitleContains(String title);

    Show findShowByShowTitle(String title);

    List<Show> findShowsByShowYear(Integer year);

    List<Show> findShowsByShowRatingStartsWith(String rating);

    List<Show> findShowByShowEpisodesEquals(Integer episodes);

    List<Show> findShowByShowSeasonsEquals(Integer seasons);

    List<Show> findShowsByShowYearAndShowRatingStartsWith(Integer year, String rating);
}
