package com.crud.travel.agency.interfaces;

import com.crud.travel.agency.domain.Hotel;

import java.util.List;

public interface HotelInterface {

    List<Hotel> findByHotelName (String hotelName);

    List<Hotel> findByLocationCity (String locationCity);

    List<Hotel> findByLocationCountry (String locationCountry);

    List<Hotel> findByHotelOfficialRating (String hotelOfficialRating);

    List<Hotel> findByFoodOption (String foodOption);
}
