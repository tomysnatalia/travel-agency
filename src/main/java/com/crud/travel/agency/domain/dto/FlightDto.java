package com.crud.travel.agency.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FlightDto {
    private Long id;
    private String departure;
    private String arrival;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private Long flightNumber;
    private Long price;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDto flightDto = (FlightDto) o;
        return Objects.equals(departure, flightDto.departure) &&
                Objects.equals(arrival, flightDto.arrival) &&
                Objects.equals(flightNumber, flightDto.flightNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival, flightNumber);
    }
}

