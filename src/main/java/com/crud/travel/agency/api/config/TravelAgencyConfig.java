package com.crud.travel.agency.api.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TravelAgencyConfig {

    @Value("${travelAgency.api.url}")
    private String travelAgencyUrl;

    @Value("${travelAgency.localhost}")
    private String travelAgencyLocalhost;
}
