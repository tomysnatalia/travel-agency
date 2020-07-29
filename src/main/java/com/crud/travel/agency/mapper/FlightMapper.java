package com.crud.travel.agency.mapper;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.domain.FlightDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapper {

    public Flight mapToFlight(final FlightDto flightDto){
        return new Flight(

                flightDto.getId(),
                flightDto.getDeparture(),
                flightDto.getArrival(),
                flightDto.getPrice());
    }

    public FlightDto mapToFlightDto(final Flight flight) {
        return new FlightDto(
                flight.getId(),
                flight.getDeparture(),
                flight.getArrival(),
                flight.getPrice());
    }

    public List<FlightDto> mapToFlightDtoList(final List<Flight> flightsList) {
        return flightsList.stream()
                .distinct()
                .map(flight -> new FlightDto(flight.getId(), flight.getDeparture(), flight.getArrival(), flight.getPrice()))
                .collect(Collectors.toList());
    }

}
