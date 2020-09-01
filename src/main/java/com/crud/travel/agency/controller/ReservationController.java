package com.crud.travel.agency.controller;

import com.crud.travel.agency.domain.dto.ReservationDto;
import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.mapper.ReservationMapper;
import com.crud.travel.agency.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Slf4j
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/travelAgency/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/reservations")
    public List<ReservationDto> getAllReservations() {
        return reservationMapper.mapToReservationDtoList(reservationService.getAllReservations());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
    public ReservationDto getReservationById(@PathVariable Long id) throws TravelAgencyNotFoundException {
        return reservationMapper.mapToReservationDto(reservationService.getReservationById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/surname/{surname}")
    public List<ReservationDto> getReservationBySurname(@PathVariable String surname) {
        return reservationMapper.mapToReservationDtoList(reservationService.findBySurname(surname));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/paymentStatus/{paymentStatus}")
    public List<ReservationDto> getReservationByPaymentStatus(@PathVariable String paymentStatus) {
        return reservationMapper.mapToReservationDtoList(reservationService.findByPaymentStatus(paymentStatus));
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public void createReservation(@RequestBody ReservationDto reservationDto) {
        reservationService.saveReservation(reservationMapper.mapToReservation(reservationDto));
        if (reservationDto.getFlightId() != null) {
            reservationService.getFlightPrice(); }

        if (reservationDto.getHotelId() != null) {
            reservationService.getHotelPrice(); }

        if((reservationDto.getFlightId() != null) & (reservationDto.getHotelId()!=null)) {
            reservationService.getHotelPriceWithFlight(); }

        if((reservationDto.getFlightId() != null) & (reservationDto.getHotelId()!=null) || ((reservationDto.getFlightId() == null) & (reservationDto.getHotelId()!=null))) {
            reservationService.getDeposit(); }

        if (reservationDto.getHotelId() != null) {
           reservationService.getPaymentDate();
        }
    }

    @Transactional
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public ReservationDto updateReservation (@RequestBody ReservationDto reservationDto) {
        return reservationMapper.mapToReservationDto(reservationService.saveReservation(reservationMapper.mapToReservation(reservationDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteReservation (@PathVariable Long id) {
        reservationService.deleteById(id); }
}

