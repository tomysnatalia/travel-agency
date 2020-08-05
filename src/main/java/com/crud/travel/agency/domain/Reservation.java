package com.crud.travel.agency.domain;

import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reservation")
public class Reservation {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

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

    @Column(name = "price")
    private int hotelPrice;

    @Column(name = "deposit")
    private int deposit;

    @Column(name = "paymentStatus")
    private boolean paymentStatus;

   // @Column(name = "depositStatus")
   // private boolean paymentDepositStatus;

    @Column(name = "paymentday")
    private LocalDate paymentDate;

    @Column(name = "totalPrice")
    private int hotelPriceWithFlight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id.equals(that.id) &&
                flight.equals(that.flight) &&
                hotel.equals(that.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flight, hotel);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

    public void setHotelPrice(int hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public void setHotelPriceWithFlight(int hotelPriceWithFlight) {
        this.hotelPriceWithFlight = hotelPriceWithFlight;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

   // public void setPaymentDepositStatus(boolean paymentDepositStatus) {
   //     this.paymentDepositStatus = paymentDepositStatus;
   // }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public void setNumberOfKids(int numberOfKids) {
        this.numberOfKids = numberOfKids;
    }


    public int adultPrice() throws TravelAgencyNotFoundException {
        return ((hotel.getDuration() * hotel.getPricePerNightForAdult()) * numberOfAdults);
    }

    public int kidPrice() {
        return ((hotel.getDuration() * hotel.getPricePerNightForKid()) * numberOfKids);
    }

    public int totalPrice() throws TravelAgencyNotFoundException{
        return adultPrice() + kidPrice();
    }

    public int adultPriceWithFlight() {
        return ((hotel.getDuration() * hotel.getPricePerNightForAdult()) * (numberOfAdults * numberOfAdults));
    }

    public int kidPriceWithFlight() {
        return ((hotel.getDuration() * hotel.getPricePerNightForKid()) * (numberOfKids * numberOfKids));
    }

    public int totalPriceWithFlight() {
        return adultPriceWithFlight() + kidPriceWithFlight();
    }

    public int hotelPrice() throws TravelAgencyNotFoundException {
        if (numberOfKids == 0) {
            adultPrice();
        } else {
            totalPrice();
        }
        return hotelPrice;
    }

    public int hotelPriceWithFlight(){
        if(numberOfKids == 0) {
            adultPriceWithFlight();
        } else {
            totalPriceWithFlight();
        }
        return hotelPriceWithFlight;
    }
}

