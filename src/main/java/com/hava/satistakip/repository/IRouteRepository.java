package com.hava.satistakip.repository;

import com.hava.satistakip.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRouteRepository extends JpaRepository<Route,Long> {
}
