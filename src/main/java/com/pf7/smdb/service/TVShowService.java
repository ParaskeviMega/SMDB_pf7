package com.pf7.smdb.service;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.MoviePersonRoles;
import com.pf7.smdb.domain.TVShow;

import java.util.Set;

public interface TVShowService extends BaseService<TVShow, Long> {
    void UpdateFilmsAndContributions(Set<TVShow> tvShows, Set<MoviePersonRoles> moviePersonRoles);
}
