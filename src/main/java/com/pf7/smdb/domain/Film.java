package com.pf7.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Films")
@SequenceGenerator(name = "idGenerator", sequenceName = "FILMS_SEQ", initialValue = 1, allocationSize = 1)
public class Film extends Movie{
    @NotNull(message = "Year2 cannot be null.")
    @Column(length = 4, nullable = false)
    private Integer year2;
}
