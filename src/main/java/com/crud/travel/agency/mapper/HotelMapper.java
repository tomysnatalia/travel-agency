package com.crud.travel.agency.mapper;

import com.crud.travel.agency.domain.Hotel;
import com.crud.travel.agency.domain.dto.HotelDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
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
                hotelDto.getDuration(),
                hotelDto.getDepartureDate(),
                hotelDto.getReturnDate());
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
                hotel.getDuration(),
                hotel.getDepartureDate(),
                hotel.getReturnDate());
    }

    public List<HotelDto> mapToHotelDtoList (final List<Hotel> hotelList) {
        return hotelList.stream()
                .map(this::mapToHotelDto)
                .collect(Collectors.toList());
    }
 }
