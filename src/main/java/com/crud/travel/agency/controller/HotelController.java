package com.crud.travel.agency.controller;

import com.crud.travel.agency.domain.Hotel;
import com.crud.travel.agency.domain.dto.FlightDto;
import com.crud.travel.agency.domain.dto.HotelDto;
import com.crud.travel.agency.mapper.HotelMapper;
import com.crud.travel.agency.repository.HotelRepository;
import com.crud.travel.agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelMapper hotelMapper;


    @RequestMapping(method = RequestMethod.GET, value = "/hotels")
    public List<HotelDto> getHotels() {
        return hotelMapper.mapToHotelDtoList(hotelService.getAllHotels());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotelName/{hotelName}")
    public List<HotelDto> getHotelName(@PathVariable String hotelName)  {
        return hotelMapper.mapToHotelDtoList(hotelService.findByHotelName(hotelName));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotelCity/{locationCity}")
    public List<HotelDto> getHotelCity(@PathVariable String locationCity)  {
        return hotelMapper.mapToHotelDtoList(hotelService.findByLocationCity(locationCity));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotelCountry/{locationCountry}")
    public List<HotelDto> getHotelCountry(@PathVariable String locationCountry)  {
        return hotelMapper.mapToHotelDtoList(hotelService.findByLocationCountry(locationCountry));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotelRating/{hotelOfficialRating}")
    public List<HotelDto> getHotelRating(@PathVariable String hotelOfficialRating)  {
        return hotelMapper.mapToHotelDtoList(hotelService.findByHotelOfficialRating(hotelOfficialRating));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotelFood/{foodOption}")
    public List<HotelDto> getHotelFoodOption(@PathVariable String foodOption)  {
        return hotelMapper.mapToHotelDtoList(hotelService.findByFoodOption(foodOption));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hotel")
    public void createHotel(@RequestBody HotelDto hotelDto) {
        hotelService.saveHotel(hotelMapper.mapToHotel(hotelDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/hotel")
    public HotelDto updateHotel (@RequestBody HotelDto hotelDto) {
        return hotelMapper.mapToHotelDto(hotelService.saveHotel(hotelMapper.mapToHotel(hotelDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/hotel/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}


