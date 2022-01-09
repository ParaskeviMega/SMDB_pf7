package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "select top ?1 * from Show s order by s.showRating desc", nativeQuery = true)
    List<Show> findXTopRatedShows(Integer x);

//    @Query(value = "select new com.pf7.smdb.transfer.KeyValue(s.showGenre , count(s.showGenre)) " +
//            "from Show s group by s.showGenre")
//    List<KeyValue<List<String>, Long>> findNumberOfShowsPerGenre();

 }
