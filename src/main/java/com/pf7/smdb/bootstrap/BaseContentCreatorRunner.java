package com.pf7.smdb.bootstrap;

import com.pf7.smdb.base.AbstractLogComponent;
import com.pf7.smdb.domain.*;
import com.pf7.smdb.service.FilmService;
import com.pf7.smdb.service.PersonService;
import com.pf7.smdb.service.TVShowService;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.profile.Association;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
;
import java.util.List;

@Component
//@Profile("base-content-creator")
@RequiredArgsConstructor
public class BaseContentCreatorRunner extends AbstractLogComponent implements CommandLineRunner {
	private final PersonService personService;
	private final FilmService filmService;
	private final TVShowService tvShowService;
//	private final BaseModel id;

	@Override
	public void run(String... args) throws Exception {
		//@formatter:off

		List<Person> people = List.of(
				Person.builder().name("Dimitris").surname("Linarakis").bio("").born("1998").build());

//		List<...> contributions = List.of(
//				Contribution.builder().id(Long id).build()
//		);
	}
}
