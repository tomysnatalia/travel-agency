package com.crud.travel.agency.interfaces;

import com.crud.travel.agency.domain.Reservation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationInterface {

    List<Reservation> findBySurname (String surname);

    List<Reservation> findByPaymentStatus (String paymentStatus);


}
