package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {


    Boolean existsShowByShowTitleContains(String string);

    Show findShowByShowTitleContains(String title);

//    @Query(value="select ts from TVShow ts where ts.title = ?1")
//    TVShow findByTitle(String title);
//    Boolean existsTVShowByMovieTitle(String title);
//
//    TVShow findTvShowByMovieTitle(String title);

//    @Query("select new com.pf7.smdb.transfer.KeyValue(concat(p.name, ' ', p.born)) " +
//            "from TVShow tv join tv.tvShowPersonRoles p group by p order")
//    List<KeyValue<String, TVShow>> findAllTvShowsByActorName();
}
