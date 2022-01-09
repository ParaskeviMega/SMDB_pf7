package com.pf7.smdb.service;

import com.pf7.smdb.domain.*;
import com.pf7.smdb.helper.PersonRole;
import com.pf7.smdb.repository.PersonRepository;
import com.pf7.smdb.repository.ShowRepository;
import com.pf7.smdb.transfer.KeyValue;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbTV;
import info.movito.themoviedbapi.model.people.PersonCast;
import info.movito.themoviedbapi.model.tv.TvSeries;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

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

        for (int i = 0; i < 3; i++) {
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
                        genres.add(genre.getName().replace("&","-")));

                Show show = Show.builder()
                        .showTitle(new String(tvSerie.getOriginalName().getBytes(StandardCharsets.UTF_16), StandardCharsets.UTF_16))
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

                        var person2 = personRepository.findPeopleByPersonNameContains(cast.getName());

                        if (person2.size() > 0) {
                            continue;
                        }

                        Person person = new Person();
                        int r = (int) (Math.random() * (2010 - 1960)) + 1960;
                        person.setPersonName(cast.getName());
                        person.setPersonBorn(r);

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

                        personRole.setPersonRoles(roles);
                        personRole.setPersonRolesPerson(person);
                        personRoleSet.add(personRole);
                    }
                }

                show.getShowPersonRoles().addAll(personRoleSet);
                try {
                    showRepository.save(show);
                }catch (Exception e){
                    logger.info("PROBLEM--------------> : {}",e.getMessage());
                }
            }
        }
    }

    @Override
    public Boolean existsShowByShowTitleContains(String title) {
        return showRepository.existsShowByShowTitleContains(title);
    }

    @Override
    public List<Show> findShowsByShowTitleContains(String title) {
        List<Show> shows = new ArrayList<>();
        for (Show show : getRepository().findAll()) {
            String s = show.getShowTitle();
            if (StringUtils.containsIgnoreCase(s,title)) {
                shows.add(show);
            }
        }
        return shows;
    }

    @Override
    public Show findShowByShowTitle(String title) {
        return showRepository.findShowByShowTitle(title);
    }

    @Override
    public List<Show> findShowsByShowYear(Integer year) {
        return showRepository.findShowsByShowYear(year);
    }

    @Override
    public List<Show> findShowsByShowGenreEquals(String genre) {
        List<Show> shows = new ArrayList<>();
        boolean exists;
        for (Show show : getRepository().findAll()) {
            exists = false;
            for (String s : show.getShowGenre()) {
                if (exists) continue;
                if (StringUtils.containsIgnoreCase(s, genre)) {
                    shows.add(show);
                    exists = true;
                }
            }
        }
        return shows;
    }

    @Override
    public List<Show> findShowsByShowRatingStartsWith(String rating) {
        return showRepository.findShowsByShowRatingStartsWith(rating);
    }

    @Override
    public List<Show> findShowByShowEpisodesEquals(Integer episodes) {
        return showRepository.findShowByShowEpisodesEquals(episodes);
    }

    @Override
    public List<Show> findShowByShowSeasonsEquals(Integer seasons) {
        return showRepository.findShowByShowSeasonsEquals(seasons);
    }

    @Override
    public Show findShowById(Long id) {
        return find(id);
    }

    @Override
    public List<Show> findShowsByShowYearAndShowRatingStartsWith(Integer year, String rating) {
        return showRepository.findShowsByShowYearAndShowRatingStartsWith(year, rating);
    }

    @Override
    public List<Show> findXTopRatedShows(Integer x) {
        return showRepository.findXTopRatedShows(x);
    }

//    @Override
//    public List<KeyValue<List<String>, Long>> findNumberOfShowsPerGenre() {
//        return showRepository.findNumberOfShowsPerGenre();
//    }

    @Override
    public List<KeyValue<List<String>, Long>> findNumberOfShowsPerGenre() {


        List<Show> shows = new ArrayList<>();
        boolean exists;
        for (Show show : getRepository().findAll()) {
            exists = false;
            for (String s : show.getShowGenre()) {
                if (exists) continue;

                shows.add(show);
                exists = true;

            }
        }
        return null;
    }
}

