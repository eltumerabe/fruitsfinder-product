package com.fruitsfinder.product.converters;

import com.fruitsfinder.product.model.dto.AddressDTO;
import com.fruitsfinder.product.model.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class AddressDtoToEntity implements Function<AddressDTO, Address> {

    private final LocationDtoToEntity locationDtoToEntity;
    @Override
    public Address apply(final AddressDTO addressDTO) {
        return Address
                .builder()
                .country(addressDTO.getCountry())
                .state(addressDTO.getState())
                .city(addressDTO.getCity())
                .village(addressDTO.getVillage())
                .location(locationDtoToEntity.apply(addressDTO.getLocation()))
                .build();
    }
}
