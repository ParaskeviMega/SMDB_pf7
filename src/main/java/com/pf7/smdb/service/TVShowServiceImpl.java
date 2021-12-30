package com.pf7.smdb.service;

import com.pf7.smdb.domain.*;
import com.pf7.smdb.helper.*;
import com.pf7.smdb.repository.TVShowRepository;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbTV;
import info.movito.themoviedbapi.model.people.PersonCast;
import info.movito.themoviedbapi.model.tv.TvSeries;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.pf7.smdb.helper.HelperFunctions.*;


@Service
@RequiredArgsConstructor
public class TVShowServiceImpl extends BaseServiceImpl<TVShow> implements TVShowService {
    private final TVShowRepository tvShowRepository;

    @Override
    public JpaRepository<TVShow, Long> getRepository() {
        return tvShowRepository;
    }

    @Override
    public void parseAndCreateTvShowFromTmdbApi() {

        TmdbTV series = new TmdbApi("690004238e130a8abc787e0ddb18a5d3").getTvSeries();

        //var a = movies.getPopularMovies("en-US",1).getTotalPages();

        Set<TVShow> generalTVshowList = new HashSet<>();

        for (int i = 0; i < 1; i++) {
            for (TvSeries tvSerie : series.getPopular("en", i)) {

                int year = 0;
                if (tvSerie.getFirstAirDate() != null) {
                    if (tvSerie.getFirstAirDate().length() >= 4) {
                        year = Integer.parseInt(tvSerie.getFirstAirDate().substring(0, 4));
                    }
                }

                TvSeries tvSeries = series.getSeries(tvSerie.getId(), "en", TmdbTV.TvMethod.credits);

                TVShow tvShow = TVShow.builder()
                        .movie(Movie.builder()
                                .title(tvSerie.getOriginalName())
                                .genre(Set.of(randomGenre()))
                                .description(tvSerie.getOverview())
                                .year(year)
                                .rating(round(tvSerie.getVoteAverage(), 2)).build())
                                .episodes(tvSeries.getNumberOfEpisodes())
                                .seasons(tvSeries.getNumberOfSeasons())
                        .build();



                if (existsTVShowByMovieTitle(tvShow.getMovie().getTitle())) {
                    continue;
                }

                boolean exists = false;
                if (generalTVshowList.size() > 0) {
                    for (TVShow tvShows : generalTVshowList) {
                        if (tvShows.getMovie().getTitle().equals(tvShow.getMovie().getTitle())) {
                            exists = true;
                            break;
                        }
                    }
                }

                if (exists)
                    continue;

                Set<Person> personList = new HashSet<>();

                var castList = series.getSeries(tvSerie.getId(), "en", TmdbTV.TvMethod.credits);

                if (castList != null) {
                    for (PersonCast cast : castList.getCredits().getCast()) {

                        int r = (int) (Math.random() * (2010 - 1960)) + 1960;
                        Person person = new Person();
                        person.setName(cast.getName());
                        person.setBorn(r);
                        personList.add(person);
                    }
                }

                Set<TvShowPersonRoles> TVShowPersonRoles = new HashSet<>();

                if (personList.size() > 0) {
                    for (Person person : personList) {
                        TvShowPersonRoles TVShowPersonRoles1 = new TvShowPersonRoles();
                        TVShowPersonRoles1.setPerson(person);
                        TVShowPersonRoles1.setPersonRoleEnum(randomRole());

                        TVShowPersonRoles.add(TVShowPersonRoles1);
                    }
                }

                tvShow.setTvShowPersonRoles(TVShowPersonRoles);
                generalTVshowList.add(tvShow);
            }
        }
        createAll(List.copyOf(generalTVshowList));
    }

    @Override
    public Boolean existsTVShowByMovieTitle(String title) {
        return tvShowRepository.existsTVShowByMovieTitle(title);
    }
}
