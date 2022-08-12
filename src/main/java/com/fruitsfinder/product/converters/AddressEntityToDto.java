package com.fruitsfinder.product.converters;

import com.fruitsfinder.product.model.dto.AddressDTO;
import com.fruitsfinder.product.model.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class AddressEntityToDto implements Function<Address, AddressDTO> {

    private final LocationEntityToDto locationEntityToDto;
    @Override
    public AddressDTO apply(final Address address) {
        return AddressDTO
                .builder()
                .country(address.getCountry())
                .state(address.getState())
                .city(address.getCity())
                .village(address.getVillage())
                .location(locationEntityToDto.apply(address.getLocation()))
                .build();
    }
}
