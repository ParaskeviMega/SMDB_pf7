package com.pf7.smdb.helper;


import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.domain.Show;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PersonParticipation {

    private Set<Movie> movieSet;

    private Set<Show> showSet;

}
