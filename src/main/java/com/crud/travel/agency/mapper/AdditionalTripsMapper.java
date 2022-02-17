package com.crud.travel.agency.mapper;

import com.crud.travel.agency.domain.AdditionalTrips;
import com.crud.travel.agency.domain.dto.AdditionalTripsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AdditionalTripsMapper {

    public AdditionalTrips mapToTrips (final AdditionalTripsDto additionalTripsDto) {
        return new AdditionalTrips(
                additionalTripsDto.getId(),
                additionalTripsDto.getNumberOfParticipant(),
                additionalTripsDto.getTripDate(),
                additionalTripsDto.getTripPrice(),
                additionalTripsDto.getForAll());
    }

    public AdditionalTripsDto mapToTripsDto (final AdditionalTrips additionalTrips) {
        return new AdditionalTripsDto(
                additionalTrips.getId(),
                additionalTrips.getNumberOfParticipant(),
                additionalTrips.getTripDate(),
                additionalTrips.getTripPrice(),
                additionalTrips.getFullPrice());
    }

    public List<AdditionalTripsDto> mapToTripsDtoList(final List<AdditionalTrips> tripsList) {
        return tripsList.stream()
                .map(t -> new AdditionalTripsDto(t.getId(), t.getNumberOfParticipant(), t.getTripDate(), t.getTripPrice(), t.getFullPrice()))
                .collect(Collectors.toList());
    }
}
