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
@Entity(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "departures")
    private String departure;

    @NotNull
    @Column(name = "arrivals")
    private String arrival;

    @Column(name = "departureDate")
    private LocalDate departureDate;

    @Column(name = "returnDay")
    private LocalDate returnDate;

    @Column(name = "flightNumber")
    private String flightNumber;

    @Column(name = "price")
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departure, flight.departure) &&
                Objects.equals(arrival, flight.arrival) &&
                Objects.equals(flightNumber, flight.flightNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival, flightNumber);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
