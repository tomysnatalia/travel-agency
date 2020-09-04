package com.crud.travel.agency.controller;
import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.domain.dto.ReservationDto;
import com.crud.travel.agency.mapper.ReservationMapper;
import com.crud.travel.agency.service.ReservationService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationService;

    @MockBean
    private ReservationMapper reservationMapper;


    @Test
    public void getEmptyReservationListTest() throws Exception {
        //Given
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        when(reservationMapper.mapToReservationDtoList(new ArrayList<>())).thenReturn(reservationDtoList);
        //When&Then
        mockMvc.perform(get("/travelAgency/reservation/reservations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getReservationListTest() throws Exception {
        //Given
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        reservationDtoList.add(new ReservationDto(1L, 2L, 2L, "Natalia", "Tomys", "hanf.natalia@gmail.com", "562698457", 2L, 0L, 1250L, 1000L, 0L, null, null, null, 4200L));
        when(reservationMapper.mapToReservationDtoList(new ArrayList<>())).thenReturn(reservationDtoList);
        //When&Then
        mockMvc.perform(get("/travelAgency/reservation/reservations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Natalia")))
                .andExpect(jsonPath("$[0].surname", is("Tomys")));
    }

    @Test
    public void createReservationTest() throws Exception {
        //Given
        ReservationDto reservationDto = new ReservationDto(1L, 2L, 2L, "Natalia", "Tomys", "hanf.natalia@gmail.com", "562698457", 2L, 0L, 1250L, 1000L, 0L, null, null, null, 4200L);
        Reservation reservation = new Reservation(1L, 2L, 2L, "Natalia", "Tomys", "hanf.natalia@gmail.com", "562698457", 2L, 0L, 1250L, 1000L, 0L, null, null, null, 4200L);
        when(reservationMapper.mapToReservation(ArgumentMatchers.any(ReservationDto.class))).thenReturn(reservation);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(reservationDto);
        //When&Then
        mockMvc.perform(post("/travelAgency/reservation/create")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    public void updateHotelTest() throws Exception {
        //Given
        ReservationDto reservationDto = new ReservationDto(1L, 2L, 2L, "Natalia", "Tomys", "hanf.natalia@gmail.com", "562698457", 2L, 0L, 1250L, 1000L, 0L, null, null, null, 4200L);
        Reservation reservation = new Reservation(1L, 2L, 2L, "Natalia", "Hanf", "hanf.natalia@gmail.com", "562698457", 2L, 0L, 1250L, 1000L, 0L, null, null, null, 4200L);

        when(reservationMapper.mapToReservationDto(ArgumentMatchers.any(Reservation.class))).thenReturn(reservationDto);
        when(reservationService.saveReservation(ArgumentMatchers.any(Reservation.class))).thenReturn(reservation);
        when(reservationMapper.mapToReservation(ArgumentMatchers.any(ReservationDto.class))).thenReturn(reservation);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(reservationDto);
        //When&Then
        mockMvc.perform(put("/travelAgency/reservation/update")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Natalia")))
                .andExpect(jsonPath("$.surname", is("Tomys")));
    }

    @Test
    public void deleteReservationTest() throws Exception  {
        //Given
        Reservation reservation = new Reservation(1L, 2L, 2L, "Natalia", "Hanf", "hanf.natalia@gmail.com", "562698457", 2L, 0L, 1250L, 1000L, 0L, null, null, null, 4200L);
        when(reservationService.findById(1L)).thenReturn(reservation);
        //When&Then
        mockMvc.perform(delete("/travelAgency/reservation/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .param("id", "1"))
                .andExpect(status().is(200));
    }
}
