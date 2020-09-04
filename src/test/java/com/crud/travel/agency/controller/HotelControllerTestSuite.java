package com.crud.travel.agency.controller;

import com.crud.travel.agency.domain.Hotel;
import com.crud.travel.agency.domain.dto.HotelDto;
import com.crud.travel.agency.mapper.HotelMapper;
import com.crud.travel.agency.service.HotelService;
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
@WebMvcTest(HotelController.class)
public class HotelControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelService hotelService;

    @MockBean
    private HotelMapper hotelMapper;

    @Test
    public void getEmptyHotelListTest() throws Exception {
        //Given
        List<HotelDto> hotelDtoList = new ArrayList<>();
        when(hotelMapper.mapToHotelDtoList(new ArrayList<>())).thenReturn(hotelDtoList);
        //When&Then
        mockMvc.perform(get("/travelAgency/hotel/hotels").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getHotelListTest() throws Exception {
        //Given
        List<HotelDto> hotelDtoList = new ArrayList<>();
        hotelDtoList.add(new HotelDto(1L, "Hotel Lavaro", "Italy", "Roma", "Roma", "3 stars", 520L, 190L,"HB", 7L, null, null));
        when(hotelMapper.mapToHotelDtoList(new ArrayList<>())).thenReturn(hotelDtoList);
        //When&Then
        mockMvc.perform(get("/travelAgency/hotel/hotels").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].hotelName", is("Hotel Lavaro")))
                .andExpect(jsonPath("$[0].locationCity", is("Roma")));
    }

    @Test
    public void createHotelTest() throws Exception {
        //Given
        HotelDto hotelDto = new HotelDto(1L, "Hotel Lavaro", "Italy", "Roma", "Roma", "3 stars", 520L, 190L,"HB", 7L, null, null);
        Hotel hotel = new Hotel(1L, "Hotel Lavaro", "Italy", "Roma", "Roma", "3 stars", 520L, 190L,"HB", 7L, null, null);

        when(hotelMapper.mapToHotel(ArgumentMatchers.any(HotelDto.class))).thenReturn(hotel);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(hotelDto);
        //When&Then
        mockMvc.perform(post("/travelAgency/hotel/create")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    public void updateHotelTest() throws Exception {
        //Given
        HotelDto hotelDto = new HotelDto(1L, "Hotel Lavaro", "Italy", "Roma", "Roma", "3 stars", 520L, 190L,"HB", 7L, null, null);
        Hotel hotel = new Hotel(1L, "Hotel Lavaro", "Italy", "Roma", "Roma", "3 stars", 520L, 190L,"HB", 7L, null, null);

        when(hotelMapper.mapToHotelDto(ArgumentMatchers.any(Hotel.class))).thenReturn(hotelDto);
        when(hotelService.saveHotel(ArgumentMatchers.any(Hotel.class))).thenReturn(hotel);
        when(hotelMapper.mapToHotel(ArgumentMatchers.any(HotelDto.class))).thenReturn(hotel);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(hotelDto);
        //When&Then
        mockMvc.perform(put("/travelAgency/hotel/update")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.hotelName", is("Hotel Lavaro")))
                .andExpect(jsonPath("$.locationCity", is("Roma")));
    }

    @Test
    public void deleteHotelTest() throws Exception  {
        //Given
        Hotel hotel = new Hotel(1L, "Hotel Lavaro", "Italy", "Roma", "Roma", "3 stars", 520L, 190L,"HB", 7L, null, null);
        when(hotelService.findById(1L)).thenReturn(hotel);
        //When&Then
        mockMvc.perform(delete("/travelAgency/hotel/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .param("id", "1"))
                .andExpect(status().is(200));
    }
}
