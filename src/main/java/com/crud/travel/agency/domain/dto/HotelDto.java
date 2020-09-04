package com.crud.travel.agency.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HotelDto {
    private Long id;
    private String hotelName;
    private String locationCountry;
    private String locationCity;
    private String closerAirport;
    private String hotelOfficialRating;
    private Long pricePerNightForAdult;
    private Long pricePerNightForKid;
    private String foodOption;
    private Long duration;
    private LocalDate departureDate;
    private LocalDate returnDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelDto hotelDto = (HotelDto) o;
        return Objects.equals(hotelName, hotelDto.hotelName) &&
                Objects.equals(locationCountry, hotelDto.locationCountry) &&
                Objects.equals(locationCity, hotelDto.locationCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelName, locationCountry, locationCity);
    }
}
