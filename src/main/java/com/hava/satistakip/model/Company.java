package com.hava.satistakip.model;

import javax.persistence.*;

/**
 * Havayolu şirketi ekleme ve arama işlemleri
 */
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Boolean active;
    @OneToOne
    private Airport airport;

    public Company() {
    }

    public Company(Long id, String name, Boolean active,Airport airport) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.airport = airport;
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

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
