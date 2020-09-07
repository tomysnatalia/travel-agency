package com.crud.travel.agency.mapper;


import com.crud.travel.agency.domain.Hotel;
import com.crud.travel.agency.domain.dto.HotelDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HotelMapperTestSuite {

    @InjectMocks
    private HotelMapper hotelMapper;

    @Test
    public void mapToHotelTest(){
        //Given
        Hotel hotel = new Hotel(1L, "Hotel Lavaro", "Italy", "Roma", "Roma", "3 stars", 520L, 190L,"HB", 7L, null, null);
        HotelDto hotelDto  = new HotelDto(1L, "Hotel Lavaro", "Italy", "Roma", "Roma", "3 stars", 520L, 190L,"HB", 7L, null, null);
        //When
        Hotel mapping = hotelMapper.mapToHotel(hotelDto);
        //Then
        assertEquals(hotel.getId(), mapping.getId());
        assertEquals(hotel.getHotelName(), mapping.getHotelName());
        assertEquals(hotel.getLocationCity(), mapping.getLocationCity());
    }

    @Test
    public void mapToHotelDtoTest() {
        //Given
        Hotel hotel = new Hotel(1L, "Hotel Lavaro", "Italy", "Roma", "Roma", "3 stars", 520L, 190L,"HB", 7L, null, null);
        HotelDto hotelDto  = new HotelDto(1L, "Hotel Lavaro", "Italy", "Roma", "Roma", "3 stars", 520L, 190L,"HB", 7L, null, null);
        //When
        HotelDto mapping = hotelMapper.mapToHotelDto(hotel);
        //Then
        assertEquals(hotelDto.getId(), mapping.getId());
        assertEquals(hotelDto.getLocationCountry(), mapping.getLocationCountry());
        assertEquals(hotelDto.getCloserAirport(), mapping.getCloserAirport());
    }

    @Test
    public void mapToHotelDtoListTest() {
        //Given
        Hotel hotel = new Hotel (1L, "Hotel Lavaro", "Italy", "Roma", "Roma", "3 stars", 520L, 190L,"HB", 7L, null, null);
        List<Hotel> hotelList = Arrays.asList(hotel);
        //When
        List<HotelDto> mappingList = hotelMapper.mapToHotelDtoList(hotelList);
        //Then
        assertEquals(1, mappingList.size());
    }
}