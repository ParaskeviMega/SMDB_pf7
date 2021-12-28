package com.pf7.smdb.domain;

import com.pf7.smdb.helper.PersonRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersonRole extends BaseModel{

    private PersonRoleEnum personRoleEnum;
}
