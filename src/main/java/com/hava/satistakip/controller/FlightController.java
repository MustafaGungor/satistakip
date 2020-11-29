package com.hava.satistakip.controller;

import com.hava.satistakip.model.Flight;
import com.hava.satistakip.repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("flight")
public class FlightController {
    @Autowired
    private IFlightRepository flightRepository;

    @RequestMapping("/saveOrUpdate")
    public Flight saveorUpdateAirport(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    @RequestMapping("/findAll")
    public List<Flight> findAll(@RequestParam String search) {
        return flightRepository.search(search);
    }
}
