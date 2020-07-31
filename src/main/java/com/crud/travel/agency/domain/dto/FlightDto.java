package com.crud.travel.agency.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
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
    int price;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDto flightDto = (FlightDto) o;
        return departure.equals(flightDto.departure) &&
                arrival.equals(flightDto.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival);
    }
}
