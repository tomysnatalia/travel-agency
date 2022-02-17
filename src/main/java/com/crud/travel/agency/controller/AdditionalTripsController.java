package com.crud.travel.agency.controller;


import com.crud.travel.agency.domain.AdditionalTrips;
import com.crud.travel.agency.domain.dto.AdditionalTripsDto;
import com.crud.travel.agency.domain.dto.FlightDto;
import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.mapper.AdditionalTripsMapper;
import com.crud.travel.agency.service.AdditionalTripsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping("/travelAgency/trip")

public class AdditionalTripsController {

    @Autowired
    private AdditionalTripsService service;

    @Autowired
    private AdditionalTripsMapper tripsMapper;

    @GetMapping(value = "/trips")
    public List<AdditionalTripsDto> getTrips() {
        return tripsMapper.mapToTripsDtoList(service.getAllTrips());
    }

    @GetMapping(value = "id/{id}")
    public AdditionalTripsDto getTripById (@PathVariable Long id) throws TravelAgencyNotFoundException {
        return tripsMapper.mapToTripsDto(service.findTripById(id));
    }

    @PutMapping(value = "/update")
    public AdditionalTripsDto updateTrip (@RequestBody AdditionalTripsDto additionalTripsDto) {
        return tripsMapper.mapToTripsDto(service.saveTrip(tripsMapper.mapToTrips(additionalTripsDto)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteTrip (@PathVariable Long tripId) {
        service.deleteTrip(tripId);
    }

    @PostMapping(value ="/create")
    public void createTrip(@RequestBody AdditionalTripsDto additionalTripsDto) {
        service.countSummary(service.saveTrip(tripsMapper.mapToTrips(additionalTripsDto)));
    }


}
