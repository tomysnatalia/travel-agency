package com.crud.travel.agency.controller;

import com.crud.travel.agency.domain.dto.ReservationDto;
import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.mapper.ReservationMapper;
import com.crud.travel.agency.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v3")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationMapper reservationMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/reservations")
    public List<ReservationDto> getAllReservations() {
        return reservationMapper.mapToReservationDtoList(reservationService.getAllReservations());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservation/{id}")
    public ReservationDto getReservationById(@PathVariable Long id) throws TravelAgencyNotFoundException {
        return reservationMapper.mapToReservationDto(reservationService.getReservationById(id).orElseThrow(TravelAgencyNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservation/{surname}")
    public List<ReservationDto> getReservationBySurname (@PathVariable String surname) {
        return reservationMapper.mapToReservationDtoList(reservationService.findBySurname(surname));

    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservation/{paymentDay}")
    public List<ReservationDto> getReservationByPaymentDay(@PathVariable LocalDate paymentDay) {
        return reservationMapper.mapToReservationDtoList(reservationService.findByPaymentDate(paymentDay));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservation/{paymentStatus}")
    public List<ReservationDto> getReservationByPaymentStatus(@PathVariable boolean paymentStatus) {
        return reservationMapper.mapToReservationDtoList(reservationService.findByPaymentStatus(paymentStatus));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reservation")
    public void createReservation (@RequestBody ReservationDto reservationDto) {
        reservationService.saveReservation(reservationMapper.mapToReservation(reservationDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/reservation")
    public ReservationDto updateReservation (@RequestBody ReservationDto reservationDto) {
        return reservationMapper.mapToReservationDto(reservationService.saveReservation(reservationMapper.mapToReservation(reservationDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/reservation/{id}")
    public void deleteReservation (@PathVariable Long id) {
        reservationService.deleteById(id);
    }
}

