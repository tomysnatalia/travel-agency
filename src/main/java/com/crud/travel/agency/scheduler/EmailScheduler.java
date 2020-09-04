package com.crud.travel.agency.scheduler;

import com.crud.travel.agency.api.config.TravelAgencyConfig;
import com.crud.travel.agency.config.AdminConfig;
import com.crud.travel.agency.controller.HotelController;
import com.crud.travel.agency.domain.Hotel;
import com.crud.travel.agency.domain.Mail;
import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.domain.dto.ReservationDto;
import com.crud.travel.agency.repository.ReservationRepository;
import com.crud.travel.agency.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class EmailScheduler {

    private static final String SUBJECT = "Travel Agency: OFFERS";

    @Autowired
    private EmailService emailService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private TravelAgencyConfig travelAgencyConfig;

    @Scheduled (cron = "0 0 10 * * *")
    public void sendInformationEmail(){
        emailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "We have new offers for you click link to check" +
                        "\n the holidays -> " +
                        travelAgencyConfig.getTravelAgencyUrl() + "/hotel/hotels" +
                        "\n the flights -> " +
                        travelAgencyConfig.getTravelAgencyUrl() + "/flight/flights"
        ));
    }
}
