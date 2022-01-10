package com.pf7.smdb.helper;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.domain.Show;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
public class CustomObject {

    @Getter
    @Setter
    public static class PersonParticipation {
        private Set<Movie> movieSet = new HashSet<>();
        private Set<Show> showSet = new HashSet<>();
    }

    @Getter
    @Setter
    public static class GenreOccurrence {
        private String genre;
        private Integer occurrences;
    }

    @Getter
    @Setter
    public static class GenreYearOccurence {
        private String genre;
        private String Year;
        private Integer occurrences;
    }

    @Getter
    @Setter
    public static class IndividualPerGenre {
        private String genre;
        private Set<Movie> movieSet = new HashSet<>();
        private Set<Show> showSet = new HashSet<>();
    }
}
