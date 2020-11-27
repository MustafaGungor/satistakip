package com.hava.satistakip.repository;

import com.hava.satistakip.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlightRepository extends JpaRepository<Flight,Long> {
}
