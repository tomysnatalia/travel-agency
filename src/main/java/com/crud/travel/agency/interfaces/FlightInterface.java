package com.crud.travel.agency.interfaces;

import com.crud.travel.agency.domain.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public interface FlightInterface {

   List<Flight> findByDeparture (String departure);

   List<Flight> findByArrival (String arrival);
}
