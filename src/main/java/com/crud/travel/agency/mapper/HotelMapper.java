package com.crud.travel.agency.mapper;

import com.crud.travel.agency.domain.Hotel;
import com.crud.travel.agency.domain.dto.HotelDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelMapper {


    public Hotel mapToHotel (final HotelDto hotelDto) {
        return new Hotel(
                hotelDto.getId(),
                hotelDto.getHotelName(),
                hotelDto.getLocationCountry(),
                hotelDto.getLocationCity(),
                hotelDto.getCloserAirport(),
                hotelDto.getHotelOfficialRating(),
                hotelDto.getPricePerNightForAdult(),
                hotelDto.getPricePerNightForKid(),
                hotelDto.getFoodOption(),
                hotelDto.getDuration());
    }

    public HotelDto mapToHotelDto (final Hotel hotel) {
        return new HotelDto(
                hotel.getId(),
                hotel.getHotelName(),
                hotel.getLocationCountry(),
                hotel.getLocationCity(),
                hotel.getCloserAirport(),
                hotel.getHotelOfficialRating(),
                hotel.getPricePerNightForAdult(),
                hotel.getPricePerNightForKid(),
                hotel.getFoodOption(),
                hotel.getDuration());
    }

    public List<HotelDto> mapToHotelDtoList (final List<Hotel> hotelsList) {
        return hotelsList.stream()
                .map(hList -> new HotelDto(hList.getId(), hList.getHotelName(), hList.getLocationCountry(), hList.getLocationCity(), hList.getCloserAirport(),hList.getHotelOfficialRating(), hList.getPricePerNightForAdult(), hList.getPricePerNightForKid(), hList.getFoodOption(), hList.getDuration()))
                .distinct()
                .collect(Collectors.toList());
    }
 }
