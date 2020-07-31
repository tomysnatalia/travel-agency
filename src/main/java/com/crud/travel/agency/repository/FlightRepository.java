package com.crud.travel.agency.repository;

import com.crud.travel.agency.domain.Flight;

import com.crud.travel.agency.interfaces.FlightInterface;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface FlightRepository extends CrudRepository <Flight, Long>, FlightInterface {
    @Override
    Flight save (Flight flight);

    @Override
    List<Flight> findAll();

    @Override
    void deleteById (Long id);

    @Override
    List<Flight> findByDeparture (String departure);

    @Override
    List<Flight> findByArrival (String arrival);

}


