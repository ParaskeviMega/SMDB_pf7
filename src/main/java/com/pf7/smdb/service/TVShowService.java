package com.pf7.smdb.service;

import com.pf7.smdb.domain.TVShow;
import com.pf7.smdb.helper.GenreEnum;
import com.pf7.smdb.helper.PersonRoleEnum;

public interface TVShowService extends BaseService<TVShow, Long> {

    GenreEnum randomGenre();

    PersonRoleEnum randomRole();

    double round(double value, int places);
}
