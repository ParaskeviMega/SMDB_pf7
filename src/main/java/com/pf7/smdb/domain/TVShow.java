package com.pf7.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity()
@Table(name = "TVSHOWS")
@SequenceGenerator(name = "idGenerator", sequenceName = "SHOWS_SEQ", allocationSize = 1)
public class TVShow extends Movie{
    @NotNull(message = "Season cannot be null.")
    @Column(nullable = false)
    private Integer season;

    @NotNull(message = "Episodes cannot be null.")
    @Column(nullable = false)
    private Integer episodes;
}
