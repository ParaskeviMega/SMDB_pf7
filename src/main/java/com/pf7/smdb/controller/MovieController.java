package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.MovieService;
import com.pf7.smdb.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search/movie")
public class MovieController extends AbstractController<Movie> {
    private final MovieService movieService;
    private final PersonService personService;

    @Override
    protected BaseService<Movie, Long> getBaseService() {
        return movieService;
    }

    @GetMapping(params = {"title"})
    public List<Movie> getByMovieTitle(@RequestParam("title") String title) {
        return movieService.findMoviesByMovieTitleContains(title);
    }

    @GetMapping(params = {"year"})
    public List<Movie> getMoviesByYear(@RequestParam("year") Integer year) {
        return movieService.findMoviesByMovieYear(year);
    }

    @GetMapping(params = {"genre"})
    public List<Movie> getMoviesByGenre(@RequestParam("genre") String genre) {
        return movieService.findMoviesByMovieGenreContains(genre);
    }

    @GetMapping(params = {"rating"})
    public List<Movie> getMoviesByRating(@RequestParam("rating") String rating) {
        return movieService.findMoviesByMovieRatingStartsWith(rating);
    }

    @GetMapping(params = {"personName"})
    public List<Movie> getMoviesByPersonName(@RequestParam("personName") String name){
        return personService.findMoviesByPersonName(name);
    }

    @GetMapping(params = {"year","rating"})
    public List<Movie> getMoviesByPersonName(@RequestParam("year") Integer year,@RequestParam("rating") String rating){
        return movieService.findMoviesByMovieYearAndMovieRatingStartsWith(year,rating);
    }

    @GetMapping("/export")
    public String exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=movies_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Movie> listMovies = movieService.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"ID", "Title", "Description", "Year", "Genre", "Rating", "Roles"};
        String[] nameMapping = {"id", "movieTitle", "movieDescription", "movieYear", "movieGenre", "movieRating", "moviePersonRoles"};

        csvWriter.writeHeader(csvHeader);

        for (Movie movie : listMovies) {
            csvWriter.write(movie, nameMapping);
        }

        csvWriter.close();

        return "Rows Exported: " + listMovies.size();
    }
}
