package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.MoviePersonRoles;
import com.pf7.smdb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface MoviePersonRolesRepository extends JpaRepository<MoviePersonRoles, Long> {

}
