package com.crud.travel.agency.repository;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.domain.Hotel;
import com.crud.travel.agency.interfaces.HotelInterface;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotelRepository extends CrudRepository <Hotel, Long>, HotelInterface {
    @Override
    Hotel save (Hotel hotel);

    @Override
    List<Hotel> findAll();

    @Override
    void deleteById (Long id);

    @Override
    List<Hotel> findByHotelName (String hotelName);

    @Override
    List<Hotel> findByLocationCity (String locationCity);

    @Override
    List<Hotel> findByLocationCountry (String locationCountry);

    @Override
    List<Hotel> findByHotelOfficialRating (String hotelOfficialRating);

    @Override
    List<Hotel> findByFoodOption (String foodOption);
}

