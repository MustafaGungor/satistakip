package com.hava.satistakip.model;

import com.hava.satistakip.model.common.Town;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Havaalanı ekleme ve arama işlemleri
 */
@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Boolean active;
    @OneToOne
    private Town town;

    public Airport() {
    }

    public Airport(Long id,String name,Boolean active,Town town){
        this.id = id;
        this.name = name;
        this.active = active;
        this.town = town;
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

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
