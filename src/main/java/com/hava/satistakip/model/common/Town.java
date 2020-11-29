package com.hava.satistakip.model.common;

import javax.persistence.*;

/**
 * İlçe tanımları
 */
@Entity
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean active;
    @OneToOne
    @JoinColumn(name = "province_id",referencedColumnName = "id")
    private Province province;

    public Town() {
    }

    public Town(Long id, String name, boolean active, Province province) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.province = province;
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
