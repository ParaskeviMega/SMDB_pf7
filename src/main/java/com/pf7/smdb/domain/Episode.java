package com.pf7.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Entity
@Table(name = "EPISODES")
@SequenceGenerator(name = "idGenerator", sequenceName = "EPISODES_SEQ", allocationSize = 1)
public class Episode extends BaseModel{

    //@NotNull(message = "Season cannot be null.")
    @Column(nullable = false)
    private String title;

    //@NotNull(message = "Season cannot be null.")
    @Column(nullable = false)
    private Integer season;

}
