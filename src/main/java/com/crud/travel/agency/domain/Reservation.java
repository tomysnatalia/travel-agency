package com.crud.travel.agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@NamedNativeQueries ({

        @NamedNativeQuery(
                name = "Reservation.getHotelPrice",
                query = "Update reservation set hotel_price = ((select duration * adult from hotels where id = hotel_id) * (adults)+ (select duration * kid from hotels where id = hotel_id) * (kids));"),


        @NamedNativeQuery(
                name = "Reservation.getHotelPriceWithFlight",
                query = "Update reservation set hotel_price_with_flight = (flight_price + hotel_price);"),


        @NamedNativeQuery(
                name = "Reservation.getFlightPrice",
                query = "Update reservation set flight_price = (select (adults + kids) * price from flights where id = flight_id);"),

        @NamedNativeQuery(
                name = "Reservation.getDeposit",
                query = "Update reservation set deposit = (select hotel_price * 0.20);"),

        @NamedNativeQuery(
                name = "Reservation.getPaymentDate",
                query = "Update reservation set payment_date = ((select departure_date from hotels where id = hotel_id) - (14));"),

})

@Entity(name = "reservation")
public class Reservation {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "flight_id")
    private Long flightId;

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
    private Long numberOfAdults;

    @Column(name = "kids")
    private Long numberOfKids;

    @Column(name = "hotel_price")
    private Long hotelPrice;

    @Column(name = "flight_price")
    private Long flightPrice;

    @Column(name = "deposit")
    private Long deposit;

    @Column(name = "paymentStatus")
    private String paymentStatus;

    @Column(name = "depositStatus")
    private String depositStatus;

    @Column(name = "paymentDate")
    private LocalDate paymentDate;

    @Column(name = "hotel_price_with_flight")
    private Long totalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return  flightId.equals(that.flightId) &&
                hotelId.equals(that.hotelId) &&
                name.equals(that.name) &&
                surname.equals(that.surname) &&
                email.equals(that.email) &&
                phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId, hotelId, name, surname, email, phoneNumber, numberOfAdults, numberOfKids, hotelPrice, flightPrice, deposit, paymentStatus, depositStatus, paymentDate, totalPrice);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", hotelId=" + hotelId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", numberOfAdults=" + numberOfAdults +
                ", numberOfKids=" + numberOfKids +
                ", hotelPrice=" + hotelPrice +
                ", flightPrice=" + flightPrice +
                ", deposit=" + deposit +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", depositStatus='" + depositStatus + '\'' +
                ", paymentDate=" + paymentDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}


