package com.fruitsfinder.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class AddressDTO {
    private String country;
    private String state;
    private String city;
    private String village;
    private LocationDTO location;
}