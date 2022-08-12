package com.fruitsfinder.product.converters;

import com.fruitsfinder.product.model.dto.PriceDTO;
import com.fruitsfinder.product.model.entity.Price;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PriceEntityToDto implements Function<Price,PriceDTO> {
    @Override
    public PriceDTO apply(final Price price) {
        return PriceDTO
                .builder()
                .currency(price.getCurrency())
                .value(price.getValue())
                .type(price.getType())
                .build();
    }
}
