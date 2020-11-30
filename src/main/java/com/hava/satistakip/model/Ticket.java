package com.hava.satistakip.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Bilet işlemleri
 */
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ticketNumber;
    private String cardNumber;
    private Date salesDate;
    private Double priceTicket;
    @OneToOne
    private Flight flight;
    private boolean active;
    private boolean isSale;
    private String name;
    private String surname;
    private String phoneNumber;

    public Ticket() {
    }

    public Ticket(Long id,String ticketNumber,String cardNumber,Date salesDate,Double priceTicket,Flight flight,
                  boolean active,boolean isSale,String name,String surname,String phoneNumber){
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.cardNumber = cardNumber;
        this.salesDate = salesDate;
        this.priceTicket = priceTicket;
        this.flight = flight;
        this.active = active;
        this.isSale = isSale;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
