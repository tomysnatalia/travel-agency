package com.crud.travel.agency.domain.dto;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.domain.Hotel;
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
    private int numberOfAdults;
    private int numberOfKids;
    private int hotelPrice;
    private int deposit;
    private boolean paymentStatus;
    private boolean paymentDepositStatus;
    private LocalDate paymentDate;
    private int hotelPriceWithFlight;

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
