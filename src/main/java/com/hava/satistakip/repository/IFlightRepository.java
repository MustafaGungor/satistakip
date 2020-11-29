package com.hava.satistakip.repository;

import com.hava.satistakip.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlightRepository extends JpaRepository<Flight,Long> {
    @Query(value = "SELECT ID,NAME,ROUTE_ID,FLIGHT_DATE,ACTIVE FROM FLIGHT WHERE NAME LIKE %?%",nativeQuery = true)
    List<Flight> search(String search);
}
