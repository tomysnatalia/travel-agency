package com.crud.travel.agency.repository;

import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.interfaces.ReservationInterface;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ReservationRepository extends CrudRepository <Reservation, Long>, ReservationInterface {


    @Override
    List<Reservation> findAll();

    @Override
    Reservation save (Reservation reservation);

    @Override
    Optional<Reservation> findById (Long id);

    @Override
    void deleteById (Long id);

    @Override
    List<Reservation> findBySurname (String surname);

    @Override
    List<Reservation> findByPaymentDate (LocalDate paymentDate);

    @Override
    List<Reservation> findByPaymentStatus (boolean paymentStatus);

    @Query(nativeQuery = true)
    Reservation getHotelPrice();

    @Query(nativeQuery = true)
    Reservation getHotelPriceWithFlight();



}
