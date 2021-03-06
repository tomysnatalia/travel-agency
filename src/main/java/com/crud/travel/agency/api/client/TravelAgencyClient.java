package com.crud.travel.agency.api.client;

import com.crud.travel.agency.api.config.TravelAgencyConfig;
import com.crud.travel.agency.domain.dto.ReservationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class TravelAgencyClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(TravelAgencyClient.class);

    @Autowired
    private TravelAgencyConfig travelAgencyConfig;

    @Autowired
    private RestTemplate restTemplate;

    public Integer createReservation(final ReservationDto reservationDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

       HttpEntity<ReservationDto> request = new HttpEntity<>(reservationDto, headers);

        URI url = UriComponentsBuilder.fromHttpUrl(travelAgencyConfig.getTravelAgencyLocalhost())
                .path("/reservation/create")
                .build().encode().toUri();
        LOGGER.info("url: " + url);

        try {
            return restTemplate.exchange(url, HttpMethod.POST, request, Integer.class).getStatusCodeValue();
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage());
            return 0;
        }
    }
}
