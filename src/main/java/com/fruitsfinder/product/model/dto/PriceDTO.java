package com.fruitsfinder.product.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDTO {

    @NotNull(message = "value should not be null")
    private BigDecimal value;
    @NotNull(message = "type should not be null")
    private String type;
    @NotNull(message = "currency should not be null")
    private String currency;
}
