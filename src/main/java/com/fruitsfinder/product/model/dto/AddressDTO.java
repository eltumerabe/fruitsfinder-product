package com.fruitsfinder.product.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {
    @NotNull(message = "country should not be null")
    private String country;
    @NotNull(message = "state should not be null")
    private String state;
    @NotNull(message = "city should not be null")
    private String city;
    private String village;
    @NotNull(message = "location should not be null")
    private @Valid LocationDTO location;
}
