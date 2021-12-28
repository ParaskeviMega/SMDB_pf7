package com.pf7.smdb.helper;

import javax.persistence.Embeddable;

@Embeddable
public enum PersonRoleEnum {
    ACTOR,
    DIRECTOR,
    PRODUCER,
    MANAGER,
    WRITER;
}
