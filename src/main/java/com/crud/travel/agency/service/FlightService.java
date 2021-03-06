package com.crud.travel.agency.service;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.repository.FlightRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> findByDeparture(final String departure) { return flightRepository.findByDeparture(departure); }

    public List<Flight> findByArrival(final String arrival) {
        return flightRepository.findByArrival(arrival);
    }

    public Flight findById(final Long id) throws TravelAgencyNotFoundException { return flightRepository.findById(id).orElseThrow(TravelAgencyNotFoundException::new); }

    public Flight saveFlight (final Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(final Long id) {
        flightRepository.deleteById(id);
    }
}