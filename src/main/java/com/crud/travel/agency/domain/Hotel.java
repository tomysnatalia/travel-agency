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


    @Column(name = "airport")
    private String closerAirport;


    @Column(name = "starsRating")
    private String hotelOfficialRating;


    @Column(name = "adult")
    private Long pricePerNightForAdult;


    @Column(name = "kid")
    private Long pricePerNightForKid;

    @Column(name = "foodOption")
    private String foodOption;

    @Column(name = "duration")
    private Long duration;


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

    public void setPricePerNightForAdult(Long pricePerNightForAdult) {
        this.pricePerNightForAdult = pricePerNightForAdult;
    }

    public void setPricePerNightForKid(Long pricePerNightForKid) {
        this.pricePerNightForKid = pricePerNightForKid;
    }

    public void setFoodOption(String foodOption) {
        this.foodOption = foodOption;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getAdultPriceForDuration() {
        return getDuration() * getPricePerNightForAdult();
    }

    public Long getKidPriceForDuration() {
        return getDuration() * getPricePerNightForKid();
    }

}
