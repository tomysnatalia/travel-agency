package com.crud.travel.agency.interfaces;

import com.crud.travel.agency.domain.Flight;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightInterface {

    List<Flight> findByDeparture (String departure);

    List<Flight> findByArrival (String arrival);

    List<Flight> findByDepartureDate(LocalDate departureDate);

    List<Flight> findByReturnDate(LocalDate returnDate);

}
