package com.crud.travel.agency.mapper;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.domain.dto.FlightDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FlightMapper {

    public Flight mapToFlight(final FlightDto flightDto){
        return new Flight(
                flightDto.getId(),
                flightDto.getDeparture(),
                flightDto.getArrival(),
                flightDto.getDepartureDate(),
                flightDto.getReturnDate(),
                flightDto.getFlightNumber(),
                flightDto.getPrice());
    }

    public FlightDto mapToFlightDto(final Flight flight) {
        return new FlightDto(
                flight.getId(),
                flight.getDeparture(),
                flight.getArrival(),
                flight.getDepartureDate(),
                flight.getReturnDate(),
                flight.getFlightNumber(),
                flight.getPrice());
    }

    public List<FlightDto> mapToFlightDtoList(final List<Flight> flightsList) {
        return flightsList.stream()
                .map(this::mapToFlightDto)
                .collect(Collectors.toList());
    }
}
