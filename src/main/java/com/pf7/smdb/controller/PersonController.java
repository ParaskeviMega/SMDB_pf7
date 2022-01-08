package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search/person")
public class PersonController extends AbstractController<Person> {
    private final PersonService personService;

    @Override
    protected BaseService<Person, Long> getBaseService() {
        return personService;
    }

    @GetMapping(params = {"id"})
    public Person getPersonById(@RequestParam("id") Long id) {
        return personService.findPersonById(id);
    }

//    @GetMapping(params = {"name"})
//    public Person getPersonByName(@RequestParam("name") String name) {
//        return personService.findPersonByPersonNameContains(name);
//    }

    @GetMapping(params = {"name"})
    public List<Person> getPeopleByName(@RequestParam("name") String name) {
        return personService.findPeopleByPersonNameContains(name);
    }

    @GetMapping(params = {"born"})
    public List<Person> getPeopleByBorn(@RequestParam("born") Integer born) {
        return personService.findPeopleByPersonBorn(born);
    }

    @GetMapping("/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=people_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Person> personList = personService.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);

        String[] csvHeader = {"ID", "Name", "Born"};
        String[] nameMapping = {"id", "personName", "personBorn"};

        csvWriter.writeHeader(csvHeader);

        for (Person person : personList) {
            csvWriter.write(person, nameMapping);
        }

        csvWriter.writeComment("\nPerson Domain Class " +
                "\nRows Exported : " + personList.size());

        csvWriter.close();
    }

}

