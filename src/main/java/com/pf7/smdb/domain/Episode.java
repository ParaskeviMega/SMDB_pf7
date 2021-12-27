package com.pf7.smdb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "EPISODES_SEQ", allocationSize = 1)
public class Episode extends BaseModel{

    @NotNull(message = "Season cannot be null.")
    @Column(nullable = false)
    private String title;

    @NotNull(message = "Season cannot be null.")
    @Column(nullable = false)
    private Integer season;

}
