package com.crud.travel.agency;

import com.crud.travel.agency.domain.Reservation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelAgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);

		Reservation reservation = new Reservation();
		reservation.getHotelPrice();

	}

}
