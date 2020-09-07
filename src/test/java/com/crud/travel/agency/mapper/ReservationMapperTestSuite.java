package com.crud.travel.agency.mapper;

import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.domain.dto.ReservationDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ReservationMapperTestSuite {

    @InjectMocks
    private ReservationMapper reservationMapper;

    @Test
    public void mapToReservationTest() {
        //Given
        Reservation reservation = new Reservation(1L, 2L, 2L, "Natalia", "Tomys", "hanf.natalia@gmail.com", "562698457", 2L, 0L, 1250L, 1000L, 0L, null, null, null, 4200L);
        ReservationDto reservationDto = new ReservationDto(1L, 2L, 2L, "Natalia", "Tomys", "hanf.natalia@gmail.com", "562698457", 2L, 0L, 1250L, 1000L, 0L, null, null, null, 4200L);
        //When
        Reservation mapping = reservationMapper.mapToReservation(reservationDto);
        //Then
        assertEquals(reservation.getId(), mapping.getId());
        assertEquals(reservation.getFlightId(), mapping.getFlightId());
        assertEquals(reservation.getHotelId(), mapping.getHotelId());
    }

    @Test
    public void mapToReservationDtoTest() {
        //Given
        Reservation reservation = new Reservation(1L, 2L, 2L, "Natalia", "Tomys", "hanf.natalia@gmail.com", "562698457", 2L, 0L, 1250L, 1000L, 0L, null, null, null, 4200L);
        ReservationDto reservationDto = new ReservationDto(1L, 2L, 2L, "Natalia", "Tomys", "hanf.natalia@gmail.com", "562698457", 2L, 0L, 1250L, 1000L, 0L, null, null, null, 4200L);
        //When
        ReservationDto mapping = reservationMapper.mapToReservationDto(reservation);
        //Then
        assertEquals(reservationDto.getId(), mapping.getId());
        assertEquals(reservationDto.getName(), mapping.getName());
        assertEquals(reservationDto.getSurname(), mapping.getSurname());
    }

    @Test
    public void mapToReservationDtoList() {
        //Given
        Reservation reservation = new Reservation(1L, 2L, 2L, "Natalia", "Tomys", "hanf.natalia@gmail.com", "562698457", 2L, 0L, 1250L, 1000L, 0L, null, null, null, 4200L);
        List<Reservation> reservationList = Arrays.asList(reservation);
        //When
        List<ReservationDto> mappingList = reservationMapper.mapToReservationDtoList(reservationList);
        //Then
        assertEquals(1, mappingList.size());
    }

}
