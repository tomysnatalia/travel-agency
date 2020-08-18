package com.crud.travel.agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "hotels")
public class Hotel {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "hotelName")
    private String hotelName;

    @NotNull
    @Column(name = "country")
    private String locationCountry;

    @NotNull
    @Column(name = "city")
    private String locationCity;

    @NotNull
    @Column(name = "airport")
    private String closerAirport;

    @NotNull
    @Column(name = "starsRating")
    private String hotelOfficialRating;

    @NotNull
    @Column(name = "adult")
    private int pricePerNightForAdult;

    @NotNull
    @Column(name = "kid")
    private int pricePerNightForKid;

    @NotNull
    @Column(name = "foodOption")
    private String foodOption;

    @NotNull
    @Column(name = "duration")
    private int duration;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return hotelName.equals(hotel.hotelName) &&
                locationCountry.equals(hotel.locationCountry) &&
                locationCity.equals(hotel.locationCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelName, locationCountry, locationCity);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public void setCloserAirport(String closerAirport) {
        this.closerAirport = closerAirport;
    }

    public void setHotelOfficialRating(String hotelOfficialRating) {
        this.hotelOfficialRating = hotelOfficialRating;
    }

    public void setPricePerNightForAdult(int pricePerNightForAdult) {
        this.pricePerNightForAdult = pricePerNightForAdult;
    }

    public void setPricePerNightForKid(int pricePerNightForKid) {
        this.pricePerNightForKid = pricePerNightForKid;
    }

    public void setFoodOption(String foodOption) {
        this.foodOption = foodOption;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAdultPriceForDuration() {
        return getDuration() * getPricePerNightForAdult();
    }

    public int getKidPriceForDuration() {
        return getDuration() * getPricePerNightForKid();
    }

}
