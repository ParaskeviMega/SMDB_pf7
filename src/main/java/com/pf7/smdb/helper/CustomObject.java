package com.pf7.smdb.helper;

import com.pf7.smdb.domain.Movie;
import com.pf7.smdb.domain.Show;
import lombok.*;

import java.util.Set;

@Data
public class CustomObject {

    @Getter
    @Setter
    public static class PersonParticipation {
        private Set<Movie> movieSet;
        private Set<Show> showSet;
    }

    @Getter
    @Setter
    public static class KeyValueObj {
        private String genre;
        private Integer occurrences;
    }

    @Getter
    @Setter
    public static class KeyValueObj2 {
        private String genre;
        private String Year;
        private Integer occurrences;
    }
}
