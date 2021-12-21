package com.pf7.smdb.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company extends BaseModel{


    private String name;

    private String address;

    private String phone;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride( name = "firstName", column = @Column(name = "contact_first_name")),
            @AttributeOverride( name = "lastName", column = @Column(name = "contact_last_name")),
            @AttributeOverride( name = "phone", column = @Column(name = "contact_phone"))
    })
    private ContactPerson contactPerson;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }
}