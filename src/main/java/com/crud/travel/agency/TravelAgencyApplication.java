package com.crud.travel.agency;

import com.crud.travel.agency.domain.AdditionalTrips;
import com.crud.travel.agency.domain.dto.AdditionalTripsDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.tags.EditorAwareTag;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class TravelAgencyApplication {
	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);

	}


}
