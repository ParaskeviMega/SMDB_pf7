package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Show;
import com.pf7.smdb.helper.CustomObject;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.PersonService;
import com.pf7.smdb.service.ShowService;
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
@RequestMapping("/search/show")
public class ShowController extends AbstractController<Show> {
    private final ShowService showService;
    private final PersonService personService;

    @Override
    protected BaseService<Show, Long> getBaseService() {
        return showService;
    }

    @GetMapping(params = {"title"})
    public ResponseEntity<ApiResponse<List<Show>>> getShowsByTitle(@RequestParam("title") String title) {
        return ResponseEntity.ok(ApiResponse.<List<Show>>builder()
                .data(showService.findShowsByShowTitleContains(title))
                .build());
    }

    @GetMapping(params = {"year"})
    public ResponseEntity<ApiResponse<List<Show>>> getShowsByYear(@RequestParam("year") Integer year) {
        return ResponseEntity.ok(ApiResponse.<List<Show>>builder()
                .data(showService.findShowsByShowYear(year))
                .build());
    }

    @GetMapping(params = {"genre"})
    public ResponseEntity<ApiResponse<List<Show>>> getShowsByGenre(@RequestParam("genre") String genre) {
        return ResponseEntity.ok(ApiResponse.<List<Show>>builder()
                .data(showService.findShowsByShowGenreEquals(genre))
                .build());
    }

    @GetMapping(params = {"rating"})
    public ResponseEntity<ApiResponse<List<Show>>> getShowsByRating(@RequestParam("rating") String rating) {
        return ResponseEntity.ok(ApiResponse.<List<Show>>builder()
                .data(showService.findShowsByShowRatingStartsWith(rating))
                .build());
    }

    @GetMapping(params = {"numberOfEpisodes"})
    public ResponseEntity<ApiResponse<List<Show>>> getShowsByNumberOfEpisodes(@RequestParam("numberOfEpisodes") Integer episodes) {
        return ResponseEntity.ok(ApiResponse.<List<Show>>builder()
                .data(showService.findShowByShowEpisodesEquals(episodes))
                .build());
    }

    @GetMapping(params = {"numberOfSeasons"})
    public ResponseEntity<ApiResponse<List<Show>>> getShowsByNumberOfSeasons(@RequestParam("numberOfSeasons") Integer seasons) {
        return ResponseEntity.ok(ApiResponse.<List<Show>>builder()
                .data(showService.findShowByShowSeasonsEquals(seasons))
                .build());
    }

    @GetMapping(params = {"personName"})
    public ResponseEntity<ApiResponse<List<Show>>> getShowsByPersonName(@RequestParam("personName") String name) {
        return ResponseEntity.ok(ApiResponse.<List<Show>>builder()
                .data(personService.findShowsByPersonName(name))
                .build());
    }

    @GetMapping(params = {"personName","personRole"})
    public ResponseEntity<ApiResponse<List<Show>>> getShowsByPersonNameAndByPersonRole(@RequestParam("personName") String name, @RequestParam("personRole") String role) {
        return ResponseEntity.ok(ApiResponse.<List<Show>>builder()
                .data(personService.findShowsByPersonNameAndPersonRole(name,role))
                .build());
    }

    @GetMapping(params = {"year", "rating"})
    public ResponseEntity<ApiResponse<List<Show>>> getShowsByYearAndRatingStartsWith(@RequestParam("year") Integer year, @RequestParam("rating") String rating) {
        return ResponseEntity.ok(ApiResponse.<List<Show>>builder()
                .data(showService.findShowsByShowYearAndShowRatingStartsWith(year, rating))
                .build());
    }

    @GetMapping("/export")
    public String exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=shows_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Show> showList = showService.findAll();

        try (ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE)) {

            String[] csvHeader = {"ID", "Title", "Description", "Year", "Genre", "Rating", "Episodes", "Seasons", "Roles"};
            String[] nameMapping = {"id", "showTitle", "showDescription", "showYear", "showGenre", "showRating", "showEpisodes", "showSeasons", "showPersonRoles"};

            csvWriter.writeHeader(csvHeader);

            for (Show show : showList) {
                csvWriter.write(show, nameMapping);
            }

            csvWriter.writeComment("\nShow Domain Class " +
                    "\nRows Exported : " + showList.size());

        } catch (Exception e) {
            logger.info("{}", e.getMessage());
        } finally {
            return "Rows Exported : " + showList.size();
        }

    }

    @GetMapping(params = {"topRatedShows"})
    public ResponseEntity<ApiResponse<List<Show>>> getXTopRatedShows(@RequestParam("topRatedShows") Integer x) {
        return ResponseEntity.ok(ApiResponse.<List<Show>>builder()
                .data(showService.findXTopRatedShows(x))
                .build());
    }

    @GetMapping(path = {"numberofShowsPerGenre"})
    public ResponseEntity<ApiResponse<List<CustomObject.KeyValueObj>>> getNumberOfShowsPerGenre() {
        return ResponseEntity.ok(ApiResponse.<List<CustomObject.KeyValueObj>>builder()
                .data(showService.findNumberOfShowsPerGenre())
                .build());
    }

    @GetMapping(path = {"numberofShowsPerYearPerGenre"})
    public ResponseEntity<ApiResponse<List<CustomObject.KeyValueObj2>>> getNumberOfShowsPerYearPerGenre() {
        return ResponseEntity.ok(ApiResponse.<List<CustomObject.KeyValueObj2>>builder()
                .data(showService.findNumberOfShowsPerYearPerGenre())
                .build());
    }
}
