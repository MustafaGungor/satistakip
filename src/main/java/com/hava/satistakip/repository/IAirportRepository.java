package com.hava.satistakip.repository;

import com.hava.satistakip.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAirportRepository extends JpaRepository<Airport,Long> {
    @Query(value = "SELECT ID,NAME,ACTIVE,TOWN_ID FROM AIRPORT WHERE NAME LIKE %?%",nativeQuery = true)
    List<Airport> search(String search);
}
