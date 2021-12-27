package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Contribution;
import com.pf7.smdb.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    Film findFilmByMovieTitle(String title);
}
