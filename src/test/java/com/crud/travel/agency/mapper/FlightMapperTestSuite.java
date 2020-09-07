package com.crud.travel.agency.mapper;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.domain.dto.FlightDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FlightMapperTestSuite {

    @InjectMocks
    private FlightMapper flightMapper;

    @Test
    public void mapToFlightTest() {
        //Given
        Flight flight = new Flight(1L, "Malaga", "Warsaw", null, null, "5689", 990L);
        FlightDto flightDto = new FlightDto(1L, "Malaga", "Warsaw", null, null, "5689", 990L);
        //When
        Flight mapping = flightMapper.mapToFlight(flightDto);
        //Then
        assertEquals(flight.getId(), mapping.getId());
        assertEquals(flight.getDeparture(), mapping.getDeparture());
        assertEquals(flight.getArrival(), mapping.getArrival());
    }

    @Test
    public void mapToFlightDto() {
        //Given
        Flight flight = new Flight(1L, "Malaga", "Warsaw", null, null, "5689", 990L);
        FlightDto flightDto = new FlightDto(1L, "Malaga", "Warsaw", null, null, "5689", 990L);
        //When
        FlightDto mapping = flightMapper.mapToFlightDto(flight);
        //Then
        assertEquals(flightDto.getFlightNumber(), flight.getFlightNumber());
        assertEquals(flightDto.getPrice(), flight.getPrice());
        assertEquals(flightDto.getId(), flight.getId());
    }

    @Test
    public void mapToFlightDtoList() {
        //Given
        Flight flight = new Flight(1L, "Malaga", "Warsaw", null, null, "5689", 990L);
        List<Flight> flights = Arrays.asList(flight);
        //When
        List<FlightDto> mappingList = flightMapper.mapToFlightDtoList(flights);
        //Then
        assertEquals(1, mappingList.size());
    }
}
