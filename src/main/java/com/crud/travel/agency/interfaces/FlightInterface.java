package com.crud.travel.agency.interfaces;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.domain.FlightDto;

import java.util.List;
import java.util.Optional;

public interface FlightInterface {

   List<Flight> findByDeparture (String departure);

    List<Flight> findByArrival (String arrival);
}
