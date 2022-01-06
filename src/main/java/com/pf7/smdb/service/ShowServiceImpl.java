package com.pf7.smdb.service;

import com.pf7.smdb.domain.*;
import com.pf7.smdb.helper.PersonRole;
import com.pf7.smdb.repository.PersonRepository;
import com.pf7.smdb.repository.ShowRepository;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbTV;
import info.movito.themoviedbapi.model.people.PersonCast;
import info.movito.themoviedbapi.model.tv.TvSeries;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.pf7.smdb.helper.HelperFunctions.*;


@Service
@RequiredArgsConstructor
public class ShowServiceImpl extends BaseServiceImpl<Show> implements ShowService {
    private final ShowRepository showRepository;
    private final PersonRepository personRepository;

    @Override
    public JpaRepository<Show, Long> getRepository() {
        return showRepository;
    }

    @Override
    public void parseAndCreateShowFromTmdbApi() {

        TmdbTV series = new TmdbApi("690004238e130a8abc787e0ddb18a5d3").getTvSeries();

        for (int i = 0; i < 1; i++) {
            for (TvSeries tvSerie : series.getPopular("en", i)) {

                int year = 0;
                if (tvSerie.getFirstAirDate() != null) {
                    if (tvSerie.getFirstAirDate().length() >= 4) {
                        year = Integer.parseInt(tvSerie.getFirstAirDate().substring(0, 4));
                    }
                }

                TvSeries tvSeries = series.getSeries(tvSerie.getId(), "en", TmdbTV.TvMethod.credits);

                List<String> genres = new ArrayList<>();

                tvSeries.getGenres().forEach(genre ->
                        genres.add(genre.getName()));

                Show show = Show.builder()
                        .showTitle(tvSerie.getOriginalName())
                        .showGenre(genres)
                        .showDescription(tvSerie.getOverview())
                        .showYear(year)
                        .showRating(String.valueOf(tvSerie.getVoteAverage()))
                        .showEpisodes(tvSeries.getNumberOfEpisodes())
                        .showSeasons(tvSeries.getNumberOfSeasons())
                        .build();


                if (showRepository.existsShowByShowTitleContains(show.getShowTitle())) {
                    continue;
                }

                Set<PersonRole> personRoleSet = new HashSet<>();

                if (tvSeries != null) {
                    for (PersonCast cast : tvSeries.getCredits().getCast()) {


                        Person person = new Person();
                        person = personRepository.findPersonByPersonNameContains(cast.getName());

                        if (person == null) {
                            person = new Person();
                            int r = (int) (Math.random() * (2010 - 1960)) + 1960;
                            person.setPersonName(cast.getName());
                            person.setPersonBorn(r);
                        }

                        PersonRole personRole = new PersonRole();

                        List<String> roles = new ArrayList<>();

                        int counter = 0;

                        while (counter != 3) {
                            String randomRole = randomRole();
                            if (!roles.contains(randomRole)) {
                                roles.add(randomRole);
                                counter++;
                            }
                        }


//                        if (roles.size() == 0){
//                        }

                        personRole.setPersonRoles(roles);
                        personRole.setPersonRolesPerson(person);
                        personRoleSet.add(personRole);
                    }
                }

                show.setShowPersonRoles(personRoleSet);
                showRepository.save(show);
            }
        }

    }




//
//    @Override
//    public Boolean existsTVShowByMovieTitle(String title) {
//        return tvShowRepository.existsTVShowByMovieTitle(title);
//    }
//
//    @Override
//    public TVShow findTvShowByTitleLike(String title) {
//        return tvShowRepository.findTvShowByMovieTitle(title);
//    }
//
//    @Override
//    public Boolean existsPersonByName(String name) {
//        return personRepository.existsPersonByName(name);
//    }

//    @Override
//    public List<KeyValue<String, TVShow>> findAllTvShowsByActorName (){
//        return tvShowRepository.findAllTvShowsByActorName();
}

