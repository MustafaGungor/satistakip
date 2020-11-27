package com.hava.satistakip.repository;

import com.hava.satistakip.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirportRepository extends JpaRepository<Airport,Long> {
}
