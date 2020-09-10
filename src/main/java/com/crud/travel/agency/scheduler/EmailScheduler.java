package com.crud.travel.agency.scheduler;

import com.crud.travel.agency.api.config.TravelAgencyConfig;
import com.crud.travel.agency.config.AdminConfig;
import com.crud.travel.agency.domain.Mail;
import com.crud.travel.agency.domain.MailToCustomers;

import com.crud.travel.agency.domain.Reservation;
import com.crud.travel.agency.repository.ReservationRepository;
import com.crud.travel.agency.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmailScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);
    private static final String SUBJECT = "Travel Agency: OFFERS";

    @Autowired
    private EmailService emailService;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private TravelAgencyConfig travelAgencyConfig;

    @Autowired
    private ReservationRepository reservationRepository;


    @Scheduled (cron = "0 0 10 * * *")
    //@Scheduled(fixedDelay = 10000)
    public void sendDailyInformationEmail() {
        List<Reservation> reservationList = reservationRepository.findAll();
        List<String> result = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            result.add(reservation.getEmail());
        }
        String email;
        for (int n = 0; n < result.size(); n++) {
            email = result.get(n);
            emailService.sendToAllCustomers(new MailToCustomers(
                    email,
                    SUBJECT,
                    "We have new offers for you click link to check  " +
                            "\n the holiday -> " +
                            travelAgencyConfig.getTravelAgencyUrl() + "/hotel/hotels" +
                            "\n the flights -> " +
                            travelAgencyConfig.getTravelAgencyUrl() + "/flight/flights"
            ));
            LOGGER.info("emails: " + email);
        }
    }
}
