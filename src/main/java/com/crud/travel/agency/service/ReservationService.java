package com.crud.travel.agency.service;

import com.crud.travel.agency.domain.Hotel;
import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    FlightService flightService;

    @Autowired
    HotelService hotelService;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }


    public Reservation saveReservation(final Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> getReservationById(final Long id) {
        return reservationRepository.findById(id);
    }

    public void deleteById(final Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> findBySurname(String surname) {
        return reservationRepository.findBySurname(surname);
    }

    public List<Reservation> findByPaymentDate (LocalDate paymentDay) {
        return reservationRepository.findByPaymentDate(paymentDay);
    }

    public List<Reservation> findByPaymentStatus (boolean paymentStatus) {
        return reservationRepository.findByPaymentStatus(paymentStatus);
    }

}
