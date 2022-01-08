package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.domain.Show;
import com.pf7.smdb.domain.Show;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.PersonService;
import com.pf7.smdb.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
public class ShowController extends AbstractController<Show>{
    private  final ShowService showService;
    private  final PersonService personService;

    @Override
    protected BaseService<Show, Long> getBaseService() {
        return showService;
    }

    @GetMapping(params = {"title"})
    public List<Show> getShowsByTitle(@RequestParam("title") String title) {
        return showService.findShowsByShowTitleContains(title);
    }

    @GetMapping(params = {"year"})
    public List<Show> getShowsByYear(@RequestParam("year") Integer year) {
        return showService.findShowsByShowYear(year);
    }

    @GetMapping(params = {"genre"})
    public List<Show> getShowsByGenre(@RequestParam("genre") String genre) {
        return showService.findShowsByShowGenreEquals(genre);
    }

    @GetMapping(params = {"rating"})
    public List<Show> getShowsByRating(@RequestParam("rating") String rating) {
        return showService.findShowsByShowRatingStartsWith(rating);
    }

    @GetMapping(params = {"numberOfEpisodes"})
    public List<Show> getShowsByNumberOfEpisodes(@RequestParam("numberOfEpisodes") Integer episodes) {
        return showService.findShowByShowEpisodesEquals(episodes);
    }

    @GetMapping(params = {"numberOfSeasons"})
    public List<Show> getShowsByNumberOfSeasons(@RequestParam("numberOfSeasons") Integer seasons) {
        return showService.findShowByShowSeasonsEquals(seasons);
    }

    @GetMapping(params = {"personName"})
    public List<Show> getShowsByPersonName(@RequestParam("personName") String name){
        return personService.findShowsByPersonName(name);
    }

    @GetMapping(params = {"year","rating"})
    public List<Show> getShowsByPersonName(@RequestParam("year") Integer year,@RequestParam("rating") String rating){
        return showService.findShowsByShowYearAndShowRatingStartsWith(year,rating);
    }

    @GetMapping("/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=shows_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Show> showList = showService.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);

        String[] csvHeader = {"ID", "Title", "Description", "Year", "Genre","Rating", "Episodes", "Seasons", "Roles"};
        String[] nameMapping = {"id", "showTitle", "showDescription", "showYear", "showGenre", "showRating","showEpisodes","showSeasons", "showPersonRoles"};

        csvWriter.writeHeader(csvHeader);

        for (Show show : showList) {
            csvWriter.write(show, nameMapping);
        }

        csvWriter.writeComment("\nShow Domain Class " +
                "\nRows Exported : " + showList.size());

        csvWriter.close();
    }
}
