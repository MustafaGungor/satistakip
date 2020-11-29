package com.hava.satistakip.repository;

import com.hava.satistakip.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRouteRepository extends JpaRepository<Route,Long> {
    @Query(value = "SELECT ID,DESCRIPTION,ARRIVE_AIRPORT_ID,GOING_AIRPORT_ID FROM ROUTE WHERE DESCRIPTION LIKE %?%",nativeQuery = true)
    List<Route> search(String search);
}
