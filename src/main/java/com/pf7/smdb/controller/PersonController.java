package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Person;
import com.pf7.smdb.helper.CustomObject;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.PersonService;
import com.pf7.smdb.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/person/search")
public class PersonController extends AbstractController<Person> {
    private final PersonService personService;

    @Override
    protected BaseService<Person, Long> getBaseService() {
        return personService;
    }


    @GetMapping(params = {"id"})
    public ResponseEntity<ApiResponse<Person>> getPersonById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(ApiResponse.<Person>builder()
                .data(personService.findPersonById(id))
                .build());
    }


    @GetMapping(params = {"name"})
    public ResponseEntity<ApiResponse<List<Person>>> getPeopleByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(ApiResponse.<List<Person>>builder()
                .data(personService.findPeopleByPersonNameContains(name))
                .build());
    }

    @GetMapping(params = {"born"})
    public ResponseEntity<ApiResponse<List<Person>>> getPeopleByBorn(@RequestParam("born") Integer born) {
        return ResponseEntity.ok(ApiResponse.<List<Person>>builder()
                .data(personService.findPeopleByPersonBorn(born))
                .build());
    }

    @GetMapping(path = "/participation", params = {"name"})
    public ResponseEntity<ApiResponse<CustomObject.PersonParticipation>> getAllParticipationsByPersonName(@RequestParam("name") String name) {
        return ResponseEntity.ok(ApiResponse.<CustomObject.PersonParticipation>builder()
                .data(personService.findAllParticipationsByPersonName(name))
                .build());
    }

    @GetMapping(path = "/participationByRole", params = {"name","role"})
    public ResponseEntity<ApiResponse<CustomObject.PersonParticipation>> getAllParticipationsByPersonNameAndByPersonRole(@RequestParam("name") String name, @RequestParam("role") String role) {
        return ResponseEntity.ok(ApiResponse.<CustomObject.PersonParticipation>builder()
                .data(personService.findAllParticipationsByPersonNameAndByPersonRole(name,role))
                .build());
    }

    @GetMapping(path = "/individualParticipationPerGenre", params = "name")
    public ResponseEntity<ApiResponse<List<CustomObject.IndividualPerGenre>>> getAllParticipationsByPersonNamePerGenre(@RequestParam("name") String name) {
        return ResponseEntity.ok(ApiResponse.<List<CustomObject.IndividualPerGenre>>builder()
                .data(personService.findAllParticipationsByIndividualPerGenre(name))
                .build());
    }

    @GetMapping("/export")
    public String exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=people_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Person> personList = personService.findAll();

        try (ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE)) {

            String[] csvHeader = {"ID", "Name", "Born"};
            String[] nameMapping = {"id", "personName", "personBorn"};

            csvWriter.writeHeader(csvHeader);

            for (Person person : personList) {
                csvWriter.write(person, nameMapping);
            }

            csvWriter.writeComment("\nPerson Domain Class " +
                    "\nRows Exported : " + personList.size());

        } catch (Exception e) {
            logger.info("{}", e.getMessage());
        }finally {
            return "Rows Exported : " + personList.size();
        }
    }
}

