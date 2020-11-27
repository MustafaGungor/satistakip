package com.hava.satistakip.model.common;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * İl , vilayet tanımları
 */
@Entity
public class Province {
    @Id
    private Long id;
    private String name;
    private boolean active;
    @OneToOne
    @JoinColumn(name = "country_id",referencedColumnName = "id")
    private Country country;

    public Province() {
    }

    public Province(Long id, String name, boolean active, Country country) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.country = country;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
