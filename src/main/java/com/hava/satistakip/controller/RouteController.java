package com.hava.satistakip.controller;

import com.hava.satistakip.model.Route;
import com.hava.satistakip.repository.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("route")
public class RouteController {
    @Autowired
    private IRouteRepository routeRepository;

    @RequestMapping("/saveOrUpdate")
    public Route saveorUpdateAirport(@RequestBody Route route) {
        return routeRepository.save(route);
    }

    @RequestMapping("/findAll")
    public List<Route> findAll(@RequestParam String search) {
        return routeRepository.search(search);
    }
}
