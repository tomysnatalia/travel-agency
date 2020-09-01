package com.crud.travel.agency.service;

import com.crud.travel.agency.api.client.TravelAgencyClient;
import com.crud.travel.agency.config.AdminConfig;
import com.crud.travel.agency.domain.Mail;
import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.domain.dto.ReservationDto;
import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.util.Optional.ofNullable;

@Slf4j
@AllArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private static final String SUBJECT = "New Reservation";

    @Autowired
    private TravelAgencyClient travelAgencyClient;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AdminConfig adminConfig;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(final Long id) throws TravelAgencyNotFoundException { return reservationRepository.findById(id).orElseThrow(TravelAgencyNotFoundException::new); }

    public List<Reservation> findBySurname(final String surname) { return reservationRepository.findBySurname(surname); }

    public List<Reservation> findByPaymentStatus(final String paymentStatus) { return reservationRepository.findByPaymentStatus(paymentStatus); }

    public Reservation saveReservation(final Reservation reservation) { return reservationRepository.save(reservation); }

    public void getHotelPrice() { reservationRepository.getHotelPrice(); }

    public void getHotelPriceWithFlight() { reservationRepository.getHotelPriceWithFlight(); }

    public void getFlightPrice() { reservationRepository.getFlightPrice(); }

    public void getDeposit() { reservationRepository.getDeposit(); }

    public void getPaymentDate() { reservationRepository.getPaymentDate(); }

    public void deleteById(final Long id) {
        reservationRepository.deleteById(id);
    }

    public List <ReservationDto> fetchReservations() {
        return travelAgencyClient.getReservations();
    }

    public Integer createReservation(final ReservationDto reservationDto) {
        Integer newReservation = travelAgencyClient.createReservation(reservationDto);
        ofNullable(newReservation).ifPresent(reservation -> emailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT,
                "Reservation: " + "for " + reservationDto.getName() + reservationDto.getSurname() + " has benn make in our Travel Agency")));

        return newReservation;
    }

}


