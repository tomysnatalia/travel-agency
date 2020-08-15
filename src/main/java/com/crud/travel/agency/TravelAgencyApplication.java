package com.crud.travel.agency;

import com.crud.travel.agency.domain.Hotel;
import com.crud.travel.agency.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TravelAgencyApplication {


	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);



	}

}
