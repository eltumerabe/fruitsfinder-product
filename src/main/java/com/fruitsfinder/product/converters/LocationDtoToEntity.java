package com.fruitsfinder.product.converters;

import com.fruitsfinder.product.model.dto.LocationDTO;
import com.fruitsfinder.product.model.entity.Location;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LocationDtoToEntity implements Function<LocationDTO,Location> {
    @Override
    public Location apply(final LocationDTO locationDTO) {
        return Location
                .builder()
                .latitude(locationDTO.getLatitude())
                .longitude(locationDTO.getLongitude())
                .build();
    }
}
