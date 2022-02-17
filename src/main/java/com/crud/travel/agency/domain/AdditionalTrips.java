package com.crud.travel.agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@NamedNativeQuery(
        name = "AdditionalTrips.getFullPrice",
        query = "UPDATE TRIP SET SUMMARY = (SELECT PRICE * QUANTITY)")


@Entity(name = "Trip")
public class AdditionalTrips {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "quantity")
    private Long numberOfParticipant;

    @Column(name = "date")
    private LocalDate tripDate;

    @Column(name = "price")
    private Long tripPrice;

    @Column(name = "summary")
    private Long fullPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalTrips that = (AdditionalTrips) o;
        return Objects.equals(id, that.id) && Objects.equals(numberOfParticipant, that.numberOfParticipant) && Objects.equals(tripDate, that.tripDate) && Objects.equals(tripPrice, that.tripPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfParticipant, tripDate, tripPrice);
    }

    @Override
    public String toString() {
        return "AdditionalTrips{" +
                "id=" + id +
                ", numberOfParticipant=" + numberOfParticipant +
                ", tripDate=" + tripDate +
                ", tripPrice=" + tripPrice +
                ", forAll=" + fullPrice +
                '}';
    }
}
