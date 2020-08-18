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
                reservationDto.getFlightId(),
                reservationDto.getHotelId(),
                reservationDto.getName(),
                reservationDto.getSurname(),
                reservationDto.getEmail(),
                reservationDto.getPhoneNumber(),
                reservationDto.getNumberOfAdults(),
                reservationDto.getNumberOfKids(),
                reservationDto.getHotelPrice(),
                reservationDto.getDeposit(),
                reservationDto.isPaymentStatus(),
                reservationDto.isPaymentDepositStatus(),
                reservationDto.getPaymentDate(),
                reservationDto.getHotelPriceWithFlight());
    }

    public ReservationDto mapToReservationDto (final Reservation reservation) {
        return new ReservationDto(
                reservation.getId(),
                reservation.getFlightId(),
                reservation.getHotelId(),
                reservation.getName(),
                reservation.getSurname(),
                reservation.getEmail(),
                reservation.getPhoneNumber(),
                reservation.getNumberOfAdults(),
                reservation.getNumberOfKids(),
                reservation.getHotelPrice(),
                reservation.getDeposit(),
                reservation.isPaymentStatus(),
                reservation.isPaymentDepositStatus(),
                reservation.getPaymentDate(),
                reservation.getHotelPriceWithFlight());
    }

    public List<ReservationDto> mapToReservationDtoList (final List<Reservation> reservationList) {
        return reservationList.stream()
                .map(rl -> new ReservationDto(rl.getId(), rl.getFlightId(), rl.getHotelId(), rl.getName(), rl.getSurname(), rl.getEmail(), rl.getPhoneNumber(), rl.getNumberOfAdults(), rl.getNumberOfKids(),
                        rl.getHotelPrice(), rl.getDeposit(), rl.isPaymentStatus(), rl.isPaymentDepositStatus(), rl.getPaymentDate(), rl.getHotelPriceWithFlight()))
                .distinct()
                .collect(Collectors.toList());
    }
}
