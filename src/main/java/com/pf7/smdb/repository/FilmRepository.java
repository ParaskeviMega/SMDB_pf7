package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    Film findFilmByMovieTitle(String title);

    Boolean existsFilmByMovieTitle(String title);

    List<Film> findFilmsByMovieYear(int year);

    List<Film> findFilmsByMovieRating(double rating);

    List<Film> findFilmsByMovieGenre(String genre);

    //Film findFilmByFilmPersonRoles
//    @Query(value = "select f.* from FILMS f inner join FILMPERSONROLES FP  inner join PEOPLE P  where P.NAME like '%?1%' and F.PERSONROLEENUM like '%?2%'",nativeQuery = true)
//    List<Film> findFilmsByPersonNameAndRole(String name,String role);


}
