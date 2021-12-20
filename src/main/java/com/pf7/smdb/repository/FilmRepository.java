package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findByTitle(String title);
}
