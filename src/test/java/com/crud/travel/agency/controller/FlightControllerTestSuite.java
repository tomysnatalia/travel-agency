package com.crud.travel.agency.controller;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.domain.dto.FlightDto;
import com.crud.travel.agency.mapper.FlightMapper;
import com.crud.travel.agency.service.FlightService;
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
@WebMvcTest(FlightController.class)
public class FlightControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightService flightService;

    @MockBean
    private FlightMapper flightMapper;

    @Test
    public void getEmptyFlightListTest() throws Exception {
        //Given
        List<FlightDto> flightDtoList = new ArrayList<>();
        when(flightMapper.mapToFlightDtoList(new ArrayList<>())).thenReturn(flightDtoList);
        //When&Then
        mockMvc.perform(get("/travelAgency/flight/flights").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getFlightListTest() throws Exception {
        //Given
        List<FlightDto> flightDtoList = new ArrayList<>();
        flightDtoList.add(new FlightDto(1L, "Malaga", "Warsaw", null, null, "5689", 990L));
        when(flightMapper.mapToFlightDtoList(new ArrayList<>())).thenReturn(flightDtoList);
        //When&Then
        mockMvc.perform(get("/travelAgency/flight/flights").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].departure", is("Malaga")))
                .andExpect(jsonPath("$[0].arrival", is("Warsaw")))
                .andExpect(jsonPath("$[0].flightNumber", is("5689")));
    }

    @Test
    public void findFlightByIdTest() throws Exception {
        //Given
        FlightDto flightDto = new FlightDto(1L, "Warsaw", "Malaga", null, null, "5689", 990L);
        Flight flight = new Flight(1L, "Warsaw", "Malaga", null, null, "5689", 990L);

        when(flightService.findById(1L)).thenReturn(flight);
        when(flightMapper.mapToFlightDto(flight)).thenReturn(flightDto);

        //When&Then
        mockMvc.perform(get("/travelAgency/flight/id/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.departure", is("Warsaw")))
                .andExpect(jsonPath("$.arrival", is("Malaga")));
        verify(flightService, times(1)).findById(1L);
    }

    @Test
    public void findFlightByDepartureTest() throws Exception {
        //Given
        List<FlightDto> flightDto = new ArrayList<>();
        flightDto.add(new FlightDto(1L, "Krakow", "Malaga", null, null, "5689", 990L));
        flightDto.add(new FlightDto(2L, "Warsaw", "Roma", null, null, "5699", 790L));

        List<Flight> flight = new ArrayList<>();
        flight.add(new Flight(1L, "Krakow", "Malaga", null, null, "5689", 990L));
        flight.add(new Flight(2L, "Warsaw", "Roma", null, null, "5699", 790L));

        when(flightMapper.mapToFlightDtoList(new ArrayList<>())).thenReturn(flightDto);
        when(flightService.findByDeparture("Warsaw")).thenReturn(new ArrayList<>()).thenReturn(flightService.findByDeparture("Warsaw"));
        //When&Then
        mockMvc.perform(get("/travelAgency/flight/departure/Warsaw").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].departure", is("Warsaw")))
                .andExpect(jsonPath("$[1].arrival", is("Roma")))
                .andExpect(jsonPath("$[1].flightNumber", is("5699")));
    }

    @Test
    public void findFlightByArrivalTest() throws Exception {
        //Given
        List<FlightDto> flightDto = new ArrayList<>();
        flightDto.add(new FlightDto(1L, "Warsaw", "Malaga", null, null, "5689", 990L));
        flightDto.add(new FlightDto(2L, "Warsaw", "Roma", null, null, "5699", 790L));
        when(flightMapper.mapToFlightDtoList(new ArrayList<>())).thenReturn(flightDto);
        when(flightService.findByArrival("Malaga")).thenReturn(new ArrayList<>());
        //When&Then
        mockMvc.perform(get("/travelAgency/flight/arrival/Malaga").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].departure", is("Warsaw")))
                .andExpect(jsonPath("$[0].arrival", is("Malaga")))
                .andExpect(jsonPath("$[0].flightNumber", is("5689")));
    }

    @Test
    public void createFlightTest() throws Exception {
        //Given
        FlightDto flightDto = new FlightDto(1L, "Warsaw", "Malaga", null, null, "5689", 990L);
        Flight flight = new Flight(1L, "Warsaw", "Malaga", null, null, "5689", 990L);

        when(flightMapper.mapToFlight(ArgumentMatchers.any(FlightDto.class))).thenReturn(flight);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(flightDto);
        //When&Then
        mockMvc.perform(post("/travelAgency/flight/create")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    public void updateFlightTest() throws Exception {
        //Given
        FlightDto flightDto = new FlightDto(1L, "Warsaw", "Malaga", null, null, "5689", 990L);
        Flight flight = new Flight(1L, "Warsaw", "Malaga", null, null, "5689", 990L);

        when(flightMapper.mapToFlightDto(ArgumentMatchers.any(Flight.class))).thenReturn(flightDto);
        when(flightService.saveFlight(ArgumentMatchers.any(Flight.class))).thenReturn(flight);
        when(flightMapper.mapToFlight(ArgumentMatchers.any(FlightDto.class))).thenReturn(flight);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(flightDto);
        //When&Then
        mockMvc.perform(put("/travelAgency/flight/update")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.departure", is("Warsaw")))
                .andExpect(jsonPath("$.arrival", is("Malaga")));
    }

    @Test
    public void deleteFlightByIdTest() throws Exception  {
        //Given
        Flight flight = new Flight(1L, "Warsaw", "Malaga", null, null, "5689", 990L);
        when(flightService.findById(1L)).thenReturn(flight);
        //When&Then
        mockMvc.perform(delete("/travelAgency/flight/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .param("id", "1"))
                .andExpect(status().is(200));
    }

}
