package com.hava.satistakip.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Bilet işlemleri
 */
@Entity
public class Ticket {
    @Id
    private Long id;
}
