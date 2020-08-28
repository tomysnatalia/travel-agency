package com.crud.travel.agency.controller;

import com.crud.travel.agency.domain.dto.FlightDto;
import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.mapper.FlightMapper;
import com.crud.travel.agency.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/flight")
public class FlightController {
    private final FlightService flightService;
    private final FlightMapper flightMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/flights")
    public List<FlightDto> getFlights() {
        return flightMapper.mapToFlightDtoList(flightService.getAllFlights());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
    public FlightDto getFlightById(@PathVariable Long id) throws TravelAgencyNotFoundException {
        return flightMapper.mapToFlightDto(flightService.findById(id)); }

    @RequestMapping(method = RequestMethod.GET, value = "/departure/{departure}")
    public List<FlightDto> getFlightByDeparture(@PathVariable String departure)  {
        return flightMapper.mapToFlightDtoList(flightService.findByDeparture(departure)); }

    @RequestMapping(method = RequestMethod.GET, value = "/arrival/{arrival}")
    public List<FlightDto> getFlightByArrival(@PathVariable String arrival) {
        return flightMapper.mapToFlightDtoList(flightService.findByArrival(arrival)); }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public void createFlight(@RequestBody FlightDto flightDto) {
        flightService.saveFlight(flightMapper.mapToFlight(flightDto)); }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public FlightDto updateFlight (@RequestBody FlightDto flightDto) {
        return flightMapper.mapToFlightDto(flightService.saveFlight(flightMapper.mapToFlight(flightDto))); }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/flightNumber/{flightNumber}")
    public List<FlightDto> getFlightByNumber(@PathVariable String flightNumber) {
        return flightMapper.mapToFlightDtoList(flightService.findByFlightNumber(flightNumber)); }
}