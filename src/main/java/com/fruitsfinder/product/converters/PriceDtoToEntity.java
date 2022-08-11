package com.fruitsfinder.product.converters;

import com.fruitsfinder.product.model.dto.PriceDTO;
import com.fruitsfinder.product.model.entity.Price;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PriceDtoToEntity implements Function<PriceDTO,Price> {
    @Override
    public Price apply(PriceDTO priceDTO) {
        return Price
                .builder()
                .currency(priceDTO.getCurrency())
                .value(priceDTO.getValue())
                .type(priceDTO.getType())
                .build();
    }
}
