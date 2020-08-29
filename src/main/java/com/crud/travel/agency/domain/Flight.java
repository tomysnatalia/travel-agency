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
    private Long flightNumber;

    @Column(name = "price")
    private Long price;

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

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", departureDate=" + departureDate +
                ", returnDate=" + returnDate +
                ", flightNumber='" + flightNumber + '\'' +
                ", price=" + price +
                '}';
    }
}
