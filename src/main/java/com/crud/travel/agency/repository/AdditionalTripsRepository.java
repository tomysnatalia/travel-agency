package com.crud.travel.agency.repository;

import com.crud.travel.agency.domain.AdditionalTrips;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
public interface AdditionalTripsRepository extends CrudRepository<AdditionalTrips, Long>{

    @Override
    List<AdditionalTrips> findAll();

    @Override
    Optional<AdditionalTrips> findById(Long id);

    @Override
    AdditionalTrips save (AdditionalTrips additionalTrips);

    @Override
    void deleteById (Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    void getFullPrice();




}
