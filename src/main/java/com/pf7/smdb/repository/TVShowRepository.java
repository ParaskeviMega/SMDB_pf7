package com.pf7.smdb.repository;

import com.pf7.smdb.domain.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TVShowRepository extends JpaRepository<TVShow, Long> {

//    @Query(value="select ts from TVShow ts where ts.title = ?1")
//    TVShow findByTitle(String title);
}
