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
    @NotNull
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

    @NotNull
    @Column(name = "price")
    int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return departure.equals(flight.departure) &&
                arrival.equals(flight.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival);
    }
}
