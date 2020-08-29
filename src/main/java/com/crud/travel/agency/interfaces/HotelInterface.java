package com.crud.travel.agency.interfaces;

import com.crud.travel.agency.domain.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelInterface {

    List<Hotel> findByHotelName (String hotelName);

    List<Hotel> findByLocationCity (String locationCity);

    List<Hotel> findByLocationCountry (String locationCountry);

    List<Hotel> findByHotelOfficialRating (String hotelOfficialRating);

    List<Hotel> findByFoodOption (String foodOption);

    List<Hotel> findByDuration (Long duration);
}
