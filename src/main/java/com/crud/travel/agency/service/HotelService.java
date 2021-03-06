package com.crud.travel.agency.service;

import com.crud.travel.agency.domain.Hotel;
import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.repository.HotelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() { return hotelRepository.findAll(); }

    public Hotel findById(final Long id) throws TravelAgencyNotFoundException { return hotelRepository.findById(id).orElseThrow(TravelAgencyNotFoundException::new); }

    public List<Hotel> findByHotelName (final String hotelName) {
        return hotelRepository.findByHotelName(hotelName);
    }

    public List<Hotel> findByLocationCity (final String locationCity) { return hotelRepository.findByLocationCity(locationCity); }

    public List<Hotel> findByLocationCountry (final String locationCountry) { return hotelRepository.findByLocationCountry(locationCountry); }

    public List<Hotel> findByHotelOfficialRating (final String hotelOfficialRating) { return hotelRepository.findByHotelOfficialRating(hotelOfficialRating); }

    public List<Hotel> findByFoodOption (final String foodOption) { return hotelRepository.findByFoodOption(foodOption); }

    public List<Hotel> findByDuration(final Long duration) { return hotelRepository.findByDuration(duration);}

    public Hotel saveHotel(final Hotel hotel) { return hotelRepository.save(hotel); }

    public void deleteHotel (final Long id) {
        hotelRepository.deleteById(id);
    }
}