package com.crud.travel.agency.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NotNull
@Getter
public class FlightListDto {
    private List<FlightDto> flights;
}
