package com.pf7.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor CAUSE NO VARIABLES
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity()
@Table(name = "FILMS")
@SequenceGenerator(name = "idGenerator", sequenceName = "FILMS_SEQ", allocationSize = 1)
public class Film extends Movie{

}
