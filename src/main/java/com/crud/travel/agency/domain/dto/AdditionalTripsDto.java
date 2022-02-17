package com.crud.travel.agency.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class AdditionalTripsDto {

    private Long id;
    private Long numberOfParticipant;
    private LocalDate tripDate;
    private Long tripPrice;
    private Long forAll;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalTripsDto that = (AdditionalTripsDto) o;
        return Objects.equals(id, that.id) && Objects.equals(numberOfParticipant, that.numberOfParticipant) && Objects.equals(tripDate, that.tripDate) && Objects.equals(tripPrice, that.tripPrice) && Objects.equals(forAll, that.forAll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfParticipant, tripDate, tripPrice, forAll);
    }
}
