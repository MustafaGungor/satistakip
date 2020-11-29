package com.hava.satistakip.model;

import javax.persistence.*;

/**
 * Havaalanı Rota ekleme ve arama işlemleri
 */
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @OneToOne
    private Airport goingAirport;
    @OneToOne
    private Airport arriveAirport;

    public Route() {
    }

    public Route(Long id,String description,Airport goingAirport,Airport arriveAirport) {
        this.id = id;
        this.description = description;
        this.goingAirport = goingAirport;
        this.arriveAirport = arriveAirport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Airport getGoingAirport() {
        return goingAirport;
    }

    public void setGoingAirport(Airport goingAirport) {
        this.goingAirport = goingAirport;
    }

    public Airport getArriveAirport() {
        return arriveAirport;
    }

    public void setArriveAirport(Airport arriveAirport) {
        this.arriveAirport = arriveAirport;
    }
}
