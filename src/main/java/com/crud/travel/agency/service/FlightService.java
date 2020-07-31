package com.crud.travel.agency.service;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight saveFlight (final Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(final Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> getFlightByDeparture(final String departure) {
        return flightRepository.findByDeparture(departure);
    }


    public List<Flight> getFlightByArrival(final String arrival) {
        return flightRepository.findByArrival(arrival);
    }
}