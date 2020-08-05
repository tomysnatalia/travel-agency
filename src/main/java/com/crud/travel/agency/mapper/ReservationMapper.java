package com.crud.travel.agency.mapper;

import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.domain.dto.ReservationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {

    public Reservation mapToReservation (final ReservationDto reservationDto) {
        return new Reservation(
                reservationDto.getId(),
                reservationDto.getFlight(),
                reservationDto.getHotel(),
                reservationDto.getName(),
                reservationDto.getSurname(),
                reservationDto.getEmail(),
                reservationDto.getPhoneNumber(),
                reservationDto.getNumberOfAdults(),
                reservationDto.getNumberOfKids(),
                reservationDto.getHotelPrice(),
                reservationDto.getDeposit(),
                reservationDto.isPaymentStatus(),
                reservationDto.getPaymentDate(),
                reservationDto.getHotelPriceWithFlight());
    }

    public ReservationDto mapToReservationDto (final Reservation reservation) {
        return new ReservationDto(
                reservation.getId(),
                reservation.getFlight(),
                reservation.getHotel(),
                reservation.getName(),
                reservation.getSurname(),
                reservation.getEmail(),
                reservation.getPhoneNumber(),
                reservation.getNumberOfAdults(),
                reservation.getNumberOfKids(),
                reservation.getHotelPrice(),
                reservation.getDeposit(),
                reservation.isPaymentStatus(),
                reservation.getPaymentDate(),
                reservation.getHotelPriceWithFlight());
    }

    public List<ReservationDto> mapToReservationDtoList (final List<Reservation> reservationList) {
        return reservationList.stream()
                .distinct()
                .map(rl -> new ReservationDto(rl.getId(), rl.getFlight(), rl.getHotel(), rl.getName(), rl.getSurname(), rl.getEmail(), rl.getPhoneNumber(), rl.getNumberOfAdults(), rl.getNumberOfKids(),
                        rl.getHotelPrice(), rl.getDeposit(), rl.isPaymentStatus(), rl.getPaymentDate(), rl.getHotelPriceWithFlight()))
                .collect(Collectors.toList());
    }
}
