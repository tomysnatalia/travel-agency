package com.crud.travel.agency.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
@NotNull
public class HotelListDto {
    private List<HotelDto> hotels;
}
