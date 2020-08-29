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
                query = "Update reservation set hotel_price = ((select duration * adult from hotels where id = hotel_id) * (adults)+ (select duration * kid from hotels where id = hotel_id) * (kids));",
                resultClass = Reservation.class),

        @NamedNativeQuery(
                name = "Reservation.getHotelPriceWithFlight",
                query = "Update reservation set hotel_price_with_flight = ((select (adults + kids) * price from flights where id = flight_id) + hotel_price);",
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

    @Column(name = "hotelPrice")
    private Long hotelPrice;

    @Column(name = "deposit")
    private Long deposit;

    @Column(name = "paymentStatus")
    private String paymentStatus;

    @Column(name = "depositStatus",length = 3000)
    private String depositStatus;

    @Column(name = "paymentday")
    private LocalDate paymentDate;

    @Column(name = "hotel_price_with_flight")
    private Long hotelPriceWithFlight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
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

