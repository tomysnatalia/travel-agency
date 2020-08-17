package com.crud.travel.agency.controller;

import com.crud.travel.agency.domain.dto.FlightDto;
import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.mapper.FlightMapper;
import com.crud.travel.agency.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping ("/v3")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightMapper flightMapper;


    @RequestMapping(method = RequestMethod.GET, value = "/flights")
    public List<FlightDto> getFlights() {
        return flightMapper.mapToFlightDtoList(flightService.getAllFlights());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/flightId/{id}")
    public FlightDto getFlightById(@PathVariable Long id) throws TravelAgencyNotFoundException {
        return flightMapper.mapToFlightDto(flightService.getFlightById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/departure/{departure}")
    public List<FlightDto> getDeparture(@PathVariable String departure)  {
        return flightMapper.mapToFlightDtoList(flightService.getFlightByDeparture(departure));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/arrival/{arrival}")
    public List<FlightDto> getArrival (@PathVariable String arrival) {
        return flightMapper.mapToFlightDtoList(flightService.getFlightByArrival(arrival));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/flight")
    public void createFlight(@RequestBody FlightDto flightDto) {
        flightService.saveFlight(flightMapper.mapToFlight(flightDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/flight")
    public FlightDto updateFlight (@RequestBody FlightDto flightDto) {
        return flightMapper.mapToFlightDto(flightService.saveFlight(flightMapper.mapToFlight(flightDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/flight/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/flightNumber/{flightNumber}")
    public List<FlightDto> getFlightsByNumber(@PathVariable String flightNumber) {
        return flightMapper.mapToFlightDtoList(flightService.getFlightByFlightNumber(flightNumber));
    }
}