package com.crud.travel.agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor

@NamedNativeQueries ({

        @NamedNativeQuery(
                name = "Reservation.getHotelPrice",
                query = "Update reservation set hotel_price = ((select duration * adult from hotels where hotel_id = id) * (adults)+ (select duration * kid from hotels where hotel_id = id) * (kids));",
                resultClass = Reservation.class),

        @NamedNativeQuery(
                name = "Reservation.getHotelPriceWithFlight",
                query = "Update reservation set hotel_price_with_flight = ((select (adults + kids) * price from flights where flight_id = id) + hotel_price);",
                resultClass = Reservation.class)

})

@Entity
@Table (name = "reservation")
public class Reservation {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "flight_id")
    private Long flight;

    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "adults")
    private int numberOfAdults;

    @Column(name = "kids")
    private int numberOfKids;

    @Column(name = "hotelPrice")
    private int hotelPrice;

    @Column(name = "deposit")
    private int deposit;

    @Column(name = "paymentStatus")
    private boolean paymentStatus;

    @Column(name = "depositStatus")
    private boolean paymentDepositStatus;

    @Column(name = "paymentday")
    private LocalDate paymentDate;

    @Column(name = "hotel_price_with_flight")
    private int hotelPriceWithFlight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFlight(Long flight) {
        this.flight = flight;
    }

    public void setHotel(Long hotelId) {
        this.hotelId = hotelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public void setNumberOfKids(int numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

    public void setTotalHotelPrice(int hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentDepositStatus(boolean paymentDepositStatus) {
        this.paymentDepositStatus = paymentDepositStatus;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setHotelPriceWithFlight(int hotelPriceWithFlight) {
        this.hotelPriceWithFlight = hotelPriceWithFlight;
    }



}
