package com.pf7.smdb.service;

import com.pf7.smdb.domain.*;
import com.pf7.smdb.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
    private final MovieRepository movieRepository;
    //private final PersonRepository personRepository;

    @Override
    public JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }
//
//    public Film findFilmByMovieTitle(String title) {
//        return filmRepository.findFilmByMovieTitle(title);
//    }
//
//    public Person findPersonById(Long id) {
//        return personRepository.findPersonById(id);
//    }
//
//    @Override
//    public void parseAndCreateFilmsFromTmdbApi() {
//
//        TmdbMovies movies = new TmdbApi("690004238e130a8abc787e0ddb18a5d3").getMovies();
//
//        //var a = movies.getPopularMovies("en-US",1).getTotalPages();
//
//        Set<Film> generalFilmlist = new HashSet<>();
//        Set<Person> personList = new HashSet<>();
//
//        for (int i = 0; i < 1; i++) {
//            for (MovieDb movie : movies.getPopularMovies("en", i)) {
//
//                int year = 0;
//                if (movie.getReleaseDate() != null) {
//                    if (movie.getReleaseDate().length() >= 4) {
//                        year = Integer.parseInt(movie.getReleaseDate().substring(0, 4));
//                    }
//                }
//
//                Film film = Film.builder()
//                        .movie(Movie.builder().title(movie.getOriginalTitle())
//                                .genre(Set.of(randomGenre()))
//                                .description(movie.getOverview())
//                                .year(year)
//                                .rating(round(movie.getVoteAverage(), 2)).build())
//                        .build();
//
//                if (existsFilmByMovieTitle(film.getMovie().getTitle())) {
//                    continue;
//                }
//
//                boolean exists = false;
//                if (generalFilmlist.size() > 0) {
//                    for (Film films : generalFilmlist) {
//                        if (films.getMovie().getTitle().equals(film.getMovie().getTitle())) {
//                            exists = true;
//                            break;
//                        }
//                    }
//                }
//
//                if (exists)
//                    continue;
//
//                var castList = movies.getMovie(movie.getId(), "en", TmdbMovies.MovieMethod.credits);
//
//                if (castList != null) {
//                    for (PersonCast cast : castList.getCredits().getCast()) {
//                        int counter = 0;
//
//                        counter++;
//
//                        if (counter == 4) {
//                            counter = 0;
//                            continue;
//                        }
//
//                        int r = (int) (Math.random() * (2010 - 1960)) + 1960;
//                        Person person = new Person();
//                        person.setName(cast.getName());
//                        person.setBorn(r);
//
//                        if (existsPersonByName(person.getName())) {
//                            continue;
//                        }
//
//                        boolean existsPerson = false;
//                        if (personList.size() > 0) {
//                            for (Person person1 : personList) {
//                                if (person1.getName().equals(person.getName())) {
//                                    existsPerson = true;
//                                    break;
//                                }
//                            }
//                        }
//
//                        if (existsPerson)
//                            continue;
//
//                        personList.add(person);
//                    }
//                }
//
//                Set<FilmPersonRoles> filmPersonRoles = new HashSet<>();
//
//                if (personList.size() > 0) {
//                    for (Person person : personList) {
//                        FilmPersonRoles filmPersonRoles1 = new FilmPersonRoles();
//                        filmPersonRoles1.setPerson(person);
//                        filmPersonRoles1.setPersonRoleEnum(randomRole());
//
//                        filmPersonRoles.add(filmPersonRoles1);
//                    }
//                }
//
//                film.setFilmPersonRoles(filmPersonRoles);
//                generalFilmlist.add(film);
//            }
//        }
//        createAll(List.copyOf(generalFilmlist));
//    }
//
//    @Override
//    public Boolean existsFilmByMovieTitle(String title) {
//        return filmRepository.existsFilmByMovieTitle(title);
//    }
//
//    @Override
//    public Film findFilmByTitleLike(String title) {
//        return findFilmByTitleLike(title);
//    }
//
//    @Override
//    public Boolean existsPersonByName(String name) {
//        return personRepository.existsPersonByName(name);
//    }
//
//    @Override
//    public List<Film> findFilmsByPersonNameLike(String name) {
//        List<Film> films = new ArrayList<>();
//
//        filmRepository.findAll().forEach(film -> {
//            film.getFilmPersonRoles().stream().filter(filmPersonRoles -> filmPersonRoles.getPerson().getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))).map(filmPersonRoles -> film).forEach(films::add);
//        });
//
//        return films;
//    }
//
//    public List<Film> findFilmsByMovieYear(int year) {
//        return filmRepository.findFilmsByMovieYear(year);
//    }
//
//    public List<Film> findFilmsByMovieRating(double rating) {
//        return filmRepository.findFilmsByMovieRating(rating);
//    }
//
//    public List<Film> findFilmsByMovieGenre(String genre) {
//        return filmRepository.findFilmsByMovieGenre(genre);
//    }
//
//    @Override
//    public List<Film> findFilmsByPersonNameAndRole(String name, String role) {
//        return findFilmsByPersonNameAndRole(name,role);

//        List<Film> films = new ArrayList<>();
//
//        for(Film film : filmRepository.findAll()){
//            film.getFilmPersonRoles().stream().filter(filmPersonRoles ->
//                    filmPersonRoles.getPerson().getName() != null).filter(filmPersonRoles ->
//                    filmPersonRoles.getPersonRoleEnum() != null).filter(filmPersonRoles ->
//                    filmPersonRoles.getPerson().getName().contains(name)).filter(filmPersonRoles ->
//                    filmPersonRoles.getPersonRoleEnum().toString().contains(role)).forEach(filmPersonRoles -> {
//                films.add(film);
//                return;
//            });
//        }
//
//        return films;
    }


