package com.hava.satistakip.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Havayolu uçuş tanımlama, arama işlemleri
 */
@Entity
public class Flight {
    @Id
    private Long id;
    private String name;
    private Boolean active;

    public Flight() {
    }

    public Flight(Long id, String name, Boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
