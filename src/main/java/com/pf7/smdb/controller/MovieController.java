package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.helper.CustomObject;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.MovieService;
import com.pf7.smdb.service.PersonService;
import com.pf7.smdb.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<List<Movie>>> getByMovieTitle(@RequestParam("title") String title) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder()
                .data(movieService.findMoviesByMovieTitleContains(title))
                .build());
    }

    @GetMapping(params = {"year"})
    public ResponseEntity<ApiResponse<List<Movie>>> getMoviesByYear(@RequestParam("year") Integer year) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder()
                .data(movieService.findMoviesByMovieYear(year))
                .build());
    }

    @GetMapping(params = {"genre"})
    public ResponseEntity<ApiResponse<List<Movie>>> getMoviesByGenre(@RequestParam("genre") String genre) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder()
                .data(movieService.findMoviesByMovieGenreContains(genre))
                .build());
    }

    @GetMapping(params = {"rating"})
    public ResponseEntity<ApiResponse<List<Movie>>> getMoviesByRating(@RequestParam("rating") String rating) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder()
                .data(movieService.findMoviesByMovieRatingStartsWith(rating))
                .build());
    }

    @GetMapping(params = {"personName"})
    public ResponseEntity<ApiResponse<List<Movie>>> getMoviesByPersonName(@RequestParam("personName") String name) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder()
                .data(personService.findMoviesByPersonName(name))
                .build());
    }

    @GetMapping(params = {"personName","personRole"})
    public ResponseEntity<ApiResponse<List<Movie>>> getMoviesByPersonNameAndByPersonRole(@RequestParam("personName") String name, @RequestParam("personRole") String role) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder()
                .data(personService.findMoviesByPersonNameAndPersonRole(name,role))
                .build());
    }

    @GetMapping(params = {"year", "rating"})
    public ResponseEntity<ApiResponse<List<Movie>>> getMoviesByYearAndRatingStartsWith(@RequestParam("year") Integer year, @RequestParam("rating") String rating) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder()
                .data(movieService.findMoviesByMovieYearAndMovieRatingStartsWith(year, rating))
                .build());
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

        try (ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE)) {

            String[] csvHeader = {"ID", "Title", "Description", "Year", "Genre", "Rating", "Roles"};
            String[] nameMapping = {"id", "movieTitle", "movieDescription", "movieYear", "movieGenre", "movieRating", "moviePersonRoles"};

            csvWriter.writeHeader(csvHeader);

            for (Movie movie : listMovies) {
                csvWriter.write(movie, nameMapping);
            }

            csvWriter.writeComment("\nMovie Domain Class " +
                    "\nRows Exported : " + listMovies.size());

        } catch (Exception e) {
            logger.info("{}", e.getMessage());
        } finally {
            return "Rows Exported : " + listMovies.size();
        }
    }

    @GetMapping(params = {"topRatedMovies"})
    public ResponseEntity<ApiResponse<List<Movie>>> getXTopRatedMovies(@RequestParam("topRatedMovies") Integer x) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder()
                .data(movieService.findXTopRatedMovies(x))
                .build());
    }

    @GetMapping(path = {"numberofMoviesPerGenre"})
    public ResponseEntity<ApiResponse<List<CustomObject.GenreOccurrence>>> getNumberOfShowsPerGenre() {
        return ResponseEntity.ok(ApiResponse.<List<CustomObject.GenreOccurrence>>builder()
                .data(movieService.findNumberOfMoviesPerGenre())
                .build());
    }

    @GetMapping(path = {"numberofMoviesPerYearPerGenre"})
    public ResponseEntity<ApiResponse<List<CustomObject.GenreYearOccurence>>> getNumberOfShowsPerYearPerGenre() {
        return ResponseEntity.ok(ApiResponse.<List<CustomObject.GenreYearOccurence>>builder()
                .data(movieService.findNumberOfMoviesPerYearPerGenre())
                .build());
    }

    @GetMapping(path = "/individualParticipationPerGenre", params = "name")
    public ResponseEntity<ApiResponse<List<CustomObject.IndividualPerGenre>>> getAllParticipationsByPersonNameAndByPersonRole(@RequestParam("name") String name) {
        return ResponseEntity.ok(ApiResponse.<List<CustomObject.IndividualPerGenre>>builder()
                .data(personService.findAllParticipationsByIndividualPerGenre(name))
                .build());
    }

}
