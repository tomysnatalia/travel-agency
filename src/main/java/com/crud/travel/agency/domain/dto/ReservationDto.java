package com.crud.travel.agency.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReservationDto {
    private Long id;
    private Long flightId;
    private Long hotelId;

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Long numberOfAdults;
    private Long numberOfKids;
    private Long hotelPrice;
    private Long deposit;
    private String paymentStatus;
    private String depositStatus;
    private LocalDate paymentDate;
    private Long hotelPriceWithFlight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDto that = (ReservationDto) o;
        return id.equals(that.id) &&
                flightId.equals(that.flightId) &&
                hotelId.equals(that.hotelId) &&
                name.equals(that.name) &&
                surname.equals(that.surname) &&
                email.equals(that.email) &&
                phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId, hotelId, name, surname, email, phoneNumber);
    }
}
