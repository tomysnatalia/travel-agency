package com.crud.travel.agency.controller;

import com.crud.travel.agency.domain.dto.FlightDto;
import com.crud.travel.agency.domain.dto.HotelDto;
import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.mapper.HotelMapper;
import com.crud.travel.agency.service.HotelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/hotels")
    public List<HotelDto> getHotels() {
        return hotelMapper.mapToHotelDtoList(hotelService.getAllHotels()); }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
    public HotelDto getHotelById(@PathVariable Long id) throws TravelAgencyNotFoundException {
        return hotelMapper.mapToHotelDto(hotelService.findById(id)); }

    @RequestMapping(method = RequestMethod.GET, value = "/name/{hotelName}")
    public List<HotelDto> getHotelByName(@PathVariable String hotelName)  {
        return hotelMapper.mapToHotelDtoList(hotelService.findByHotelName(hotelName)); }

    @RequestMapping(method = RequestMethod.GET, value = "/city/{locationCity}")
    public List<HotelDto> getHotelByCity(@PathVariable String locationCity)  {
        return hotelMapper.mapToHotelDtoList(hotelService.findByLocationCity(locationCity)); }

    @RequestMapping(method = RequestMethod.GET, value = "/country/{locationCountry}")
    public List<HotelDto> getHotelByCountry(@PathVariable String locationCountry)  {
        return hotelMapper.mapToHotelDtoList(hotelService.findByLocationCountry(locationCountry));}

    @RequestMapping(method = RequestMethod.GET, value = "/rating/{hotelOfficialRating}")
    public List<HotelDto> getHotelByRating(@PathVariable String hotelOfficialRating)  {
        return hotelMapper.mapToHotelDtoList(hotelService.findByHotelOfficialRating(hotelOfficialRating)); }

    @RequestMapping(method = RequestMethod.GET, value = "/food/{foodOption}")
    public List<HotelDto> getHotelByFoodOption(@PathVariable String foodOption)  {
        return hotelMapper.mapToHotelDtoList(hotelService.findByFoodOption(foodOption)); }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public void createHotel(@RequestBody HotelDto hotelDto) {
        hotelService.saveHotel(hotelMapper.mapToHotel(hotelDto)); }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public HotelDto updateHotel (@RequestBody HotelDto hotelDto) {
        return hotelMapper.mapToHotelDto(hotelService.saveHotel(hotelMapper.mapToHotel(hotelDto))); }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}


