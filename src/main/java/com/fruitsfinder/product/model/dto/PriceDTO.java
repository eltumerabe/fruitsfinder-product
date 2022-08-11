package com.fruitsfinder.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class PriceDTO {

    private BigDecimal value;
    private String type;
    private String currency;
}
