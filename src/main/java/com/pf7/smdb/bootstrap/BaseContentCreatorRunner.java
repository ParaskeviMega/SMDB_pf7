package com.pf7.smdb.bootstrap;

import com.pf7.smdb.base.AbstractLogComponent;
import com.pf7.smdb.domain.Person;
import com.pf7.smdb.domain.PersonRole;
import com.pf7.smdb.service.FilmService;
import com.pf7.smdb.service.PersonService;
import com.pf7.smdb.service.TVShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Profile("base-content-creator")
@RequiredArgsConstructor
public class BaseContentCreatorRunner extends AbstractLogComponent implements CommandLineRunner {
	private final PersonService personService;
	private final FilmService filmService;
	private final TVShowService tvShowService;

	@Override
	public void run(String... args) throws Exception {
		//@formatter:off
		//Set<PersonRole> example = Set.of(PersonRole.ACTOR, PersonRole.PRODUCER);

		List<Person> Persons = List.of(
				Person.builder().name("Dimitris").surname("Linarakis").bio("").born("1998").personRoles(Set.of(PersonRole.ACTOR, PersonRole.PRODUCER)).build());

		//logger.info("Created {} Persons.", PersonService.createAll(Persons).size());



	}
}
