package com.crud.travel.agency.repository;

import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.interfaces.ReservationInterface;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository <Reservation, Long>, ReservationInterface {
    @Override
    List<Reservation> findAll();

    @Override
    Reservation save(Reservation reservation);

    @Override
    Optional<Reservation> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    List<Reservation> findBySurname(String surname);

    @Override
    List<Reservation> findByPaymentStatus(String paymentStatus);

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    void getHotelPrice();

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    void getHotelPriceWithFlight();

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    void getFlightPrice();

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    void getDeposit();

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    void getPaymentDate();


}
