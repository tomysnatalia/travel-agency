package com.crud.travel.agency.service;

import com.crud.travel.agency.domain.Flight;
import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(final Long id) throws TravelAgencyNotFoundException { return reservationRepository.findById(id).orElseThrow(TravelAgencyNotFoundException::new); }

    public List<Reservation> findBySurname(String surname) {
        return reservationRepository.findBySurname(surname);
    }

    public List<Reservation> findByPaymentDate(LocalDate paymentDay) { return reservationRepository.findByPaymentDate(paymentDay); }

    public List<Reservation> findByPaymentStatus(String paymentStatus) { return reservationRepository.findByPaymentStatus(paymentStatus); }

    public Reservation saveReservation(final Reservation reservation) { return reservationRepository.save(reservation); }

    public void deleteById(final Long id) {
        reservationRepository.deleteById(id);
    }
}


