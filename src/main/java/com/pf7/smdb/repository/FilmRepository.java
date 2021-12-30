package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    Film findFilmByMovieTitle(String title);

    @Query("select pr from Person pr where pr.id = ?1")
    Person findPersonById(Long id);

    Boolean existsFilmByMovieTitle(String title);


//    @Query("select pr from Person pr where pr.surname like %?1")
//    Person findPersonBySurname(String surname);
}
