package com.pf7.smdb.service;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.domain.Show;
import com.pf7.smdb.helper.CustomObject;
import com.pf7.smdb.helper.PersonRole;
import com.pf7.smdb.repository.MovieRepository;
import com.pf7.smdb.repository.PersonRepository;
import com.pf7.smdb.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
    private final PersonRepository personRepository;
    private final MovieRepository movieRepository;
    private final ShowRepository showRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    @Override
    public Boolean existsPersonByPersonNameContains(String name) {
        return personRepository.existsPersonByPersonNameContains(name);
    }

    @Override
    public Person findPersonByPersonNameContains(String name) {
        return personRepository.findPersonByPersonNameContains(name);
    }

    @Override
    public List<Person> findPeopleByPersonNameContains(String name) {
        return personRepository.findPeopleByPersonNameContains(name);
    }

    @Override
    public Person findPersonById(Long id) {
        return find(id);
    }

    @Override
    public List<Person> findPeopleByPersonBorn(Integer born) {
        return personRepository.findPeopleByPersonBorn(born);
    }

    @Override
    public List<Movie> findMoviesByPersonName(String name) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie: movieRepository.findAll()) {
            if(movies.contains(movie)) continue;
            for (PersonRole personRole: movie.getMoviePersonRoles()){
                if(movies.contains(movie)) continue;
                if(StringUtils.containsIgnoreCase(
                        personRole.getPersonRolesPerson().getPersonName(),name)) {
                    movies.add(movie);
                }
            }
        }
        return movies;
    }

    @Override
    public List<Movie> findMoviesByPersonNameAndPersonRole(String name, String role) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie: movieRepository.findAll()) {
            if(movies.contains(movie)) continue;
            for (PersonRole personRole: movie.getMoviePersonRoles()){
                if(movies.contains(movie)) continue;
                if(StringUtils.containsIgnoreCase(
                        personRole.getPersonRolesPerson().getPersonName(),name) &&
                        personRole.getPersonRoles().stream().anyMatch(role::equalsIgnoreCase)) {
                    movies.add(movie);
                }
            }
        }
        return movies;
    }

    @Override
    public List<Show> findShowsByPersonName(String name) {
        List<Show> shows = new ArrayList<>();
        for (Show show: showRepository.findAll()) {
            if(shows.contains(show)) continue;
            for (PersonRole personRole: show.getShowPersonRoles()){
                if(shows.contains(show)) continue;
                if(StringUtils.containsIgnoreCase(
                        personRole.getPersonRolesPerson().getPersonName(),name)) {
                    shows.add(show);
                }
            }
        }
        return shows;
    }

    @Override
    public List<Show> findShowsByPersonNameAndPersonRole(String name, String role) {
        List<Show> shows = new ArrayList<>();
        for (Show show: showRepository.findAll()) {
            if(shows.contains(show)) continue;
            for (PersonRole personRole: show.getShowPersonRoles()){
                if(shows.contains(show)) continue;
                if(StringUtils.containsIgnoreCase(
                        personRole.getPersonRolesPerson().getPersonName(),name) &&
                        personRole.getPersonRoles().stream().anyMatch(role::equalsIgnoreCase)) {
                    shows.add(show);
                }
            }
        }
        return shows;
    }

    @Override
    public CustomObject.PersonParticipation findAllParticipationsByPersonName(String name) {
        CustomObject.PersonParticipation personParticipation = new CustomObject.PersonParticipation();
        personParticipation.setMovieSet(new HashSet<>(findMoviesByPersonName(name)));
        personParticipation.setShowSet(new HashSet<>(findShowsByPersonName(name)));

        return personParticipation;
    }

    @Override
    public CustomObject.PersonParticipation findAllParticipationsByPersonNameAndByPersonRole(String name, String role) {
        CustomObject.PersonParticipation personParticipation = new CustomObject.PersonParticipation();
        personParticipation.setMovieSet(new HashSet<>(findMoviesByPersonNameAndPersonRole(name,role)));
        personParticipation.setShowSet(new HashSet<>(findShowsByPersonNameAndPersonRole(name,role)));

        return personParticipation;
    }

//    @Override
//    public PersonParticipation findAllParticipationsByPersonNameAndPersonRole(String name, String role) {
//        PersonParticipation personParticipation = new PersonParticipation();
//        personParticipation.setMovieSet(new HashSet<>(findMoviesByPersonName(name)));
//        personParticipation.setShowSet(new HashSet<>(findShowsByPersonName(name)));
//
//        return personParticipation;
//    }

}
