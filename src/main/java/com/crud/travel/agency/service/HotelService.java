package com.crud.travel.agency.service;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.domain.Hotel;
import com.crud.travel.agency.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel saveHotel(final Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel (final Long id) {
        hotelRepository.deleteById(id);
    }

    public List<Hotel> findByHotelName (final String hotelName) {
        return hotelRepository.findByHotelName(hotelName);
    }

    public List<Hotel> findByLocationCity (final String locationCity) {
        return hotelRepository.findByLocationCity(locationCity);
    }

    public List<Hotel> findByLocationCountry (final String locationCountry) {
        return hotelRepository.findByLocationCountry(locationCountry);
    }

    public List<Hotel> findByHotelOfficialRating (final String hotelOfficialRating) {
        return hotelRepository.findByHotelOfficialRating(hotelOfficialRating);
    }


    public List<Hotel> findByFoodOption (String foodOption) {
        return hotelRepository.findByFoodOption(foodOption);
    }
}