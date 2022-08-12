package com.fruitsfinder.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class LocationDTO {
    private Long id;
    private Double longitude;
    private Double latitude;
}
