package com.pf7.smdb.repository;

import com.pf7.smdb.domain.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.List;

@Repository
public interface TVShowRepository extends JpaRepository<TVShow, Long> {

//    @Query(value="select ts from TVShow ts where ts.title = ?1")
//    TVShow findByTitle(String title);
    Boolean existsTVShowByMovieTitle(String title);

    TVShow findTvShowByMovieTitle(String title);

//    @Query("select new com.pf7.smdb.transfer.KeyValue(concat(p.name, ' ', p.born)) " +
//            "from TVShow tv join tv.tvShowPersonRoles p group by p order")
//    List<KeyValue<String, TVShow>> findAllTvShowsByActorName();
}
