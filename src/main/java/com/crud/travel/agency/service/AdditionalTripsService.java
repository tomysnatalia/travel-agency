package com.crud.travel.agency.service;


import com.crud.travel.agency.domain.AdditionalTrips;
import com.crud.travel.agency.exception.TravelAgencyNotFoundException;
import com.crud.travel.agency.mapper.AdditionalTripsMapper;
import com.crud.travel.agency.repository.AdditionalTripsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
@Service
public class AdditionalTripsService {

    @Autowired
    private AdditionalTripsRepository tripsRepository;
    @Autowired
    private AdditionalTripsMapper tripsMapper;

    public List<AdditionalTrips> getAllTrips() {
        return tripsRepository.findAll();
    }

    public Optional<AdditionalTrips> getTripById (Long id) {
        return tripsRepository.findById(id);
    }

    public AdditionalTrips saveTrip (final AdditionalTrips additionalTrips) {
        return tripsRepository.save(additionalTrips);
    }

    public void countSummary(AdditionalTrips additionalTrips) {
        tripsRepository.getFullPrice();
    }

    public void deleteTrip (Long id){
        tripsRepository.deleteById(id);
    }

    public AdditionalTrips findTripById(final Long id) throws TravelAgencyNotFoundException {
        return tripsRepository.findById(id).orElseThrow(TravelAgencyNotFoundException::new);
    }
}
