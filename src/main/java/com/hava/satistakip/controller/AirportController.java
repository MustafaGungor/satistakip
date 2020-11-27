package com.hava.satistakip.controller;

import com.hava.satistakip.model.Airport;
import com.hava.satistakip.repository.IAirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("airport")
public class AirportController {

    @Autowired
    private IAirportRepository airportRepository;

    @RequestMapping("/saveOrUpdate")
    public Airport saveorUpdateAirport(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

    @RequestMapping("/findAll")
    public List<Airport> findAll(@RequestParam String search) {
        return airportRepository.findAll();
    }


}
