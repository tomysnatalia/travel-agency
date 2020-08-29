package com.crud.travel.agency.repository;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.interfaces.FlightInterface;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends CrudRepository <Flight, Long>, FlightInterface {
    @Override
    Flight save(Flight flight);

    @Override
    Optional<Flight> findById(Long id);

    @Override
    List<Flight> findAll();

    @Override
    void deleteById(Long id);

    @Override
    List<Flight> findByDeparture(String departure);

    @Override
    List<Flight> findByArrival(String arrival);

    @Override
    List<Flight> findByFlightNumber(String flightNumber);

    @Override
    List<Flight> findByDepartureDate(LocalDate departureDate);

    @Override
    List<Flight> findByReturnDate(LocalDate returnDate);
}


