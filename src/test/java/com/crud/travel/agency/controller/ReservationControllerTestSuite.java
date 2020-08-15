package com.crud.travel.agency.controller;

import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.repository.ReservationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationControllerTestSuite {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void testReservationControllerSave() {
        //Given
        Reservation reservation = new Reservation (55L,3L, 47L, "John", "Smith", "j.smith@gmail.com", "750820352", 2, 0, 0, 1500, false, true, LocalDate.of(20,9,12), 0);
        //When
        reservationRepository.save(reservation);
        //Then
        Long id = reservation.getId();
        Optional<Reservation> reservationList = reservationRepository.findById(id);
        Assert.assertTrue(reservationList.isPresent());
        //CleanUp
        reservationRepository.delete(reservation);

    }

    @Test
    public void testReservationControllerFindById() {

    }

    @Test
    public void testNamedQueries() {
        //Given
        Reservation reservation = new Reservation (55L,3L, 47L, "John", "Smith", "j.smith@gmail.com", "750820352", 2, 0, 0, 1500, false, true, LocalDate.of(20,9,12), 0);
        //When
        reservation.getHotelPrice();
        //Then
        Assert.assertEquals(0, reservation.getHotelPrice());
    }
}
