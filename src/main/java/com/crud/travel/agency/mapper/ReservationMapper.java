package com.crud.travel.agency.mapper;

import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.domain.dto.ReservationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
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
                reservationDto.getFlightPrice(),
                reservationDto.getDeposit(),
                reservationDto.getPaymentStatus(),
                reservationDto.getDepositStatus(),
                reservationDto.getPaymentDate(),
                reservationDto.getTotalPrice());
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
                reservation.getFlightPrice(),
                reservation.getDeposit(),
                reservation.getPaymentStatus(),
                reservation.getDepositStatus(),
                reservation.getPaymentDate(),
                reservation.getTotalPrice());
    }

    public List<ReservationDto> mapToReservationDtoList (final List<Reservation> reservationList) {
        return reservationList.stream()
                .map(this::mapToReservationDto)
                .collect(Collectors.toList());
    }
}
