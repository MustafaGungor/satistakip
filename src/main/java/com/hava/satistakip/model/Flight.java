package com.hava.satistakip.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Havayolu uçuş tanımlama, arama işlemleri
 */
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Boolean active;
    @OneToOne
    private Route route;
    private Date flightDate;
    private Integer quota;
    private Double price;

    public Flight() {
    }

    public Flight(Long id, String name, Boolean active,Route route,Date flightDate,Integer quota,Double price) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.route = route;
        this.flightDate = flightDate;
        this.quota = quota;
        this.price = price;
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

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
