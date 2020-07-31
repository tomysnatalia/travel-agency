package com.crud.travel.agency.interfaces;

import com.crud.travel.agency.domain.Flight;

import java.util.List;

public interface FlightInterface {

    List<Flight> findByDeparture (String departure);

    List<Flight> findByArrival (String arrival);
}
